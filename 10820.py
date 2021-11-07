import sys
while 1:
    st = sys.stdin.readline().rstrip('\n')
    if not st:
        break
    temp = [0 for _ in range(4)]
    result = ''
    for i in st:
        if ord(i) == 32:  # isspace()
            temp[3] += 1
        elif ord(i) <= 57 and ord(i) >= 48:  # isdigit()
            temp[2] += 1
        elif ord(i) >= 97 and ord(i) <= 122:  # islower()
            temp[0] += 1
        elif ord(i) <= 90 and ord(i) >= 65:  # isupper()
            temp[1] += 1
    sys.stdout.write("{} {} {} {}\n".format(
        temp[0], temp[1], temp[2], temp[3]))
