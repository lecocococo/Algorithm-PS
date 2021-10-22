# -*- coding: utf-8 -*-
# """
# Created on Sun May  2 16:07:20 2021

# @author: 이찬민
# """
#백준 그리디


#1 2839번
# a= int(input())
# cnt=5000

# if a<5 and a!=3:
#         cnt=-1
# elif a==3:
#         cnt = 1
# else:
#     for i in range(a):
    
#         b=a-(5*i)
#         if b<0:
#             break
#         if b%3==0:
#             temp = i + b//3
#             if(temp<cnt):
#                 cnt = temp
# if cnt ==5000:
#     cnt = -1
# print(int(cnt))



#2 11399번
# a= int(input())
# arr= input().split()
# sum=0
# sum2=0
# arr2=[]
# for i in range(a):
#     arr[i]=int(arr[i])
#     arr2.append(0)
# arr.sort()

# for i in range(a):
#     sum += arr[i]
#     arr2[i] = sum
#     sum2+=arr2[i]

# print(sum2)


#3 11047번
# a,b = input().split()
# a = int(a)
# b = int(b)
# arr = []
# for i in range(a):
#     arr.append(int(input()))
# arr.sort(reverse=True)  #배열을 내림차순정렬
# cnt = 0
# for i in range(a):
#     if b//arr[i]!=0:
#         cnt+=(b//arr[i])
#         b=b%arr[i]
# print(cnt)


#4 1931번 정렬에 대해서 알게됨 sorted(arr,key=lambda x:(x[1],x[0]))
# 위의 식을 통해서 두번쨰 줄로 오름차순 정렬하고 같은 경우 첫번째줄로 오름차순 해줌 
# sorted(arr,key=lambda x:x[1])
# sorted(arr,key=lambda x:x[0]) 
# 이렇게 해줘도 된다 
# a= int(input())
# arr = []
# for i in range(a):
#     b,c = input().split()
#     arr.append([int(b), int(c)])
# arr = sorted(arr,key=lambda x:(x[1],x[0]))
# end=0
# answer=0
# for s,e in arr:
#     if s>=end:
#         answer+=1
#         end = e
# print(answer)



#5 5585번
# a = int(input())
# m = 1000 - a
# cnt = 0
# arr = [500,100,50,10,5,1]
# for i in range(6):
#     if m==0:
#         break
#     cnt+=m//arr[i]
#     m=m%arr[i]   
# print(cnt)



#6 2217번
# a = int(input())
# cnt = 0
# max = -1
# arr = []
# for i in range(a):
#     w = int(input())
#     arr.append(w)
# arr.sort();
# for i in range(a):
#     if max < (a-i)*arr[i]:
#         max = (a-i)*arr[i]
# print(max)
    

#7 1541번
# 이 문제는 거의 논리적으로는 다 유추함
# 하지만 - 기준으로 나눠준 이후 +끼리는 다 더하고 빼주게 하는 방식을 생각못함
# a=input().split('-')
# arr=[]
# for i in a:
#     sum = 0
#     b = i.split('+')
#     for j in b:
#         sum += int(j)
#     arr.append(sum)
# answer = arr[0]
# for i in range(1,len(arr)):
#     answer-=arr[i]
# print(answer)

        
#8 1946번
#이 문제는 문제 자체를 이해하는게힘들었다
#일단 서류 1등은 당연히 뽑히고 서류1등의 면접등수를 봄
#그 면접 등수보다 높은 등수의 경우에는 뽑히므로 +1 해주고
# 다시 뽑힌 사람의 면접 등수보다 높으면 +1 해준다 
# 시간 초과나서 input().split()대신 
# import sys 해주고 
# *****sys.stdin.readline().split()*****을 해주었다
# import sys

# tc = int(input())
# for i in range(tc):
#     a = int(input())
#     arr = []
    
#     for j in range(a):
#         b= sys.stdin.readline().split()
#         arr.append([int(b[0]),int(b[1])])
#     arr = sorted(arr,key=lambda x:x[0])
    
#     answer = 1
#     m = arr[0][1]
#     for i in range(1,a):
#         if arr[i][1]< m:
#             answer+=1
#             m = arr[i][1]
#     print(answer)



