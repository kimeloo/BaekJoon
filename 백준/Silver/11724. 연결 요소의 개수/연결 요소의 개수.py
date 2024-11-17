import sys
from collections import defaultdict

def inp():
    n, m = map(int, sys.stdin.readline().split())
    visited = [0] * n
    graph = defaultdict(set)
    for _ in range(m):
        u, v = map(int, sys.stdin.readline().split())
        graph[u].add(v)
        graph[v].add(u)
    return graph, visited

def simulate(graph):
    global visited
    cnt = 0
    for point in graph:
        if dfs(graph, point):
            cnt += 1
    return cnt

def dfs(graph, point):
    global visited
    if visited[point-1]:
        return True
    visited[point-1] += 1
    next_points = graph[point]
    for next_point in next_points:
        dfs(graph, next_point)
    return False

def main():
    global visited
    graph, visited = inp()
    print(len(visited)-simulate(graph))

if __name__ == '__main__':
    sys.setrecursionlimit(10000)
    visited = []
    main()