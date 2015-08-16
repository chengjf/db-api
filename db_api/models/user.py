# -*- coding: utf-8 -*-

from msilib.schema import Signature
from flask_login import UserMixin
from passlib.apps import custom_app_context as pwd_context
from itsdangerous import (TimedJSONWebSignatureSerializer
                          as Serializer, BadSignature, SignatureExpired)

from db_api import app
from db_api.extensions import db
from db_api.extensions import restless
from db_api.models import processor



class User(db.Model, UserMixin):
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
        s = Serializer(app.config['SECRET_KEY'])
        try:
            data = s.loads(token)
        except SignatureExpired:
            return None
        except BadSignature:
            return None
        user = User.query.get(data['id'])
        return user


restless.create_api(
    User,
    methods=['GET', 'POST', 'DELETE', 'PUT'],
    url_prefix='/api/v1',
    collection_name='users',
    results_per_page=-1,
    preprocessors={
        'GET_MANY': [processor.get_many_preprocessor],
        'POST': [processor.post_preprocessor],
        'GET_SINGLE': [processor.get_single_preprocessor],
        'PUT_SINGLE': [processor.put_single_preprocessor],
        'PUT_MANY': [processor.put_many_preprocessor],
        'DELETE_SINGLE': [processor.delete_single_preprocessor],
        'DELETE_MANY': [processor.delete_many_preprocessor]
    },
    postprocessors={
        'GET_MANY': [processor.test('user')],
        'POST': [processor.post_postprocessor],
        'GET_SINGLE': [processor.get_single_postprocessor],
        'PUT_SINGLE': [processor.put_single_postprocessor],
        'PUT_MANY': [processor.put_many_postprocessor],
        'DELETE_SINGLE': [processor.delete_single_postprocessor],
        'DELETE_MANY': [processor.delete_many_postprocessor]
    }
)