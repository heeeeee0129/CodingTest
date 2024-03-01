t = int(input())

def subset(all_list):
    global m
    result = []
    for flag in range(1, 1 << m):
        sub = []
        for i in range(m):
            if (flag >> i) & 1:
                sub.append(all_list[i])
        result.append(sub)
    return result


def sum_honey(sub):
    if sum(sub) > c:
        return 0
    return sum(e * e for e in sub)


def cal_max(sub_arr):
    max_honey = 0
    for sub in sub_arr:
        max_honey = max(max_honey, sum_honey(sub))
    return max_honey

def find_max(margin_map):
    return

for test_case in range(1, t+1):
    n, m, c = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n)]
    margin = []
    
    for i in range(n):
        for j in range(n-m+1):
            margin.append((cal_max(subset(arr[i][j:j+m])), i, j))
    margin = sorted(margin, reverse=True)
    m1, first_x, first_y = margin[0]
    idx = 1
    m2, second_x, second_y = margin[idx]
    while second_x == first_x and abs(second_x - first_x) < m: 
        idx+=1
        m2, second_x, second_y = margin[idx]
    
    print(f"#{test_case} {m1+m2}")


