# -*- coding: utf-8 -*-
__author__ = 'sharp'
from flask_wtf import Form, RecaptchaField
from wtforms import StringField, PasswordField, BooleanField, SubmitField
from wtforms.validators import DataRequired


class LoginForm(Form):
    login = StringField("Username or E-Mail Address", validators=[
        DataRequired(message="A Username or E-Mail Address is required.")])
    password = PasswordField("Password", validators=[
        DataRequired(message="A Password is required.")])
    remember_me = BooleanField("Remember Me", default=False)
    submit = SubmitField("Login")
