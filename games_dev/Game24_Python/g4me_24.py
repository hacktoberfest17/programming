import re
from collections import OrderedDict
import os
import sys
import random

class Game_24 :
    number_pattern = re.compile(r"\D+")    #Except integer number
    correct_answer = 24
    answer = 0
    player_name = ""
    ranking = OrderedDict()
    question = []
    temp_ranking_list = []

    def __init__(self, name):
        self.player_name = name
        if os.path.isfile("ranking.txt") :      #Read if exist file
            #print("THERE's")
            self.read_ranking_file()            #Read file ranking.txt
        else :
            ranking_file_temp = open("ranking.txt", "w")     #Create a file if there isn't
            ranking_file_temp.close()

    #Check player name for resume
    def have_play_ever(self):
        if self.player_name not in self.ranking:
            self.ranking[self.player_name] = 0

    #Check answer == 24
    def check_answer(self, answer, answer_equation):
        if self.check_good_answer(answer_equation) == False :
            print("You are going to cheating me!!!")
            sys.exit()

        #print(number_checker)
        if self.correct_answer == answer :
            print("WHAT A GENIUS!!!")
            self.add_score()
        else :
            print("Try again later!!!, BYE")
            sys.exit()

    #If answer is correct add score to player
    def add_score(self):
        #print("adding. . . . .")
        self.ranking[self.player_name] += 1
        print(self.ranking[self.player_name])
        #print("added . . . . .")
        #print(self.player_name + "   " + str(self.ranking[self.player_name]))
        #print(self.ranking[self.player_name])

    #Showing ranking table
    def show_ranking(self):
        self.sort_ranking()
        os.system("clear")                             #Clear screen
        print("<><><><><><><><><><><>Ranking<><><><><><><><><><><>")
        for player in self.temp_ranking_list :
                print(player[0] + "  " + str(player[1]))
        print("<><><><><><><><><><><><><><><><><><><><><><><><><><>")

    #Show player name
    def show_name(self):
        print(self.player_name)

    #Sorting ranking table
    def sort_ranking(self):
        self.ranking = (OrderedDict(sorted(self.ranking.items(), key = lambda t : t[1])))
        self.temp_ranking_list = list(self.ranking.items())
        self.temp_ranking_list.reverse()

    #Radomize the number for a new question
    def random_number(self):
        self.question = []
        for i in range(4):
            self.question.insert(i, random.randint(1, 9))

    #Show question's number
    def show_number(self):
        print("QUESTION :", end=" ")
        for each_num in self.question:
            print(" " + str(each_num), end = " ")


    #Check for only answer from given number will pass
    def check_good_answer(self, answer_equation):
        number_checker = re.split(self.number_pattern, answer_equation)
        while "" in number_checker : number_checker.remove("")
        #print(number_checker)
        sorted_number_checker = sorted(number_checker)
        sorted_question = sorted(self.question)

        for n_check, n_question in zip(sorted_number_checker, sorted_question) :
            if str(n_check) != str(n_question) :
                return False

    #Reading a ranking file
    def read_ranking_file(self):
        ranking_file = open("./ranking.txt", "r+")
        for line in ranking_file:
            line_temp = line.split(" ")
            #print(line_temp)
            player_name_temp = line_temp[0]
            #print("++++++++++++++++++++++++++++")
            #print(line_temp[1].strip(), end="x")
            #print("++++++++++++++++++++++++++++")
            player_score = line_temp[1].strip()
            #print(player_score, end="test")
            self.ranking[player_name_temp] = int(player_score)
        ranking_file.close()

    #Writing a ranking file(Inclue Updating scores)
    def write_ranking_file(self):
        ranking_file = open("./ranking.txt", "w+")
        #for player in self.ranking:
        #    print(player + " " + str(self.ranking[player]) + "\n")
        #    ranking_file.write(player + " " + str(self.ranking[player]) + "\n")
        #for player, score in self.ranking.items():
        #    ranking_file.write(player + " " + str(score) + "\n")
        for player in self.temp_ranking_list :
                ranking_file.write(player[0] + " " + str(player[1]) + "\n")
        ranking_file.close()
