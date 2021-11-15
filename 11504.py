n = int(input())
li = list(map(int, input().split()))
dp_1 = [1 for _ in range(n)]
dp_2 = [1 for _ in range(n)]
for i in range(n):
    for j in range(i):
        if li[j] < li[i] and dp_1[i] <= dp_1[j]:
            dp_1[i] = dp_1[j] + 1


for i in range(n-1, -1, -1):
    for j in range(n-1, i, -1):
        if li[j] < li[i] and dp_2[i] <= dp_2[j]:
            dp_2[i] = dp_2[j] + 1

for i in range(n):
    dp_1[i] = dp_1[i] + dp_2[i] - 1
print(max(dp_1))
