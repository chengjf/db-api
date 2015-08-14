# -*- coding: utf-8 -*-

__author__ = 'sharp'
from db_api.extensions import db


class View(object):
    app = None

    def init_app(self, app):
        self.app = app
        self.config_views()
        self.init_restless()
        pass

    def config_views(self):
        self.app.add_url_rule('/', 'index', self.index)
        self.app.add_url_rule('/todo/api/v1.0/tasks', None, self.get_tasks, methods=['GET'])

    def get_tasks(self):
        print('get tasks');

    def index(self):
        pass
        print("index")
        # return "Hello, world!"
        return self.app.send_static_file("index.html")

    def init_restless(self):
        from flask_restless import APIManager
