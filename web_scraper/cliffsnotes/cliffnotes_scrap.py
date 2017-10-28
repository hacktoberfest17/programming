import urllib2
from bs4 import BeautifulSoup
import re

def more(url):
	url = url+"-2"
	req = urllib2.Request(url, headers={ 'User-Agent': 'Mozilla/5.0' })
	plain = urllib2.urlopen(req).read()
	soup = BeautifulSoup(plain, "lxml")
	i = soup.find_all('p',{'class':'litNoteText'})
	return str(i)

f = open("urls.tsv","r")
data = open("data.tsv","w")
ongoing_books = 1
for lines in f.readlines()[1:]:
	lines = lines.split("\t")
	# url = "http://www.cliffsnotes.com/literature/o/100-years-of-solitude/about-100-hundred-years-of-solitude"
	url = lines[0]
	req = urllib2.Request(url, headers={ 'User-Agent': 'Mozilla/5.0' })
	plain = urllib2.urlopen(req).read()
	page_two = ""
	soup = BeautifulSoup(plain, "lxml")
	i = soup.find_all('p',{'class':'litNoteText'})
	page_one = str(i)
	check = "Continued on next page..." 
	if check in page_one:
		page_two = more(url)
	summary = page_one+page_two
	summary = summary.replace(check, "").replace("[","").replace("]","")
	final = re.sub('<[^>]*>', '', summary)
	data.write(final+"\t"+lines[1])
	data.write("\n")
	print ongoing_books
	ongoing_books = ongoing_books + 1
