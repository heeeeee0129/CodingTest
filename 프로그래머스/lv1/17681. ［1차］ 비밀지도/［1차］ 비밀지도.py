def solution(n, arr1, arr2):
    answer = []
    for i in range(0, n):
        arr1_row = format(arr1[i], 'b').zfill(n)
        arr2_row = format(arr2[i], 'b').zfill(n)
        row = ""
        for j in range(0, n):
            if arr1_row[j] == "0" and arr2_row[j] == "0":
                row += " "
            else:
                row += "#"
        answer.append(row)
    
    return answer