import sys

def prime(n):
    if n==1:
        return 0
    for i in range(2,n):
        if n%i==0:
            # print(n,i)
            return 0
    return 1

def inp():
    _ = sys.stdin.readline()
    nums = list(map(int, sys.stdin.readline().split()))
    return nums

def main():
    nums = inp()
    result = 0
    for num in nums:
        result += prime(num)
    print(result)

if __name__ == '__main__':
    main()