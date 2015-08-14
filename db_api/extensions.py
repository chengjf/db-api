from flask_restless import APIManager
from flask_sqlalchemy import SQLAlchemy
from flask import logging

__author__ = 'sharp'

db = SQLAlchemy()

restless = APIManager(app=None, flask_sqlalchemy_db=db)

logger = logging.getLogger()
