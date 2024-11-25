import sys

n = int(sys.stdin.readline().strip())

width = 4*n-3
height = 2*n-1

stack = ["*"*n+" "*(2*n-3)+"*"*n,]

for i in range(1,n):
    line = [" "] * width
    line[i] = line[n+i-1] = line[width-n-i] = line[width-1-i]= "*"
    # if line.count("*") == 2:
    #     line[line.index("*")+1] = "*"
    line = "".join(line).rstrip()
    stack.append(line)
    if line.count("*") == 3:
        break
        

print(*stack,sep="\n")
stack.pop()
stack.reverse()
print(*stack,sep="\n")