import sys
input = sys.stdin.readline
n = int(input())
board = [0]*n
answer = 0

# x번째에 board[x]를 놓음
def check(x):
    for i in range(x):
        if board[i] == board[x] or abs(board[i]-board[x]) == abs(i-x):
            return False
    return True

def n_queen(row_num):
    global answer
    if row_num == n:
        answer += 1
        return
    for i in range(n):
        board[row_num] = i
        if check(row_num):
            n_queen(row_num+1)

n_queen(0)
print(answer)