#9 1202번 
# 우선순위큐를 활용하는 문제 
# 그 이유는 우선순위로 정해진 값을 작은것(또는 큰것)부터 순차적으로 꺼내기 떄문?
# 파이썬은 if문에서 empty list는 False를, empty가 아닌 list는 True를 리턴
# 파이썬에서는 HEAP이 MIN heap이다. 
# 즉, 작은 값을 index 0에 올려준다. 
# 그래서 값을 음수처리해서 heap에 넣어주면 빼낼때 뺄셈으로 계산을 해주면 MAX heap으로 사용가능하다.

# input() 사용하면 시간초과 많이뜸
# import sys
# import heapq

# a,b = input().split()
# a = int(a)
# b = int(b)
# jewel = []
# bag = []
# for i in range(a):
#     k, p = map(int,sys.stdin.readline().split())
#     temp = [k, p]
#     heapq.heappush(jewel,temp)
# for i in range(b):
#     bag.append(int(sys.stdin.readline()))
    

# bag.sort()
# answer = 0
# temp = []
# for i in range(b):
#     while jewel and bag[i]>=jewel[0][0]:
#         k, p = heapq.heappop(jewel)
#         heapq.heappush(temp,-p)  #무게를 제외한 값만 heappush하여 넣어준다(최대힙 구성)
#                                 # 파이썬은 min heap이기때문에 -붙혀서 하면 제일컷던 값이 제일위에 존제 
#     if temp:
#         answer -=heapq.heappop(temp)   # -를 붙혀 maxheap으로 만들었기 때문에 - 해주는 것 
#     elif not jewel:
#         break
# print(answer)


#10 1744번
# a = int(input())
# minus=[]
# plus=[]
# for i in range(a):
#     n = int(input())
#     if n<=0:
#         minus.append(n)
#     elif n>0:
#         plus.append(n)
# minus.sort()
# plus.sort(reverse=True)
# m_cnt = 0
# p_cnt = 0
# for i in range(0,len(minus),2):
#     if minus[i]==0:
#         break
#     else:
#         if i+1==len(minus):
#             continue
#         if minus[i+1] !=0:
#             temp = minus[i] * minus[i+1]
#         else:
#             temp=0
#         m_cnt+=temp
        
# if len(minus)%2==1:
#     m_cnt+=minus[len(minus)-1]
        
# for i in range(0,len(plus),2):
    
#     if plus[i]==1:
#         p_cnt+=(len(plus) - i)
#         break
#     else:
#         if i+1==len(plus):
#             continue
#         if plus[i+1]!=1:
#             temp = plus[i] * plus[i+1]
#         elif plus[i+1]==1:
#             temp = plus[i] + plus[i+1]
#         p_cnt+=temp
# if len(plus)%2==1 and plus[len(plus)-1]!=1:
#         p_cnt+=plus[len(plus)-1]
# print(m_cnt+p_cnt)

#11 1339번
# 딕셔너리의 사용 필요!!
# https://wikidocs.net/16
# 딕셔너리는 key, value로 이루어짐 
# https://yoonsang-it.tistory.com/41

# a = int(input())
# arr = []
# for i in range(a):
#     t = input()
#     arr.append(t)

# dictionary = {}
# for temp in arr:
#     i = len(temp)-1
#     for c in temp:
#         if c in dictionary:
#             dictionary[c] += pow(10,i)
#         else:
#             dictionary[c] = pow(10,i)
#         i-=1
# num = []
# for i in dictionary.values():   #dictionary.values()하면 value값만 나옴
#     num.append(i)
# num.sort(reverse=True)
# answer = 0
# cnt = 9
# for i in range(len(num)):
#     answer += num[i] * cnt
#     cnt-=1
# print(answer)
    


#12 13305번
# a = int(input())
# dist = input().split()
# station = input().split()

# for i in range(a-1):
#     dist[i] = int(dist[i])
# for i in range(a):
#     station[i] = int(station[i])
    
# answer = 0

# st_num = 0
# temp = station[0]
# for i in range(1,a):
#     dist_sum = 0
#     if i==(a-1):
#         answer += (dist[i-1] * temp)
#         break
#     if station[i] >= temp:
#         answer += (dist[i-1] * temp)
#     elif station[i] < temp:
#         answer += (dist[i-1] * temp)
#         temp = station[i]
# print(answer)




