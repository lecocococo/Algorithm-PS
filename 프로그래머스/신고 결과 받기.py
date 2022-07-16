def solution(id_list, report, k):
    answer = []
    dic = {} 
    ban_list = set([])
    for name in id_list:
        dic[name] = [0]
        
    for r in set(report):
        report_name = r.split(" ")
        
        temp = dic.get(report_name[0])
        temp.append(report_name[1])
        
        dic[report_name[0]] = temp
        dic[report_name[1]][0] +=1
        
        cnt = dic[report_name[1]][0]
        if cnt>= k:
            ban_list.add(report_name[1])
    
    for d in dic.values():
        # print(d)
        count = 0
        for ban_name in ban_list:
            if ban_name in d:
                count += 1
        answer.append(count)
        
    return answer
