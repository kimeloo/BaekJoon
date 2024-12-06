import sys
# from collections import deque

def inp():
    n = int(sys.stdin.readline().strip())
    nums = list(map(int, sys.stdin.readline().split()))
    return nums

def compr(nums:list):
    compressed = []
    current = 0
    cnt = 0
    for n in nums:
        if n != current:
            compressed.append((current, cnt))
            current = n
            cnt = 0
        cnt += 1
        # print(n, cnt)
    compressed.append((current, cnt))
    return compressed

def search(nums:list):
    idx = 0
    subtotal = 0
    max_total = 0
    while idx < len(nums):
        if idx>1:
            if nums[idx-2][0] != nums[idx][0]:
                max_total = max(max_total, subtotal)
                subtotal = nums[idx-1][1]
        subtotal += nums[idx][1]
        idx += 1
        # print(max_total)
    max_total = max(max_total, subtotal)
    return max_total

def main():
    nums = inp()
    nums = compr(nums)
    # print(nums)
    print(search(nums))

if __name__ == '__main__':
    main()

    
# print(search([[7,1],[5,2],[2,1],[5,2],[2,6],[7,1]]))
# print(search([[1,5]]))

# 7 5 5 2 5 5 2 2 2 2 2 2 7
# 11