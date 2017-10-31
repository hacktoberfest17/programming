import webbrowser, sys, requests, json, xml.etree.ElementTree
from urllib.request import urlopen
word = sys.argv[1]

'''
Check is word given to program is a real word.
'''
def exists():
    url = r'https://wiktionary.org/w/api.php?action=query&titles={}&format=json'.format(word)
    response = requests.get(url)
    data = response.json()
    if not '-1' in data['query']['pages']:
        print('Real word')
        return 0
    else:
        print('Try another word that one doesn\'t exist')
        return 1
        sys.exit(0)

exists()
