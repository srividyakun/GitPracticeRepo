package service;

import dao.Teacher;

import java.util.List;

public interface TeacherService {

    void addTeacher();
    List<Teacher> addTeachers();
    void updateTeacher();
    void removeTeacher();
    void searchTeacher();

}
