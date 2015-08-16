# -*- coding: utf-8 -*-

# from dotenv import load_dotenv

# dotenv_path = join(dirname(__file__), 'sample.env')
# load_dotenv(dotenv_path)

from flask.ext.script import Manager
from click.decorators import command
from db_api import app
from db_api.tools import init_user_data
from db_api.extensions import db

manager = Manager(app)


@manager.command
def init_admin():
    init_user_data(app)

@manager.command
def init_db():
    db.create_all()


if __name__ == '__main__':
    manager.run()
