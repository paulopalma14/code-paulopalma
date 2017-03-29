"""
Class Inst, it contains all the information of a Institution.

@_id - Id of the institution;

@_name - Name of the institution;

@_listC - List of the courses in the institution.

@_showList - Filtered list of the courses in the institution
"""
class Inst(object):

    def __init__(self, id, name):
        self._id = id
        self._name = name
        self._listC = []
        self._showList =[]

    """
    Method the return the id of the institution

    :return - return institution's id
    """
    def getId(self):
        return (self._id)
    """
    Method the return the name of the institution

    :return - return institution's name
    """
    def getName(self):
        return (self._name)

    """
    Method that add a Course to an institution.

    :param curso - course to add.
    """
    def addCourse(self, curso):
        self._listC.append(curso)

    """
    Method that returns a the list of courses of each institution.

    :return - returns list of courses of the institution.
    """
    def getListaCursos(self):
        return self._listC
    """
    Method to get a Course by Id.

    :arg id - index of the course in the list.

    :return - return a course from the list.
    """
    def getCourse(self, id):
        return self._listC.index(id)

    """
    Method to add at a new filtered course to the institution.

    :param curso - Course to add to the list.
    """
    def addCourseFilter(self,curso):
        self._showList.append(curso)

    """
    Method to return the filtered list of Courses

    :return - return the filtered list of courses.
    """
    def getShowFilterList(self):
        return self._showList


