import re # 파이썬 정규표현식 모듈
# re.sub(pattern, repl, string, count=0, flags=0)

def solution(new_id):
    answer = ''
    new_id = new_id.lower()
    new_id = re.sub(r'[^\w\-\.]', '', new_id)
# \w: 알파벳, 숫자, 밑줄(_)
# \-, \., \w를 제외(^)
# 패턴에 일치하는 문자열들은 ""로 대체하여 제거함
    new_id = re.sub(r'\.{2,}', '.', new_id)
    new_id = new_id.strip('.')
    if not new_id:
        new_id += "a"
    if len(new_id) > 15:
        new_id = new_id[:15]
        new_id = new_id.strip('.')
    while len(new_id) < 3:
        new_id += new_id[-1]
    return new_id


# 파이썬 공백 및 문자제거, strip(시작, 끝), rstrip(끝), lstrip(시작)
# 파라미터가 없을 시 공백을 제거하고 파라미터를 넘겨주면 문자열에서 파라미터와 일치하는 문자 혹은 문자열을 제거
# 



# ldd
