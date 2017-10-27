import sys
import time
import telepot
import subprocess
def runProcess(chat_id,gotmsg):
    str=[x.encode('utf-8') for x in gotmsg.split()]
    try:
        if "reboot" in str:
            body="You can't use reboot, use 'shutdown -r hh:mm &' instead"
            return
        #df=subprocess.Popen(str,stdout=PIPE)
        #output,err=df.communicate()
        #print type(output),output
        elif str[0].lower() =="download":
            str=("aria2c -x 16 -s 16 "+str[1]).split()
            print str
            body="Downloaded :)"
        else:
            body="executed"

        output=subprocess.check_call(str,stderr=subprocess.STDOUT)
        bot.sendMessage(chat_id,body)

    except subprocess.CalledProcessError:
        bot.sendMessage(chat_id, "CalledProcessError :(")
    except OSError as e:
        bot.sendMessage(chat_id,"OSError :(")
        #print e.message

def handle(msg):
    content_type, chat_type, chat_id = telepot.glance(msg)
    #print(content_type, chat_type, chat_id)

    if content_type == 'text':
        runProcess(chat_id,msg['text'])
#TOKEN = sys.argv[1]  # get token from command-line
#########################################################################################
TOKEN="PUT_YOUR_TOKEN_HERE"
#########################################################################################
bot = telepot.Bot(TOKEN)
bot.message_loop(handle)
#print ('Listening ...')

# Keep the program running.
while 1:
    time.sleep(2)
