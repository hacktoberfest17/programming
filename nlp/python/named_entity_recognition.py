#Named Entity Recognition- The idea is to have the machine immediately be able to pull out "entities" like people, places, things, locations, monetary figures, and more.

#NE Type and Examples
#ORGANIZATION - Georgia-Pacific Corp., WHO
#PERSON - Eddy Bonte, President Obama
#LOCATION - Murray River, Mount Everest
#DATE - June, 2008-06-29
#TIME - two fifty a m, 1:30 p.m.
#MONEY - 175 million Canadian Dollars, GBP 10.40
#PERCENT - twenty pct, 18.75 %
#FACILITY - Washington Monument, Stonehenge
#GPE - South East Asia, Midlothian

import nltk
from nltk.corpus import state_union
from nltk.tokenize import PunktSentenceTokenizer

train_text = state_union.raw("2005-GWBush.txt")
sample_text = state_union.raw("2006-GWBush.txt")

custom_sent_tokenizer = PunktSentenceTokenizer(train_text)

tokenized = custom_sent_tokenizer.tokenize(sample_text)

def process_content():
    try:
        for i in tokenized[5:]:
            words = nltk.word_tokenize(i)
            tagged = nltk.pos_tag(words)
            namedEnt = nltk.ne_chunk(tagged, binary=True)
            namedEnt.draw()
    except Exception as e:
        print(str(e))


process_content()

# When Binary is False, it picked up the same things, but wound up splitting up terms like White House into "White" and "House" as if they were different,
# whereas we could see in the binary = True option, the named entity recognition was correct to say White House was part of the same named entity.