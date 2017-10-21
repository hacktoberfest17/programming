import os
from ftplib import FTP
from paramiko.client import SSHClient, AutoAddPolicy
from contextlib import closing


def export_via_ftp(local_obj_file, file_name, **config):
    with closing(FTP(
            host=config['host'],
            user=config['user'],
            passwd=config['password'])) as ftp:
        ftp.cwd(config['destination'])
        ftp.storbinary('STOR '+ file_name, local_obj_file)


def export_via_sftp(local_file, file_name, **config):
    with closing(SSHClient()) as client:
        client.set_missing_host_key_policy(AutoAddPolicy)
        client.connect(
            hostname=config['host'],
            port=int(config['port']),
            username=config['user'],
            password=config['password']
        )
        with closing(client.open_sftp()) as sftp:
                sftp.putfo(local_file,
                    os.path.join(config['destination'], file_name))


def export_factory(arg):
    return EXPORT_TYPE[arg]


EXPORT_TYPE = {
    'ftp': export_via_ftp,
    'sftp': export_via_sftp
}
