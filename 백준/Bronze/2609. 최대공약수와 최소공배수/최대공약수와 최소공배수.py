import sys

def gcd(a,b):
    while b>=1:
        a, b = b, a%b
    return a

a,b = map(int,sys.stdin.readline().split())
g = gcd(a,b)
l = (a*b)//g
print(g)
print(l)