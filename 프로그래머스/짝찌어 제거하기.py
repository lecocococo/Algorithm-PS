def solution(s):
    answer = 0
    st = []
    
    for c in s:
        if st and st[-1] == c:
            st.pop()
        else:
            st.append(c)
    
    if not st:
        answer = 1
    
    return answer
