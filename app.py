# -*- coding: utf-8 -*-

from os.path import join, dirname
from dotenv import load_dotenv

dotenv_path = join(dirname(__file__), 'sample.env')
load_dotenv(dotenv_path)

from flask.ext.script import Manager, prompt, prompt_bool, prompt_pass
from db_api import app
from db_api.model import system
from db_api.database import db

manager = Manager(app)

if __name__ == '__main__':
	manager.run()