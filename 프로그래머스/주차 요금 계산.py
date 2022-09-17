import math

def solution(fees, records):
    standard_time = fees[0]
    standard_fee = fees[1]
    unit_time = fees[2]
    unit_fee = fees[3]
    answer = []
    
    car = {}
    dic = {}
    for record in records:
        r = record.split(" ")
        time = list(map(int,r[0].split(":")))
        hour = time[0] * 60
        
        if r[1] not in car:
            car[r[1]] = [hour+time[1]]
            dic[r[1]] = 0
        else:
            # dic[r[1]] = dic[r[1]] + (hour+time[1] - car.get(r[1])[0])
            if r[2] == 'OUT':
                dic[r[1]] = dic[r[1]] + (hour+time[1] - car.get(r[1])[0])
                car[r[1]] = []
            if r[2] == 'IN':
                car[r[1]] = [hour+time[1]]
    
    temp = 23*60 + 59
    for c in car:
        if len(car.get(c)) != 0:
             dic[c] = dic[c] + temp - car.get(c)[0]
                
    sort_dic = sorted(dic.keys())
    
    for i in sort_dic:
        val = dic[i]
        if val< standard_time:
            answer.append(standard_fee)
        else:
            val -= standard_time
            answer.append(standard_fee + (math.ceil(val/unit_time)*unit_fee))
    return answer
