A, B, C = input().split()
a = int(A)
b = int(B)
c = int(C)
print(f'{(a+b)%c}\n{((a%c)+(b%c))%c}\n{(a*b)%c}\n{((a%c)*(b%c))%c}')