import scrapy
import datetime

class NewsSpider(scrapy.Spider):
    name = "saints_news"
    start_urls = [
            'http://www.espn.com/nfl/team/_/id/18',
            # 'file:///home/malbwa/projects/saints_news_spider/saints_news-2017-10-19.html',
        ]
    
    def parse(self, response):
        # today_date = datetime.date.isoformat(datetime.date.today())
        # filename = 'saints_news-%s.csv' % today_date
        # with open(filename, 'wb') as f:
        #     f.write(response.body)
        a = 0
        for article in response.xpath('//article/div'):
            yield {
                'title': article.xpath('//h1/text()')[a].extract(),
                'text': article.xpath('//p/text()')[a].extract(),
            }
            a += 1
        # titles = response.xpath('//article/div/h1/text()').extract()
        # articles =  response.xpath('//article/div/p/text()').extract()
        # for title, article in zip(titles, articles):
        #     new_articles = [title, article,]