#13 1715번
# 우선순위 큐를 사용 하는 때에 대해서 잘 알아야할듯하다 
# 여기선 제일 작은 것 2개를 빼서 더하고 다시 그결과를 이용해서 비교하기때문에 사용함 

# import heapq

# a = int(input())
# min_heap = []
# answer = 0
# for i in range(a):
#     heapq.heappush(min_heap, int(input()))


# while len(min_heap)>1:
#     a = heapq.heappop(min_heap)
#     b = heapq.heappop(min_heap)
#     sum = a+b
#     answer += sum
#     heapq.heappush(min_heap,sum)
# print(answer)



#14 1700번
# 페이지부재를 최소화하는 방법이랑 비슷
# 멑티탭 구멍 개수 만큼 뒤를 보고 자신이 꽂혀잇다면 그 구멍을제외한 
# 멀티탭 구멍에서 빼야함  
# 자바의 contain() 대신에 in, not in을 통해 가지고 있는지 확인 가능
# https://angangmoddi.tistory.com/165 참고 

# a,b = input().split()
# a = int(a)
# b = int(b)
# arr = input().split()
# for i in range(b):
#     arr[i] = int(arr[i])
# temp = []
# ix = 0
# for i in range(a):
#     temp.append(0)
# answer=num=change=max_idx= 0

# for i in arr:
    
#     if i in temp:
#         pass
#     elif 0 in temp:
#         temp[temp.index(0)] = i
#     else:
#         for j in temp:
#             if j not in arr[num:]:
#                 change = j
#                 break
#             elif arr[num:].index(j)>max_idx:
#                 max_idx = arr[num:].index(j)
#                 change = j
#         temp[temp.index(change)] = i
#         answer+=1
#         change=max_idx = 0
#     num+=1

# print(answer)



#15 2812번
# 스택 사용법 알아두기!!!
# https://ooeunz.tistory.com/7
# import sys

# a,b = map(int,sys.stdin.readline().split())
# str = input()
# stack = []
# k = b
# for i in range(a):
#     while k>0 and stack and stack[-1] < str[i]:
#         stack.pop()
#         k-=1
#     stack.append(str[i])
    
# print(''.join(stack[:a-b])) # 이렇게도 문자열 출력이 가능 하다는것 알아두기




#16 10162번
# t = int(input())
# a,b,c = 0,0,0
# a = t//300
# b = (t%300)//60
# c = ((t%300)%60)//10
# if ((t%300)%60)%10 !=0:
#     print(-1)
# else:
#     print(a,b,c)



#17 4796번
# cnt=1
# while 1:
    
#     l,p,v = input().split()
#     if l == '0':
#         break
#     l,p,v = int(l),int(p),int(v)
#     answer = (v//p)*l
#     answer += min(v%p,l)
#     print("Case %d: %d" %(cnt,answer))    # 이렇게 출력하는 법 알아두자 
#     cnt+=1    




#18 1080번 
# https://m.blog.naver.com/PostView.nhn?blogId=pjok1122&logNo=221652193756&proxyReferer=http:%2F%2F210.117.121.211%2F

# N, M = map(int,input().split())
# A = [list(map(int,list(input()))) for _ in range(N)]
# B = [list(map(int,list(input()))) for _ in range(N)]

# cnt = 0 

# for i in range(N-2):
#     for j in range(M-2):
#         if A[i][j] != B[i][j]:
#             # 0 ->1, 1->0 으로 바꾸는 작업 해줌
#             for k in range(i,i+3):
#                 for l in range(j,j+3):
#                     A[k][l] = 1 - A[k][l]
#             cnt+=1
# #똑같은 지 확인 
# for i in range(N):
#     for j in range(M):
#         if A[i][j] != B[i][j]:
#             cnt = -1
#             break
# print(cnt)




