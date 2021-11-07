import sys
N = int(sys.stdin.readline())
postfix = sys.stdin.readline().strip()
nums = {}
for i in range(N):
    nums[chr(65 + i)] = int(sys.stdin.readline())

stack = []
for ch in postfix:
    if ch in "-+*/":
        front = stack.pop()
        back = stack.pop()
        if ch == '-':
            stack.append(back - front)
        elif ch == '+':
            stack.append(front + back)
        elif ch == '*':
            stack.append(front * back)
        elif ch == '/':
            stack.append(back / front)
    else:
        stack.append(nums[ch])
print('{:.2f}'.format(stack.pop()))
