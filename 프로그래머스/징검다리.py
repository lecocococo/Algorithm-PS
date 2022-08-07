import sys

def solution(distance, rocks, n):
    answer = 0
    rocks.sort()
    
    start = 1
    end = distance
    
    while start <= end:
        mid = (start+end)//2
        cnt = 0
        prev = 0
        min_val = sys.maxsize
        for rock in rocks:
            if rock - prev < mid:
                cnt += 1
                if cnt > n:
                    break
            else:
                min_val = min(min_val, rock - prev)
                prev = rock
        if cnt > n:
            end = mid - 1
        else:
            answer = min_val
            start = mid + 1
        
    return answer
