import sys

def inp():
    n = int(sys.stdin.readline().strip())
    clothes = dict()
    for _ in range(n):
        _, ctgory = sys.stdin.readline().split()
        clothes[ctgory] = 1 + (0 if (ctgory not in clothes) else clothes[ctgory])
    return clothes

def simulate(clothes:dict):
    result = 1
    for cat in clothes:
        result *= clothes[cat]+1
    return result-1

if __name__ == '__main__':
    t = int(sys.stdin.readline().strip())
    for _ in range(t):
        clothes = inp()
        print(simulate(clothes))