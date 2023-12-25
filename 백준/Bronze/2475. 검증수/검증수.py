inputList = list(map(int, open(0).readline().split()))
sum = 0
for i in inputList:
    sum += i**2
print(sum%10)