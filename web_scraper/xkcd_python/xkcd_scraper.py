from bs4 import BeautifulSoup
import urllib.request
import requests

## Base URL for all XKCD Comics
url = "https://xkcd.com/"

## Taking user input for comic number to scrape
print("Enter Comic Number (<1883)")
n = int(input())

## Generating URL for comicUrl
url_to_get = url + str(n)

## Getting page content using requests.get
page = requests.get(url_to_get).content

## Parsing the page as BeautifulSoup Object
soup = BeautifulSoup(page , "html.parser")

## Finding div element with id 'comic'
ImageDiv = soup.find("div",{"id":"comic"})

## Extracting image url from dictionary
comicImageTag = ImageDiv.find("img")
comicUrl = comicImageTag['src']

## Printing image url
print("The image URL is https:" + comicUrl)

## Creating a string for filename
filename = "comic" + str(n) + comicUrl[-4:len(comicUrl)]

## Downloading imahe using urllib
urllib.request.urlretrieve("https:" + comicUrl , filename)

print("Saved file as " + filename)
