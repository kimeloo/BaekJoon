import sys

def count(nums):
    last = 0
    cnt = 0
    for num in nums:
        if num > last:
            last = num
            cnt += 1
        # print(num, last, cnt)
    return cnt

def main():
    n = int(sys.stdin.readline().strip())
    nums = []
    for _ in range(n):
        nums.append(int(sys.stdin.readline().strip()))
    print(count(nums))
    nums.reverse()
    print(count(nums))

if __name__ == '__main__':
    main()