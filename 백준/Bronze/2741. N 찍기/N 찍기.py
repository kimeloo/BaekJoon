def main(input_value):
    a = input_value[0]
    output_value = [i for i in range(1, a+1)]
    return output_value

if "__main__" == __name__:
    input_value = list(map(int, open(0).readline().split()))
    # duration(1)
    output_value = main(input_value)
    for i in output_value:
        print(i)
    # duration(0)