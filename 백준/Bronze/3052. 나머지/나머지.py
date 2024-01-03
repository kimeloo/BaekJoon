def main(input_value):
    div_list = []
    for i in input_value:
        div_list.append(i%42)
    div_list = list(set(div_list))
    return len(div_list)

if "__main__" == __name__:
    input_value = list(map(int, open(0).readlines()))
    # duration(1)
    print(main(input_value))
    # duration(0)