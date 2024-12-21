import sys

def inp():
    # n, m : 세로*가로
    # b : 인벤토리 내 블록 개수
    n, m, b = map(int, sys.stdin.readline().split())
    ground = []
    for _ in range(n):
        ground.extend(list(map(int, sys.stdin.readline().split())))
    ground.sort()
    return ground, b

def count_height(ground):
    counter = dict()
    for value in ground:
        counter[value] = 1 + (0 if (value not in counter) else counter[value])
    return counter

def calculate(counter, target, inventory):
    block_needed = 0
    block_removed = 0
    for height in counter:
        if height < target:
            block_needed += (target-height)*counter[height]
        elif height>target:
            block_removed += (height-target)*counter[height]
    if block_needed>(block_removed + inventory):      # target값 도달 불가
        return 1e16
    return block_needed+2*block_removed

def simulate(counter, inventory):
    heights = [x for x in range(0,257)]
    min_time = 1e16
    result = 0
    for target in heights:
        current_time = calculate(counter, target, inventory)
        if min_time>current_time:
            min_time = current_time
            result = target
        elif min_time==current_time:
            result = max(target, result)
    return min_time, result

def main():
    ground, inventory = inp()
    counter = count_height(ground)
    print(*simulate(counter, inventory), sep=" ")

if __name__ == '__main__':
    main()