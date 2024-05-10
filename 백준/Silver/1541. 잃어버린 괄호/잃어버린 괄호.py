'''
괄호를 일단 최대한으로 다 만들어두고, 한쌍씩 제거해보기?
경우의 수가 너무 많을듯한데

빼기 기호 뒤에 "(" 추가하기
빼기 기호 앞에 ")" 추가하여 가장 큰 음수 만들기

짝이 안맞는다면 가장 뒤에 ) 계속 추가
'''

# 입력된 문자열을 분석해서 return [가장 먼저 나오는 숫자, 숫자 직후 연산자, 연산자 뒤 남은 문자열]
# 재귀 후 최종 return 값은 [숫자, 연산자, 숫자, 연산자, ... , 숫자, 연산자, 숫자]
def number_maker(expression:str):
    if expression=="":
        return []
    number = ""
    idx = 0
    operator = ""
    new_expression = ""
    result = []

    while True:
        try:
            is_number = int(expression[idx])
        except IndexError:
            break       # 숫자 뒤에 아무것도 없으면 중단
        except:
            operator = expression[idx]
            result.append(operator)
            new_expression = expression[idx+1:]
            break

        number+=str(is_number)      # idx의 값이 숫자면 number라는 string에 추가
        idx += 1
    
    number = str(int(number))       # 올바른 숫자 형식으로 변환하고 다시 string 형식으로 변환
    result.insert(0, number)
    result.extend(number_maker(new_expression))     # 재귀 후 추가되는 숫자, 연산자를 모두 리스트에 추가
    return result

# 가장 앞에 (, 가장 뒤에 ) 추가
# - 기호 전에 ), 후에 ( 추가
# 큰 음수 만들기
def append_parentheses(expression:list):
    expression.insert(0, "(")
    minus_index = []
    for idx, num in enumerate(expression):
        if num=="-":
            minus_index.append(idx)
    minus_index.reverse()
    for idx in minus_index:
        expression.insert(idx+1, "(")
        expression.insert(idx, ")")
    expression.append(")")
    return expression        

if __name__ == '__main__':
    expression_input = open(0).readline().strip()
    expression_list = number_maker(expression_input)

    expression_list = append_parentheses(expression_list)

    expression = "".join(expression_list)

    # print(*expression_list, sep=" ", end="/\n")
    print(eval(expression))

    