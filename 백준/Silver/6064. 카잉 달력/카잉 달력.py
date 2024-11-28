import sys

def inp():
    return map(int, sys.stdin.readline().split())

def simulate(m, n, x, y):
    # 정수 k1, k2에 대해서, mk1+x = nk2+y, k1가 정수일때 (mk1+x-y)/n=k2 만족하는 k2가 정수이면 됨
    for k1 in range(n):
        nk2 = m*k1+x-y
        if nk2%n == 0:
            return k1*m+x
    return -1


def main():
    t = int(sys.stdin.readline().strip())
    for _ in range(t):
        m, n, x, y = inp()
        print(simulate(m,n,x,y))

if __name__ == '__main__':
    main()