import math
import os
import random
import re
import sys
from collections import Counter 
#
# Complete the 'climbingLeaderboard' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER_ARRAY ranked
#  2. INTEGER_ARRAY player
#

def climbingLeaderboard(ranked, player):
    # Write your code here
    rl = list(set(ranked))
    rl.sort()

    answer = []
    for p in player:
        low = 0
        high = len(rl) -1
        m = (low + high) // 2
        fp = -1
        while low <= high:
            if rl[m] > p:
                high = m - 1
            elif rl[m] < p:
                low = m + 1
            else:
                high = m
                fp = m
                break
            m = (low + high) // 2
        if fp == -1:
            rl.insert(high +1, p)
            fp = high + 1
        answer.append(len(rl) -  fp)
    return answer
    

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    ranked_count = int(input().strip())

    ranked = list(map(int, input().rstrip().split()))

    player_count = int(input().strip())

    player = list(map(int, input().rstrip().split()))

    result = climbingLeaderboard(ranked, player)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
