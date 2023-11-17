from collections import deque

def bruteforce(numList):
    sumDict = dict()
    sumList = [0]
    for num in numList:
        for i in range(len(sumList)):
            sumList.append(sumList[i]+num)
    for sum in sumList:
        try:
            sumDict[sum]+=1
        except:
            sumDict[sum]=1
    return sumDict

def mergeDict(dict1, dict2):
    resultDict = dict()
    numList1 = list(dict1.keys())
    numList2 = list(dict2.keys())
    for num1 in numList1:
        for num2 in numList2:
            sum = num1+num2
            count = dict1[num1]*dict2[num2]
            try:
                resultDict[sum]+=count
            except:
                resultDict[sum]=count
    resultDict[0]-=1
    return resultDict

if __name__=='__main__':
    inputLines=open(0).readlines()
    n, s = map(int, inputLines[0].split())
    nList = list(map(int,inputLines[1].split()))
    mid = int(n/2)
    dict1 = bruteforce(nList[:mid])
    dict2 = bruteforce(nList[mid:])
    result = mergeDict(dict1,dict2)
    try:
        print(result[s])
    except:
        print(0)