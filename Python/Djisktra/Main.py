from Djis import *
from Vertex import *

g = Graph()

def lerficheiro():
    list = []
    with open('lpr-a-01.dat', 'r') as f:
        data = f.readlines()

        for line in data[12:]:
            rline = line.replace("Arc=", "").replace("From=", "").replace("To=", "").replace("Inv=", "").replace(
                "Coll=", "").replace("Turns=", "").replace("PenTurns=", "").replace("Qty=", "").replace("Trav=",
                                                                                                        "").replace(
                "Pen", "").replace(" ", "")
            list.append(rline.split(","))
            # print(rline)

        i = 0
        for xxx in list:
            g.add_edge(list[i][1], list[i][2], int(list[i][5]), int(list[i][3]))
            i += 1


lerficheiro()
i = 1

dijkstra(g, g.get_vertex('14'))

while i <= 28:
    target = g.get_vertex(str(i))
    path = [target.get_id()]
    shortest(target, path)
    print('The shortest path : %s' % (path[::-1]))
    i += 1
