from __future__ import print_function

def print_reverse_num(num):
    print(num[::-1])

if __name__ == "__main__":
    number_input = input("Please input any number (integer): ")
    try:
        converted = int(number_input)
    except ValueError as e:
        print("'{}' is not a number, please input a number ({})"
              .format(number_input, e))
    else:
        print_reverse_num(number_input)
