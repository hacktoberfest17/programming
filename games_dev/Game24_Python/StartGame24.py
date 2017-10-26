from g4me_24 import Game_24
import random
import os
import re
import sys

number_pattern = ("(\d+)")
os.system("clear")              #Clear screen
print("""\
                       Game 24
########################################################
RULE:
1.Use +, -, *, / to calculate random number equal to 24.
2.Please anwser in term of mathimetic equation.
3.Each number can use only once.
4.Enjoy!!!

Option
1.Press and Enter -1 for request new random numbers
2.Press and Enter 0 for show ranking board
3.Press and Enter spacebar to exit a game
########################################################
""")

name = input("\nPlease enter your name : ")
game_start = Game_24(name)
print("Hello, " + name + "\n")
game_start.have_play_ever()
game_start.random_number()
while(True):
    game_start.show_number()
    answer_equation = input("\nPlease enter your answer in mathematical equation or your option : ")
    if answer_equation == "-1":             #Request a new question
        game_start.random_number()
        continue
    elif answer_equation == "0":            #Request a ranking table
        game_start.show_ranking()
        continue
    elif answer_equation == " ":            #Quit a game
        break
    try:
        answer = eval(answer_equation)      #Calculating equation
    except Exception:
        print("Waring!!! : Please input your equation or option")
        sys.exit()
    if game_start.check_answer(answer, answer_equation) == True :
        game_start.random_number()

game_start.write_ranking_file()
os.system("clear")
print("""\
        <3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3
        <3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3
        <3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3
        <3<3<3<3<3<3<3<3 Thank You, Hope you enjoy it <3<3<3<3<3<3<3<3<3
        <3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3
        <3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3
        <3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3
        """)
