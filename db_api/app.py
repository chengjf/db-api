# -*- coding: utf-8 -*-
__author__ = 'sharp'

from flask import Flask
from db_api.extensions import login_manager
from db_api.models.user import User

from .extensions import db
from .extensions import restless
from .views import view
from .models import model
from .tools import init_user_data
from .auth.views import auth
__author__ = 'sharp'





def create_app(config=None):
    """Creates the app."""

    # Initialize the app
    app = Flask("db_api")

    # Use the default config and override it afterwards
    app.config.from_object('db_api.configs.default.DefaultConfig')
    # Update the config
    app.config.from_object(config)
    # try to update the config via the environment variable
    # app.config.from_envvar("FLASKBB_SETTINGS", silent=True)

    configure_blueprints(app)

    configure_extensions(app)

    # configure_template_filters(app)
    # configure_context_processors(app)
    # configure_before_handlers(app)
    # configure_errorhandlers(app)
    # configure_logging(app)

    # init tools
    init_user_data(app)



    # initial login manager
    login_manager.init_app(app)

    return app


def configure_blueprints(app):
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
    """Configures the extensions."""

    # Flask-WTF CSRF
    # csrf.init_app(app)

    # Flask-Plugins
    # plugin_manager.init_app(app)

    # Flask-SQLAlchemy
    db.init_app(app)

    # init models
    model.init_app(app)

    # init db
    db.app = app
    db.create_all()

    # init restless
    restless.init_app(app)

    # init views
    view.init_app(app)

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
