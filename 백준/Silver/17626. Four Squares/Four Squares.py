import sys

def main():
    n = int(sys.stdin.readline().strip())
    print(simulate(n))

def simulate(n):
    dp = [0] * (n+1)
    for i in range(1, n+1):
        min_cnt = 1e9
        for j in range(1, int((i**0.5))+1):
            min_cnt = min(min_cnt, dp[i-int(j**2)])
        dp[i] = min_cnt+1
    # print(dp)
    return dp[n]

if __name__ == '__main__':
    main()