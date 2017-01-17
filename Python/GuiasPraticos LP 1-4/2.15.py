def fibonacci_iterativo(n):
    n_k2 = 1
    n_k1 = 0

    n_k = 0

    k = 1

    while k <= n :
        n_k = n_k1 + n_k2
        n_k1, n_k2 = n_k, n_k1
        k += 1
        pass
    return n_k

print(fibonacci_iterativo(50))