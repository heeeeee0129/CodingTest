
def convert_num(num_type, num):
    arr = []
    if num < num_type:
        return [num]
    while num > 0:
        arr.append(num % num_type)
        num = num // num_type
    return arr

alpha_dict = {10: "A", 11: "B", 12: "C", 13: "D", 14: "E", 15: "F"}

def convert(n, base):#n:10진수 base: 진수 k
    T = "0123456789ABCDEF"
    q, r = divmod(n, base)
    if q == 0:
        return T[r]
    else:
        return convert(q, base) + T[r]

def solution(n, t, m, p):
    answer = ''
    all_number = ""
    cur_num = 0
    while len(all_number) <= m * t:
        # result_arr = convert_num(n, cur_num)
        # cur_num += 1
        # while result_arr:
        #     c = result_arr.pop()
        #     if n == 16 and c in alpha_dict:
        #         all_number += alpha_dict[c]
        #     else:
        #         all_number += str(c)
        all_number += convert(cur_num, n)
        cur_num += 1
                
    for i in range(p-1, m*t, m):
        answer+= all_number[i]
    
    
    
    return answer