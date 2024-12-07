import sys

def main():
    n = int(sys.stdin.readline().strip())
    print(simulate(n))

def cache(func):
    nums = dict()
    def wrapper(n):
        if n not in nums:
            nums[n] = func(n)
        return nums[n]
    return wrapper

@cache
def fact(n):
    if n<=1:
        return 1
    return n*fact(n-1)

def permutation(n, a, b):
    return fact(n)//(fact(a)*fact(b))

def simulate(n):
    result = 0
    for two in range(0, (n//2)+1):
        one = n-2*two
        result += permutation(one+two, one,two)*(2**two)
        # print(one, two, result)
    return result%10007

# 1 1 2 2 2
# 1 2 1 2 2
# 1 2 2 1 2
# 1 2 2 2 1
# 2 1 1 2 2
# 2 1 2 1 2
# 2 1 2 2 1
# 2 2 1 1 2
# 2 2 1 2 1
# 2 2 2 1 1



if __name__ == '__main__':
    sys.setrecursionlimit(10000)
    main()