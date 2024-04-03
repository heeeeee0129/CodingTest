import sys
input = sys.stdin.readline
n, m = map(int, input().split())

selected = [0] * m

def n_and_m(prev, count):
    global selected, n, m
    if count == m:
        print(*selected)
        return
    for i in range(1, n+1):
        if prev <= i:
            selected[count] = i
            n_and_m(i, count+1)

n_and_m(0, 0)