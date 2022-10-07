import math
import os
import random
import re
import sys
from collections import deque
#
# Complete the 'roadsAndLibraries' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER c_lib
#  3. INTEGER c_road
#  4. 2D_INTEGER_ARRAY cities
#

# 1 2 3 4 
def roadsAndLibraries(n, c_lib, c_road, cities):
    # Write your code here
    graph = [[] for _ in range(n+1)]
    for cityA,cityB in cities:
        graph[cityA].append(cityB)
        graph[cityB].append(cityA)
    # print(graph)
    
    visited = [False] * (n+1)
    cost = 0
    for city in range(1, n+1):
        
        # city = graph[i]
        # for city in graph[i]:
            # print(city)
        count = 0
        # print(city)
        if not visited[city]:
            # print("in")
            q = deque()
            q.append(city)
            visited[city] = True
            # print(q)
            # count = 0
            while q:
                cityVal = q.popleft()
                count += 1
                for tCity in graph[cityVal]:
                    if not visited[tCity]:
                        visited[tCity] = True
                        
                        q.append(tCity)
            # print(count)
            if count == 1:
                cost += c_lib
            if count != 1:
                m = sys.maxsize
                for i in range(count):
                    m = min(m, c_lib * (count - i) + c_road * i)
                # print(m)
                cost += m
    return cost
                
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input().strip())

    for q_itr in range(q):
        first_multiple_input = input().rstrip().split()

        n = int(first_multiple_input[0])

        m = int(first_multiple_input[1])

        c_lib = int(first_multiple_input[2])

        c_road = int(first_multiple_input[3])

        cities = []

        for _ in range(m):
            cities.append(list(map(int, input().rstrip().split())))

        result = roadsAndLibraries(n, c_lib, c_road, cities)

        fptr.write(str(result) + '\n')

    fptr.close()
