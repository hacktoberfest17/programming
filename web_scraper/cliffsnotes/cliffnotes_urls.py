import urllib2
from bs4 import BeautifulSoup

f = open("urls.tsv","w")
f.write("link\tbook\tauthor\n")
url = "http://www.cliffsnotes.com/literature"
req = urllib2.Request(url, headers={ 'User-Agent': 'Mozilla/5.0' })
plain = urllib2.urlopen(req).read()
soup = BeautifulSoup(plain, "lxml")
i = soup.find('section',{'class':'content active'})
for tag in i.find_all('li'):
	link = tag.find("a").get("href")
	link = str(filter(lambda x:ord(x) > 31 and ord(x) < 128, link))
	book = tag.find("h4").getText()
	book = str(filter(lambda x:ord(x) > 31 and ord(x) < 128, book))
	author = tag.find("p").getText()
	author = str(filter(lambda x:ord(x) > 31 and ord(x) < 128, author))
	link = "http://www.cliffsnotes.com"+link
	f.write(link+"\t"+book+"\t"+author)
	f.write("\n")
	# print link,book,author
