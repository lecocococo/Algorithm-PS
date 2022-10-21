#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'minimumNumber' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. STRING password
#

def minimumNumber(n, password):
    # Return the minimum number of characters to make the password strong
    upper = False
    lower = False
    special = False
    number = False
    
    special_characters = "!@#$%^&*()-+"
    cnt = 0
    # max(0, 6 - n)
    for p in password:
        
        if p.islower():
            lower = True
        if p.isupper():
            upper = True
        if p.isdigit():
            number = True
        if p in special_characters:
            special = True
    
    if not upper:
        cnt += 1
    if not lower:
        cnt += 1
    if not number:
        cnt += 1
    if not special:
        cnt += 1
        
    if cnt < 6-n:
        cnt = 6-n
        
    return cnt
        
        

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    password = input()

    answer = minimumNumber(n, password)

    fptr.write(str(answer) + '\n')

    fptr.close()
