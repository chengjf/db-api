# -*- coding: utf-8 -*-
from flask_login import UserMixin

from ..extensions import db
from ..extensions import restless

from werkzeug.security import generate_password_hash, check_password_hash


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
        """A classmethod for authenticating users
        It returns true if the user exists and has entered a correct password

        :param login: This can be either a username or a email address.

        :param password: The password that is connected to username and email.
        """

        user = cls.query.filter(User.username == login).first()

        if user:
            authenticated = user.check_password(password)
        else:
            authenticated = False
        return user, authenticated

    def check_password(self, password):
        """Check passwords. If passwords match it returns true, else false"""

        if self.password is None:
            return False
        return check_password_hash(self.password, password)


restless.create_api(User, methods=['GET', 'POST', 'DELETE', 'PATCH', 'PUT'], results_per_page=100)
