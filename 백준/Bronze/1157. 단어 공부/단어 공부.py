inputText = open(0).readline().strip().upper()
abcDict = dict()
for letter in inputText:
    if letter in abcDict:
        abcDict[letter] += 1
    else:
        abcDict[letter] = 1

abcList = list(abcDict.keys())
countList = list(abcDict.values())

maxIndex = countList.index(max(countList))
maxLetter = abcList[maxIndex]

countList.sort(reverse=True)
try:
    if countList[0] == countList[1]:
        maxLetter = "?"
except:
    pass
print(maxLetter)