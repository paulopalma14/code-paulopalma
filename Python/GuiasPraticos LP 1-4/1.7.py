from random import randint

def calcV(l1):
    med = calcM(l1)
    sum = 0
    for i in l1:
        sum = (i - med)**2

    return sum / len(l1)

def calcM(l1):
    sum = 0
    for i in l1 :
        sum += i

    return sum / len(l1)

def randomFill():
    return [randint(0,100) for i in range (1,100)]

if __name__ == "__main__":
    print(calcV(randomFill()))