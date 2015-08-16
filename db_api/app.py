# -*- coding: utf-8 -*-
__author__ = 'sharp'

from flask import Flask
from db_api.extensions import login_manager


def create_app(config=None):
    """Creates the app."""
    # Initialize the app
    app = Flask("db_api")
    # Use the default config and override it afterwards
    app.config.from_object('db_api.configs.default.DefaultConfig')
    # Update the config
    app.config.from_object(config)
    return app


def configure_blueprints(app):
    from .auth.views import auth
    # app.register_blueprint(forum, url_prefix=app.config["FORUM_URL_PREFIX"])
    # app.register_blueprint(user, url_prefix=app.config["USER_URL_PREFIX"])
    app.register_blueprint(auth, url_prefix=app.config["AUTH_URL_PREFIX"])
    # app.register_blueprint(
    #     management, url_prefix=app.config["ADMIN_URL_PREFIX"]
    # )
    # app.register_blueprint(
    #     message, url_prefix=app.config["MESSAGE_URL_PREFIX"]
    # )


def configure_extensions(app):
    from db_api.extensions import db
    from db_api.extensions import restless
    from db_api.views import view
    from db_api.models import model
    # Flask-WTF CSRF
    # csrf.init_app(app)

    # Flask-Plugins
    # plugin_manager.init_app(app)

    # Flask-SQLAlchemy
    db.init_app(app)
    db.app = app

    # init models
    model.init_app(app)



    # init restless
    restless.init_app(app)

    # init views
    view.init_app(app)

    login_manager.init_app(app)

    # Flask-Migrate
    # migrate.init_app(app, db)

    # Flask-Mail
    # mail.init_app(app)

    # Flask-Cache
    # cache.init_app(app)

    # Flask-Debugtoolbar
    # debugtoolbar.init_app(app)

    # Flask-Themes
    # themes.init_themes(app, app_identifier="flaskbb")

    # Flask-And-Redis
    # redis_store.init_app(app)

    # Flask-WhooshAlchemy
    # with app.app_context():
    #     whoosh_index(app, Post)
    #     whoosh_index(app, Topic)
    #     whoosh_index(app, Forum)
    #     whoosh_index(app, Category)
    #     whoosh_index(app, User)

    # Flask-Login
    # login_manager.login_view = app.config["LOGIN_VIEW"]
    # login_manager.refresh_view = app.config["REAUTH_VIEW"]
    # login_manager.anonymous_user = Guest

    # @login_manager.user_loader
    # def load_user(user_id):
    #     """Loads the user. Required by the `login` extension."""
    #
    #     unread_count = db.session.query(db.func.count(Conversation.id)).\
    #         filter(Conversation.unread,
    #                Conversation.user_id == user_id).subquery()
    #     u = db.session.query(User, unread_count).filter(User.id == user_id).\
    #         first()
    #
    #     if u:
    #         user_instance, user_instance.pm_unread = u
    #         return user_instance
    #     else:
    #         return None
    #
    # login_manager.init_app(app)
    #
    # # Flask-BabelEx
    # babel.init_app(app=app, default_domain=FlaskBBDomain(app))
    #
    # @babel.localeselector
    # def get_locale():
    #     # if a user is logged in, use the locale from the user settings
    #     if current_user.is_authenticated() and current_user.language:
    #         return current_user.language
    #     # otherwise we will just fallback to the default language
    #     return flaskbb_config["DEFAULT_LANGUAGE"]


@login_manager.user_loader
def load_user(user_id):
    """Loads the user. Required by the `login` extension."""

    u = db.session.query(User).filter(User.id == user_id).first()
    if u:
        return u
    else:
        return None
