n = int(input())
li = list(map(int, input().split()))
dp = [[0, 0] for _ in range(n)]
dp[0] = [li[0], float('-inf')]

for i in range(1, n):
    dp[i][0] = max(dp[i-1][0] + li[i], li[i])
    dp[i][1] = max(dp[i-1][0], dp[i-1][1] + li[i])
result = float('-inf')

for i in range(n):
    result = max(result, dp[i][0], dp[i][1])

print(result)
