import os
import time
import telepot
from telepot.loop import MessageLoop

def handle(msg):
    content_type, chat_type, chat_id = telepot.glance(msg)
    if content_type == 'text':
        answer = rot13(msg['text'])
        bot.sendMessage(chat_id, answer)
    else:
        bot.sendMessage(chat_id,"Sorry I can only answer text messages right now")

def rot13(text):
    x=""
    for i in text:
        x+=chr(ord('A')+(ord(i.upper())-ord('A')+13)%26)
    return x

#Has to be taken from @botfather
TOKEN = os.environ['TOKEN']

bot = telepot.Bot(TOKEN)
MessageLoop(bot, handle).run_as_thread()
print ('Listening ...')

while 1:
    time.sleep(1000)