import sys

def main():
    original = []
    for _ in range(3):
        original.append(sys.stdin.readline().strip())
    toInt = list(map(int, original))
    print(toInt[0]+toInt[1]-toInt[2])
    print(int(original[0]+original[1])-int(original[2]))

if __name__ == '__main__':
    main()