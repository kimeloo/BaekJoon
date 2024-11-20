import sys

from collections import deque

class Point():
    def __init__(self, point, order):
        self.point = point
        self.order = order

class Visited():
    def __init__(self):
        self.vset = set()
    
    def has_visited(self, point):
        if point in self.vset:
            return True
        return False

    def visit(self, point:Point):
        if self.has_visited(point.point):
            return False
        self.vset.add(point.point)
        return True

def check_point(num_map, point, target):
    x, y = point
    m, n = target
    if (x>m) or (y>n) or (x<0) or (y<0):
        pass
    elif num_map[y][x]:
        return True
    return False

def find_next(num_map, point, target):
    x, y = point
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    next_points = []
    for i in range(4):
        new_point = (x+dx[i], y+dy[i])
        if check_point(num_map, new_point, target):            
            next_points.append(new_point)
    return next_points

def bfs(num_map, start, target):
    q = deque()
    q.append(Point(start,1))
    check = Visited()
    while q:
        point = q.popleft()
        if point.point == target:
            return point.order
        if check.visit(point):
            next_points = find_next(num_map, point.point, target)
            for next_point in next_points:
                q.append(Point(next_point, point.order+1))
        # print(q)
        # print(check.vset)

def inp():
    n, m = map(int, sys.stdin.readline().split())
    target = (m-1,n-1)
    num_map = []
    for _ in range(n):
        num_map.append(list(map(int,list(sys.stdin.readline().strip()))))
    return num_map, target

def main():
    num_map, target = inp()
    print(bfs(num_map, (0,0), target))

if __name__ == '__main__':
    main()