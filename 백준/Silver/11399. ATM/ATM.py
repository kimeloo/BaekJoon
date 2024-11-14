import sys

def inp():
    sys.stdin.readline()
    nums = list(map(int, sys.stdin.readline().split()))
    return nums

def calculate(nums):
    result = 0
    wait = 0
    for num in nums:
        result += wait + num
        wait += num
    return result

def main():
    nums = inp()
    nums.sort()
    print(calculate(nums))

if __name__ == '__main__':
    main()