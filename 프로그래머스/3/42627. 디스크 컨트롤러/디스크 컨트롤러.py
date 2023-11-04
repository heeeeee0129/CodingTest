import heapq

#  [작업이 요청되는 시점, 작업의 소요시간] 

def solution(jobs):
    answer = 0
    request_heap = []
    time = 0
    length = len(jobs)
    
    # 매 타임마다
    while jobs or request_heap:
        i = 0
        while i < len(jobs):
            if jobs[i][0] <= time:
                request_time, processing_time = jobs.pop(i)
                heapq.heappush(request_heap, [processing_time, request_time])
            else:
                i += 1
            
        if len(request_heap) > 0:
            process = heapq.heappop(request_heap) # 우선순위대로 하나 뽑기
            time+=process[0]
            answer += (time-process[1])
        else:
            time+=1

    return answer //length # 작업 요청부터 종료까지 걸린 시간의 평균