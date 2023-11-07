n = int(input())
caselist = []
for i in range(n):
    caselist.append(input().split())
for i in range(len(caselist)):
    c = caselist[i]
    print(f'Case #{i+1}: {int(c[0])+int(c[1])}')