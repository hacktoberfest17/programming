from setuptools import setup, find_packages

setup(
    name='MyFtp',
    version='0.1',
    description='FTP and SFTP methods',
    author='Lays Rodrigues',
    author_email='laysrodriguessilva@gmail.com',
    license='GPLV3',
    packages=find_packages(),
    install_requires=[
        'paramiko==2.2.1',
        'PyYAML==3.12',
    ],
)
