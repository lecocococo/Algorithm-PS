import sys

s = str(sys.stdin.readline().rstrip())
list = []

for _ in s:
    list.append(s)
    s = s[1:]

for i in sorted(list):
    print(i)
