def solution(numbers, hand):
    answer = ''
    keypad = {'*':[3,0], '0':[3,1], '#':[3,2], '7':[2,0], '8':[2,1], '9':[2,2],
              '4':[1,0], '5':[1,1], '6':[1,2], '1':[0,0], '2':[0,1], '3':[0,2] }

    right = '#' 
    left = '*'
    for num in numbers:
        
        if num in [1, 4, 7]:
            answer += 'L'
            left = num
        elif num in [3, 6, 9]:
            answer += 'R'
            right = num
        else:
            rdist, ldist = calc(keypad, num, right, left)
            
            # 거리체크
            if rdist> ldist:
                answer += 'L'
                left = num
            elif rdist < ldist:
                answer += 'R'
                right = num
            elif rdist == ldist:
                if hand == 'right':
                    answer += 'R'
                    right = num
                elif hand == 'left':
                    answer += 'L'
                    left = num
    return answer

def calc(keypad, num, right, left):
    number = keypad.get(str(num))
    r = keypad.get(str(right))
    l = keypad.get(str(left))
    
    rdist = abs(number[0] - r[0]) + abs(number[1] - r[1])
    ldist = abs(number[0] - l[0]) + abs(number[1] - l[1])
    return rdist, ldist
