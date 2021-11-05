s = input()
stack = []
flag = True
answer = ''
i = 0
while i < len(s):
    if s[i] == ' ':
        while len(stack) != 0:
            answer += stack.pop()
        i += 1
        answer += ' '
    if s[i] == '<':
        if len(stack) != 0:
            while len(stack) != 0:
                answer += stack.pop()
        while s[i] != '>':
            answer += s[i]
            i += 1
        answer += s[i]
        i += 1
    else:
        stack.append(s[i])
        i += 1

while len(stack) != 0:
    answer += stack.pop()
print(answer)
