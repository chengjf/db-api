# -*- coding: utf-8 -*-

# from flask_login import UserMixin
from passlib.apps import custom_app_context as pwd_context
from itsdangerous import (TimedJSONWebSignatureSerializer
                          as Serializer, BadSignature, SignatureExpired)

from db_api import app
from db_api.extensions import db
from db_api.extensions import restless
from db_api.models.processor import create_restless_api


class User(db.Model):
    """
    User
    """
    __tablename__ = "user"

    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(255), unique=True, nullable=False)
    password = db.Column(db.String(255), nullable=False)

    @classmethod
    def authenticate(cls, login, password):
        user = cls.query.filter(User.username == login).first()
        if user:
            authenticated = user.check_password(password)
        else:
            authenticated = False
        return user, authenticated

    def verify_password(self, password):
        if self.password is None:
            return False
        return pwd_context.verify(password, self.password)

    def generate_auth_token(self, expiration=app.config['TOKEN_EXPIRATION']):
        s = Serializer(app.config['SECRET_KEY'], expires_in=expiration)
        return s.dumps({'id': self.id})

    @staticmethod
    def verify_auth_token(token):
        if token:
            s = Serializer(app.config['SECRET_KEY'])
            try:
                data = s.loads(token)
            except SignatureExpired:
                return None
            except BadSignature:
                return None
            user = User.query.get(data['id'])
            return user
        else:
            return None


create_restless_api(User, 'user', 'users')
