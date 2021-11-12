n = int(input())
dp = [[None for _ in range(2)] for _ in range(n + 1)]
dp[1] = [0, 1]
for i in range(2, n + 1):
    dp[i] = [dp[i-1][0] + dp[i-1][1], dp[i-1][0]]
print(sum(dp[n]))
