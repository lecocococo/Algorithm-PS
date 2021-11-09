import sys
# // 계산은 내림 처리 하기때문에 + 1 필요
# % 연산에서 음수로 나누어 줄때 결과는 나누어주는 수의 부호를 따라간다
n = int(sys.stdin.readline().rstrip())

result = ''
if not n:
    print('0')
while n:
    if n % (-2):
        result = '1' + result
        n = n//(-2) + 1
    else:
        result = '0' + result
        n //= (-2)
print(result)
