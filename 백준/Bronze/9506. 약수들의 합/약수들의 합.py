inputList = list(map(int,open(0).readlines()))[:-1]
for num in inputList:
    d = []
    for n in range(1,num):
        if num%n == 0:
            d.append(n)
    if sum(d) == num:
        print(num, end=" = ")
        for n in range(len(d)-1):
            print(d[n], end=" + ")
        print(d[-1])
    else:
        print(f'{num} is NOT perfect.')