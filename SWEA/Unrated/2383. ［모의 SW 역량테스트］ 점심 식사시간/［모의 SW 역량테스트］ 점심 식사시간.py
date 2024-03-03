import heapq
from collections import deque 

t = int(input())
def cal_distance(stair, persons):
    arr = []
    for person in persons:
        arr.append([abs(person[0]-stair[0][0])+abs(person[1]-stair[0][1]), abs(person[0]-stair[1][0])+abs(person[1]-stair[1][1])])
    return arr


def cal_time(select):
    global persons, dist_list, depth, num_person, min_time
    time_list = [[] for _ in range(2)]
    
    for i in range(num_person):
        time_list[select[i]].append(dist_list[i][select[i]])
   
    time_list[0] = deque(sorted(time_list[0]))
    time_list[1] = deque(sorted(time_list[1]))

    time1 = 0
    curr = 0
    queue = deque()
    while time_list[0]:
        time1 += 1
        while queue and queue[0] == time1:
            queue.popleft()
            curr-=1
        while time_list[0][0] < time1 and curr < 3:
            time_list[0].popleft()
            if not time_list[0]:
                time1 += depth[0]
                break
            queue.append(time1+depth[0])
            curr += 1

    time2 = 0
    curr = 0
    queue = deque()
    while time_list[1]:
        time2 += 1
        while queue and queue[0] == time2:
            queue.popleft()
            curr -= 1
        while time_list[1][0] < time2 and curr < 3:
            time_list[1].popleft()
            if not time_list[1]:
                time2 += depth[1]
                break
            queue.append(time2+depth[1])
            curr+=1
    
    min_time = min(min_time, max(time1, time2))



        

def cal_subset(cnt):
    global stair_select, num_person
    if cnt == num_person:
        cal_time(stair_select)
        return
    stair_select[cnt] = 0
    cal_subset(cnt+1)
    stair_select[cnt] = 1
    cal_subset(cnt+1)

for test_case in range(1, t+1):
    n = int(input())
    arr = [[0]*n for _ in range(n)]
    stair = []
    persons = []
    min_time = float('inf')
    for i in range(n):
        
        arr[i] = list(map(int, input().split()))
        for j in range(n):
            if arr[i][j] == 1:
                temp = (i,j)
                persons.append(temp)
            elif arr[i][j] > 1:
                temp = (i,j,arr[i][j])
                stair.append(temp)
    dist_list = cal_distance(stair, persons)
    num_person = len(persons)
    stair_select = [0] * num_person
    depth = [stair[0][2], stair[1][2]]
    cal_subset(0)

    print(f"#{test_case} {min_time}")