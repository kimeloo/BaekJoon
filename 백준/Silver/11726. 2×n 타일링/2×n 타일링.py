import sys

def fct(n):
    s = 1
    for i in range(1,n+1):
        s *= i
    # print(s)
    return s

# (a+b)! / a!*b!

n = int(sys.stdin.readline().strip())

s = 0
a = 0
b = n
while b >= 0:
    s += (fct(a+b)//(fct(a)*(fct(b))))
    a += 1
    b -= 2
print(s%10007)



'''
9
7+1
5+2
3+3
1+4

'''