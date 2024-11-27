import sys
from collections import deque

def inp():
    cmd = list(sys.stdin.readline().strip())
    n = int(sys.stdin.readline().strip())
    nums_raw = sys.stdin.readline().strip('[]\n')
    if nums_raw:
        nums = deque(list(map(int, nums_raw.split(','))))
    else:
        nums = deque()
    return cmd, n, nums

def simulate(cmd:list, n:int, nums:deque):
    if cmd.count("D") > n:
        return "error"
    direction = True
    for command in cmd:
        if command=="R":
            direction = not direction
        if command=="D":
            if direction:
                nums.popleft()
            else:
                nums.pop()
    if not direction:
        nums.reverse()
    return list(nums)

def main():
    cases = int(sys.stdin.readline().strip())
    for _ in range(cases):
        cmd, n, nums = inp()
        result = simulate(cmd, n, nums)
        if result != 'error':
            print("[",end="")
            print(*result,sep=",",end="]\n")
        else:
            print(result)

if __name__ == '__main__':
    main()