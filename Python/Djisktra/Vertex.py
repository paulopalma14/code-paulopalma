import sys
import gc
import heapq

class truck:
    def __init__(self):
        self.maxcap = 10000
        self.actualcap = None

    def getcap (self):
        return self.actualcap

    def addcap (self, add):
        self.actualcap += add

    def releasecap(self):
        self.actualcap = 0

class Vertex:
    def __init__(self, node):
        self.id = node
        self.adjacent = {}
        self.qty = None
        self.distance = 10000000
        self.visited = False
        self.previous = None

    def add_neighbor(self, neighbor, weight=0, qty=0 ):
        self.adjacent[neighbor] = weight
        self.qty = qty

    def get_qty(self, node):
        return self.qty

    def set_qty(self, node, qty):
        self.qty = qty

    def get_connections(self):
        return self.adjacent.keys()

    def get_id(self):
        return self.id

    def get_weight(self, neighbor):
        return self.adjacent[neighbor]

    def set_distance(self, dist):
        self.distance = dist

    def get_distance(self):
        return self.distance

    def set_previous(self, prev):
        self.previous = prev

    def set_visited(self):
        self.visited = True

    def __str__(self):
        return str(self.id) + ' adjacent: ' + str([x.id for x in self.adjacent])

class Graph:
    def __init__(self):
        self.vert_dict = {}
        self.num_vertices = 0

    def __iter__(self):
        return iter(self.vert_dict.values())

    def add_vertex(self, node):
        self.num_vertices += 1
        new_vertex = Vertex(node)
        self.vert_dict[node] = new_vertex
        return new_vertex

    def get_vertex(self, n):
        if n in self.vert_dict:
            return self.vert_dict[n]
        else:
            return None

    def add_edge(self, frm, to, cost = 0, qty=0):
        if frm not in self.vert_dict:
            self.add_vertex(frm)
        if to not in self.vert_dict:
            self.add_vertex(to)

        self.vert_dict[frm].add_neighbor(self.vert_dict[to], cost, qty)
        self.vert_dict[to].add_neighbor(self.vert_dict[frm], cost, qty)

    def get_vertices(self):
        return self.vert_dict.keys()

    def set_previous(self, current):
        self.previous = current

    def get_previous(self, current):
        return self.previous