def solution(numbers):
    answer = ''
    numbers_str = list(map(str, numbers))
    numbers_str.sort(key=lambda x:x*3, reverse=True)
    if_zero = True
    for num in numbers_str:            
        answer = answer+num
        if if_zero:
            if answer[0] == '0':
                answer = str(int(answer))
                continue
            else:
                if_zero = False
    return answer