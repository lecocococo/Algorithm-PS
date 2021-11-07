import sys
infix = sys.stdin.readline().strip()
op = []

postfix = ''
for ch in infix:

    if ch in "-+*/()":
        if ch == '(':
            op.append(ch)
        elif ch in "*/":
            while op and op[-1] in '*/':
                postfix += op.pop()
            op.append(ch)
        elif ch in '+-':
            while op and op[-1] != '(':
                postfix += op.pop()
            op.append(ch)
        elif ch == ')':
            while op and op[-1] != '(':
                postfix += op.pop()
            op.pop()
    else:
        postfix += ch

while op:
    postfix += op.pop()

print(postfix)
