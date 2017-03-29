import xlrd

from Course import Course
from Inst import Inst

"""
Class with the mothods to read the xlsx file.

:param _url - Url of the file with the data.

:param _table - sheet to read the data.

:param _book - varible to save the open xlsx file.
"""


class XLSReader(object):
    def __init__(self, url, table):
        self._url = url
        self._table = table
        self._book = xlrd.open_workbook(url)

    """
    Method to get all the institutions from the xlsx file.

    :return - return the list of all unique institutions in the xlsx file.
    """

    def getInstsFromFile(self):
        newDic = {}
        newList = []

        sheet = self._book.sheet_by_name(self._table)
        for row_index in range(3, 6521):
            newDic[(sheet.cell(row_index, 2).value)] = (sheet.cell(row_index, 4).value)

        keys = newDic.keys()
        for key in keys:
            id = key
            newList.append(Inst(id, newDic[key]))

        return newList

    """
    Method to get all the courses of the xlsx file. It also add the courses to the institutions.

    :return- returns a the list of institutions with the courses already added.
    """

    def getCourses(self, instList):

        sheet = self._book.sheet_by_name(self._table)

        for row_index in range(3, 6521):
            tipo = sheet.cell(row_index, 7).value
            ramo = sheet.cell(row_index, 6).value

            if "Licenciatura" in tipo :
                if "Tronco Comum" in ramo:
                    instu = sheet.cell(row_index, 4).value
                    for inst in instList:
                        name = inst.getName()
                        if (name == instu ):
                            w = sheet.cell(row_index, 12).value
                            m = sheet.cell(row_index, 11).value
                            curso = sheet.cell(row_index, 5).value
                            inst.addCourse(Course(curso,m,w))
                            break

        return instList
