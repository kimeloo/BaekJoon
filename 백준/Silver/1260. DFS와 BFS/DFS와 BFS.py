import sys

from collections import deque

class visited():
    def __init__(self):
        self.vlist = []
        self.vset = set()
    
    def has_visited(self, point):
        if point in self.vset:
            return True
        return False

    def visit(self, point):
        if self.has_visited(point):
            return False
        self.vlist.append(point)
        self.vset.add(point)
        return True
    
    def get_list(self):
        return self.vlist

def bfs(graph, start, check):
    bfs_q = deque()
    bfs_q.append(start)
    while bfs_q:
        point = bfs_q.popleft()
        if check.visit(point):
            bfs_q.extend(sorted(graph[point]))

def dfs(graph, point, check):
    if check.visit(point):
        next_points = sorted(graph[point])
        for next_point in next_points:
            dfs(graph, next_point, check)

def get_input():
    n, m, start = map(int, sys.stdin.readline().split())
    graph = dict()
    for i in range(1,n+1):
        graph[i] = []

    for _ in range(m):
        u, v = map(int, sys.stdin.readline().split())
        graph[u].append(v)
        graph[v].append(u)
    
    return graph, start

def main():
    check_dfs = visited()
    check_bfs = visited()
    graph, start = get_input()
    dfs(graph, start, check_dfs)
    bfs(graph, start, check_bfs)
    print(*check_dfs.get_list(), sep=" ")
    print(*check_bfs.get_list(), sep=" ")

if __name__ == '__main__':
    main()