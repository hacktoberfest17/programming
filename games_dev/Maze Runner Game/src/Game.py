import pygame

import random

import time

import sys


pygame.init()


    
display_width = 800
display_height = 600

gameDisplay = pygame.display.set_mode((display_width,display_height))
pygame.display.set_caption('Maze Runner')

black = (0,0,0)
white = (255,255,255)

clock = pygame.time.Clock()
gameExit=False


#Images


#Tree obstacles

images=['../resources/images/tree1.jpeg','../resources/images/tree2.jpeg','../resources/images/tree3.jpeg','../resources/images/shrub1.jpeg','../resources/images/shrub2.jpeg']

#Cloud images

clouds=['../resources/images/cloud_1.jpg','../resources/images/cloud_2.png','../resources/images/cloud_3.jpg']

#Bird images

birds=['../resources/images/bird1.jpg','../resources/images/bird2.jpg']

Img1= pygame.image.load('../resources/images/sonic_run.jpg')

Img2=pygame.image.load('../resources/images/sonic_still.jpg')

#Displaying score on the top-left corner

def your_score(string,count=0,size=0):
    font = pygame.font.SysFont(None,size)
    text = font.render(string+str(count), True, (200,25,0))
    gameDisplay.blit(text,(0,0))

def img1(x,y):
    gameDisplay.blit(Img1, (x,y))

def img2(x,y):
    gameDisplay.blit(Img2, (x,y))

x =  (display_width * 0.050)
y = (display_height * 0.66)






start_x=720
start_y=396
height=80



red=90
green=185
blue=125





#Main Menu

def title_objects(text, font):
    textSurface = font.render(text, True, (255,255,255))
    return textSurface, textSurface.get_rect()

def title(text):
    largeText = pygame.font.Font('freesansbold.ttf',75)
    TextSurf, TextRect = title_objects(text, largeText)
    TextRect.center = ((display_width/2),(display_height/2-210))
    gameDisplay.blit(TextSurf, TextRect)

    pygame.display.update()




def play_now_objects(text, font):
    textSurface = font.render(text, True, (255,255,255))
    return textSurface, textSurface.get_rect()

def play_now(text):
    largeText = pygame.font.Font('freesansbold.ttf',40)
    TextSurf, TextRect = play_now_objects(text, largeText)
    TextRect.center = (display_width/2+10,display_height/2-40)
    gameDisplay.blit(TextSurf, TextRect)

    pygame.display.update()





def quit_text_objects(text, font):
    textSurface = font.render(text, True, (255,255,255))
    return textSurface, textSurface.get_rect()

def quit_text(text):
    largeText = pygame.font.Font('freesansbold.ttf',45)
    TextSurf, TextRect = quit_text_objects(text, largeText)
    TextRect.center = (display_width/2,display_height/2+100)
    gameDisplay.blit(TextSurf, TextRect)

    pygame.display.update()    


#Crashed Message Displaying Methods

def text_objects(text, font):
    textSurface = font.render(text, True, black)
    return textSurface, textSurface.get_rect()

def message_display(text):
    largeText = pygame.font.Font('freesansbold.ttf',65)
    TextSurf, TextRect = text_objects(text, largeText)
    TextRect.center = ((display_width/2),(display_height/2))
    gameDisplay.blit(TextSurf, TextRect)

    pygame.display.update()

    

    





#Displaying the score

def text_render(text, font):
    textSurface = font.render(text, True, (255,0,0))
    return textSurface, textSurface.get_rect()

def display(text):
    largeText = pygame.font.Font('freesansbold.ttf',45)
    TextSurf, TextRect = text_render(text, largeText)
    TextRect.center = ((display_width/2),(30))
    gameDisplay.blit(TextSurf, TextRect)

    pygame.display.update()

    time.sleep(3)


    


score=0
speed=3.5

user_click=False







pygame.mixer.music.load('../resources/music/intro.mp3')
pygame.mixer.music.play(-1)


i=0
j=8
k=14

index=0

