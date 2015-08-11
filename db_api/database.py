#!flask/Scripts/python.exe

# -*- coding: utf-8 -*-

from flask_sqlalchemy import SQLAlchemy
from flask_restless import APIManager
from db_api import app

db = SQLAlchemy(app)
restless = APIManager(app, flask_sqlalchemy_db=db)
