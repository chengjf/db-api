# -*- coding: utf-8 -*-

from db_api.app import create_app,configure_blueprints, configure_extensions

app = create_app()


configure_blueprints(app)

configure_extensions(app)