#Main Menu

while not user_click:


         
         for event in pygame.event.get():

             

             
             if i>=255:
                i=0

             if j>=255:
                j=2

             if k>=255:
                k=3 


          
             #gameDisplay.fill((i,j,k))

              
             maze_img=pygame.image.load('../resources/images/maze.jpeg')
             gameDisplay.blit(maze_img,(0,0))  


             title("Maze Runner Game!")
             
             #Getting the mouse co-ordinates

             mouse = pygame.mouse.get_pos()

             #Play Now button

             if display_width/2-100+220 > mouse[0] > display_width/2-100 and display_height/2-80+70 > mouse[1] > display_height/2-80:
                 
                pygame.draw.rect(gameDisplay, (235,25,15),(display_width/2-100,display_height/2-80,220,70))
                play_now("Play Now")

                if event.type==pygame.MOUSEBUTTONDOWN:

                    user_click=True
             else:
                pygame.draw.rect(gameDisplay, (0,200,0), (display_width/2-100,display_height/2-80,220,70))
                play_now("Play Now")
                
             
             #Quit button
             
             if display_width/2-100+220 > mouse[0] > display_width/2-100 and display_height/2+60+70 > mouse[1] > display_height/2+60:
                
                pygame.draw.rect(gameDisplay, (0,200,0), (display_width/2-100,display_height/2+60,220,70))
                quit_text("Quit")
                if event.type==pygame.MOUSEBUTTONDOWN:
                    pygame.quit()
                    sys.exit()

             else:

                pygame.draw.rect(gameDisplay, (235,25,15), (display_width/2-100,display_height/2+60,220,70))
                quit_text("Quit")

             
             i+=2

             j+=14

             k+=20   
pygame.mixer.music.stop()
            
                     


random_tree=random.randint(0,4)

tree_obstacles=pygame.image.load(images[random_tree])

if random_tree==3:
   gameDisplay.blit(tree_obstacles,(start_x,start_y+52))

elif random_tree==4:
     gameDisplay.blit(tree_obstacles,(start_x,start_y+20))
   
else:               
     gameDisplay.blit(tree_obstacles,(start_x,start_y))

#Bird coordinates

bird_x=920
bird_y=320

random_cloud=random.randint(0,2)

#Cloud initial coordinates

cloud_x=880
cloud_y=200

#Setting initial value of the bird list index to zero!
index=0

#move_down=False

pygame.mixer.music.load("../resources/music/gamePlay.mp3")
pygame.mixer.music.play(-1,4.0)

