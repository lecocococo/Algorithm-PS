import sys
N = int(sys.stdin.readline())
input = list(map(int, sys.stdin.readline().split()))
stack = []
result = [-1 for _ in range(N)]
stack.append(0)
i = 1
while stack and i < N:
    while stack and input[stack[-1]] < input[i]:
        result[stack[-1]] = input[i]
        stack.pop()
    stack.append(i)
    i += 1

for i in range(N):
    print(result[i], end=" ")
