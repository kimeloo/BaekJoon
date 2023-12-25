a, b = map(int, open(0).readline().split())
if a==b:
    print("==")
elif a>b:
    print(">")
elif b>a:
    print("<")