# 9093번 단어 뒤집기
n = int(input())
li = []
stack = []
s = ""
for i in range(n):
    li.append(input())
for i in range(n):
    s = ""
    for st in li[i].split():
        # print(st[::-1])
        s += st[::-1]
        # for ch in st:
        #     stack.append(ch)
        # while len(stack) > 0:
        #     s += stack.pop()
        s += " "
    li[i] = s

for i in range(n):
    print(li[i])
