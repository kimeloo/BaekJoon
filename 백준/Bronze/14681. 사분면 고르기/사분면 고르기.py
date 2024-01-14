def duration(b=bool):
    '''
    if b is True or 1, timer starts
    else (b is False or 0), timer stops and prints total elapsed time
    '''

    import time
    global duration_start_time
    if b:
        duration_start_time = time.time()
    else:
        duration_end_time = time.time()
        elapsed_time = duration_end_time-duration_start_time
        print(f'{elapsed_time:.5f} sec')

def main(input_value):
    q = 0
    x = input_value[0]
    y = input_value[1]
    if x > 0 and y > 0:
        q = 1
    elif x < 0 and y > 0:
        q = 2
    elif x < 0 and y < 0:
        q = 3
    else:
        q = 4
    output_value = q
    return output_value

if "__main__" == __name__:
    input_value = list(map(int, open(0).readlines()))
    # duration(1)
    print(main(input_value))
    # duration(0)