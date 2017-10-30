"""This module writes every contributor to contributor.md"""

import urllib.request
import os
import json

#List of contributor object (name,weburl)
CONTRIBUTORS = []

#first page with 100 contributors
with urllib.request.urlopen("https://api.github.com/repos/hacktoberfest17/" +
                            "programming/contributors?per_page=100&page=1") as response:
    HEADERS = response.info()
    PAGE = 2
    for val in json.loads(response.read()):
        CONTRIBUTORS.append((val['login'], val['html_url']))

        #if github has more pages
        while HEADERS['Link'].find('rel="next"') is not -1:
            with urllib.request.urlopen("https://api.github.com/repos/hacktoberfest17/" +
                                        "programming/contributors?per_page=100&page=" +
                                        str(PAGE)) as response:
                HEADERS = response.info()
                PAGE += 1
                for contributor in json.loads(response.read()):
                    CONTRIBUTORS.append((contributor['login'], contributor['html_url']))

#write to the file contributors.md
FILE = open(os.path.join(os.path.dirname(__file__), 'CONTRIBUTORS.md'), "w")
FILE.write("""## Check your hacktoberfest contributions at:
 [hacktoberfest.digitalocean.com/stats](https://hacktoberfest.digitalocean.com/stats/t2013anurag)



Programming contributors (sorted contributions)
============================================


""")

for contributor in CONTRIBUTORS:
    FILE.write("* **[" + str(contributor[0]) +"]("+str(contributor[1])+")**\n\n\n")

FILE.close()
