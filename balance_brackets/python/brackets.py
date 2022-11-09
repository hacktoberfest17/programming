def is_balanced(s):
    brackets = {'(': ')', '[': ']', '{': '}'}
    stack = []
    for c in s:
        if c in '([{':
            stack.append(c)
        elif c in ')]}' and len(stack) > 0:
            if brackets[stack[-1]] != c:
                return False  # not the right bracket
            stack.pop()
        else:
            return False  # invalid character
    return len(stack) == 0
