def solution(s):
    answer = True
    stack = []
    for i in s:
        if i == "(":
            stack.append("(")
        else:
            if not stack:
                return False
            stack.pop()
   
    
    return not stack