#!/usr/bin/env python
###### Command line for getting indian train history for last n days at different stations
###### Requirement: BeautifulSoup from bs4 repository
###### Example: "python scrapTrainHistory.py 13237 10 0100011 PNBE,BSB,MGS"
###### 1st argument is the train number,
###### 2nd argument is the running status for last n days (from today ) on which the train runs,
###### 3rd argument is the days of the week on which the train runs starting from Mon to Sun, where 0100010 means that the train runs only on Tue and Sat.
###### 4th argument is the stations codenames for which we want the status.(Must be the boarding, deboarding point or the station of interest.)
###### Note: This scrapper is for educational/learning purpose only.
import urllib2
import sys
import time
from time import sleep
from bs4 import BeautifulSoup as bs
daydict={'Mon':0,'Tue':1,'Wed':2,'Thu':3,'Fri':4,'Sat':5,'Sun':6}
def scrapDATA(train,date):
    data1=urllib2.urlopen("https://runningstatus.in"+"/status/"+str(train)+"-on-"+str(date))
    return data1.read()

def forTrain(train,date):
    data=scrapDATA(train,date)
    st=""
    soup=bs(data,'lxml')
    table=soup.find("table",{"class":"table table-striped table-bordered"})
    tbody=table.find("tbody")
    for x in tbody.findAll("tr"):
        td=x.findAll('td')
        if len(td)==7 and td[0].string.split()[-1][1:-1] in stations:
            st+= td[0].string.split()[-1][1:-1]+" /"
            late=td[6].findAll('font')
            st+=td[2].string+" / "+late[1].string+"\n"
        elif len(td) == 5:
            pass
    return st

def allday(train,count,run):
    print "Train No:",train
    today=time.time()
    p=-1
    while count > 0:
        p+=1
        day=time.ctime(today-24*60*60*p).split()
        # print day,daydict[day]
        if run[ daydict[day[0]] ] == '0':
            continue
        x=time.strftime('%Y%m%d',time.localtime(today-24*60*60*p))
        print " ".join( [ day[0],day[1],day[2],day[3] ] )
        print forTrain(train,str(x))
        count-=1

if __name__ == '__main__':
    train,count,run,stations=sys.argv[1],sys.argv[2],list(sys.argv[3]),sys.argv[4].split(",")
    allday(train,int(count),run)
