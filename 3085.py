n = int(input())
li = [list(input()) for _ in range(n)]
mx = 0


def check():
    global mx
    for i in range(n):
        cnt = 1
        for j in range(1, n):
            if li[i][j] == li[i][j-1]:
                cnt += 1
            else:
                cnt = 1
            if cnt > mx:
                mx = cnt

        cnt = 1
        for j in range(1, n):
            if li[j][i] == li[j-1][i]:
                cnt += 1
            else:
                cnt = 1
            if cnt > mx:
                mx = cnt


for i in range(n):
    for j in range(1, n):

        li[i][j], li[i][j - 1] = li[i][j - 1], li[i][j]
        check()
        li[i][j], li[i][j - 1] = li[i][j - 1], li[i][j]

for i in range(n):
    for j in range(1, n):
        li[j][i], li[j - 1][i] = li[j-1][i], li[j][i]
        check()
        li[j][i], li[j-1][i] = li[j-1][i], li[j][i]
print(mx)
