inputList = open(0).readlines()[1:]
for line in inputList:
    total = 0
    score = 0
    for char in line:
        if char == "O":
            score += 1
            total += score
        else:
            score = 0
    print(total)