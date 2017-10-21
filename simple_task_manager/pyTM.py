import os
import sys
import time

filename="todo.txt"

args=["-a","-ls"]

if(len(sys.argv)<2):
    print("Error, Enter some argument")
    print("""-a to Add a task\n-ls to Display all tasks""")
    exit()


if(not os.path.isfile(filename)):
    open("todo.txt","w")
    print("File created")

count = sum(1 for line in open(filename))
count = count + 1

if(sys.argv[1]=="-a"):
    if(len(sys.argv)<4):
        print("Error with argument")
    else:
        task = sys.argv[2]
        duetime = sys.argv[3]
        fl = open(filename, "a+")
        fl.write(str(count)+" "+task + " " + duetime + " \n")

if(sys.argv[1]=="-ls"):
os.system("cat todo.txt")
