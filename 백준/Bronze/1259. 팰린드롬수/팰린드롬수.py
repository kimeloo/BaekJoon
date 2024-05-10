import sys

if __name__=='__main__':
    input_list = sys.stdin.readlines()
    input_list.pop()        # 마지막에 오는 0 제거
    while input_list:
        num = str(int(input_list.pop(0)))
        length = len(num)
        for i in range(length//2):
            if num[i]!=num[length-1-i]:
                print("no")
                break
        else:
            print("yes")