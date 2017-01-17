def gerar_cubos(N):
    for i in range(N):
        yield i ** 3

gen = gerar_cubos(5)

print(gen.__next__())
print(gen.__next__())
print(gen.__next__())
print(gen.__next__())

