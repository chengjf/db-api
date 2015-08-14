# -*- coding: utf-8 -*-

__author__ = 'sharp'


class Model(object):
    def init_app(self, app):
        from .system import System
        from .user import User
        pass
