def solution(triangle):
    answer = 0
    
    for i in range(1, len(triangle)):
        line = triangle[i]
        j=0
        while j < len(line):
            val = line[j]
            if j==0:
                line[j] = triangle[i-1][j] + val
            elif j==len(line)-1:    
                line[j] = triangle[i-1][j-1] + val
            else:
                line[j] = max(triangle[i-1][j-1] + val, triangle[i-1][j] + val)
            
            j += 1
    answer = max(triangle[-1])
    return answer