while not gameExit:

       

    bird_img=pygame.image.load(birds[index])

    if index==0:
        index=1
    else:
        index =0
    
    
    for event in pygame.event.get():
        

        
        i+=1

        
    
        if event.type == pygame.QUIT:
            gameExit=True

        if event.type==pygame.KEYDOWN:
            if event.key==pygame.K_UP:
                
                
                y-=80
                pygame.mixer.music.load('../resources/music/jump.wav')
                pygame.mixer.music.play(1)

            
            if event.key==pygame.K_SPACE:
                
                
                y-=80
                pygame.mixer.music.load('../resources/music/jump.wav')
                pygame.mixer.music.play(1)
                
              
                    
        
        if event.type==pygame.KEYUP:
            if event.key==pygame.K_UP or pygame.K_SPACE:
               
               y=display_height*0.66
       
               
      

        '''if move_down:
           
           pygame.time.delay(300)
           y=display_height*0.66'''
             
           



    

    gameDisplay.fill(white)
    score+=1
    #Rectangular blocks instead
    #pygame.draw.rect(gameDisplay, (red,green,blue), [start_x,start_y,80,height])

    #Displaying the tree obstacles randomly
    

        
    if random_tree==3:
           gameDisplay.blit(tree_obstacles,(start_x,start_y+52))

    elif random_tree==4:
             gameDisplay.blit(tree_obstacles,(start_x,start_y+20))

    else:               
             gameDisplay.blit(tree_obstacles,(start_x,start_y)) 
    
    start_x-=speed

    #Horizontal line

    pygame.draw.line(gameDisplay, (0, 0, 0), (0, 480), (800,480))

    if i%2==0:
           img1(x,y)
    else:
           img2(x,y)
    


    #Green colour beneath the horizontal line       

    pygame.draw.rect(gameDisplay,[0,255,0],[0,481,800,200])

    #Blue-ish tone!

    pygame.draw.rect(gameDisplay,[25,95,235],[0,0,800,80])

    #Mighty sun!

    sun_img=pygame.image.load('../resources/Images/sun_normal.png')

    gameDisplay.blit(sun_img,(660,100))

    #Generating clouds randomly


    cloud_img=pygame.image.load(clouds[random_cloud])

    gameDisplay.blit(cloud_img,(cloud_x,cloud_y))

    cloud_x-=1

    #Birds as obstacles in the air

    #bird_img=pygame.image.load(birds[index])

    gameDisplay.blit(bird_img,(bird_x,bird_y))

    bird_x-=speed

    your_score("Your score is ",score,30)

    #Ensuring that the tree doesn't come beneath the bird

    if bird_x>=start_x+80 and bird_x-speed<=start_x:
        bird_x+=280

    #Checking whether the obstacle crossed sonic

    #Comparing X and Y coordinates of sonic with that of the obstacle
   
    if start_x<=x+65 and start_x-speed>=x:
        

        #Checking whether sonic and the obstacle has the same y co-ordinate (Crashed!!!)
        
        if start_y==y:
           pygame.mixer.music.load('../resources/music/crash.wav')
           pygame.mixer.music.play(-1)
           message_display("GAME OVER")
           display("Your score is "+str(score))
           break
    #Checking whether X and Y coordinate of the bird and sonic are the same

    if bird_x<=x+45:

        #Checking whether sonic and the bird has the same Y co-ordinate

         if bird_y-4==y:
           pygame.mixer.music.load('../resources/music/crash.wav')
           pygame.mixer.music.play(1)   
           message_display("GAME OVER")
           display("Your score is "+str(score))
           break

    #Checking whether the tree obstacles crossed the left most point    
    
    if start_x<=-40:
        random_tree=random.randint(0,4)
        
        tree_obstacles=pygame.image.load(images[random_tree])

        
        if random_tree==3:
           gameDisplay.blit(tree_obstacles,(start_x,start_y+52))

        elif random_tree==4:
             gameDisplay.blit(tree_obstacles,(start_x,start_y+20))

        else:               
             gameDisplay.blit(tree_obstacles,(start_x,start_y))

        

        #setting the co-ordinates of tree obstalces to initial values             
        
        start_x=720
        #height=random.randint(70,80)
        start_y=396

        '''red+=30
        green+=30
        blue+=30

        if red>=255:
            red=90
        if green>=255:
            green=90
        if blue>=255:
            blue=125'''


        
        if speed>=20:
            speed=23.5

        else:
            speed+=1
        pygame.mixer.music.load('../resources/music/gamePlay.mp3')
        pygame.mixer.music.play(-1,i)

    #Checking whether the cloud crossed the leftmost point        


    if cloud_x<=-40:

        random_cloud=random.randint(0,2)

        cloud_img=pygame.image.load(clouds[random_cloud])

        gameDisplay.blit(cloud_img,(cloud_x,cloud_y))

        #Resetting cloud co-ordinates             

        cloud_x=880
        cloud_y=200


    if bird_x<=0:

        if index==0:
            index=1
        else:
            index=0

        bird_img=pygame.image.load(birds[index])    
                  
        gameDisplay.blit(bird_img,(bird_x,bird_y))


                                                         
        bird_x=920+(start_x-speed+40)
        bird_y=320
        
        if speed>=20:
            speed=23.5

        else:
            speed+=1

        
    

    pygame.display.update()
    clock.tick(60)


pygame.display.update()

    

pygame.quit()
quit()
 
 
 
