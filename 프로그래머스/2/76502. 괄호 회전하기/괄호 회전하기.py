def solution(s):
    count = 0
    for i in range(len(s)):
        arr = s[i:] + s[:i]
        if analyze(arr):
            count+=1        
    return count

def analyze(arr):
    open = ['(', '{', '[']
    close = [')','}',']']
    stack = []
    for i in arr:
        if i in open:
            stack.append(i)
        else:
            if not stack:
                return False
            brace = stack.pop()
            if brace != open[close.index(i)]:
                stack.append(brace)
                stack.append(i)
    return not stack
            
      