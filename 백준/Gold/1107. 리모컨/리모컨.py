'''
1. 이동하고자하는 채널 중, 없는 숫자 파악
2. 갖고 있는 숫자로 가장 가까운 채널 후보 만들기
    2-1. 목표보다 작은 수 중 가장 큰 수 만들기
    2-2. 목표보다 큰 수 중 가장 작은 수 만들기
3. 후보 중 가장 가장 가까운 값 채택
4. 100에서 얼마나 걸리는지 파악
5. 만들수 있는 가장 작은 수, 가장 큰 수 만들기
6. 모든 후보 중 가장 가까운 값 채택

'''

import sys

def find_smallest_large(target:str, able_list:list):
    result_list = list()
    min_num = str(min(able_list))
    for n in target:
        if int(n) not in able_list:
            break
        result_list.append(n)
    # result+남은수 조합으로 target보다 크면서 가장 작은 값 만들거나
    # result에서 하나씩 빼가며 target보다 큰 수로 넣고 그중 가장 작은 값
    a = "99999999"
    for n in able_list:
        if int(target[len(result_list)]) < n:
            a = "".join(result_list)
            a = (a + str(n)).ljust(len(target), min_num)
            break
    b = None
    while result_list:
        result_list.pop()
        for n in able_list:
            if int(target[len(result_list)]) < n:
                b = "".join(result_list)
                b = (b + str(n)).ljust(len(target), min_num)
                result_list = []
                break
    if b==None and result_list==[]:
        if min_num != "0":
            b = min_num*(len(target)+1)
        else:
            temp = able_list.copy()
            temp.remove(0)
            if len(temp)>0:
                b = str(min(temp))+"0"*len(target)
                if int(b[:-1])>int(target):
                    b = b[:-1]
            else:
                b = "99999999"
    a = int(a)
    b = int(b)
    return min(a, b)

def find_largest_small(target:int, able_list:list):
    result_list = list()
    max_num = str(max(able_list))
    for n in target:
        if int(n) not in able_list:
            break
        result_list.append(n)
    # result+남은수 조합으로 target보다 크면서 가장 작은 값 만들거나
    # result에서 하나씩 빼가며 target보다 큰 수로 넣고 그중 가장 작은 값
    a = "-99999999"
    temp = able_list.copy()
    temp.reverse()
    for n in temp:
        if int(target[len(result_list)]) > n:
            a = "".join(result_list)
            a = (a + str(n)).ljust(len(target), max_num)
            break
    b = None
    while result_list:
        result_list.pop()
        for n in temp:
            if int(target[len(result_list)]) > n:
                b = "".join(result_list)
                b = (b + str(n)).ljust(len(target), max_num)
                result_list = []
                break
    if b==None and result_list==[]:
        if max_num != "0":
            try:
                b = max_num*(len(target)-1)
                if b == "":
                    raise
            except:
                b = max_num*(len(target))
        else:
            b = "-99999999"
    a = int(a)
    b = int(b)
    return max(a, b)

if __name__ == '__main__':
    target = int(sys.stdin.readline())
    zero = sys.stdin.readline().strip()
    disabled_list = []
    if zero!="0":
        disabled_list = list(map(int, sys.stdin.readline().split()))
    true = False
    for n in str(target):
        if int(n) in disabled_list:
            true = True
    case_a = abs(target-100)
    if true:
        all_list = [i for i in range(0, 10)]
        able_list = list(set(all_list)-set(disabled_list))
        able_list.sort()
        if able_list != []:
            sl = find_smallest_large(str(target), able_list)
            ls = find_largest_small(str(target), able_list)
            case_b = len(str(sl))+abs(sl-target)
            case_c = len(str(ls))+abs(ls-target)
            for_case_d = int(str(max(able_list))*len(str(target)))
            case_d = len(str(for_case_d))+abs(target-for_case_d)
            for_case_e = int(str(min(able_list))*len(str(target)))
            case_e = len(str(for_case_e))+abs(target-for_case_e)
            # print(case_a, case_b, case_c, case_d, case_e)
            print(min(case_a, case_b, case_c, case_d, case_e))
        else:
            print(case_a)
    else:
        case_b = len(str(target))
        print(min(case_a, case_b))