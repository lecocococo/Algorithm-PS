import sys
n = int(input())
li = list(map(int, sys.stdin.readline().split()))
dp = [None for _ in range(n)]
dp[0] = li[0]
for i in range(1, n):
    dp[i] = max(dp[i - 1] + li[i], li[i])
print(max(dp))
