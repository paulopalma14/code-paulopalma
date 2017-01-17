f = open("teste.txt", "w")
s = "treta"

for k in range(10) : f.write(s); f.write("\n")
f.close()

f = open("teste.txt", "r")
f.seek(1)
print (f.tell())

x = f.read()