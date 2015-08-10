# -*- coding: utf-8 -*-

import json
from db_api import  app
from db_api import logger

from db_api.database import	db
from db_api.database import	restless
from db_api.model import processor


class System(db.Model):
	"""
	system
	"""
	id = db.Column(db.Integer, primary_key=True)
	number = db.Column(db.String(255), unique=True, nullable=False)
	name = db.Column(db.String(255), nullable=False)
	desc = db.Column(db.String(512))


#restless.create_api(System, collection_name='systems',	url_prefix='/api/v1',methods=['GET', 'POST', 'DELETE','PUT'], results_per_page=100)

restless.create_api(
    System,
    methods=['GET', 'POST', 'DELETE', 'PUT'],
    url_prefix='/api/v1',
    collection_name='systems',
    results_per_page=-1,
    preprocessors={
		'GET_MANY': [processor.get_many_preprocessor],
		'POST':	[processor.post_preprocessor],
		'GET_SINGLE':[processor.get_single_preprocessor],
		'PUT_SINGLE':[processor.put_single_preprocessor],
		'PUT_MANY':[processor.put_many_preprocessor],
		'DELETE_SINGLE':[processor.delete_single_preprocessor],
		'DELETE_MANY':[processor.delete_many_preprocessor]
    },
    postprocessors={
		'GET_MANY': [processor.test('system')],
		'POST':	[processor.post_postprocessor],
		'GET_SINGLE':[processor.get_single_postprocessor],
		'PUT_SINGLE':[processor.put_single_postprocessor],
		'PUT_MANY':[processor.put_many_postprocessor],
		'DELETE_SINGLE':[processor.delete_single_postprocessor],
		'DELETE_MANY':[processor.delete_many_postprocessor]
    }
)

