def solution(s):
    dict = {"zero":"0", "one":"1", "two":"2", "three":"3", "four":"4" , "five":"5", "six":"6", "seven":"7", "eight":"8", "nine":"9"}
    answer = ""
    temp = ""
    for num in s:
        if "0" <= num <= "9":
            answer += num
        else:
            temp+= num
            if temp in dict:
                answer+=dict[temp]
                temp = ""
    return int(answer)