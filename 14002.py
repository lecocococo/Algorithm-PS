n = int(input())
arr = list(map(int, input().split()))

dp = [1 for i in range(n)]

for i in range(n):
    for j in range(i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i], dp[j]+1)

print(max(dp))
ord = max(dp)
li = []
for i in range(n-1, -1, -1):
    if dp[i] == ord:
        li.append(arr[i])
        ord -= 1
li.reverse()

for num in li:
    print(num, end=' ')
