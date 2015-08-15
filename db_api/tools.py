# -*- coding: utf-8 -*-

__author__ = 'sharp'
from .models.user import User
from .extensions import db
from werkzeug.security import generate_password_hash


def init_user_data(app):
    password = generate_password_hash('admin')
    user = User(id=0, username='admin', password=password)
    db_session = db.create_scoped_session()
    db_session.add(user)
    db_session.commit()
