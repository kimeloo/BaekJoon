import sys

if __name__ == '__main__':
    n = int(sys.stdin.readline().strip())
    for i in range(n):
        a, b, x = map(int, sys.stdin.readline().split())
        print(a*(x-1)+b)