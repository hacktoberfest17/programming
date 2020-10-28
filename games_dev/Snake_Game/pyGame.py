import random
import pygame

pygame.init()

white = (255, 255, 255)
black = (0, 0, 0)
red = (255, 0, 0)
green = (0, 255, 0)

display_width = 900
display_height = 600
block_size = 30
speed = 30
apple_thickness = 30

gameDisplay = pygame.display.set_mode((display_width, display_height))
pygame.display.set_caption('Slither')
apple_img = pygame.image.load('apple2.png')
snakeHead = pygame.image.load('snakehead.png')
pygame.display.set_icon(apple_img)
clock = pygame.time.Clock()

FPS = 15
small_font = pygame.font.SysFont(None, 25)
med_font = pygame.font.SysFont(None, 50)
large_font = pygame.font.SysFont(None, 80)


def pause():

    paused = True
    message_to_screen("Game Paused", red, -100, "large")
    message_to_screen("press C to continue,R to restart and Q to quit", black, 25)
    pygame.display.update()
    while paused:
        for event in pygame.event.get():
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_q:
                    pygame.quit()
                    quit()
                elif event.key == pygame.K_c:
                    paused = False
                elif event.key == pygame.K_r:
                    paused = False
                    game_loop()
            elif event.type == pygame.QUIT:
                pygame.quit()
                quit()


def score(underscore):
    text = small_font.render("score: " + str(underscore), True, black)
    gameDisplay.blit(text, [10, 10])


def snake(snake_list, direction):
    if direction == 'right':
        head = pygame.transform.rotate(snakeHead, 270)
    elif direction == 'left':
        head = pygame.transform.rotate(snakeHead, 90)
    elif direction == 'top':
        head = pygame.transform.rotate(snakeHead, 0)
    else:
        head = pygame.transform.rotate(snakeHead, 180)
    gameDisplay.blit(head, [snake_list[-1][0], snake_list[-1][1]])
    for xny in snake_list[:-1]:
        pygame.draw.rect(gameDisplay, green, [xny[0], xny[1], block_size, block_size])


def text_objects(text, color, size):
    text_surf = small_font.render(text, True, color)
    if size == "small":
        text_surf = small_font.render(text, True, color)
    elif size == "medium":
        text_surf = med_font.render(text, True, color)
    elif size == "large":
        text_surf = large_font.render(text, True, color)
    return text_surf, text_surf.get_rect()


def message_to_screen(msg, color, y_displace=0, size='small'):
    text_surf, text_rect = text_objects(msg, color, size)
    text_rect.center = (display_width / 2), (display_height / 2) + y_displace
    gameDisplay.blit(text_surf, text_rect)


def game_intro():
    intro = True

    while intro:
        gameDisplay.fill(white)
        message_to_screen("Welcome to Slither", green, -100, "large")
        message_to_screen("Press C to play, P to pause, R to restart and Q to exit", black, -20, "small")
        pygame.display.update()
        clock.tick(5)

        for event in pygame.event.get():
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_q:
                    pygame.quit()
                    quit()
                elif event.key == pygame.K_c:
                    intro = False
            elif event.type == pygame.QUIT:
                pygame.quit()
                quit()


def game_loop():

    game_exit = False
    game_over = False

    lead_x = display_width / 2
    lead_y = display_height / 2

    lead_x_change = speed
    lead_y_change = 0

    snake_list = []
    snake_length = 1

    rand_apple_x = random.randrange(0, display_width - apple_thickness + 1, 30)
    rand_apple_y = random.randrange(0, display_height - apple_thickness + 1, 30)

    direction = 'right'

    while not game_exit:

        if game_over:
            message_to_screen("Game over ", red, y_displace=-50, size="large")
            message_to_screen("Your score is: " + str(snake_length - 1), green, y_displace=10, size="medium")
            message_to_screen("press C to continue, Q to quit", black, y_displace=60, size="medium")
            pygame.display.update()

        while game_over:
            for event in pygame.event.get():
                if event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_q:
                        game_exit = True
                        game_over = False
                    elif event.key == pygame.K_c:
                        game_loop()
                elif event.type == pygame.QUIT:
                    game_exit = True
                    game_over = False

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                game_exit = True
            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_q:
                    game_exit = True
                    game_over = False
                elif event.key == pygame.K_LEFT:
                    lead_x_change = -speed
                    lead_y_change = 0
                    direction = 'left'
                elif event.key == pygame.K_RIGHT:
                    lead_x_change = speed
                    lead_y_change = 0
                    direction = 'right'
                elif event.key == pygame.K_UP:
                    lead_y_change = -speed
                    lead_x_change = 0
                    direction = 'top'
                elif event.key == pygame.K_DOWN:
                    lead_y_change = speed
                    lead_x_change = 0
                    direction = 'down'
                elif event.key == pygame.K_p:
                    pause()
                elif event.key == pygame.K_r:
                    game_loop()

        if lead_x < 0 or lead_x > display_width - block_size or lead_y < 0 or lead_y > display_height - block_size:
            game_over = True

        lead_x += lead_x_change
        lead_y += lead_y_change
        gameDisplay.fill(white)
        while [rand_apple_x, rand_apple_y] in snake_list:
            rand_apple_x = random.randrange(0, display_width - apple_thickness + 1, 30)
            rand_apple_y = random.randrange(0, display_height - apple_thickness + 1, 30)
        gameDisplay.blit(apple_img, (rand_apple_x, rand_apple_y))

        snake_head = list()
        snake_head.append(lead_x)
        snake_head.append(lead_y)
        snake_list.append(snake_head)

        for each in snake_list[:-2]:
            if each == snake_head:
                game_over = True

        if len(snake_list) > snake_length:
            del snake_list[0]

        snake(snake_list, direction)
        score(snake_length - 1)
        pygame.display.update()

        if rand_apple_x <= lead_x < rand_apple_x + apple_thickness:
            if rand_apple_y <= lead_y < rand_apple_y + apple_thickness or rand_apple_y <= lead_y + block_size - 1 < \
                    rand_apple_y + apple_thickness:
                rand_apple_x = random.randrange(0, display_width - apple_thickness + 1, 30)
                rand_apple_y = random.randrange(0, display_height - apple_thickness + 1, 30)
                snake_length += 1

        elif rand_apple_y <= lead_y < rand_apple_y + apple_thickness:
            if rand_apple_x <= lead_x + block_size - 1 < rand_apple_x + apple_thickness or rand_apple_x <= lead_x < \
                    rand_apple_x + apple_thickness:
                rand_apple_x = random.randrange(0, display_width - apple_thickness + 1, 30)
                rand_apple_y = random.randrange(0, display_height - apple_thickness + 1, 30)
                snake_length += 1
        clock.tick(FPS)

    pygame.quit()
    quit()

game_intro()
game_loop()