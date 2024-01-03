def main(input_value):
    ans = 1
    for i in input_value:
        ans *= i
    
    count = [0] * 10
    val = list(map(str, range(0, 10)))
    for i in str(ans):
        for j in range(10):
            if val[j] == i:
                count[j]+=1
    return count

if "__main__" == __name__:
    input_list = list(map(int, open(0).readlines()))
    result = main(input_list)
    for i in result:
        print(i)