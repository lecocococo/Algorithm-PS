N, M = map(int, input().split())

def count(n, d):
    count = 0
    while n:
        n //= d
        count += n
    return count

result = min(count(N, 2) - count(M, 2) - count(N - M, 2), count(N, 5) - count(M, 5) - count(N - M, 5))
print(result)
