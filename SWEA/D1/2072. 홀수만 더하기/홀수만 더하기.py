n = int(input())
for i in range(n):
    nums = list(map(int, input().split()))
    total = 0
    for num in nums:
        total += num if num%2==1 else 0
    print('#{} {}'.format(i+1, total))