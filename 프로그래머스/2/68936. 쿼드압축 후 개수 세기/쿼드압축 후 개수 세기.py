count = [0, 0]

def compress(arr, n):
    global count
    
    if n == 1:
        count[arr[0][0]] += 1
        return
    
    cur = arr[0][0]
    if all(cur == x for row in arr[:n//2] for x in row[:n//2]):
        count[cur] += 1
    else:
        compress([row[:n//2] for row in arr[:n//2]], n//2)
    
    cur = arr[n//2][0]
    if all(x == cur for row in arr[n//2:] for x in row[:n//2]):
        count[cur] += 1
    else:
        compress([row[:n//2] for row in arr[n//2:]], n//2)
        
    cur = arr[0][n//2]
    if all(x == cur for row in arr[:n//2] for x in row[n//2:]):
        count[cur] += 1
    else:
        compress([row[n//2:] for row in arr[:n//2]], n//2)
    
    cur = arr[n//2][n//2]
    if all(x == cur for row in arr[n//2:] for x in row[n//2:]):
        count[cur] += 1
    else:
        compress([row[n//2:] for row in arr[n//2:]], n//2)

def solution(arr):
    global count
    cur = arr[0][0]
    if all(cur==x for row in arr for x in row):
        count[cur] += 1
        return count
    compress(arr, len(arr))
    return count