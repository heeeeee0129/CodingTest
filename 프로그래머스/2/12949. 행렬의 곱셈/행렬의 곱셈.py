def solution(arr1, arr2):
    answer = []
    arr2_zip = list(zip(*arr2))
    for list1 in arr1:
        temp = []
        for list2 in arr2_zip:
            temp.append(sum(i*j for i, j in zip(list1, list2)))
        answer.append(temp)
    return answer