import sys
from collections import Counter
N = int(sys.stdin.readline())
input = list(map(int, sys.stdin.readline().split()))
stack = []
count = Counter(input)
result = [-1 for _ in range(N)]
stack.append(0)
i = 1
while stack and i < N:
    while stack and count.get(input[stack[-1]]) < count.get(input[i]):
        result[stack[-1]] = input[i]
        stack.pop()
    stack.append(i)
    i += 1

for i in range(N):
    print(result[i], end=" ")
