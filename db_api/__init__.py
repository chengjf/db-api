# -*- coding: utf-8 -*-

from .app import create_app


class UserDataConfig(object):
    INIT_USER_DATA = False


app = create_app(UserDataConfig)
