import sys
mx = 1000000

arr = [True for _ in range(mx)]

for i in range(2, int(mx**0.6)):
    if arr[i]:
        for j in range(2*i, mx, i):
            arr[j] = False

t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    n = int(sys.stdin.readline().rstrip())
    cnt = 0
    for i in range(2, n//2 + 1):
        if arr[i] and arr[n-i]:
            cnt += 1
    print(cnt)
