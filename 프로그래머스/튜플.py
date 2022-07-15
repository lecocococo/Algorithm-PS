def solution(s):
    answer = []
    dic = {}
    garbage = ["{", "}", ","]
    s = s.replace("{", "").replace("}", "")
    
    temp = s.split(",")
    
    # 가장 많이 나온 순서대로 이루어지지 않을까
    for ch in temp:
        if ch in dic:
            dic[ch] += 1
        else:
            dic[ch] = 1
            
    answer = list(map(int ,sorted(dic, key = lambda x: dic[x],reverse = True)))
    
    return answer

