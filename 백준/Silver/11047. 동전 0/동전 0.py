import sys

def inp():
    n, k = map(int, sys.stdin.readline().split())
    coins = []
    for _ in range(n):
        coins.append(int(sys.stdin.readline().strip()))
    return k, coins

def simulate(n, coins):
    cnt = 0
    while n:
        coin = coins.pop()
        cnt += n//coin
        n = n%coin
        # print(coin, cnt, n)
    return cnt

def main():
    n, coins = inp()
    print(simulate(n, coins))

if __name__ == '__main__':
    main()