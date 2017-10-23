import RPi.GPIO as GPIO
import time
# blinking function
def blink(pin):
    GPIO.output(pin,GPIO.HIGH)
    time.sleep(0.1)
    GPIO.output(pin,GPIO.LOW)
#    time.sleep(1)
    return
# setup pi board pin
GPIO.setmode(GPIO.BCM)
# setup GPIO output channel
GPIO.setup(17,GPIO.OUT)
GPIO.setup(18,GPIO.OUT)
# call the function blink
# blink GPIO17 50 times
for i in range(0, 50):
    blink(17)
    blink(18)
# cleanup
GPIO.cleanup()
