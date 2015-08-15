# -*- coding: utf-8 -*-

from ..extensions import logger


def get_single_preprocessor(instance_id=None, **kw):
    """Accepts a single	argument, `instance_id`, the primary key of the
    instance of	the models to get.

    """
    pass


def get_single_postprocessor(result=None, **kw):
    """Accepts a single	argument, `result`, which is the dictionary
    representation of the requested instance of	the models.

    """
    pass
    obj = result.copy()
    result.clear()
    result['system'] = obj


def get_many_preprocessor(search_params=None, **kw):
    """Accepts a single	argument, `search_params`, which is a dictionary
    containing the search parameters for the request.

    """
    pass
    logger.info("start get_many_preprocessor")
    logger.info(search_params)
    logger.info("end get_many_preprocessor")


def get_many_postprocessor(result=None, search_params=None, **kw):
    """Accepts two arguments, `result`,	which is the dictionary
    representation of the JSON response	which will be returned to the
    client, and	`search_params`, which is a dictionary containing the
    search parameters for the request (that produced the specified
    `result`).

    """
    pass
    logger.info("start get_many_postprocessor")
    objects = result['objects']
    result.clear()
    result['systems'] = objects
    logger.info(result)
    logger.info("end get_many_postprocessor")


def put_single_preprocessor(instance_id=None, data=None, **kw):
    """Accepts two arguments, `instance_id`, the primary key of	the
    instance of	the models to patch, and	`data`,	the dictionary of fields
    to change on the instance.

    """
    logger.info("start put_single_preprocessor")
    logger.info(data)
    system = data['system']
    data.clear()
    data.update(system)
    logger.info("end put_single_preprocessor")
    pass


def put_single_postprocessor(result=None, **kw):
    """Accepts a single	argument, `result`, which is the dictionary
    representation of the requested instance of	the models.

    """

    logger.info("start put_single_postprocessor")
    logger.info(result)
    logger.info("end put_single_postprocessor")
    pass


def put_many_preprocessor(search_params=None, data=None, **kw):
    """Accepts two arguments: `search_params`, which is	a dictionary
    containing the search parameters for the request, and `data`, which
    is a dictionary representing the fields to change on the matching
    instances and the values to	which they will	be set.

    """
    pass


def put_many_postprocessor(query=None, data=None, search_params=None,
                           **kw):
    """Accepts three arguments:	`query`, which is the SQLAlchemy query
    which was inferred from the	search parameters in the query string,
    `data`, which is the dictionary representation of the JSON response
    which will be returned to the client, and `search_params`, which is	a
    dictionary containing the search parameters	for the	request.

    """
    pass


def post_preprocessor(data=None, **kw):
    """Accepts a single	argument, `data`, which	is the dictionary of
    fields to set on the new instance of the models.

    """
    logger.info(data)
    logger.info("start post_preprocessor")
    system = data['system']
    data.clear()
    data.update(system)
    logger.info(data)
    logger.info("end post_preprocessor")
    pass


def post_postprocessor(result=None, **kw):
    """Accepts a single	argument, `result`, which is the dictionary
    representation of the created instance of the models.

    """
    logger.info("start post_postprocessor")
    logger.info(result)
    logger.info("end post_postprocessor")
    pass


def delete_single_preprocessor(instance_id=None, **kw):
    """Accepts a single	argument, `instance_id`, which is the primary key
    of the instance which will be deleted.

    """
    logger.info("start delete_single_preprocessor")
    pass
    logger.info(instance_id)
    logger.info("end delete_single_preprocessor")


def delete_single_postprocessor(was_deleted=None, **kw):
    """Accepts a single	argument, `was_deleted`, which represents whether
    the	instance has been deleted.

    """
    logger.info("start delete_single_postprocessor")
    pass
    logger.info(was_deleted)
    logger.info("end delete_single_postprocessor")


def delete_many_preprocessor(search_params=None, **kw):
    """Accepts a single	argument, `search_params`, which is a dictionary
    containing the search parameters for the request.

    """
    pass


def delete_many_postprocessor(result=None, search_params=None, **kw):
    """Accepts two arguments: `result`,	which is the dictionary
    representation of which is the dictionary representation of	the JSON
    response which will	be returned to the client, and `search_params`,
    which is a dictionary containing the search	parameters for the
    request.

    """
    pass


def foo(name='1'):
    return bar()


def hello(system_name):
    def name(fn):
        def wrapper(*args, **kwds):
            print("hello, %s" % fn.__name__)
            fn(system_name, *args, **kwds)
            print("goodby, %s" % fn.__name__)

        return wrapper

    return name


@hello('system')
def bar(name):
    logger.info('bar ' + name)


def test(system_name):
    def default_get_many_postprocessor(result=None, search_params=None, **kw):
        """Accepts two arguments, `result`, which is the dictionary
        representation of the JSON response which will be returned to the
        client, and `search_params`, which is a dictionary containing the
        search parameters for the request (that produced the specified
        `result`).

        """
        pass
        logger.info("start default_get_many_postprocessor " + system_name)
        if result:
            objects = result['objects']
            result.clear()
            b = {system_name: objects}
            # result[name] = objects
            result.update(b)
            logger.info(result)
            logger.info("end default_get_many_postprocessor " + system_name)
        else:
            logger.info('result is None')

    return default_get_many_postprocessor


def default_get_many_postprocessor(system_name=None, result=None, search_params=None, **kw):
    """Accepts two arguments, `result`, which is the dictionary
    representation of the JSON response which will be returned to the
    client, and `search_params`, which is a dictionary containing the
    search parameters for the request (that produced the specified
    `result`).

    """
    pass
    logger.info("start default_get_many_postprocessor " + system_name)
    if result:
        objects = result['objects']
        result.clear()
        b = {system_name: objects}
        # result[name] = objects
        result.update(b)
        logger.info(result)
        logger.info("end default_get_many_postprocessor " + system_name)
    else:
        logger.info('result is None')
