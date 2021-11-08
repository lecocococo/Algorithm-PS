import sys

mx = 1000000
arr = [True for _ in range(mx)]

for i in range(2, int(mx**0.6)):
    if arr[i]:
        for j in range(2*i, mx, i):
            arr[j] = False

while True:
    num = int(sys.stdin.readline().rstrip())
    flag = 0

    if num == 0:
        break
    for i in range(3, len(arr)):
        if arr[i] and arr[num - i]:
            print(str(num) + " = " + str(i) + " + " + str(num - i))
            flag = 1
            break
    if flag == 0:
        print("Goldbach's conjecture is wrong.")
