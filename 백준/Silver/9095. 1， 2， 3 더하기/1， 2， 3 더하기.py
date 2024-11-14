import sys

def inp():
    n = int(sys.stdin.readline().strip())
    nums = []
    for _ in range(n):
        nums.append(int(sys.stdin.readline().strip()))
    return nums

def find_sum(num):
    result = 0
    max3 = num//3
    for three in range(max3+1):
        num_3 = num - 3*three
        max2 = num_3//2
        for two in range(max2+1):
            one = num_3 - 2*two
            result += find_case(one, two, three)
    return result

def find_case(one, two, three):
    return int(factorial(one+two+three)/(factorial(one)*factorial(two)*factorial(three)))

def factorial(num):
    result = 1
    for i in range(2, num+1):
        result *= i
    return result

def main():
    nums = inp()
    for num in nums:
        print(find_sum(num))

if __name__ == '__main__':
    main()