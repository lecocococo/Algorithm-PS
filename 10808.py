import sys
from collections import Counter
cnt = Counter(sys.stdin.readline().strip())

alpha = cnt.keys()

for i in range(26):
    if chr(97 + i) in alpha:
        print(cnt[chr(97 + i)], end=' ')
    else:
        print(0, end=" ")
