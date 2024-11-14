import sys

def inp():
    _, m = map(int, sys.stdin.readline().split())
    nums = list(map(int, sys.stdin.readline().split()))
    return m, nums

def calculate(nums):
    sums = [0]
    s = 0
    for num in nums:
        s += num
        sums.append(s)
    return sums

def simulate(sums):
    i, j = map(int, sys.stdin.readline().split())
    print(sums[j]-sums[i-1])

def main():
    m, nums = inp()
    sums = calculate(nums)
    for _ in range(m):
        simulate(sums)

if __name__ == '__main__':
    main()