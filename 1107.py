N = int(input())
k = int(input())
if k:
    M = set(input().split())
else:
    M = set()

result = abs(100 - N)

for i in range(1000001):
    nums = str(i)
    for num in nums:
        if num in M:
            break
    else:
        result = min(result, len(nums) + abs(i - N))
print(result)
