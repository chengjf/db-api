# -*- coding: utf-8 -*-

__author__ = 'sharp'
from .models.user import User
from .extensions import db
from passlib.apps import custom_app_context as pwd_context


def init_user_data(app):
    db_session = db.create_scoped_session()
    user = db_session.query(User).filter(User.username == 'admin').first()
    if user:
        db_session.delete(user)
    password = pwd_context.encrypt('admin')
    user = User(id=0, username='admin', password=password)

    db_session.add(user)
    db_session.commit()
