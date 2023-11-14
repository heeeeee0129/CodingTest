def solution(sizes):
    maxWidth = 0
    maxHeight = 0
    
    for size in sizes:
        w, h = size
        i = max(maxWidth, w)*max(maxHeight, h)
        j = max(maxWidth, h)*max(maxHeight, w)
        if i < j:
            maxWidth = max(maxWidth, w)
            maxHeight = max(maxHeight, h)
        else:
            maxWidth = max(maxWidth, h)
            maxHeight = max(maxHeight, w)
    
    
    return maxWidth*maxHeight