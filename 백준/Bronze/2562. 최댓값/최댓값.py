def main(input_list):
    m = max(input_list)
    i = input_list.index(m)
    print(m)
    print(i+1)

if '__main__' == __name__:
    input_lines = list(map(int, open(0).readlines()))
    main(input_lines)