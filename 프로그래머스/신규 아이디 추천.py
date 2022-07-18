import re
def solution(new_id):
    answer = ''
    new_id = re.sub('[~!@#$%^&*()=+{}\[\]:?,<>/]', "",new_id.lower())
    new_id = re.sub('([.])\\1{1,}', '.', new_id)
    
    new_id = new_id.strip(".")
    
    l = len(new_id)
    if l == 0:
        new_id = "a"
    elif l>=16:
        new_id = new_id[:15]
        new_id = new_id.rstrip('.')
    if len(new_id)<=2:
        val = new_id[len(new_id) - 1]
        while len(new_id)<3:
            new_id += val
    answer = new_id
    return answer
