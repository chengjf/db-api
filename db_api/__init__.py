#!flask/Scripts/python.exe

# -*- coding: utf-8 -*-

from flask import Flask, jsonify

from flask_sqlalchemy import SQLAlchemy
from flask_restless import APIManager
import datetime
import os
import logging

from db_api import config

app = Flask(__name__)

#database url
basedir = os.path.abspath(os.path.dirname(__file__))
SQLALCHEMY_DATABASE_URI = 'sqlite:///' + os.path.join(basedir, 'app.db')

# init config
#app.config.from_object(config)
app.config.update(
	DEBUG=(os.environ.get('DEBUG') == 'yes'),
	SQLALCHEMY_DATABASE_URI=SQLALCHEMY_DATABASE_URI
)

#setup logging
logger = logging.getLogger('db-api')
logger.setLevel(logging.INFO)
logger.addHandler(logging.StreamHandler())

# init views
from db_api import views

#init database
from db_api.database import db, restless
from db_api.model import user, system


logger.info(db)
db.create_all()
logger.info('database created ...')

from db_api import db_init
db_init.init()
logger.info('database initialized ...')


if __name__ == "__main__":
	app.run(debug=True)
