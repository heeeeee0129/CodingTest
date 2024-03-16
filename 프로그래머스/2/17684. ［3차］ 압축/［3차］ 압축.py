from collections import deque

def solution(msg):
    answer = []
    dictionary = {}
    
    dictionary_add_idx = 27
    
    for i in range(26):
        dictionary[str(chr(65+i))] = i+1
    msg = deque(list(msg))
    while(msg):
        target_msg = msg.popleft()
        msg_len = 1
        while msg and target_msg+msg[0] in dictionary:
            target_msg += msg.popleft()
            msg_len += 1
        
        answer.append(dictionary[target_msg])
        if msg:
            dictionary[target_msg + msg[0]] = dictionary_add_idx
            dictionary_add_idx += 1
        
    return answer