#19 2437번
# https://velog.io/@sch804/%ED%8C%8C%EC%9D%B4%EC%8D%AC-%EB%B0%B1%EC%A4%80-2437%EB%B2%88-%EC%A0%80%EC%9A%B8
# 푸는 방식을 못찾았던 문제 
# 중요한것은 더한 것까진 모두 만들 수 있다는 것
# 더하는 수가 목표로 하는 수보다 크면 안됨 

# N = int(input())
# c = list(map(int,input().split()))

# c.sort()

# cnt = 1
# for i in range(N):
#     if cnt<c[i]:
#         break
#     cnt+=c[i]
# print(cnt)



#20 11000번
# 어렵다 
# 이건 다시 한번 봐야한다 
# 끝나는 시간 보다 다른강의의 시작시간이 빠르면 우선순위 큐에 추가
# 느리면 가장 빨리 끝나는 강의 다음에 이어서 하면 되기 때문에
# 우선순위 큐에서 pop하고 이어서하는 강의의 끝나는 시간을 추가한다
# import heapq
# import sys

# N = int(input())
# teach = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]
# q = []
# teach.sort(key=lambda x:x[0])
# heapq.heappush(q,teach[0][1])
# for i in range(1,N):
#     if q[0]>teach[i][0]:
#         heapq.heappush(q,teach[i][1])
#     else:
#         heapq.heappop(q)
#         heapq.heappush(q,teach[i][1])
# print(len(q))




#21 3109번
# 다시 풀어봐야할문제 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
# def traversal(a,b):
#     if b==c-1:
#         return True
#     for i in move:
#         if 0<=a+i<r and m[a+i][b+1] =='.' and not visited[a+i][b+1]:
#             visited[a+i][b+1] = True
#             if traversal(a+i,b+1):
#                 return True
#     return False
# r,c = map(int,input().split())
# m = []
# visited = [[False]*c for _ in range(r)]
# answer = 0
# for i in range(r):
#     m.append(list(input()))
# move = [-1,0,1] # 위, 앞, 아래 로 움직이는 경우 
# for i in range(r):
#     if m[i][0] == ".":
#         if traversal(i,0):
#             answer+=1
# print(answer)






#22 1449번 

# n, r = input().split()
# arr = list(map(int, input().split()))
# arr.sort()
# answer = 0
# i=0
# while i<int(n):
#     answer = answer + 1
#     a= arr[i] + int(r) - 0.5
#     cnt = 1
#     while i+cnt<int(n) and arr[i+cnt]+0.5<=a:
#         cnt= cnt + 1
#     i = i + cnt
# print(answer)




#23 10775번
# union - find 로 푸는 disjoint set 문제 
# 다시 풀어봐야함 !!!!!


# g=int(input())
# p=int(input())
# parent=[]
# for i in range(g+1):
#     parent.append(i)
    
# def union(a, b):
#     a = find(a)
#     b = find(b)
#     parent[b] = a
    
# def find(v):
#     if parent[v]==v:
#         return v
#     else:
#         parent[v]=find(parent[v])
#         return parent[v]
    
# plane=[]
# for _ in range(p):
#     plane.append(int(input()))
    
# cnt=0
# for i in plane:
#     k=find(i)
#     if k==0:
#         break
#     union(k-1,k)
#     cnt+=1
# print(cnt)






#24 1783번
#  어렵다
# case를 나누어 생각하고
# 최대로 이동하는 방법을 잘 생각해야함 
# n,m = map(int,input().split())
# cnt = 0
# if n==1:
#     cnt = 1
# elif n==2:
#     cnt = min(4,(m-1)//2 + 1)
# elif m<7:
#     cnt = min(4,m)
# else:
#     cnt = 2 + (m-5) + 1  # 2는 2,3번 한번씩 쓰는것
#                         # m-5는 2,3번 쓰고 첫번째 위치 까지 뺀 경우
#                         # 1은 2 + (m-5)는 이동횟수이고 최대 방문횟수는 이동횟수+1
# print(cnt)






#25 1493번

# s = input()
# i = 0
# cnt_1 = 0
# cnt_2 = 0
# while i < len(s):
#     if s[i] == '0':
#         i=i+1
#         while i < len(s)-1 and s[i] == '0':
#             i = i + 1
#             if s[i]=='1':
#                 break
#         cnt_1 = cnt_1 + 1
        
