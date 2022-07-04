def solution(lines):
    answer = 0
    timeRange = []
    for temp in lines :
        logs = temp.split(" ")
        times = list(map(float, logs[1].split(":")))
        totalSeconds = times[0] * 60 * 60 + times[1] * 60 + times[2]
        
        if totalSeconds == 0:
            timeRange.append([ 0.0 , round(totalSeconds, 3)])
        else:
            timeRange.append([ round(totalSeconds - float(logs[2][:-1]) + 0.001, 3), round(totalSeconds, 3)])
    
    for i in range(len(timeRange)):
        cnt1 = 0;
        cnt2 = 0;
        
        checkStart1 = timeRange[i][0]
        checkEnd1 = round(timeRange[i][0] + 1 - 0.001, 3)
        
        checkStart2 = timeRange[i][1]
        checkEnd2 = round(timeRange[i][1] + 1 - 0.001, 3)
        
        for j in range(len(timeRange)):
            
            if timeRange[j][0]<= checkStart1 <=timeRange[j][1] or timeRange[j][0]<= checkEnd1 <=timeRange[j][1] or checkStart1<= timeRange[j][0]<=checkEnd1:
                cnt1 += 1;
            if timeRange[j][0]<= checkStart2 <=timeRange[j][1] or timeRange[j][0]<= checkEnd2 <=timeRange[j][1] or checkStart2<= timeRange[j][0]<=checkEnd2:
                cnt2 += 1;
        answer = max(answer, cnt1, cnt2)
        

    
    return answer
