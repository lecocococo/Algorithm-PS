n = int(input())
stack = []
li = []
flag = True
cnt = 1
for i in range(n):
    num = int(input())
    while cnt <= num:
        stack.append(cnt)
        cnt += 1
        li.append('+')

    if stack[-1] == num:
        stack.pop()
        li.append('-')
    else:
        flag = False
        break
if not flag:
    print('NO')
else:
    for op in li:
        print(op)
