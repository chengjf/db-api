# -*- coding: utf-8 -*-

# from dotenv import load_dotenv

# dotenv_path = join(dirname(__file__), 'sample.env')
# load_dotenv(dotenv_path)

from flask.ext.script import Manager
from db_api import app

manager = Manager(app)

if __name__ == '__main__':
    manager.run()
