def solution(dirs):
    answer = 0
    dxdy = [[-1, 0], [1, 0], [0, -1], [0, 1]]
    op_to_d = {'L': 0, 'U': 3, 'R': 1, 'D': 2}
    
    curx, cury = 0, 0
    pos_set = set()
    
    for op in dirs:
        next_x = curx+dxdy[op_to_d[op]][0]
        next_y = cury + dxdy[op_to_d[op]][1]
        
        if -5 <= next_x <= 5 and -5 <= next_y <= 5:
            temp = (curx+next_x, cury+next_y)
            if temp not in pos_set:
                answer+=1
                pos_set.add(temp)
            curx, cury = next_x, next_y
    
    return answer