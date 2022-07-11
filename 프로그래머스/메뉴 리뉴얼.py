from itertools import combinations, permutations

def solution(orders, course):
    answer = []
    dic = {}
    for number in course:
        for order in orders:
            if len(order) >= number:
                for temp in list(combinations(sorted(order), number)):
                    
                    temp = ''.join(temp)
                    
                    if temp in dic:
                        dic[temp] += 1
                        
                    else:
                        dic[temp] = 1
                        
    for num in course:
        arr = []
        maxNum = 2
        for k, v in dic.items():
            if len(k) == num:
                if maxNum < v:
                    arr = [k]
                    maxNum = v
                elif maxNum == v:
                    arr.append(k)
        for ans in arr:
            answer.append(ans)

    answer.sort()
    
    return answer
