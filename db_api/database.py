# -*- coding: utf-8 -*-

from flask_sqlalchemy import SQLAlchemy
from flask_restless import APIManager

from . import app

db = SQLAlchemy(app)
restless = APIManager(app, flask_sqlalchemy_db=db)
