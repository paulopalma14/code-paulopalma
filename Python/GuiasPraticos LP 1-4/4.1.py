class Cartão:
    entidade = ""

    def __init__(self, numero = 0):
        self._numero = numero

    def __str__(self):
         return "numero {0}".format(self._numero)

def f1 (self, a, b):
    return min(a,b)

class C :
    f = f1



obj = C()

print(obj.f(2,3))

obj1 = Cartão(123456789)

Cartão.entidade = "Governo"

print(obj1, obj1.entidade)