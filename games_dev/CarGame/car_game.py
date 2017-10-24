
#   CAR OBSTACLE COURSE GAME : DODGE IT!
#   Author : Apaar Gupta (@apaar97)
#   Python 3.5.2 Pygame


import pygame
import sys
import random

pygame.init()
width, height = 640, 480
gameDisplay = pygame.display.set_mode((width, height))
pygame.display.set_caption("Dodge It!")
clock = pygame.time.Clock()

car_crash_sound = pygame.mixer.Sound("car_crash.wav")
car_start_sound = pygame.mixer.Sound("car_start.wav")
pygame.mixer.music.load("game_music.wav")

black = (0, 0, 0)
white = (255, 255, 255)
bright_red = (255, 0, 0)
bright_green = (0, 255, 0)
red = (200, 0, 0)
green = (0, 200, 0)
pause = False

carImg = pygame.image.load("car.png")
carRect = carImg.get_rect()
car_w = carRect.right-carRect.left
car_h = carRect.bottom-carRect.top
button_w = 160
button_h = 60
block_w = 80
block_h = 80


def car(x, y):
    gameDisplay.blit(carImg, (x, y))

def block(blockx, blocky, blockw, blockh, color):
    pygame.draw.rect(gameDisplay, color, [blockx, blocky, blockw, blockh])

def collision(ax, ay, aw, ah, bx, by, bw, bh):
    return ax < bx+bw and ay < by+bh and bx < ax+aw and by < ay+ah

def message(text, textSize, textColor, textCenterPos):
    textFont = pygame.font.Font("freesansbold.ttf", textSize)
    textSurf = textFont.render(text, True, textColor)
    textRect = textSurf.get_rect()
    textRect.center = textCenterPos
    gameDisplay.blit(textSurf, textRect)

def button(text, x, y, w, h, inactive_color, active_color, action=None):
    mouse = pygame.mouse.get_pos()
    click = pygame.mouse.get_pressed()
    if x < mouse[0] < x+w and y < mouse[1] < y+h:
        pygame.draw.rect(gameDisplay, active_color, (x, y, w, h))
        if click[0] == 1 and action != None :
            action()
    else:
        pygame.draw.rect(gameDisplay, inactive_color, (x, y, w, h))
    message(text, 22, white, (x+w/2, y+h/2))

def crash():
    message('You Crashed!', 48, bright_red, (width/2, height/4))
    pygame.mixer.Sound.play(car_crash_sound)
    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                quitgame()
        button('PLAY AGAIN', width / 2 - button_w / 2, height / 2, button_w, button_h, green, bright_green, gameloop)
        button('MAIN MENU', width / 2 - button_w / 2, height / 2 + 3 * button_h / 2, button_w, button_h, red, bright_red,gameintro)
        pygame.display.update()
        clock.tick(15)

def showScore(score):
    message("Score : "+str(score), 24, black, (70,30))

def unpause():
    global pause
    pause = False
    pygame.mixer.music.unpause()

def paused():
    pygame.mixer.music.pause()
    while pause:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                quitgame()
        gameDisplay.fill(white)
        button('RESUME', width/2-button_w/2,height/2,button_w,button_h,green,bright_green,unpause)
        button('QUIT', width/2-button_w/2,height/2+3*button_h/2,button_w,button_h,red,bright_red,gameintro)
        message('Game Paused', 64, black, (width / 2, height / 4))
        pygame.display.update()
        clock.tick(15)

def quitgame():
    pygame.quit()
    sys.exit()

def loading():
    pygame.mixer.Sound.play(car_start_sound)
    gameDisplay.fill(white)
    message('LOADING', 42, black, (width/2,height/2))
    x = width/5
    endx = 4*x
    y = 2*height/3
    while x <= endx :
        x += 15
        pygame.draw.rect(gameDisplay, black, (x, y, 15, 5))
        pygame.display.update()
        clock.tick(10)
    gameintro()

def gameintro():
    pygame.mixer.music.play(-1)
    gameDisplay.fill(white)
    pygame.time.delay(2000)
    while True :
        for event in pygame.event.get():
            if event.type == pygame.QUIT :
                quitgame()
        gameDisplay.fill(white)
        button('PLAY', width/2-button_w/2, height/2, button_w, button_h, green, bright_green, gameloop)
        button('QUIT', width/2-button_w/2, height/2+3*button_h/2, button_w, button_h,red, bright_red, quitgame)
        message('Dodge It!', 72, black, (width/2,height/4))
        pygame.display.update()
        clock.tick(15)

def gameloop() :
    global pause
    car_x = width*0.45
    car_y = height*0.8
    block_x = random.randrange(0,width-block_w)
    block_y = -800
    block_speed = 10
    score = 0
    key_right = False
    key_left = False
    while True :
        for event in pygame.event.get() :
            if event.type == pygame.QUIT :
                quitgame()
            if event.type == pygame.KEYDOWN :
                if event.key == pygame.K_LEFT :
                    key_left = True
                if event.key == pygame.K_RIGHT :
                    key_right = True
                if event.key == pygame.K_p :
                    pause = True
                    paused()
            if event.type == pygame.KEYUP :
                if event.key == pygame.K_LEFT :
                    key_left = False
                if event.key == pygame.K_RIGHT :
                    key_right = False

        if key_left and car_x>0 : car_x -= 5
        if key_right and car_x<width-car_w : car_x += 5
        block_y += block_speed

        if block_y>height :
            block_y = -block_h
            block_x = random.randrange(0,width-block_w)
            score += 1
            if score%5 == 0 : block_speed += 1
        gameDisplay.fill(white)
        car(car_x, car_y)
        block(block_x, block_y, block_w, block_h, black)
        showScore(score)
        if collision(car_x, car_y, car_w, car_h, block_x, block_y, block_w, block_h) :
            crash()
        pygame.display.update()
        clock.tick(60)

loading()