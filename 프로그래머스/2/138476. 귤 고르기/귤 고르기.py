def solution(k, tangerine):
    dict = {}
    for i in tangerine:
        if i in dict:
            dict[i] += 1
        else:
            dict[i] = 1
    sorted_dict = sorted(dict.items(), key=lambda x:-x[1])
    idx = 0
    while k > 0:
        k -= sorted_dict[idx][1]
        idx+=1
    return idx