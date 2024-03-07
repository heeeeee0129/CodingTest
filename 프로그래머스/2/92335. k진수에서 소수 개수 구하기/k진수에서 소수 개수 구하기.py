import math

def isPrime(n):
    if n == 1:
        return False
    for i in range(2, int(math.sqrt(n))+1):
        if n%i == 0:
            return False
    return True

def solution(n, k):
    answer = -1
    num_list = []
    word = ""
    while n > 0:
        cur = n % k
        n = n // k
        if cur == 0:
            num_list.append(word)
            word = ""
        else:
            word = str(cur) + word
        
    num_list.append(word)
    count = 0
    for num in num_list:
        if num and isPrime(int(num)):
            count+=1          
    return count