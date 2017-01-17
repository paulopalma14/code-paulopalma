def fsome(a, b):
    soma = 0
    return a + b if isinstance(a,int) and isinstance(b, int) else soma

def frec(l1, x, n):

    return l1 if not n else [x] + frec(l1, x, n-1)

def func1 (a, b , c=True):

    return a + b if c else a - b

if __name__ == "__main__":
    print(fsome(2 , 3))
    print(fsome(2, "Dota2"))

    print(frec([], "bu", 5))

    print(func1(2, 3))
    print(func1(4,5,False))