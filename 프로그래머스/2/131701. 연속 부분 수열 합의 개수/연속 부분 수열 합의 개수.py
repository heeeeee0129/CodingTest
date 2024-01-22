def solution(elements):
    sum_set = set()
    for i in range(0, len(elements)):
        sum = 0
        for j in range(1, len(elements)+1):
            sum += elements[(i+j)%len(elements)]
            sum_set.add(sum)
    # print(sum_set)
    return len(sum_set)