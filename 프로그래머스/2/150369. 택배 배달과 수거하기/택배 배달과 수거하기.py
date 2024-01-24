def solution(cap, n, deliveries, pickups):
    move = 0
    del_pool = 0
    pick_pool = 0
    for i in range(n-1, -1, -1):
        del_pool += deliveries[i]
        pick_pool += pickups[i]
        while del_pool > 0 or pick_pool > 0:
            del_pool -= cap
            pick_pool -= cap
            move += i+1
    return move*2
    
    
    
    
    
    
    
    
    
    
    
    # def solution(cap, n, deliveries, pickups):
    # move = 0
    # idx = n-1
    # while(idx>=0):
    #     if deliveries[idx] > 0 or pickups[idx] > 0:
    #         move+=idx+1
    #         count_del = 0
    #         count_pick = 0
    #         for i in range(idx, -1, -1):
    #             delivery = min(cap-count_del, deliveries[i])
    #             deliveries[i] -= delivery
    #             count_del += delivery
    #             pick = min(cap-count_pick, pickups[i])
    #             pickups[i] -= pick
    #             count_pick += pick
    #             if count_del > cap or count_pick > cap:
    #                 idx = i
    #                 break
    #     else:
    #         idx -= 1
    # return move*2
