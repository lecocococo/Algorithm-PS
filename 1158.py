import sys
N, k = map(int, sys.stdin.readline().split())
q = [i+1 for i in range(N)]

answer = []
cnt = 0
for i in range(N):
    cnt += k-1
    if cnt >= len(q):
        cnt = cnt % len(q)

    answer.append(str(q.pop(cnt)))


print("<", ", ".join(answer)[:], ">", sep="")
