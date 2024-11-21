import sys

'''
1칸, 2칸으로 나누어 dp (dp 내에서 나누기)
dp 내에서, 다음 칸 건너뛰기 포함
마지막 칸이 포함되거나, 건너뛰는 칸이 마지막 칸이면 중단

현위치, 현재합 변수 필요 (1칸,2칸 여부는 dp 내에서 결정)
'''

#   1   2   3   4   5   6   7
#   dp  
#   c1  sk  dp
#   c1  c2  sk  dp

def memo(func):
    cache = {}

    def wrapper(*args, **kwargs):
        key = str(args)+'/'+str(kwargs)
        if key in cache:
            return cache[key]
        result = func(*args, **kwargs)
        cache[key] = result
        return result
    
    return wrapper


@memo
def dp(graph, point, step):
    last = len(graph)-1
    step -= 1
    
    if (point+step) > last:     # 끝점이 초과한 경우
        return -1
    
    _sum = 0
    for i in range(step+1):
        _sum += graph[point+i]
    if (point+step) < last:    # 끝점 < target인 경우   (target과 같으면 _sum만 return)
        next_dp1 = dp(graph, point+step+2, 1)
        next_dp2 = dp(graph, point+step+2, 2)
        result = max([next_dp1, next_dp2])
        if result < 0:
            return -1
        _sum += result
    # print(point, step+1, _sum)
    return _sum

def inp():
    n = int(sys.stdin.readline().strip())
    graph = []
    for _ in range(n):
        graph.append(int(sys.stdin.readline().strip()))
    return graph

def main():
    graph = inp()
    result = []
    for i in range(2):
        for j in range(1,3):
            result.append(dp(graph, i, j))
    print(max(result))

if __name__ == '__main__':
    sys.setrecursionlimit(50000)
    main()
