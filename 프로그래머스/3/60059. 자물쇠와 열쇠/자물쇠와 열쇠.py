def solution(key, lock):
    answer = True
    m = len(key)
    n = len(lock)
    K = 2 * n - 2 + m
    
    keys = [[[2]*K for _ in range(n-1)] for _ in range(4)]
    for i in range(m):
        one = [2] * (n-1)
        two = [2] * (n-1)
        four = [2] * (n-1)
        three = [2] * (n-1)
        for j in range(m):
            one.append(key[i][j])
            two.append(key[j][m-1-i])
            three.append(key[m-i-1][m-j-1])
            four.append(key[m-1-j][i])
        for _ in range(n-1):
            one.append(2)
            two.append(2)
            three.append(2)
            four.append(2)
        
        keys[0].append(one)
        keys[1].append(two)
        keys[2].append(three)
        keys[3].append(four)
    for _ in range(n-1):
        keys[0].append([2]*K)
        keys[1].append([2]*K)
        keys[2].append([2]*K)
        keys[3].append([2]*K)
        
    # print("lock")
    # for l in lock:
    #     print(l)
    
    for key in keys:
        # for k in key:
        #     print(k)
        for i in range(len(key)-n+1):
            for j in range(len(key)-n+1):
                l_first = lock[0][0]
                k_first = key[i][j]
                if (l_first == 0 and k_first == 1) or (l_first == 1 and k_first != 1):                    
                    flag = True
                    for a in range(n):
                        for b in range(n):
                            l = lock[a][b]
                            k = key[i+a][j+b]
                                          
                            if k == 2 and l != 0:
                                continue
                            elif k == 1 and l == 1: # 둘 다 돌기일 경우 실패
                                flag = False
                                break
                            elif l == 0 and k != 1:
                                flag = False
                                break
                            
                        if not flag:
                            break
                    if flag:
                        
                            return True
        
    return False

