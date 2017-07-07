# this is for practicing some basic python functions

# def fibo(n):
#     if n <= 2: 
#         return 1
#     else: 
#         return fibo(n - 1) + fibo(n - 2)

table = {}
def fibo(n, table):
    if n in table:
        return table[n]
    if n <= 2: 
        table[n] = 1
        return 1
    else:
        table[n] = fibo(n - 1, table) + fibo(n - 2, table)
        return table[n]

a = input('input: ')
print('you just typed in : ' + a)
print(fibo(int(a), table))

