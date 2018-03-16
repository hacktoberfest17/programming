# ----------- #
# <-- Credits --> #
# Developed by James George #


# importing various modules required especially pygame.
import pygame
import sys
import time
import random

# Initializing pygame.

pygame.init()

# Initializing the width and height of the window to be 680 and 1250 pixels respectively.

display_height = 680
display_width = 1250

# Setting the title and dimensions of the window

pygame.display.set_caption('Catch It!')
gameDisplay = pygame.display.set_mode((display_width, display_height))

# Defining the clock to set the FPS rates
clock = pygame.time.Clock()


# Defining setText() function to display text to the screen which requires six parameters to be supplied while calling it:

# 1. The text to be displayed.
# 2. The font size.
# 3. The position in terms of X and Y coordinates in pixles where the text is to be displayed.
# 4. The background color which defaults to None if nothing are supplied.
# 6. The font type / font-family as string enclosed within double quotations which defaults to Times New Roman.

def setText(text, font_size, position, foreground_color, background_color=None, font_family="Times New Roman"):
    # Setting the font and related font features as per the parameters supplied.

    font = pygame.font.SysFont(font_family, font_size)
    text_to_display = font.render(text, 1, foreground_color, background_color)
    gameDisplay.blit(text_to_display, position)
    pygame.display.update()

# Defining functions for file operations.


def file_open_write(high_score):

    f = open('../res/File/high_score.txt', 'w')
    f.write(high_score)
    return f


def file_open_read():

    f = open('../res/File/high_score.txt', 'r')
    best_score = f.read()
    return f, best_score


def file_close(file):

    file.close()


# Game Play starts here!!!


