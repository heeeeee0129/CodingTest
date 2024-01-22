def solution(n):
    dp = [1]*(n+1)
    if n < 2:
        return 1
    for i in range(2, n+1):
        dp[i] = (dp[i-1] + dp[i-2]) % 1234567
    return dp[n]


