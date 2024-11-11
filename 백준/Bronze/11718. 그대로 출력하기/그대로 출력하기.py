import sys

while True:
    a = sys.stdin.readline().strip()
    if a:
        sys.stdout.write(a+'\n')
    else:
        break