def game_play():
    # Images section

    # Relatively small sized images to be placed in the main menu

    minion_image = pygame.image.load('../res/images/small_minion.jpg')

    basket_image = pygame.image.load('../res/images/small_basket.jpg')

    egg_images = ['../res/images/1.jpg', '../res/images/2.jpg', '../res/images/3.jpg', '../res/images/4.jpg',
                  '../res/images/5.jpg', '../res/images/6.jpg', '../res/images/7.gif', '../res/images/8.jpg',
                  '../res/images/9.jpg', '../res/images/bomb.png']

    bomb_image = pygame.image.load(egg_images[9])

    basket = pygame.image.load('../res/images/basket.jpg')

    minion = pygame.image.load(egg_images[7])

    explosion = pygame.image.load('../res/images/explosion.gif')

    # Initializing the speed variable which denotes the speed with which the images move.

    image_speed = 3

    # Intialiaing the score variable.

    score = 0

    # Pixels being moved by the basket under keystrokes (10 px)

    unit = 7

    # Initialising a boolean variable user_click to False to keep track of the user clicking any button in the main menu

    user_clicked = False

    # Boolean variables to keep track which button the user taps on the main menu

    # Whether it is the:

    # 1. Play now button

    play_clicked = False

    # 2. Instructions button

    instruction_clicked = False

    # 3. Best Scores button

    best_scores_clicked = False

    # Intialising game over variable.

    game_over = False

    # Main Menu with 3 Buttons

    # Setting white background to the game window
    gameDisplay.fill((255, 255, 255))

    # The Title moving up and positioning itself in the required co-ordinates.
    for i in range(display_height + 100, 14, -10):
        setText("Catch It!!", 140, (display_width / 2 - 340, i), (225, 10, 20), (255, 255, 255), "Algerian")
        pygame.time.wait(5)

    # Underlines
    pygame.draw.line(gameDisplay, (125, 20, 220), (display_width / 2 - 340, 165), (display_width / 2 + 330, 165))
    pygame.draw.line(gameDisplay, (25, 120, 220), (display_width / 2 - 340, 168), (display_width / 2 + 330, 168))
    pygame.draw.line(gameDisplay, (220, 20, 125), (display_width / 2 - 340, 170), (display_width / 2 + 330, 170))

    pygame.time.wait(1000)

    gameDisplay.blit(bomb_image, (display_width / 2 + 340, 25))

    start = display_height + 40
    end = 299
    value = 0

    # Setting the basket image to move from start to end.
    '''while start>= end:
        gameDisplay.blit(basket_image, (display_width/2-550, start))
        start-= value
        pygame.time.wait(1000)
        value+= 1
        pygame.display.update()'''

    gameDisplay.blit(basket_image, (display_width / 2 - 550, 300))

    gameDisplay.blit(minion_image, (display_width / 2 - 470, 355))

    ''' q = 0
    for j in range(-20, 346):
        q+=j
        gameDisplay.blit(minion_image, (display_width/2-465, q))
        pygame.time.wait(10)'''

    time.sleep(1)

    # Play Button
    pygame.draw.rect(gameDisplay, (225, 10, 20), (display_width / 2 - 100, 260, 230, 100))

    # Setting Play text on the button with setText() method
    setText("Play !", 80, (530, 260), (255, 255, 255), None, "forte")

    time.sleep(1)

    # Instructions Button
    pygame.draw.rect(gameDisplay, (30, 220, 20), (display_width / 2 - 200, 400, 440, 100))

    # Setting Instructions text on the button with setText() method
    setText("Instructions", 80, (435, 400), (255, 255, 255), None, "forte")

    time.sleep(1)

    # Best Scores Button
    pygame.draw.rect(gameDisplay, (30, 22, 240), (display_width / 2 - 200, 540, 440, 100))

    # Setting Best Scores text on the button with setText() method
    setText("Best Scores", 80, (450, 540), (255, 255, 255), None, "forte")

    pygame.display.update()

    while not user_clicked:

        # (Event Loop) Keyboard and Mouse events (Checking whether the user had clicked any button)

        for event in pygame.event.get():

            # Retrieving the mouse co-ordinates (Returns a list with 2 elements i,e X and Y co-ordinates)

            mouse_cord = pygame.mouse.get_pos()

            # Checking whether the close button was tapped and if so terminate the program!
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()

            # Checking whether the mouse is within the boundaries of the respective buttons in order (Hovered / Not)
            if display_width / 2 - 100 + 230 > mouse_cord[0] > display_width / 2 - 100 and 360 > mouse_cord[1] > 260:

                pygame.draw.rect(gameDisplay, (150, 220, 200), (display_width / 2 - 100, 260, 230, 100))
                setText("Play !", 80, (530, 260), (225, 10, 20), None, "forte")

                # Checking whether the user has clicked the play button
                if event.type == pygame.MOUSEBUTTONDOWN:
                    user_clicked = True
                    play_clicked = True

            else:

                pygame.draw.rect(gameDisplay, (225, 10, 20), (display_width / 2 - 100, 260, 230, 100))
                setText("Play !", 80, (530, 260), (255, 255, 255), None, "forte")

            if display_width / 2 - 200 + 440 > mouse_cord[0] > display_width / 2 - 200 and 500 > mouse_cord[1] > 400:

                pygame.draw.rect(gameDisplay, (225, 100, 200), (display_width / 2 - 200, 400, 440, 100))
                setText("Instructions", 80, (435, 400), (30, 220, 20), None, "forte")

                # Checking whether the user has clicked the Instructions button
                if event.type == pygame.MOUSEBUTTONDOWN:
                    user_clicked = True
                    instruction_clicked = True
            else:

                pygame.draw.rect(gameDisplay, (30, 220, 20), (display_width / 2 - 200, 400, 440, 100))
                setText("Instructions", 80, (435, 400), (255, 255, 255), None, "forte")

            if display_width / 2 - 200 + 440 > mouse_cord[0] > display_width / 2 - 200 and 640 > mouse_cord[1] > 540:

                pygame.draw.rect(gameDisplay, (16, 140, 122), (display_width / 2 - 200, 540, 440, 100))
                setText("Best Scores", 80, (450, 540), (75, 22, 205), None, "forte")

                # Checking whether the user has clicked the Best scores button
                if event.type == pygame.MOUSEBUTTONDOWN:
                    user_clicked = True
                    best_scores_clicked = True

            else:

                pygame.draw.rect(gameDisplay, (30, 22, 240), (display_width / 2 - 200, 540, 440, 100))
                setText("Best Scores", 80, (450, 540), (255, 255, 255), None, "forte")

        clock.tick(60)

    # Instructions window
    if instruction_clicked:
        
        instruction_window = pygame.display.set_mode((display_width, display_height))

        pygame.display.set_caption('Instructions')

        instruction_clock = pygame.time.Clock()

        instruction_window.fill((69, 250, 245))

        setText("Instructions", 120, (display_width / 2 - 360, 50), (125, 20, 220), None, "Elephant")

        pygame.draw.line(instruction_window, (255, 0, 0), (display_width / 2 - 360, 180), (display_width / 2 + 400, 180), 5)

        pygame.draw.line(instruction_window, (0, 255, 0), (display_width / 2 - 360, 185), (display_width / 2 + 400, 185), 5)

        pygame.draw.line(instruction_window, (0, 0, 255), (display_width / 2 - 360, 190), (display_width / 2 + 400, 190), 5)

        setText("1. Use left and right arrow keys to move the basket appropriately.", 45, (40, 220), (255, 0, 0))

        setText("2. Use down arrow key to stop the basket at that point.", 45, (40, 290), (0, 185, 0))

        setText("3. Collect as many eggs as you can with the basket.", 45, (40,360), (0, 0, 255))

        setText("4. Avoid crashing with minions and bombs!", 45, (40, 430), (255, 0, 0))
        
        setText("5. Points Awarded: 1, 3, 5 and 10 depending up on the kind of egg.", 45, (40, 500), (255, 0, 255))
        
        pygame.draw.rect(instruction_window, (0, 128, 255), (display_width / 2 - 180, 560, 160, 80))

        setText("Back", 60, (display_width / 2 - 160, 570), (255, 255, 255))

    while instruction_clicked:

        for event in pygame.event.get():

            mouse = pygame.mouse.get_pos()

            if event.type == pygame.QUIT:

                pygame.quit()
                sys.exit()

            if display_width / 2 - 20 > mouse[0] > display_width / 2 - 180 and 640 > mouse[1] > 560:

                pygame.draw.rect(instruction_window, (255, 255, 255), (display_width / 2 - 180, 560, 160, 80))

                setText("Back", 60, (display_width / 2 - 160, 570), (0, 128, 255))

                setText("Best of Luck!!", 60, (display_width / 2, 560), (185, 0, 0), None, "Forte")

                if event.type == pygame.MOUSEBUTTONDOWN:

                    instruction_clicked = False
                    game_play()


            else:
                
                pygame.draw.rect(instruction_window, (0, 128, 255), (display_width / 2 - 180, 560, 160, 80))

                setText("Back", 60, (display_width / 2 - 160, 570), (255, 255, 255))

                instruction_window.fill((69, 250, 245), (display_width / 2, 570, 500, 70))

        pygame.display.update()

        instruction_clock.tick(30)

        



    # Shows  previous best high score stored in files in the same directory where the game lies
    if best_scores_clicked:
        score_window = pygame.display.set_mode((display_width, display_height))

        pygame.display.set_caption('High Score')

        score_clock = pygame.time.Clock()

        score_window.fill((255, 255, 255))

        setText("High Score", 120, (display_width / 2 - 320, 50), (125, 20, 220), None, "Elephant")

        pygame.draw.line(score_window, (255, 0, 0), (display_width / 2 - 320, 180), (display_width / 2 + 340, 180), 5)

        pygame.draw.line(score_window, (0, 255, 0), (display_width / 2 - 320, 185), (display_width / 2 + 340, 185), 5)

        pygame.draw.line(score_window, (0, 0, 255), (display_width / 2 - 320, 190), (display_width / 2 + 340, 190), 5)

        file_object, high_score = file_open_read()

        setText(high_score, 100, (display_width / 2, display_height / 2), (0, 255, 0))

        pygame.draw.rect(score_window, (212, 3, 108), (display_width / 2 - 130, display_height / 2 + 160, 300, 130))

        setText("Go Back", 80, (display_width / 2 - 120, display_height / 2 + 180), (255, 255, 255))

        file_close(file_object)

    while best_scores_clicked:


        for event in pygame.event.get():

            mouse_position = pygame.mouse.get_pos()

            if event.type == pygame.QUIT:

                pygame.quit()
                sys.exit()

            if display_width / 2 + 170 > mouse_position[0] > display_width / 2 - 130 and display_height / 2 + 290 > mouse_position[1] > display_height / 2 + 160:

                pygame.draw.rect(score_window, (212, 3, 108), (display_width / 2 - 130, display_height / 2 + 160, 300, 130))

                setText("Go Back", 80, (display_width / 2 - 120, display_height / 2 + 180), (255, 255, 255))

                if event.type == pygame.MOUSEBUTTONDOWN:

                    best_scores_clicked = False
                    game_play()

            else:

                pygame.draw.rect(score_window, (212, 108, 3), (display_width / 2 - 130, display_height / 2 + 160, 300, 130))

                setText("Go Back", 80, (display_width / 2 - 120, display_height / 2 + 180), (255, 255, 255))

        pygame.display.update()

        score_clock.tick(30)

    # X and Y co-ordinates of the basket.
    basket_x = display_width / 2 - 200

    basket_y = display_height - 270

    # For changing the X co-ordinate of the basket when appropriate keys are pressed.
    x_change = 0

    # Random positions for eggs

    x = random.randint(0, display_width - 250)
    y = -150

    # Randomly loading Egg images

    random_images = egg_images[random.randint(0, 9)]

    random_eggs = pygame.image.load(random_images)

    # Game in action !!!

    while play_clicked:

        # New game window is created on clicking the play button with the same dimensions.
        play_window = pygame.display.set_mode((1250, 680))

        pygame.display.set_caption('Play')

        play_window.fill((255, 255, 255))

        play_clock = pygame.time.Clock()

        play_window.blit(random_eggs, (x, y))

        # Horizontal line carrying the basket.

        pygame.draw.line(play_window, (175, 115, 0), (0, display_height - 20), (display_width, display_height - 20))

        # Color beneath the line.

        pygame.draw.rect(play_window, (243, 128, 12), (0, display_height - 18, display_width, display_height))

        for event in pygame.event.get():

            # Event handling
            if event.type == pygame.QUIT:

                pygame.quit()
                sys.exit()

            elif event.type == pygame.KEYDOWN:

                if event.key == pygame.K_RIGHT:

                    x_change = unit

                elif event.key == pygame.K_LEFT:

                    x_change = -unit

                elif event.key == pygame.K_DOWN:

                    x_change = 0

        basket_x += x_change

        y += image_speed

        # Placing the Basket in position

        play_window.blit(basket, (basket_x, basket_y))

        # Placing score on the game window.

        setText("Your Score:" + str(score), 40, (0, 0), (107, 20, 99), (128, 255, 255))

        # Checking egg and basket crossover.

        if y + 80 >= basket_y and y + 80 <= basket_y + 15:

            if x >= basket_x - 40 and x + 100 <= basket_x + display_width / 2 - 240:

                # Checks collision with bomb and minion image

                if random_images == egg_images[9] or random_images == egg_images[7]:

                    score -= 5
                    setText("Your Score:" + str(score), 40, (0, 0), (107, 20, 99), (128, 255, 255))

                     # Checking whether the current score is greater than the best score.
                     
                    file, current_best_score = file_open_read()

                    file_close(file)

                    if score > int(current_best_score):
                        file = file_open_write(str(score))
                        file_close(file)

                    setText("Crashed", 150, (display_width / 2 - 240, 35), (0, 0, 0))
                    setText(None, 40, (0, 0), (255, 255, 255))
                    play_window.blit(explosion, (basket_x, basket_y - 80))
                    pygame.display.update()

                    time.sleep(3)

                    for k in range(0, display_width + 1, 5):
                        setText("Your Score:" + str(score), 40, (k, 0), (107, 20, 99), (128, 255, 255))
                        pygame.time.wait(20)

                    time.sleep(2)

                    game_over = True
                    play_clicked = False

                # Makes the egg disappear !

                y = display_height

                # Incrementing the score appropriately.

                if random_images == egg_images[6]:

                    score += 1

                elif random_images == egg_images[0] or random_images == egg_images[1] or random_images == egg_images[3]:

                    score += 3

                elif random_images == egg_images[4] or random_images == egg_images[5] or random_images == egg_images[8]:

                    score += 5

                elif random_images == egg_images[2]:

                    score += 10

        # Checking whether the egg image had crossed the floor.

        if y >= display_height + 200:

            # Random positions for eggs

            x = random.randint(0, display_width - 250)
            y = -150

            # Randomly loading Egg images

            random_images = egg_images[random.randint(0, 9)]

            random_eggs = pygame.image.load(random_images)

            # Increasing the speed in which the basket moves both the directions.

            if unit != 15:
                unit += 1

            # Increasing the speed in which the images moves down.

            if image_speed != 16:
                image_speed += 1

        # Restricting the basket within the width of the Game window

        if basket_x <= 0:

            basket_x = 0

        elif basket_x >= display_width - 300:

            basket_x = display_width - 300

        pygame.display.update()
        play_clock.tick(60)


    # Game Over window

    if game_over:

            game_over_window = pygame.display.set_mode((display_width, display_height))

            pygame.display.set_caption("Game Over Buddy!")

            game_over_clock = pygame.time.Clock()

            game_over_window.fill((188, 7, 116))

            setText("G", 90, (180, 250), (255, 255, 255), None, "Elephant")

            pygame.time.wait(400)

            setText("A", 90, (270, 250), (255, 255, 255), None, "Elephant")

            pygame.time.wait(400)

            setText("M", 90, (360, 250), (255, 255, 255), None, "Elephant")

            pygame.time.wait(400)

            setText("E", 90, (460, 250), (255, 255, 255), None, "Elephant")

            pygame.time.wait(400)

            setText("O", 90, (630, 250), (5, 96, 196), None, "Elephant")

            pygame.time.wait(400)

            setText("V", 90, (720, 250), (5, 96, 196), None, "Elephant")

            pygame.time.wait(400)

            setText("E", 90, (810, 250), (5, 96, 196), None, "Elephant")

            pygame.time.wait(400)

            setText("R", 90, (900, 250), (5, 96, 196), None, "Elephant")

            pygame.time.wait(400)

            pygame.draw.rect(game_over_window, (244, 122, 11), (display_width / 2 - 200, 420, 420, 90))

            setText("Back to Main Menu", 50, (display_width / 2 - 190, 430), (255, 255, 255))

            pygame.draw.rect(game_over_window, (255, 255, 128), (display_width / 2 - 110, 540, 180, 95))

            setText("Credits", 60, (display_width / 2 - 110, 550), (0, 128, 127), None, "Forte")

    while game_over:

            for event in pygame.event.get():

                if event.type == pygame.QUIT:
                    pygame.quit()
                    sys.exit()

                mouse = pygame.mouse.get_pos()

                if display_width / 2 + 220 > mouse[0] > display_width / 2 - 200 and 510 > mouse[1] > 420:

                    pygame.draw.rect(game_over_window, (128, 128, 255), (display_width / 2 - 200, 420, 420, 90))

                    setText("Back to Main Menu", 50, (display_width / 2 - 190, 430), (255, 0, 0))

                    if event.type == pygame.MOUSEBUTTONDOWN:
                        game_over = False
                        game_play()

                else:

                    pygame.draw.rect(game_over_window, (244, 122, 11), (display_width / 2 - 200, 420, 420, 90))

                    setText("Back to Main Menu", 50, (display_width / 2 - 190, 430), (255, 255, 255))

                if display_width / 2 + 70 > mouse[0] > display_width / 2 - 110 and 635 > mouse[1] > 540:

                    pygame.draw.rect(game_over_window, (235, 125, 255), (display_width / 2 - 110, 540, 180, 95))

                    setText("Credits", 60, (display_width / 2 - 110, 550), (0, 128, 127), None, "Forte")

                    if event.type == pygame.MOUSEBUTTONDOWN:
                        credit_clicked = True
                        game_over = False

                else:

                    pygame.draw.rect(game_over_window, (255, 255, 128), (display_width / 2 - 110, 540, 180, 95))

                    setText("Credits", 60, (display_width / 2 - 110, 550), (0, 128, 127), None, "Forte")

            pygame.display.update()

            game_over_clock.tick(60)

    # Variables required for foreground colors.
    i=65

    j=64

    k=65        

    if credit_clicked:

        credits_window = pygame.display.set_mode((display_width, display_height))

        pygame.display.set_caption("CREDITS")

        credits_clock = pygame.time.Clock()

        credits_window.fill((0, 255, 255))

        setText("CREDITS", 150, (display_width / 2 - 280, 20), (127, 178, 68), None, "Algerian")

        pygame.draw.line(credits_window, (0, 0, 255), (display_width / 2 - 280, 160), (display_width / 2 + 280, 160), 3)
        
        pygame.draw.line(credits_window, (0, 255, 0), (display_width / 2 - 280, 165), (display_width / 2 + 280, 165), 3)

        pygame.draw.line(credits_window, (255, 0, 0), (display_width / 2 - 280, 170), (display_width / 2 + 280, 170), 3)
        
        pygame.time.wait(1000)
       
        setText("Developer:", 120, (display_width / 2 - 240, display_height / 2 - 150), (0, 170, 0), None, "Forte")
        
        setText("James", 100, (display_width / 2 - 170, display_height / 2 - 20), (i, j, k), None, "Elephant")

        pygame.time.wait(1500)    

        setText("George", 100, (display_height / 2 + 90, display_height / 2 + 80), (k, j, i), None, "Elephant")

        pygame.time.wait(1500)
        
        pygame.draw.rect(credits_window, (160, 0, 0), (display_width / 2 - 230, display_height / 2 + 200, 470, 120))

        setText("Play Again!", 80, (display_width / 2 - 205, display_height / 2 + 210), (0, 160, 0), None, "Forte")
        
    while credit_clicked:
        
        if i >= 255:
            i = 64

        if j >=255:
            j = 65

        if k >=255:
            k = 64        
        
        setText("James", 100, (display_width / 2 - 170, display_height / 2 - 20), (i, j, k), None, "Elephant")    

        setText("George", 100, (display_height / 2 + 90, display_height / 2 + 80), (k, j, i), None, "Elephant")

        for event in pygame.event.get():

            mouse_pos = pygame.mouse.get_pos()

            if event.type == pygame.QUIT:

                pygame.quit()
                sys.exit()

            if display_width / 2 + 260 > mouse_pos[0] > display_width / 2 - 230 and display_height / 2 + 300 > mouse_pos[1] > display_height / 2 + 200:

                pygame.draw.rect(credits_window, (0, 0, 160), (display_width / 2 - 230, display_height / 2 + 200, 470, 120))

                setText("Play Again!", 80, (display_width / 2 - 205, display_height / 2 + 210), (0, 160, 0), None,"Forte")
                
                if event.type == pygame.MOUSEBUTTONDOWN:

                    credit_clicked = False
                    game_play()

            else:

                pygame.draw.rect(credits_window, (160, 0, 0), (display_width / 2 - 230, display_height / 2 + 200, 470, 120))

                setText("Play Again!", 80, (display_width / 2 - 205, display_height / 2 + 210), (0, 160, 0), None, "Forte")

        i += random.randint(1, 10)

        j += random.randint(1, 10)

        k += random.randint(1, 10)
        
        pygame.display.update()

        credits_clock.tick(30)        


if __name__ == '__main__':
    game_play()