#     elif s[i] == '1':
#         i=i+1
#         while i < len(s)-1 and s[i] == '1':
#             i = i + 1
#             if s[i]=='0':
#                 break
#         cnt_2 = cnt_2 + 1
# print(min(cnt_1,cnt_2))
                





#26 9576번
# 정렬 기준을 잘 정해야 했다 
# 끝나는 부분을 기준으로 해야 최대로 들어가기 때문 

# case = int(input())

# for _ in range(case):
#     n,m = map(int,input().split())
#     cnt=0
#     arr = [0 for _ in range(n+1)]
#     people = []
#     for i in range(m):
#         a,b = map(int,input().split())
#         people.append([a, b])
#     people = sorted(people, key = lambda x:(x[1]))
#     #print(people)
#     for i in people:
#         a = i[0]
#         b = i[1]
        
#         for j in range(a,b+1):
#             if arr[j]==0:
#                 cnt+=1
#                 arr[j]=1
#                 break
#     print(cnt)
    





#27 16953번

# a,b = map(int,input().split())
# cnt = 0
# while 1:
#     if b==a:
#         cnt+=1
#         break
#     if a>b:
#         cnt = -1
#         break
    
#     if b%10 == 1:
#        b //=10
       
#     elif b%2==0:
#         b//=2
#     else:
#         cnt = -1
#         break
#     cnt+=1 
# print(cnt)   







#28번 1041번
#https://kkk4872.tistory.com/130
# 주사위 한개의 1면이 보이는 개수:(n-2)*(n-2) + 4*(n-1)*(n-2)
# 주사위 한개의 2면이 보이는 개수: 4*(n-2) + 4*(n-1)
# 주사위 한개의 3면이 보이는 개수: 4개 
#이렇게 수학적인 부분을 알아야함 
#그리고 A는 F와 마주보게 되고 B는 E와 C는 D와 마주보게 됨
#주사위 특성상 마주보는 면을 제외하고 모든 면이 인접함
#그러므로 마주보는 면중 최소값을 쓰면된다 
#총3개의 면 나옴

# n = int(input())
# nums = list(map(int, input().split()))
# sum=0
# minList = []
# if(n==1):
#     nums.sort()
#     for i in range(5):
#         sum+=nums[i]
# else:
#     minList.append(min(nums[0],nums[5]))
#     minList.append(min(nums[1],nums[4]))
#     minList.append(min(nums[2],nums[3]))
#     minList.sort()

#     #1,2,3면이 보여지는 주사위 개수
#     n1 = (n-2)*(n-2) + 4*(n-1)*(n-2)
#     n2 = 4*(n-2) + 4*(n-1)
#     n3 = 4
    
#     #1,2,3면이 보여질때 주사위 최소값
#     min1 = minList[0]
#     min2 = minList[0] + minList[1]
#     min3 = minList[0] + minList[1] + minList[2]

#     sum = n1 * min1 + n2 * min2 + n3 * min3

# print(sum)






#29번 1092번
#https://velog.io/@ju_h2/Python-%EB%B0%B1%EC%A4%80-1092.-%EB%B0%B0-%ED%92%80%EC%9D%B4-%ED%8C%8C%EC%9D%B4%EC%8D%AC-%ED%83%90%EC%9A%95-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EA%B7%B8%EB%A6%AC%EB%94%94-%EA%B5%AC%ED%98%84-5
#원래 코드는 python3에선 시간초과 pypy3에선 통과
#python3에서 돌아가게 하기 위해서 position이라는 배열을 만들어
#각 크레인이 다음에 들 박스 번호를 정해둠으로써 해결 가능

# import sys

# n=int(sys.stdin.readline())
# crane = list(map(int,sys.stdin.readline().split()))
# m=int(sys.stdin.readline())
# weight = list(map(int,sys.stdin.readline().split()))

# crane.sort(reverse=True)
# weight.sort(reverse = True)

# check = [0 for _ in range(m)]
# position = [0] * n

# time = 0
# if crane[0]<weight[0]:
#     time=-1
# else:
#     cnt = 0
#     while cnt<len(weight):
#         for i in range(n):
#             while position[i]<len(weight):
#                 a=position[i]
#                 if not check[a] and weight[a]<=crane[i]:
#                     check[a] = 1
#                     position[i]+=1
#                     cnt+=1
#                     break
#                 position[i]+=1
#         time+=1
# print(time)                
            






