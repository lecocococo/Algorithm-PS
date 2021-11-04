import sys

s = sys.stdin.readline().strip()
stack_1 = []
stack_2 = []
answer = ""
for ch in s:
    stack_1.append(ch)

n = int(sys.stdin.readline().strip())

for _ in range(n):
    command = sys.stdin.readline().strip()
    if command == 'L':
        if len(stack_1) != 0:
            stack_2.append(stack_1.pop())

    elif command == 'D':
        if len(stack_2) != 0:
            stack_1.append(stack_2.pop())

    elif command == 'B':
        if len(stack_1) != 0:
            stack_1.pop()

    elif 'P' in command:
        # print(command.split()[1])
        stack_1.append(command.split()[1])

for i in range(len(stack_2)):
    stack_1.append(stack_2.pop())

for i in stack_1:
    # print(i, end="")
    answer += i
print(answer)
