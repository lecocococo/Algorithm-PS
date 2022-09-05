def solution(sizes):
    answer = 0
    width = 0
    height = 0
    for i in range(len(sizes)):
        w = sizes[i][0]
        h = sizes[i][1]
        if w < h:
            w, h = h, w
        width = max(width, w)
        height = max(height, h)
        
    # print(width, height)
    answer = width * height
    return answer
