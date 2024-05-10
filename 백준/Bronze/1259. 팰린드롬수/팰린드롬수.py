import sys

if __name__=='__main__':
    while True:
        num = sys.stdin.readline().strip()
        if num=="0":
            break
        
        r_num = num[::-1]
        if num==r_num:
            print("yes")
        else:
            print("no")