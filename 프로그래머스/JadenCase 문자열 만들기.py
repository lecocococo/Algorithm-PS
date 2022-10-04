def solution(s):
    answer = ''
    s = list(s)
    # print(s)
    t = []
    for i in range(len(s)):
        k = s[i]
        k = k.lower()
        asci = ord(k)
        if asci == 32:
            t.append(k)
            continue
        elif asci < 65:
            t.append(k)
        else:
            if s[i-1] == ' ' or i==0:
                temp = chr(asci - 32)
                t.append(temp)
            else:
                t.append(k)
    answer = ''.join(t)
    return answer
