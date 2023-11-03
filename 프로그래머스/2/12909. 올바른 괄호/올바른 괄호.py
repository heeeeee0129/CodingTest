def solution(s):
    answer = True
    stack = []
    for parentheses in s:
        if parentheses == "(":
            stack.append("(")
        else:
            if not stack:
                return False
            stack.pop()
    if stack:
        return False
    
    return True