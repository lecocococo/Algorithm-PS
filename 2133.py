n = int(input())
dp = [0 for _ in range(31)]
dp[0] = 1
dp[2] = 3
for i in range(4, 31, 2):
    dp[i] += 3 * dp[i-2]  # 2칸 짜리와 구하는 갯수-2 간의 경우의 수
    for j in range(4, i, 2):
        dp[i] += 2 * dp[i-j]  # 새로나오게되는 모양 2개에 대한 경우의수 더해줌
    dp[i] += 2  # 새로운 경우의수
print(dp[n])
