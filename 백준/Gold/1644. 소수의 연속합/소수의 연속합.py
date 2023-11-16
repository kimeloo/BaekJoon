import math

def smallerPrime(n):
    prime = [False, False] + [True]*(n-1)    # 0~n까지에 해당하는 리스트 생성, True면 소수, 0과 1은 소수가 될 수 없음 -> 2부터 True
    for i in range(2, int(math.sqrt(n))+1):
        if prime[i]:
            whileCount=2
            while True:
                notPrime = i * whileCount
                if notPrime > n:
                    # print(notPrime, i, whileCount)
                    break
                # print(notPrime)
                prime[notPrime]=False
                whileCount += 1
    result = []
    for i in range(n+1):
        if prime[i]:
            result.append(i)
    return result

num = int(input())
result = 0
primeList = smallerPrime(num)
# print(primeList)
left=0
right=0
sum=0
while left<=right and right<len(primeList):
    try:
        sum+=primeList[right]
    except:
        break
    while sum>num:
        sum -= primeList[left]
        left += 1
    if sum==num:
        result+=1
    right += 1
print(result)