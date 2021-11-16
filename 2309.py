from itertools import combinations
li = []
for _ in range(9):
    li.append(int(input()))
result = list(combinations(li, 7))
for tup in result:
    if sum(tup) == 100:
        arr = list(tup)
        arr.sort()
        for i in arr:
            print(i, end="\n")
        break
