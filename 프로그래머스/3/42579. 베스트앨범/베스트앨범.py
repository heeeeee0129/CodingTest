import heapq

def solution(genres, plays):
    answer = []
    dict = {}
#   딕셔너리 - key: 장르명 , value: heapq에서 배열 [플레이 횟수, i(고유번호)]
    genre_count = {}
    
    for i in range(len(genres)):
        if genres[i] in dict:
            heapq.heappush(dict[genres[i]], [-plays[i], i])
            genre_count[genres[i]] += plays[i]
        else:
            dict[genres[i]] = []
            heapq.heappush(dict[genres[i]], [-plays[i], i])
            genre_count[genres[i]] = plays[i]
    
    genre_count = sorted(genre_count.items(), key=lambda x: x[1], reverse=True)
    
    for genre, _ in genre_count:
        top_songs = dict[genre]
        answer.append(heapq.heappop(top_songs)[1])
        if top_songs:
            answer.append(heapq.heappop(top_songs)[1])
        
    return answer
