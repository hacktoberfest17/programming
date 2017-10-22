"""Configuration loading module."""
from os import environ
import yaml

with open(environ['CONFIG']) as config_file:
    config = yaml.load(config_file.read())
