import sys

def inp():
    n = int(sys.stdin.readline().strip())
    nums = list(map(int, sys.stdin.readline().split()))
    return nums

def simulate(nums):
    num_unique = list(set(nums))
    num_unique.sort()
    num_dict = dict()
    for idx, num in enumerate(num_unique):
        num_dict[num] = idx
    for i in range(len(nums)):
        nums[i] = num_dict[nums[i]]
    return nums

def main():
    nums = inp()
    nums = simulate(nums)
    print(*nums, sep=" ")

if __name__ == '__main__':
    main()