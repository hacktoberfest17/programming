# -*- coding: utf-8 -*-
""" Change http references to https.

Author:
    Wellington Pardim Ferreira - wellpardim10@gmail.com

Description: this file will replace any http to https
    from the requested file extensions with specified extension
    from the requested directory.
    It will use mmap module for mem-mapping the files.

Usage:
    Enter the directory you want to modify the files.
    Enter the file extensions you want to modify.

Observation:
    Be sure your user has access to all the files you want to modify.
    Use sudo chown $USER:$USER /path/to/file, if you wish to have permissions.

Todo:
    Check if https address exists before replacing it.

Repository:
    https://github.com/Pardim93/http_to_https
"""

import os
import sys
import mmap

def modify_files(filepaths):
    """ Change found file's http references to https.

        Argument:
            filepaths: filepaths included from specified directory
                with entered file extensions.
        Raises:
            ValueError: It will raise if you try to modify a empty file
            PermissionError: It will raise if you try to modify a file which
                your user has no write access to it.
            FileNotFoundError: It will raise if you try to open a symlink.
    """
    for filepath in filepaths:
        try:
            with open(filepath, 'r+') as file, \
                mmap.mmap(file.fileno(), 0, flags=mmap.MAP_PRIVATE) as mmap_file:

                http_to_https = mmap_file.read().replace(b'http:', b'https:')

                mmap_file.resize(len(http_to_https))
                mmap_file.seek(0)
                mmap_file.write(http_to_https)
                # write changes to the file then close it
                mmap_file.flush()
                mmap_file.close()
        except ValueError as value_err:
            print(value_err, filepath)
        except PermissionError as permission_err:
            print(permission_err)
        except FileNotFoundError as file_not_found_err:
            print(file_not_found_err, '. File might be a broken symlink.')

def get_filepaths():
    """ Return filepaths of all found files with the specified extensions."""
    project_path = get_project_path()
    file_exts = get_files_extensions()

    # array to store filepaths with matched extensions
    filepaths = []
    # walk over the entire project looking for the extensions
    for root, _, files in os.walk(project_path):
        for file in files:
            #  get file extension
            file_ext = os.path.splitext(file)[-1]
            if file_ext in file_exts or file_exts == '*':
                filepaths.append(os.path.join(root, file))

    modify_files(filepaths)

def get_files_extensions():
    """ Return specified file extensions."""

    exts = input("Enter the file extensions you want to modify separated by " \
                             "commas. Enter '*' for all files:\n")
    if exts == '*':
        return exts

    exts = exts.split(',')
    # remove whitespaces, trailing and leading space
    exts = [ext.strip() for ext in exts  if ext.strip()]

    # add dots if needed
    exts = [ext if ext[0] == '.' else '.' + ext for ext in exts]

    return exts

def get_project_path():
    """ Return the specified path, if it exists. Exits if not."""

    project_path = input("Enter the absoulte project path or \
                 hit enter to use your current directory:\n")

    # user entered enter, then get cwd
    if not project_path:
        project_path = os.getcwd()

    if not os.path.isdir(project_path):
        print("Entered path doesn't exist. Aborting...")
        sys.exit(0)

    print("Path entered: " + project_path)

    return project_path

def main():
    """ Starts script. """
    if __name__ == "__main__":
        get_filepaths()

main()
