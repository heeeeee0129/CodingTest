import sys
input = sys.stdin.readline

n, m = map(int, input().split())
selected = [False] * n
nums = sorted(list(map(int, input().rstrip().split())))

def n_and_m(count, result):
    if count == m:
        print(*result)
        return
    prev = 0
    for i in range(n):
        if not selected[i] and prev != nums[i]:
            prev = nums[i]
            selected[i] = True
            n_and_m(count + 1, result + [nums[i]])
            selected[i] = False

n_and_m(0, [])