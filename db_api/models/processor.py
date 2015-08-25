# -*- coding: utf-8 -*-

from db_api.extensions import logger
from db_api.extensions import restless


def get_single_preprocessor(instance_id=None, **kw):
    """Accepts a single argument, `instance_id`, the primary key of the
    instance of the models to get.

    """
    pass


def my_get_single_postprocessor(model_name):
    def default_get_single_postprocessor(result=None, **kw):
        """Accepts a single argument, `result`, which is the dictionary
        representation of the requested instance of the models.

        """
        pass
        obj = result.copy()
        result.clear()
        result[model_name] = obj
    return default_get_single_postprocessor


def get_many_preprocessor(search_params=None, **kw):
    """Accepts a single argument, `search_params`, which is a dictionary
    containing the search parameters for the request.

    """
    pass
    logger.info("start get_many_preprocessor")
    logger.info(search_params)
    logger.info("end get_many_preprocessor")


def my_put_single_preprocessor(model_name):
    def default_put_single_preprocessor(instance_id=None, data=None, **kw):
        """Accepts two arguments, `instance_id`, the primary key of the
        instance of the models to patch, and    `data`, the dictionary of fields
        to change on the instance.

        """
        logger.info("start put_single_preprocessor")
        logger.info(data)
        model = data[model_name]
        data.clear()
        data.update(model)
        logger.info("end put_single_preprocessor")
        pass
    return default_put_single_preprocessor


def put_single_postprocessor(result=None, **kw):
    """Accepts a single argument, `result`, which is the dictionary
    representation of the requested instance of the models.

    """

    logger.info("start put_single_postprocessor")
    logger.info(result)
    logger.info("end put_single_postprocessor")
    pass


def put_many_preprocessor(search_params=None, data=None, **kw):
    """Accepts two arguments: `search_params`, which is a dictionary
    containing the search parameters for the request, and `data`, which
    is a dictionary representing the fields to change on the matching
    instances and the values to which they will be set.

    """
    pass


def put_many_postprocessor(query=None, data=None, search_params=None,
                           **kw):
    """Accepts three arguments: `query`, which is the SQLAlchemy query
    which was inferred from the search parameters in the query string,
    `data`, which is the dictionary representation of the JSON response
    which will be returned to the client, and `search_params`, which is a
    dictionary containing the search parameters for the request.

    """
    pass


def my_post_preprocessor(model_name):
    def post_preprocessor(data=None, **kw):
        """Accepts a single argument, `data`, which is the dictionary of
        fields to set on the new instance of the models.

        """
        logger.info(data)
        logger.info("start post_preprocessor")
        model = data[model_name]
        data.clear()
        data.update(model)
        logger.info(data)
        logger.info("end post_preprocessor")
    return post_preprocessor


def post_postprocessor(result=None, **kw):
    """Accepts a single argument, `result`, which is the dictionary
    representation of the created instance of the models.

    """
    logger.info("start post_postprocessor")
    logger.info(result)
    logger.info("end post_postprocessor")
    pass


def delete_single_preprocessor(instance_id=None, **kw):
    """Accepts a single argument, `instance_id`, which is the primary key
    of the instance which will be deleted.

    """
    logger.info("start delete_single_preprocessor")
    pass
    logger.info(instance_id)
    logger.info("end delete_single_preprocessor")


def delete_single_postprocessor(was_deleted=None, **kw):
    """Accepts a single argument, `was_deleted`, which represents whether
    the instance has been deleted.

    """
    logger.info("start delete_single_postprocessor")
    pass
    logger.info(was_deleted)
    logger.info("end delete_single_postprocessor")


def delete_many_preprocessor(search_params=None, **kw):
    """Accepts a single argument, `search_params`, which is a dictionary
    containing the search parameters for the request.

    """
    pass


def delete_many_postprocessor(result=None, search_params=None, **kw):
    """Accepts two arguments: `result`, which is the dictionary
    representation of which is the dictionary representation of the JSON
    response which will be returned to the client, and `search_params`,
    which is a dictionary containing the search parameters for the
    request.

    """
    pass


def my_get_many_postprocessor(model_name):
    def default_get_many_postprocessor(result=None, search_params=None, **kw):
        logger.info("start default_get_many_postprocessor " + model_name)
        if result:
            objects = result['objects']
            result.clear()
            b = {model_name: objects}
            result.update(b)
            logger.info(result)
            logger.info("end default_get_many_postprocessor " + model_name)
        else:
            logger.info('result is None')
    return default_get_many_postprocessor


def create_restless_api(model, model_name, collection_name, methods=['GET', 'POST', 'DELETE', 'PUT'],
                        url_prefix='/api/v1', results_per_page=-1):
    restless.create_api(
        model,
        methods=methods,
        url_prefix=url_prefix,
        collection_name=collection_name,
        results_per_page=results_per_page,
        preprocessors={
            'GET_MANY': [get_many_preprocessor],
            'POST': [my_post_preprocessor(model_name)],
            'GET_SINGLE': [get_single_preprocessor],
            'PUT_SINGLE': [my_put_single_preprocessor(model_name)],
            'PUT_MANY': [put_many_preprocessor],
            'DELETE_SINGLE': [delete_single_preprocessor],
            'DELETE_MANY': [delete_many_preprocessor]
        },
        postprocessors={
            'GET_MANY': [my_get_many_postprocessor(model_name)],
            'POST': [post_postprocessor],
            'GET_SINGLE': [my_get_single_postprocessor(model_name)],
            'PUT_SINGLE': [put_single_postprocessor],
            'PUT_MANY': [put_many_postprocessor],
            'DELETE_SINGLE': [delete_single_postprocessor],
            'DELETE_MANY': [delete_many_postprocessor]
        }
    )
