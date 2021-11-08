import sys

result = ''
for ch in sys.stdin.readline().strip('\n'):
    asc = ord(ch)
    if ch.isupper():
        if asc + 13 > 90:
            result += chr(64 + (asc + 13) % 90)
        else:
            result += chr(asc + 13)
    elif ch.islower():
        if asc + 13 > 122:
            result += chr(96 + (asc + 13) % 122)
        else:
            result += chr(asc + 13)
    else:
        result += ch
print(result)
