def solution(elements):
    sum_set = set()
    for i in range(0, len(elements)):
        sum = 0
        for j in range(1, len(elements)+1):
            sum += elements[(i+j)%len(elements)]
            sum_set.add(sum)
    # print(sum_set)
    return len(sum_set)


## 접근 방법
# 연속 부분 수열,,? 에 머리 굳어서 일단 힘으로 풀기.
# 첫번째 접근법: 
# for(더하는 요소 개수: 1 ~ len+1 ) { for(시작인덱스: 0 ~ len ){ for(배열 탐색하면서 합 구하기)}} >> 이렇게 더한 모든 값 set에 저장해서 중복 제거 후 리턴 => 시간 초과
# 다시 생각
# 위의 경우에서 값을 더하는 게 중복되기 때문에 오래 걸리겠군!
# 중복 없이 계산하는 방법 생각
# 첫 요소에서 더하기 시작하면서 1개, 2개, 3개,,, 끝까지 더하는 값을 각각 set에 계속 더함 -> for문 2개!
# 해결


## 소요시간
# 30분