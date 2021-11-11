n = int(input())

dp = [[None for _ in range(10)] for _ in range(n+1)]

for i in range(10):
    dp[1][i] = 1

def recursive(n, m):
    if n == 1:
        return dp[1][m]
    if dp[n][m] == None:
        if m == 0:
            dp[n][m] = recursive(n-1, 1)
        elif m == 9:
            dp[n][m] = recursive(n-1, 8)
        else:
            dp[n][m] = recursive(n-1, m-1) + recursive(n-1, m+1)
    return dp[n][m] % 1000000000

result = 0
k = 1
while k < 10:
    result += recursive(n,k)
    k += 1
print(result % 1000000000)
