import math
import os
import random
import re
import sys
from collections import deque
#
# Complete the 'journeyToMoon' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. 2D_INTEGER_ARRAY astronaut
#

def journeyToMoon(n, astronaut):
    # Write your code here
    
    # mak adj list
    graph = [[] for _ in range(n)]
    for a,b in astronaut:
        graph[a].append(b)
        graph[b].append(a)
    print(graph)
    
    # BFS to make same country astronauts
    temp = []
    visited = [False]*n
    for i in range(n):
        cnt = 0
        if not visited[i]:
            q = deque()
            q.append(i)
            visited[i] = True
            cnt += 1
            while q:
                val = q.popleft()
                if not graph[val]:
                    cnt = 1
                    break
                for k in graph[val]:
                    if not visited[k]:
                        visited[k]=True
                        cnt += 1
                        q.append(k)
                       
        if cnt != 0:
            temp.append(cnt)
    
    #calc part
    answer = 0
    for c in temp:
        n -= c
        answer += n*c
    return answer

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    p = int(first_multiple_input[1])

    astronaut = []

    for _ in range(p):
        astronaut.append(list(map(int, input().rstrip().split())))

    result = journeyToMoon(n, astronaut)

    fptr.write(str(result) + '\n')

    fptr.close()
