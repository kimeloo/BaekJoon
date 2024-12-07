import sys

def main():
    t = int(sys.stdin.readline().strip())
    for _ in range(t):
        simulate()

def simulate():
    n = int(sys.stdin.readline().strip())
    print(padoban(n))

def cache(func):
    nums = dict()
    def wrapper(n):
        if n in nums:
            result = nums[n]
        else:
            result = func(n)
            nums[n] = result
        return result
    return wrapper

@cache
def padoban(n):
    if (n==1) or (n==2) or (n==3):
        return 1
    return padoban(n-2)+padoban(n-3)

if __name__ == '__main__':
    main()