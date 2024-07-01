import sys

def main():
    n = int(sys.stdin.readline().strip())
    canvas = []
    for _ in range(n):
        canvas.append(list(map(int, sys.stdin.readline().split())))
    splitter(n, canvas)
    print(*counter, sep="\n")

def splitter(n, canvas):
    global counter
    color = canvas[0][0]        # canvas의 첫번째 칸을 해당 색종이의 컬러로 지정
    flag = False                # break point 지정
    if n != 1:                  # canvas가 1*1이 아닌 경우 실행
        for i in range(n):
            for j in range(n):
                if canvas[i][j] != color:   # 각 칸이 색종이 컬러와 다를 경우 break
                    flag = True
                    break
            if flag:
                break
    if not flag:                # 모든 칸이 첫 칸과 색이 같은 경우, color를 count
        counter[color]+=1
    else:                       # 색이 다른 칸이 있는 경우 작은 칸으로 쪼개기
        canvases = [[], [], [], []]
        for c in canvas[:(n//2)]:
            canvases[0].append(c[:(n//2)])
            canvases[1].append(c[(n//2):])
        for c in canvas[(n//2):]:
            canvases[2].append(c[:(n//2)])
            canvases[3].append(c[(n//2):])
        for smallerCanvas in canvases:
            splitter((n//2), smallerCanvas)

if __name__ == '__main__':
    counter = [0, 0]
    main()