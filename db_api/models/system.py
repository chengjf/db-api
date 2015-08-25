# -*- coding: utf-8 -*-

from db_api.extensions import db
from db_api.extensions import restless
from db_api.models.processor import create_restless_api


class System(db.Model):
    """
    system
    """
    __tablename__ = "system"

    id = db.Column(db.Integer, primary_key=True)
    number = db.Column(db.String(255), unique=True, nullable=False)
    name = db.Column(db.String(255), nullable=False)
    desc = db.Column(db.String(512))


create_restless_api(System, 'system', 'systems')
