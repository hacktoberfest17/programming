# Saint News Spider
### Scrapy Spider retrieves news stories about the New Orleans Saints from espn.com

### These directions are intended for use on Linux.

###### This application was produced using Python and Scrapy, versions as follows:
+ Python 3.6.1
+ Scrapy 1.4.0 


###### Once Python is installed, install Scrapy
```
pip install scrapy
```

######Next, you will want to run the application and save the results to a file. Run the following command to crawl the site and save the results.

```
scrapy crawl saints_news -o <filename.csv>
```

The command "scrapy" instantiates the Scrapy framework and the next variable "crawl" instructs Scrapy to initiate a crawl based upon the spider which follows. In this case, "saint_news" which is then followed by the output command and filename "-o saints_news.csv".

You can output files to JSON (.json), JSON Lines (.jl), CSV (.csv).
