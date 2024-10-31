n = int(input())
n_list = list(map(int, input().split()))
n_list.sort()
m = int(input())
for i in input().split():
    target = int(i)
    min_idx = 0
    max_idx = n-1
    answer = 0
    while min_idx <= max_idx:
        mid = (min_idx + max_idx) // 2
        if n_list[mid] == target:
            answer = 1
            break
        elif n_list[mid] < target:
            min_idx = mid + 1
        else:
            max_idx = mid - 1
    print(answer)