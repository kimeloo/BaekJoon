import sys

sites = dict()
n, m = map(int, sys.stdin.readline().split())
for _ in range(n):
    site, pswd = sys.stdin.readline().split()
    sites[site] = pswd
for _ in range(m):
    site = sys.stdin.readline().strip()
    print(sites[site])