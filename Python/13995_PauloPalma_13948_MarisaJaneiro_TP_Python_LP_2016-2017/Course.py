"""
Class Course, it contains all the information of a course.

@name - Name of the course

@m - number of men in the course

@f - number of woman in the course
"""
class Course(object):
    def __init__(self, name, m, w):
        self._name = name
        self._w = w
        self._m = m

    """
    Method that return the name of the course.

    :return - returns the name of the course
    """

    def getName(self):
        return self._name

    """
    Method that return the number of woman in the course

    return - returns the number of woman in the course
    """

    def getW(self):
        return self._w

    """
    Method that return the number of men in the course

    return - returns the number of men in the course
    """
    def getM(self):
        return self._m

    """
    Method that return the number of persons in the course

    return - returns the number of persons in the course
    """
    def getTotalStu(self):
        return self._m + self._w
