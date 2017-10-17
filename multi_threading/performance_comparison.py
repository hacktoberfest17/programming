#!/usr/bin/env python3

# requires `requests`
# pip install requests

import requests
import time
import threading

URLS = [
    "https://www.{}".format(host)
    for host in (
        "wikipedia.org", "python.org", "fsf.org", "usaultimate.org", "npr.org",
        "reddit.com", "nytimes.com", "github.com", "scala-lang.org",
        "weather.gov", "apple.com", "whatsapp.com", "trello.com", "spotify.com",
        "duckduckgo.com", "mozilla.org", "canonical.com",
        "docker.com", "democracynow.org", "google.com",
    )
]

def get_and_print(url):
    response = requests.get(url)
    print("{}\t{}".format(response.status_code, response.url))


print("Making 20 HTTP GETs serially...")
start = time.time()
for url in URLS:
    get_and_print(url)

duration = time.time() - start
print("Serial GETs took {} seconds".format(duration))

print("\n---------\n")

print("Making 20 HTTP GETs in separate threads...")
start = time.time()
threads = []
for url in URLS:
    threads.append(
        threading.Thread(target=get_and_print, args=(url, ))
    )
for thread in threads:
    thread.start()
for thread in threads:
    thread.join()
duration = time.time() - start
print("Threaded GETs took {} seconds".format(duration))

# Sample output
# Making 20 HTTP GETs serially...
# 200 https://www.wikipedia.org/
# 200 https://www.python.org/
# ...
# 200 https://www.google.com/
# Serial GETs took 9.889546871185303 seconds
#
# ---------
#
# Making 20 HTTP GETs in separate threads...
# 200 https://www.apple.com/
# 200 https://www.wikipedia.org/
# ...
# 200 https://www.docker.com/
# Threaded GETs took 2.1607656478881836 seconds
