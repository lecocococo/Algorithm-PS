dx = [ 1, 0, -1, 0]
dy = [ 0, 1, 0, -1]

def solution(places):
    answer = []
    
    for place in places:
        # 의미 없는 값
        cnt = 100 
        room = [list(i) for i in place]
        
        for i in range(len(room)):
            for j in range(len(room[i])):
                if cnt == 0:
                        break;
                if room[i][j] == 'P':
                    if check(room, i, j, 'P') == 0:
                        cnt = 0
                        break;
                    else:
                        cnt = 1
                if room[i][j] == 'O':
                    if check(room, i, j, 'O') == 0:
                        cnt = 0
                        break;
                    else:
                        cnt = 1
        if cnt == 100:
            cnt = 1
        answer.append(cnt)
    return answer


def valid(x,y):
    if x<0 or x>4 or y<0 or y>4:
        return False
    else:
        return True
    
def check(room, x, y, ch):
    cnt = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if valid(nx,ny) and room[nx][ny] == 'P':
            if ch == 'P':
                return 0
            if ch=='O':
                cnt +=1
                if cnt > 1:
                    return 0

    return 1      
