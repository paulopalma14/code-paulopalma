def listisEven():
    l1 = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    l2 = []
    length = len(l1)

    while length:
        l2.append(length) if length % 2 else print(length, "par")
        length -= 1

    print(l2)

if __name__ == "__main__":
    listisEven()

