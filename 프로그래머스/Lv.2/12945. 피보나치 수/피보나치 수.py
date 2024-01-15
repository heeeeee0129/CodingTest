import sys
sys.setrecursionlimit(1000000)
def solution(n):
    memo = {}
    return fibonacci(n, memo)

def fibonacci(n, memo):
    if n < 2:
        return n
    
    if n not in memo:
        memo[n] = (fibonacci(n-1, memo) + fibonacci(n-2, memo)) % 1234567
    
    return memo[n]

