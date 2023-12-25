inputInt = int(open(0).readline())

for i in range(1, inputInt+1):
    p = "*"*i
    print(p.rjust(inputInt, " "))