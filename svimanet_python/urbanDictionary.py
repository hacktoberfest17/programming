# Python 2.6
from bs4 import BeautifulSoup
import lxml.html
import urllib2
import sys

def urban(term):
	url = "http://urbandictionary.com/define.php?term=%s" %term
	resource = BeautifulSoup(urllib2.urlopen(url), "lxml")
	content = resource.find('div', {"class":"meaning"}).text.strip()
	strlen = len(content.split())
	string = content
	splits = 1

	if strlen > 75:
		string = content.split(".")[0]
		for x in range(splits):
			if strlen>20:
				string += content.split(".")[splits]
				splits += 1

		string += "."
	print string
	return string


urban("kek")