from itertools import combinations
from bisect import bisect_left, bisect_right

def bruteforce(numList):
    # sumDict = dict()
    n = len(numList)
    result = []
    for i in range(n+1):
        for comb in combinations(numList,i):
            result.append(sum(comb))
    return result

def findNum(numList, num):  # 가장 처음 나오는 num과, 가장 마지막에 나오는 num의 인덱스를 빼줌 = 목록 내의 num의 개수
    return bisect_right(numList,num)-bisect_left(numList,num)

# def mergeDict(dict1, dict2):
#     resultDict = dict()
#     for num1 in list(dict1.keys()):
#         for num2 in list(dict2.keys()):
#             sum = num1+num2
#             count = dict1[num1]*dict2[num2]
#             try:
#                 resultDict[sum]+=count
#             except:
#                 resultDict[sum]=count
#     # resultDict[0]-=1
#     return resultDict

if __name__=='__main__':
    inputLines=open(0).readlines()
    n, s = map(int, inputLines[0].split())
    nList = list(map(int,inputLines[1].split()))
    k = n//2
    list1 = bruteforce(nList[:k])
    list2 = bruteforce(nList[k:])
    list2.sort()
    r=0
    for num1 in list1:
        num2 = s-num1
        try:
            r+=findNum(list2,num2)
        except:
            pass
    if s==0:
        r-=1
    print(r)