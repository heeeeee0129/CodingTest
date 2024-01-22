import math

def solution(arr):
    
    while len(arr) > 1:
        arr.append(lcm(arr.pop(), arr.pop()))
    return arr[0]

def lcm(a, b):
    return (a*b)//math.gcd(a,b)