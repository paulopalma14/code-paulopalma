def isEven(n):
    return False if n % 2 else True


def sumHex(n1, n2):
        base = 16
        n1_int = int(n1, base)
        n2_int = int(n2, base)

        result_int = n1_int + n2_int

        return hex(result_int)




if __name__ == "__main__" :

    print("2 é par ? " , isEven(2))
    print("3 é par ? ", isEven(3))

    print (sumHex('0xa', '0xb'))