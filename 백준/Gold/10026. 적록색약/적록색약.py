import sys

def inp():
    color_map = []
    n = int(sys.stdin.readline().strip())
    for _ in range(n):
        line = sys.stdin.readline().strip()
        color_map.append(list(line))
    return color_map, n

def find_next(yx, n):
    next_list = []
    dy = [0,0,1,-1]
    dx = [1,-1,0,0]
    y, x = yx
    for i in range(4):
        new_y, new_x = y+dy[i], x+dx[i]
        if (new_y>=n) or (new_x>=n) or (new_y<0) or (new_x<0):
            continue
        next_list.append((new_y, new_x))
    # print(yx, next_list)
    return next_list

def dfs(start, color_map, visited, n, is_rg=False):
    stack = [start]
    color = color_map[start[0]][start[1]]
    if is_rg and (color=="B"):
        is_rg=False
    while stack:
        y, x = stack.pop()
        if (y,x) in visited:
            continue
        if (color_map[y][x] == color) or (is_rg and (color_map[y][x] in ["R", "G"])):
            stack.extend(find_next((y,x), n))
            visited.add((y,x))
    # print(visited)
    return visited

def bfs(color_map, n):
    visited_normal = set()
    visited_bl = set()
    cnt_normal = 0
    cnt_bl = 0
    for y in range(n):
        for x in range(n):
            # print(f'-------{y,x}------')
            if (y,x) not in visited_normal:
                visited_normal = dfs((y,x), color_map, visited_normal, n)
                cnt_normal += 1
            # print('--')
            if (y,x) not in visited_bl:
                visited_bl = dfs((y,x), color_map, visited_bl, n, is_rg=True)
                cnt_bl += 1
    return cnt_normal, cnt_bl

def main():
    color_map, n = inp()
    print(*bfs(color_map, n), sep=" ")

if __name__ == '__main__':
    main()