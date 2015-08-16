# -*- coding: utf-8 -*-

__author__ = 'sharp'
from functools import wraps
from hashlib import md5
from random import Random, SystemRandom
from flask import request, make_response, session


class MyAuth(object):
    def __init__(self, username, password):
        self.username = username
        self.password = password

class HTTPAuth(object):
    def __init__(self):
        def default_get_password(username):
            return None

        def default_auth_error():
            return "Unauthorized Access"

        self.realm = "Authentication Required"
        self.get_password(default_get_password)
        self.error_handler(default_auth_error)

    def get_password(self, f):
        self.get_password_callback = f
        return f

    def error_handler(self, f):
        @wraps(f)
        def decorated(*args, **kwargs):
            res = f(*args, **kwargs)
            if type(res) == str:
                res = make_response(res)
                res.status_code = 401
            if 'WWW-Authenticate' not in res.headers.keys():
                res.headers['WWW-Authenticate'] = self.authenticate_header()
            return res

        self.auth_error_callback = decorated
        return decorated

    def login_required(self, f):
        @wraps(f)
        def decorated(*args, **kwargs):
            auth = request.authorization
            # We need to ignore authentication headers for OPTIONS to avoid
            # unwanted interactions with CORS.
            # Chrome and Firefox issue a preflight OPTIONS request to check
            # Access-Control-* headers, and will fail if it returns 401.
            if request.method != 'OPTIONS':
                token = request.headers.get('Authorization')

                if auth:
                    password = self.get_password_callback(auth.username)
                else:
                    password = None
                    auth = MyAuth(username=token, password=password)
                if not self.authenticate(auth, password):
                    return self.auth_error_callback()
            return f(*args, **kwargs)

        return decorated

    def username(self):
        if not request.authorization:
            return ""
        return request.authorization.username


class HTTPBasicAuth(HTTPAuth):
    def __init__(self):
        super(HTTPBasicAuth, self).__init__()
        self.hash_password(None)
        self.verify_password(None)

    def hash_password(self, f):
        self.hash_password_callback = f
        return f

    def verify_password(self, f):
        self.verify_password_callback = f
        return f

    def authenticate_header(self):
        return 'Basic realm="{0}"'.format(self.realm)

    def authenticate(self, auth, stored_password):
        if auth:
            username = auth.username
            client_password = auth.password
        else:
            username = ""
            client_password = ""
        if self.verify_password_callback:
            return self.verify_password_callback(username, client_password)
        if not auth:
            return False
        if self.hash_password_callback:
            try:
                client_password = self.hash_password_callback(client_password)
            except TypeError:
                client_password = self.hash_password_callback(username,
                                                              client_password)
        return client_password == stored_password
