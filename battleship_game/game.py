class Ship:
    '''
    class Ship objects have method shoot_at
    '''
    def __init__(self,  length):
        '''
        :param length: length of the ship 1-4
        '''
        self.bow = (0, 0)  # (horizontal, vertical)
        self.horizontal = False
        self.__length = length
        self.__hit = [False]*length

    def shoot_at(self, coordinates):
        '''
        checks if the ship is hit
        :param coordinates: where to shoot
        :return: true if the whloe ship is hit
        '''

        for i in range(self.__length):
            if self.horizontal:
                if (self.bow[0], self.bow[1+i]) == coordinates:
                    self.__hit[i] = True
                    break
            else:
                if (self.bow[0+i], self.bow[1]) == coordinates:
                    self.__hit[i] = True
                    break

        if self.__hit == [True]*self.__length:
            return True


class Field:
    '''
    generates field and displays field with and without ships
    '''

    def __init__(self):
        self.__ships = Field.generator()
        self.shot_at = set()
        self.shot_ship = set()

    @staticmethod
    def generator():
        '''
        generates field
        :return: two-dimentional list with ships
        '''
        from random import randint, choice

        def test_fail(square):

            for i in range(square[0]-1, square[0]+2):
                for j in range(square[1]-1, square[1]+2):
                    try:
                        if field[i][j] is not None:
                            return True
                    except IndexError:
                        continue

        field = [[None] * 10 for i in range(10)]
        for size in range(4, 0, -1):
            for number in range(5 - size):
                while True:
                    i = randint(0, 9)  #horizontal
                    j = randint(0, 9)  #vertical
                    direction = choice(['horizontal', 'vertical'])
                    ship = []
                    check = False
                    if direction == 'vertical':
                        if i + size > 10:
                            continue
                        for k in range(size):
                            square = (i+k, j)
                            ship.append(square)
                            if test_fail(square):
                                check = True
                                break
                    else:
                        if j + size > 10:
                            continue
                        for k in range(size):
                            square = (i, j+k)
                            ship.append(square)
                            if test_fail(square):
                                check = True
                                break
                    if check:
                        continue
                    else:
                        break

                ship_example = Ship(size)
                ship_example.bow = (i, j)
                if direction == 'horizontal':
                    ship_example.horizontal = True
                else:
                    ship_example.horizontal = False

                for tile in ship:
                    try:
                        field[tile[0]][tile[1]] = ship_example
                    except IndexError:
                        print(tile)
        return field

    def shoot_at(self, coordinates):
        '''
        check if user hit the ship
        :param coordinates: where to shoot
        :return: 2 if ship is destroyed, 1 if ship is it, 0 if missed
        '''
        try:
            if coordinates not in self.shot_at:
                self.shot_at.add(coordinates)
                if self.__ships[coordinates[0]][coordinates[1]] is not None:
                    self.shot_ship.add(coordinates)
                    if self.__ships[coordinates[0]][coordinates[1]].shoot_at(coordinates):
                        return 2
                    else:
                        return 1
                else:
                    return 0
        except IndexError as err:
            print(err, coordinates)

    def field_without_ships(self):
        '''
        :return: two-dimentional list of places where the players shot at
        '''
        field = [[' '] * 10 for i in range(10)]
        for shot_tile in self.shot_at:
            if self.__ships[shot_tile[0]][shot_tile[1]] is None:
                field[shot_tile[0]][shot_tile[1]] = '0'
            else:
                field[shot_tile[0]][shot_tile[1]] = 'X'
        for i in range(10):
            field[i] = ' '.join(field[i])
        return '\n'.join(field)

    def field_with_ships(self):
        '''
        :return: two-dimentional list of places where the players shot at and ships
        '''
        field = [[' '] * 10 for i in range(10)]
        for line in range(10):
            for ship_tile in range(10):
                if self.__ships[line][ship_tile] is not None:
                    field[line][ship_tile] = '*'
        for shot_tile in self.shot_at:
            if self.__ships[shot_tile[0]][shot_tile[1]] is None:
                field[shot_tile[0]][shot_tile[1]] = '0'
            else:
                field[shot_tile[0]][shot_tile[1]] = 'X'

        return '\n'.join(' '.join(field[i]) for i in range(10))


class Player:
    '''
    objects of class Player have method read_position
    '''
    def __init__(self, name):
        self.__name = name

    def read_position(self):
        '''
        reads where to shoot from input
        :return: coordinates where to shoot
        '''
        position = input('{}, where do you want to shoot?'.format(self.__name))
        while not(position[0].isalpha() and position[1:].isnumeric() and
                  'A' <= position[0].upper() <= 'J' and
                  1 <= int(position[1:]) <= 10):
            position = input('Please enter valid coordinates: ')
        coordinates = (int(position[1])-1, ord(position[0].upper()) - ord("A"))
        return coordinates


class Game:
    def __init__(self, names):
        self.names = names
        self.__players = [Player(input("1st player's name: ")),
                          Player(input("2nd player's name: "))]
        self.field = [Field(), Field()]
        self.__current_player = 0

    def read_position(self, player):
        '''
        reads position where to shoot
        :param player: current player
        :return: coordinates
        '''
        return self.__players[player].read_position()

    def field_without_ships(self, player):
        '''
        :param player: current player
        :return: list of places shot at
        '''
        return self.field[player].field_without_ships()

    def field_with_ships(self, player):
        '''
        :param player: current player
        :return: list of places shot at
        '''
        return self.field[player].field_with_ships()

    def action(self):
        '''
        activates the game
        '''
        while len(self.field[0].shot_ship) < 20 or len(self.field[1].shot_ship) < 20:
            print(self.field_with_ships(self.__current_player))
            print('\n'*3)
            print(self.field_without_ships(1 - self.__current_player))

            coordinates = self.__players[self.__current_player].read_position()
            ex = self.field[1 - self.__current_player].shoot_at(coordinates)
            if ex == 2:
                print("Good job, you've destroyed the ship. Have a go again!")
                continue
            elif ex == 1:
                print("You hit the ship! It's your turn again")
                continue
            else:
                print("Oh, you missed. Sorry")
                self.__current_player = 1 - self.__current_player
                input("PRESS ENTER")
                print(" \n"*100)
                input("PRESS ENTER")
                continue

        print("CONGRATULATIONS, {}! YOU WON!".format(self.__current_player))
