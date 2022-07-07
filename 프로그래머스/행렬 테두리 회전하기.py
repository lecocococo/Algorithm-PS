def solution(rows, columns, queries):
    answer = []
    num = 0
    matrix = [[ ((j-1) * columns + i) for i in range(1, columns + 1)] for j in range(1, rows + 1)]
    
    for query in queries:
        minArr = []
        x1, y1, x2, y2 = query 
        x1 -= 1
        y1 -= 1
        x2 -= 1
        y2 -= 1
        for i in range(y2 - 1, y1 - 1, -1):
            matrix[x1][i], matrix[x1][i+1] = matrix[x1][i+1], matrix[x1][i]
            minArr.append(matrix[x1][i])
            minArr.append(matrix[x1][i + 1])
        
        for i in range(x1, x2):
            matrix[i][y1], matrix[i+1][y1] =  matrix[i+1][y1], matrix[i][y1]
            minArr.append(matrix[i][y1])
            minArr.append(matrix[i+1][y1])
        
        for i in range(y1, y2):
            matrix[x2][i], matrix[x2][i+1] = matrix[x2][i+1], matrix[x2][i]
            minArr.append(matrix[x2][i])
            minArr.append(matrix[x2][i + 1])
            
        for i in range(x2 - 1, x1, -1):
            matrix[i][y2], matrix[i+1][y2] = matrix[i+1][y2], matrix[i][y2]
            minArr.append(matrix[i][y2])
            minArr.append(matrix[i + 1][y2])
            
        minVal = min(set(minArr))
        answer.append(minVal)
    
    return answer
