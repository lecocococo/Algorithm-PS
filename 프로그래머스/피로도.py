from itertools import permutations

def solution(k, dungeons):
    answer = -1
    for a in permutations(dungeons):
        cnt = 0
        val = k
        for i in range(len(dungeons)):
            dungeon = a[i]
            if val >= dungeon[0]:
                val -= dungeon[1]
                cnt += 1
            elif val < dungeon[0]:
                break
        answer = max(answer, cnt)
    return answer
