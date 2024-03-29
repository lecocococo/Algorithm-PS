#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'superReducedString' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#

def superReducedString(s):
    # Write your code here

    pattern = '([a-z])\\1{1}'
    # pattern = r'([a-z])\1{1}'
    while re.findall(pattern, s):
        s = re.sub(pattern, '' ,s)
    if s:
        return s 
    else:
        return 'Empty String'
        
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = superReducedString(s)

    fptr.write(result + '\n')

    fptr.close()
