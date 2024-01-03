def solution(s):
    answer = ''
    flag = True
    for char in s:
        if char.isalpha():
            if flag:
                answer += char.upper()
                print(char)
                flag = False
            else:
                answer += char.lower()
            
        elif char == " ":
            flag = True
            answer += " "
            
        else:
            answer += char
            flag = False
        
    return answer