#30번 17609번
#rstrip() 안해서 고통받음 ....
#기본적인 생각은 올바른 접근 이었다 

# import sys

# def check(str,left,right):
#     while left < right:
#         if str[left] == str[right]:
#             left+=1
#             right-=1
#         else:
#             return False
#     return True

# def pelin(a,left,right):
#     while left<right:
#         if a[left] == a[right]:
#             left+=1
#             right-=1
#         else:
#             c1 = check(a,left+1,right)
#             c2 = check(a,left,right-1)
#             if c1 or c2:
#                 return 1
#             else:
#                 return 2
#     return 0 

# t = int(sys.stdin.readline().rstrip())

# for i in range(t):
#     a=list(sys.stdin.readline().rstrip())
#     result = pelin(a,0,len(a)-1)
#     print(result)
    






#31번 2457번 
#지는 날은 꽃을 못봄 
# 3월 1일 부터 11월 30일 까지는 매일 꽃이 한가지 이상
# 가장 적게 심어야함 
# 스케쥴링
# ***월과 일을 단순히 비교하기위해 월*100 + 일 을 해주어 단순히 숫자크기비교*** 


# import sys

# def gardening(n,a,cnt):

#     a = sorted(a,key = lambda x:(x[0],x[1]))
    
#     if a[0][0]>301:
#         return 0

#     s=301
#     e=1130
#     t=0
#     linenum=0
#     while(1):
#         f = False
#         for i in range(linenum,n):
            
#             if a[i][0]>s:
#                 break
#             if t<a[i][1]:
#                 t=a[i][1]
#                 linenum = i
#                 f = True
#         s=t
#         if f==True:
#             cnt+=1
#         elif f==False:
#             return 0
#         if(t>1130):
#             return cnt


# n = int(sys.stdin.readline().rstrip())
# a = []
# cnt = 0

# for _ in range(n):
#     l = list(map(int,sys.stdin.readline().split()))
#     a.append([l[0]*100+l[1],l[2]*100+l[3]])

# print(gardening(n,a,cnt))







# 32번 2847번
# 뒤집어서 생각해보자
# for문 지정 방법 알아두기
# 변경 횟수 최소 ->뒤의 값 -1 이 최소

# import sys

# n = int(sys.stdin.readline().rstrip())
# a = []

# for _ in range(n):
#     a.append(int(sys.stdin.readline().rstrip()))

# cnt = 0

# for i in range(n-1,0,-1):
#     if a[i-1]>=a[i]:
#         cnt += a[i-1] - a[i] + 1
#         a[i-1] = a[i]-1

# print(cnt)








# 33번 2810번

# import sys

# n = int(sys.stdin.readline().rstrip())
# a = input()

# cnt=0

# a = a.replace('LL','!')
# cnt= len(a)+1

# if cnt>=n:
#     print(n)
# else:
#     print(cnt)







# 34번 15903번


# 1번 풀이
# 그냥 배열을 그떄그떄 정렬
# 2번 풀이보다 오래걸림 (메모리 차지는 조금 덜함)
# import sys

# n,m = list(map(int,sys.stdin.readline().split()))
# a = list(map(int,sys.stdin.readline().split()))

# a.sort()
# sum = 0
# result = 0
# for i in range(m):
#     sum  = a[0] + a[1]
#     a[0] = sum
#     a[1] = sum
#     a.sort() 

# for i in range(n):
#     result += a[i]
# print(result)


# 2번풀이 
# heapq를 이용해서 풀었음
# 시간이 1번 보다 적게 걸림

# import sys
# import heapq

# n,m = list(map(int,sys.stdin.readline().split()))
# a = list(map(int,sys.stdin.readline().split()))
# b=[]
# for i in range(n):
#     heapq.heappush(b, a[i])

# for i in range(m):
#     c1=heapq.heappop(b)
#     c2=heapq.heappop(b)

#     heapq.heappush(b,c1 + c2)
#     heapq.heappush(b,c1 + c2)
# print(sum(b))






