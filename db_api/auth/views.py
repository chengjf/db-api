# -*- coding: utf-8 -*-
from flask import Blueprint
from flask import redirect, url_for, request, flash
import flask
from flask_login import login_user, current_user, logout_user
from db_api.models.user import User
from itsdangerous import TimestampSigner

from flask import jsonify

__author__ = 'sharp'

auth = Blueprint("auth", __name__)
s = TimestampSigner('secret_key_db_api')


@auth.route("/login", methods=["GET", "POST"])
def login():
    """
    Logs the user in
    """
    if current_user is not None and current_user.is_authenticated():
        string = s.sign(current_user.username)
        data = {'username': current_user.username, 'api_key': {'access_token': string}}
        return jsonify(data)
    request_data = request.get_json(force=True)

    username = request_data["username"]
    password = request_data["password"]
    remember_me = request_data["remember_me"]

    string = s.sign(username)

    user, authenticated = User.authenticate(username, password)
    if user and authenticated:
        data = {'username': user.username, 'api_key': {'access_token': string}}
        login_user(user, remember=remember_me)
        return jsonify(data)
    flash('Wrong Username or Password.', "danger")
    return flask.abort(401)
    # return redirect(url_for("index"))
    # return auth.send_static_file("login.html")
    # return render_template("auth/login.html", form=form)


@auth.route("/logout", methods=["GET"])
def logout():
    logout_user()
    return redirect('/')
