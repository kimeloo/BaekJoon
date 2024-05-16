import sys

if __name__ == '__main__':
    n, m = map(int, sys.stdin.readline().split())
    case_a = set()
    case_b = set()

    for _ in range(n):
        case_a.add(sys.stdin.readline().strip())
    for _ in range(m):
        case_b.add(sys.stdin.readline().strip())
    
    case_ab = list(case_a & case_b)
    case_ab.sort()
    print(len(case_ab))
    print(*case_ab, sep="\n")