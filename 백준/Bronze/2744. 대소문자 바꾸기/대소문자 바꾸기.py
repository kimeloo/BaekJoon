import sys

string = list(sys.stdin.readline().split()[0])
for idx, s in enumerate(string):
    if ord(s) < 91:
        string[idx] = chr(ord(s)+32)
    else:
        string[idx] = chr(ord(s)-32)
print(*string,sep="")