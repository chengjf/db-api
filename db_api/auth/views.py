# -*- coding: utf-8 -*-
from __builtin__ import object
from flask import Blueprint, redirect, url_for, request, flash, g, jsonify, abort
from db_api.models.user import User
from db_api.extensions import db
from itsdangerous import TimestampSigner

from db_api.auth.db_httpauth import HTTPBasicAuth, MyAuth

__author__ = 'sharp'

auth = Blueprint("auth", __name__)
s = TimestampSigner('secret_key_db_api')

basic_auth = HTTPBasicAuth()

@auth.route("/login", methods=["GET", "POST"])
def login():
    """
    Logs the user in
    """
    request_data = request.get_json(force=True)
    username = request_data["username"]
    password = request_data["password"]
    remember_me = request_data["remember_me"]
    myauth = MyAuth(username=username, password=password)
    result = basic_auth.authenticate(myauth, None)
    if result:
        user = User.query.filter_by(username=username).first()
        g.user = user
        return jsonify({'username': username, 'api_key': {'access_token': get_auth_token()}})
    else:
        return abort(401)





@auth.route("/logout", methods=["GET"])
def logout():
    return redirect('/')


@auth.route('/helloworld')
def helloworld():
    from db_api import  app
    return app.send_static_file("helloworld.html")

@basic_auth.verify_password
def verify_password(username_or_token, password):
    # first try to authenticate by token
    user = User.verify_auth_token(username_or_token)
    if not user:
        user = User.query.filter_by(username=username_or_token).first()
        if not user or not user.verify_password(password):
            return False
    g.user = user
    return True


@basic_auth.error_handler
def error_handler():
    return redirect('/#/auth/login')


@auth.route('/api/users', methods=['POST'])
def new_user():
    username = request.json.get('username')
    password = request.json.get('password')
    if username is None or password is None:
        abort(400)  # missing arguments
    if User.query.filter_by(username=username).first() is not None:
        abort(400)  # existing user
    user = User(username=username)
    user.hash_password(password)
    db.session.add(user)
    db.session.commit()
    return (jsonify({'username': user.username}), 201,
            {'Location': url_for('get_user', id=user.id, _external=True)})


@auth.route('/api/users/<int:id>')
def get_user(id):
    user = User.query.get(id)
    if not user:
        abort(400)
    return jsonify({'username': user.username})


def get_auth_token():
    token = g.user.generate_auth_token(600)
    return token
    # return jsonify({'token': token.decode('ascii'), 'duration': 600})


@auth.route('/api/resource')
@basic_auth.login_required
def get_resource():
    return jsonify({'data': 'Hello, %s!' % g.user.username})


@auth.route('/users', methods=['GET'])
def get_user_info():
    token = request.headers.get('Authorization')
    if verify_password(token, None):
        user = g.user
        return jsonify({'username': user.username})
    return abort(401)
