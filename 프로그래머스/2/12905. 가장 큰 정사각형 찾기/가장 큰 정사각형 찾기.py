
def solution(board):
    answer = 0
    n = len(board)
    m = len(board[0])
    
    dp = [[0]*m for _ in range(n)]
    
    for i in range(m):
        dp[0][i] = board[0][i]
        answer = max(answer, dp[0][i])
    
    for i in range(n):
        dp[i][0] = board[i][0]
        answer = max(answer, dp[i][0])
        
    for i in range(1, n):
        for j in range(1, m):
            if board[i][j] == 1:
                dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
                answer = max(answer, dp[i][j])
                
    
#     for i in range(m):
#         for j in range(n):
#             if board[i][j] == 1:
#                 count = 1

#                 while(i+count < m and j+count < n):
#                     flag = True
#                     for d in range(0, count+1):
#                             if board[i+d][j+count] == 0:
#                                 flag = False
#                                 break
#                             if board[i+count][j+d] == 0:
#                                 flag = False
#                                 break
#                     if not flag:
#                         break
#                     count+=1
                    
#                 answer = max((count)*(count), answer)

    return answer*answer