import sys
#1
n = int(sys.stdin.readline().rstrip())


def cal(k, cnt):
    if k <= 1:
        return cnt
    return min(cal(k//2, cnt + (k % 2) + 1), cal(k//3, cnt + (k % 3) + 1))

print(cal(n, 0))

# cnt = [0 for _ in range(n+1)]
# k = 2
# while k <= n:
#     cnt[k] = cnt[k - 1] + 1
#     if k % 3 == 0:
#         cnt[k] = min(cnt[k//3] + 1, cnt[k])
#     if k % 2 == 0:
#         cnt[k] = min(cnt[k//2] + 1, cnt[k])
#     k += 1
# print(cnt[n])
