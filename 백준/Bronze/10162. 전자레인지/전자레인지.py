inputInt = int(input())
if inputInt%10 != 0:
    print(-1)
else:
    if inputInt>=300:
        A=inputInt//300
        inputInt%=300
    else:
        A=0
    if inputInt>=60:
        B=inputInt//60
        inputInt%=60
    else:
        B=0
    print(f'{A} {B} {inputInt//10}')