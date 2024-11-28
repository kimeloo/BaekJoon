import sys

def inp():
    n = int(sys.stdin.readline().strip())
    m = int(sys.stdin.readline().strip())
    s = list(sys.stdin.readline().strip())
    return n, m, s

def count(m, s):
    wasI = False
    wasIO = False
    counts = []
    current = 0
    for i in range(m):              # 현재 검사 위치가 ^오른쪽일 때
        if wasIO and s[i]=="I":     # IO^I
            wasI = True
            wasIO = False
            current += 1
        elif wasI and s[i]=="O":    # I^O
            wasI = False
            wasIO = True
        else:
            if current:
                counts.append(current)
            wasI, wasIO, current = False, False, 0
            if s[i]=="I":
                wasI = True
    if current:
        counts.append(current)
    return counts

# def use_cache(func):
#     cache = dict()
#     def wrapper(n):
#         key = n
#         if key in cache:
#             return cache[key]
#         result = func(n)
#         cache[key] = result
#         return result
    
#     return wrapper


# @use_cache
# def fctr(n):
#     if n<=1:
#         return 1
#     return n*fctr(n-1)

# O O O O O




# def combi(n,r):
#     if r>n:
#         return 0
#     result = [1,1]
#     for i in range(1,r+1):
#         result[0] *= n-i+1
#         result[1] *= i
#     print(n,r, result)
#     return result[0]//result[1]

def simulate(n, m, s):
    counts = count(m,s)
    result = 0
    for cnt in counts:
        # result += combi(cnt-n,1)
        if cnt>=n:
            result += cnt-n+1
        # print(cnt, result)
    return result



if __name__ == '__main__':
    n, m, s = inp()
    print(simulate(n,m,s))