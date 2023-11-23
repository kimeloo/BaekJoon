from collections import deque

inputLines = open(0).readlines()
waterNum = int(inputLines[0])
waterList = list(map(int,inputLines[1].split()))

result_a_b = []
last = "l"

left = 0
right = waterNum-1

while left!=right:
    a = waterList[left]
    b = waterList[right]
    sum = a + b
    
    if sum == 0:
        result_a_b = [a, b]
        break
    elif last == "l" or abs(sum)<abs(last):
        last = sum
        result_a_b = [a, b]
    
    if sum < 0:
        left+=1
    else:
        right-=1

print(result_a_b[0], result_a_b[1])