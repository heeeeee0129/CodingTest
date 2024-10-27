def dfs(i, visited, n, ban_list, visited_set):
    global cnt
    if i == n:
        if visited not in visited_set:
            visited_set.add(visited)
            cnt = cnt + 1
        return
    for b in ban_list[i]:
        if not (visited >> b) & 1:
            dfs(i+1, visited | (1 << b), n, ban_list, visited_set)

def solution(user_id, banned_id):
    global cnt
    cnt = 0
    n = len(banned_id)
    ban_list = [[] for _ in range(n)]
    user_dict = {}
    visited_set = set()
    
    for i, user in enumerate(user_id):
        user_dict.setdefault(len(user), []).append(i)

    for i, ban in enumerate(banned_id):
        for target_idx in user_dict[len(ban)]:
            flag = True
            for idx, c in enumerate(ban):
                if c != '*' and c != user_id[target_idx][idx]:
                    flag = False
                    break
            if flag:
                ban_list[i].append(target_idx)
                
    dfs(0, 0, n, ban_list, visited_set)
    
    return cnt