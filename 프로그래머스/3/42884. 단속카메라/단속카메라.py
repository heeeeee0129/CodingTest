def solution(routes):
    answer = 0
    sorted_routes = sorted(routes, key=lambda x: x[0], reverse=True)
    print(sorted_routes)
    camera_location = sorted_routes[0][0]
    answer+=1
    
    for start, end in sorted_routes[1:]:
        if end >= camera_location:
            continue
        else:
            camera_location = start
            answer+=1
            
        
    return answer