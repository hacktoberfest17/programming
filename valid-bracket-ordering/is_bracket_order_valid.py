""" Amazon Problem -> the order of brackets
- Part A: Given a string of parentheses, as such: "((()))", determine if the string is a valid ordering of parentheses.
  Valid string examples:
    - "()()()"
    - "((()))"
    - "(())()"
    - "((())())"
  Invalid string examples:
    - "())()"
    - ")))((("
    - "(())())"
  Return type: boolean
  Part B: Given a string of mixed brackets, as such: "([{}])", determine if the string is a valid ordering of parentheses.
    Valid string examples:
      - "{{}}[[]](())"
      - "({([])})"
      - "()[]{}"
    Invalid string examples:
      - "{{}}[{]}()"
      - "{[()()])}"
  Return type: boolean
  """

def valid_bracket_order_part_a(string):
    stack = []
    try:
        for letter in string:
            if (letter == "("):
                stack.append(letter)
            elif (letter == ")"):
                stack.pop()
        return len(stack) == 0
    except IndexError:
        return False

def valid_bracket_order_part_b(string):
    stack = []
    brackets = {
        ")" : "(",
        "]" : "[",
        "}" : "{"
    }
    try:
        for letter in string:
            if (letter == "(" or letter == "[" or letter == "{"):
               stack.append(letter)
            elif (stack[len(stack)-1] == brackets[letter]):
                stack.pop()
            else:
                return False
        return len(stack) == 0
    except IndexError:
        return False

if __name__ == "__main__":
    # Test A: - Valid
    print(valid_bracket_order_part_a("()()()"))
    print(valid_bracket_order_part_a("((()))"))
    print(valid_bracket_order_part_a("((())())"))
    print()
    
    # Test A: - Invalid
    print(valid_bracket_order_part_a("())()"))
    print(valid_bracket_order_part_a(")))((("))
    print(valid_bracket_order_part_a("(())())"))
    print()

    # Test B: Valid
    print(valid_bracket_order_part_b("{{}}[[]](())"))
    print(valid_bracket_order_part_b("({([])})"))
    print(valid_bracket_order_part_b("()[]{}"))
    print()

    # Test B: Invalid
    print(valid_bracket_order_part_b("{{}}[{]}()"))
    print(valid_bracket_order_part_b("{[()()])}"))