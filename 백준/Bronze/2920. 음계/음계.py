def main(input_value):
    ascending = input_value.copy()
    descending = input_value.copy()
    ascending.sort()
    descending.sort(reverse=True)
    if input_value == ascending:
        return "ascending"
    elif input_value == descending:
        return "descending"
    else:
        return "mixed"


if "__main__" == __name__:
    input_value = list(map(int, open(0).readline().split()))
    # duration(1)
    print(main(input_value))
    # duration(0)
  