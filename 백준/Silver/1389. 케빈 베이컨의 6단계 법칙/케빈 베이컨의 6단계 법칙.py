import sys

from collections import deque

class Friend():
    def __init__(self):
        self.friend = dict()

    def set_friend(self, friend, order):
        self.friend[friend] = order
    
    def get_friend(self):
        return self.friend

class Visited(Friend):
    def __init__(self):
        super().__init__()
        self.vset = set()

    def has_visited(self, point):
        if point.point in self.vset:
            return True
        return False
    
    def visit(self, point):
        if self.has_visited(point):
            return False
        self.vset.add(point.point)
        super().set_friend(point.point, point.order)
        return True
    
    def get_friend(self):
        return super().get_friend()

class Point():
    def __init__(self, point, order):
        self.point = point
        self.order = order

def inp():
    n, m = map(int, sys.stdin.readline().split())
    graph = dict()
    for i in range(1, n+1):
        graph[i] = []
    for _ in range(m):
        u, v = map(int, sys.stdin.readline().split())
        graph[u].append(v)
        graph[v].append(u)
    return graph, n

def bfs(graph, start):
    q = deque()
    q.append(Point(start, 0))
    check = Visited()
    while q:
        point = q.popleft()
        if check.visit(point):
            next_points = graph[point.point]
            for next_point in next_points:
                q.append(Point(next_point, point.order+1))
    return check.get_friend()

def main():
    graph, n = inp()
    result = Point(9999, 9999)
    for person in range(1, n+1):
        friends = bfs(graph, person)
        current_sum = sum(list(friends.values()))
        if (result.order > current_sum) or ((result.order == current_sum) and (result.point > person)):
            result = Point(person, current_sum)
    print(result.point)
            
    
        
        # print(i, end=" : ")
        # for key in sorted(list(friends.keys())):
            # print(friends[key], end=" ")
        # print("")

if __name__ == '__main__':
    main()