# 35번 8980번 ******
# https://steadev.tistory.com/15
# 중요한것은 도착지 기준으로 정렬 하는것
# 중간에 있는 마을들이 어떨지 알수가 없기때문에 도착지 기준으로 정렬 하는것

# import sys

# n,c = list(map(int,sys.stdin.readline().split()))
# m = int(sys.stdin.readline().rstrip())
# a=[]
# for i in range(m):
#     a.append(list(map(int,sys.stdin.readline().split())))

# a = sorted(a,key = lambda x:x[1])
# truck = [c]*n
# result = 0
# for i in range(m):
#     temp = c
#     for j in range(a[i][0],a[i][1]):
#         temp = min(truck[j],temp)
#     temp = min(temp, a[i][2])
#     for j in range(a[i][0],a[i][1]):
#         truck[j]-=temp
#     result+=temp

# print(result)








# *****************************************
# 36번 1781번
# 어렵다 다시한번 보자
# ******************************************
# import sys 
# import heapq

# n = int(sys.stdin.readline().rstrip())
# a = []

# for i in range(n):
#     a.append(list(map(int,sys.stdin.readline().split())))

# a.sort()

# b = []
# result = 0

# for i in range(n):
#     heapq.heappush(b,a[i][1])
#     if a[i][0] < len(b):
#         heapq.heappop(b)
# print(sum(b))





# 37번 11501번
# 최댓 값을 계속찾는 경우는 숫자가 매우 클 경우 비효율적
# 잘생각해보면 뒤에서 부터 보면 최대값 갱신이후 값이 작아지면 그떄 사서 최대값에 파는게 최대이득이고
# 더 큰값이 나오면 최대값 갱신하고 다시 더큰 값이 나올떄까지 작은 값들을 사고파는 방식이 O(n)에 
# 해결하는 방법
# 뒤에서 부터 보는 방식을 생각을 못함

# import sys

# t = int(sys.stdin.readline().rstrip())
# result = []

# for i in range(t):
#     n = int(sys.stdin.readline().rstrip())
#     a = list(map(int,sys.stdin.readline().split()))
#     max = 0 
#     sum = 0
#     for j in range(n-1,-1,-1):
#         if a[j]>max:
#             max=a[j]
#         elif a[j]==max:
#             continue
#         elif a[j]<max:
#             sum += max - a[j]
#     result.append(sum)

# for i in result:
#     print(i)



# 시간초과 -계속 최대값 찾는 것은 O(n^2)
# for i in range(t):
#     n = int(sys.stdin.readline().rstrip())
#     a = list(map(int,sys.stdin.readline().split()))
#     result = 0
#     #s=0
#     while 1:
#         sum=0
#         max=-1
#         idx=0
#         if not a:
#             print(result)
#             break
#         for j in range(len(a)):
#             if a[j]>max:
#                 max=a[j]
#                 idx=j
#         #print(idx)
        
#         if idx==0:
#             print(result)
#             break
#         for j in range(0,idx):
#             sum +=a[j]

#         result += max*idx - sum
        
#         del a[0:idx+1]
        #print(a)
        
        #s=idx+1
    #for j in range(n):






# 38번 2212번 
# 거리 배열 만드는 것 까지는 생각함
# 여기서 제일 긴 거리를 (집중국-1) 만 큼 빼주어도 다 연결된다는 것을 생각 못함 

# import sys

# n = int(sys.stdin.readline().rstrip())
# k = int(sys.stdin.readline().rstrip())

# a = list(map(int,sys.stdin.readline().split()))
# a.sort()

# if k>=n:
#     print(0)
# else:   
#     distance = []

#     for i in range(n-1):
#         distance.append(a[i+1] -a[i])

#     distance.sort(reverse=True)

#     for i in range(k-1):
#         distance[i] = 0

#     print(sum(distance))







# 39번 15904번 

# import sys

# a=sys.stdin.readline()

# ucpc = ["U","C","P","C"]
# c = True

# for i in range(len(ucpc)):
#     if ucpc[i] in a:
#         c = True
#         idx =a.index(ucpc[i])
#         a = a[idx + 1:]
#     else:
#         c =False
#         break

