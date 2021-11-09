import sys


def GCD(a, b):
    if b > a:
        a, b = b, a
    if b == 0:
        return a
    else:
        return GCD(b, a % b)


n, s = map(int, sys.stdin.readline().split())
m = list(map(int, sys.stdin.readline().split()))
if n == 1:
    print(abs(m[0]-s))
elif n == 2:
    print(GCD(abs(m[0] - s), abs(m[1] - s)))
else:
    a = GCD(abs(m[0] - s), abs(m[1] - s))
    for i in range(2, n):
        a = GCD(a, abs(m[i] - s))
    print(a)
