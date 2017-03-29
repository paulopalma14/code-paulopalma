from Inst import *
from Course import *
from XLSReader import *
import codecs


def main():
    color1 = input("Cor das Instituições(Eng):")
    shape1 = input("Forma das Instituiçõs(Box, Square, Star, etc):")
    color2 = input("Cor dos Cursos(Eng):")
    shape2 = input("Forma dos Cursos(Box, Square, Star, etc):")

    reader = XLSReader("data/data.xlsx", "Tabela 4")

    instList = reader.getInstsFromFile()
    filledList = reader.getCourses(instList)

    instFilterList = filterInstList(filledList)
    instFilledFilterList = filterCoursesList(instFilterList)

    print(writeOutPut(instFilledFilterList, color1, color2, shape1, shape2))


"""
This Method filter the list of institutions by the input of the file (instituicoes.txt).

:param list - list of all institutions.

:return - return a list of filtered institutions.
"""


def filterInstList(list):
    newList = []
    txtList = readTxtFile(1)

    if txtList:
        for inst in list:
            for txt in txtList:
                instName = inst.getName()
                txt = txt.rstrip()
                if (instName == txt):
                    newList.append(inst)
        return newList
    else:
        return list

"""
This Method filters the courses of each institution by the input of the file (cursos.txt).

:param list - list of the filtred institutions.

:return- return a list of institutions with the courses filtered.
"""


def filterCoursesList(list):
    newList = []
    txtList = readTxtFile(2)

    if txtList:
        for inst in list:
            for course in inst.getListaCursos():
                for txt in txtList:
                    txt = txt.rstrip()
                    cName = course.getName()
                    if (cName == txt):
                        inst.addCourseFilter(course)
            newList.append(inst)
        return newList
    else:
        for inst in list:
            for course in inst.getListaCursos():
                inst.addCourseFilter(course)
            newList.append(inst)
    return newList


"""
Method that reads the input files.

:param id - indentifies the file it must read.

:return- return in form of list the content of the files.
"""


def readTxtFile(id):
    listFile = []
    f = ""

    if (id == 1):
        f = open("data/instituicoes.txt", "r", encoding="UTF-8")
    if (id == 2):
        f = open("data/cursos.txt", "r", encoding="UTF-8")

    for text in f.readlines():
        listFile.append(text)

    return listFile


"""
Method that generates the code to create the graph.

:param listInst - list of institutions to generate.

:param color1 - color of the institutions on the graph.

:param color2 - color of the courses on the graph.

:param shape1 - shape of the institutions on the graph.

:param shape2 - shape of the courses on the graph.

:return - string in dot to generate the graph.
"""


def writeOutPut(listInst, color1, color2, shape1, shape2):
    header = "digraph G {"
    body = ""

    for inst in listInst:
        listaCurso = inst.getShowFilterList()
        for curso in listaCurso:
            totalStu = curso.getTotalStu()
            result = totalStu / 100
            body += '\n"' + curso.getName() + '" [height=' + str(result) + ',weight=' + str(result) + '];'
            body += '\n"' + curso.getName() + '" [shape=' + shape1 + ', color=' + color1 + '];'
            body += '\n"' + inst.getName() + '" [shape=' + shape2 + ', color=' + color2 + '];'
            body += '\n"' + inst.getName() + '"->"' + curso.getName() + '";'

    footer = "\n}"

    return header + body + footer


if __name__ == "__main__":
    main()