# if c:
#     print("I love UCPC")
# else:
#     print("I hate UCPC")










# 40번 2873번
# https://suri78.tistory.com/148
# https://kkk4872.tistory.com/141
# 구현이 개빡세다 

# import sys

# r,c = map(int,sys.stdin.readline().split())
# a = []

# for i in range(r):
#     a.append(list(map(int, sys.stdin.readline().split())))

# if r%2==1:
#     print(('R'*(c-1) + 'D' + 'L'*(c-1) + 'D')*(r//2) + 'R'*(c-1))
# elif c%2==1:
#     print(('D'*(r-1) + 'R' + 'U'*(r-1) + 'R')*(c//2) + 'D'*(r-1))
# elif r%2==0 and c%2==0:
#     min = 1000
#     point = [-1. -1]
#     for i in range(r):
#         for j in range(c):
#                 if ((i+j)%2!=0 and min>a[i][j]):
#                     min = a[i][j]
#                     point = [i,j]

#     result = ('D'*(r-1)+'R'+'U'*(r-1)+'R')*(point[1]//2)
#     curX = 2*(point[1]//2) 
#     curY = 0 
#     xbound = 2*(point[1]//2)+1

#     while curX!=xbound or curY!=r-1:
#         if curX<xbound and [curY,xbound] != point:
#             curX+=1
#             result+='R'
#         elif curX==xbound and [curY,xbound-1]!=point:
#             curX-=1
#             result+='L'
#         if curY!=r-1:
#             curY+=1
#             result+='D'

#     result+=('R' + 'U'*(r-1) + 'R' + 'D'*(r-1))*((c - point[1] - 1)//2)

#     print(result)



    
        
            




# 41번 14659번
# !!!!!!!!!!!!!!변수명을 함수와 똑같이 하지말자 오류발생함!!!!!!!!!!!!!!


# import sys

# n = int(sys.stdin.readline().rstrip())
# a = list(map(int,sys.stdin.readline().split()))

# x=0
# cnt=0
# ans=0

# for i in range(n):
#     if a[i]>x:
#         x=a[i]
#         cnt=0
#     else:
#         cnt+=1
#     ans=max(ans,cnt)

# print(ans)











# 42번 2613번
# 파라매트릭 서치 => 최적화문제(문제상황을 만족하는 특정 변수의 최솟값, 최댓값을 구하는 문제)를
#                   결정 문제로 바꾸어 푸는것
# 이분 탐색과 매우 비슷하지만 차이가 존재
# 이분 탐색기준을 찾지 못함!!!
# 어렵다
# 그룹을 나눠보는게 아닌 최대값을 늘리거나 줄여가며 그때 조건에 맞으면 출력해주는 방식 
# 최대값을 찾을대 이분탐색을 사용
# https://zoosso.tistory.com/415


# import sys

# n,m = map(int,sys.stdin.readline().split())
# a = list(map(int,sys.stdin.readline().split()))

# def check(mid):
#     sum = 0
#     group_cnt = 1
#     for i in range(n):
#         sum+=a[i]
#         if sum > mid:
#             sum = a[i]
#             group_cnt+=1
#     if group_cnt <= m:
#         return True
#     else:
#         return False

    

# left = max(a)
# right = sum(a)
# ans=0
# mid = 0

# while left<=right:
#     mid = (left + right)//2
#     if check(mid):
#         ans = mid  # 여기서 이렇게 해주는 이유는 결과가 m보다 작을땐 좀더 작은 값 찾기위해 좌측 탐색함
#                    # 그래서 결국 안되면 원래 값이 답이됨(check 함수에서 true 값이 나와야만 ans가 될수 있다)
#         right = mid - 1
#     else:
#         left = mid + 1

# print(ans)

# sum = 0
# inside_cnt = 0
# for i in range(n):
#     sum+=a[i]
#     if sum > ans:
#         sum = a[i]
#         m-=1
#         print(inside_cnt,end=" ")
#         inside_cnt = 0
#     inside_cnt += 1

#     if n-i==m:
#         break

# while m>0:
#     print(inside_cnt,end=" ")
#     inside_cnt=1
#     m-=1












# 43번 2109번

import sys

