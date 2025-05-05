package service.impl;

import dao.College;
import dao.Department;
import dao.Teacher;
import service.TeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherServiceImpl implements TeacherService {
    Scanner scanner = new Scanner(System.in);
    List<College> colleges = CollegeServiceImpl.colleges.getCollegeList();

    @Override
    public void addTeacher() {
        System.out.println("Enter college id");
        int collegeId = scanner.nextInt();
        for (College selectedCollege : colleges) {
            do {
                if (selectedCollege.getCollegeId() == collegeId) {
                    do {
                        System.out.println("Enter department Id");
                        int departmentId = scanner.nextInt();
                        for (Department selectedDepartment : selectedCollege.getDepartmentList()) {
                            if (selectedDepartment.getDepartmentId() == departmentId) {
                                if (selectedDepartment.getTeachers() == null) {
                                    //added teacher to a department
                                    selectedDepartment.setTeachers(addTeachers());
                                    break;
                                } else {
                                    selectedDepartment.getTeachers().add(getTeacher());
                                    break;
                                }

                                //selectedCollege.setDepartment(selectedDepartment);
                            }
                        }
                        System.out.println("Do you want to add another department: 'yes' or 'no'");
                    } while (!scanner.next().equalsIgnoreCase("No"));
                }
                System.out.println("Do you want to add teacher for different college: yes or NO ");
            } while (!scanner.next().equalsIgnoreCase("No"));
        }
    }

    @Override
    public List<Teacher> addTeachers() {
        List<Teacher> teacher = new ArrayList<>();
        do {
            teacher.add(getTeacher());
            System.out.println("Do you want to add a teacher : yes or No");
        } while (!scanner.next().equalsIgnoreCase("No"));
        return teacher;
    }


    private Teacher getTeacher() {
        Teacher teacher = new Teacher();
        System.out.println("Enter Teacher Id");
        teacher.setTeacherId(scanner.nextInt());
        System.out.println("Enter Teacher name");
        teacher.setTeacherName(scanner.next());
        return teacher;
    }

    @Override
    public void updateTeacher() {
        System.out.println("enter college id");
        int collegeId = scanner.nextInt();
        for (College selectedCollege : colleges) {
            if (selectedCollege.getCollegeId() == collegeId) {
                System.out.println("Enter department Id");
                int departmentId = scanner.nextInt();
                for (Department selectedDepartment : selectedCollege.getDepartmentList()) {
                    if (selectedDepartment.getDepartmentId() == departmentId) {
                        //added teacher to a department
                        System.out.println("Enter teacher id");
                        int teacherId = scanner.nextInt();
                        for (Teacher teacher : selectedDepartment.getTeachers()) {
                            if (teacherId == teacher.getTeacherId()) {
                                System.out.println("Update Teacher name");
                                teacher.setTeacherName(scanner.next());
                                break;
                            }
                        }
                    }
                }
            }
        }

    }

    @Override
    public void removeTeacher() {
        System.out.println("enter college id");
        int collegeId = scanner.nextInt();
        for (College selectedCollege : colleges) {
            if (selectedCollege.getCollegeId() == collegeId) {
                System.out.println("Enter department Id");
                int departmentId = scanner.nextInt();
                for (Department selectedDepartment : selectedCollege.getDepartmentList()) {
                    if (selectedDepartment.getDepartmentId() == departmentId) {
                        //added teacher to a department
                        System.out.println("Enter teacher id");
                        int teacherId = scanner.nextInt();
                        for (Teacher teacher : selectedDepartment.getTeachers()) {
                            if (teacherId == teacher.getTeacherId()) {
                                selectedDepartment.getTeachers().remove(teacher);
                                break;
                            }
                        }

                    }
                }
            }
        }
    }

    @Override
    public void searchTeacher() {
        System.out.println("enter college id");
        int collegeId = scanner.nextInt();
        for (College selectedCollege : colleges) {
            if (selectedCollege.getCollegeId() == collegeId) {
                System.out.println("Enter department Id");
                int departmentId = scanner.nextInt();
                for (Department selectedDepartment : selectedCollege.getDepartmentList()) {
                    if (selectedDepartment.getDepartmentId() == departmentId) {
                        //added teacher to a department
                        System.out.println("Enter teacher id");
                        int teacherId = scanner.nextInt();
                        for (Teacher teacher : selectedDepartment.getTeachers()) {
                            if (teacherId == teacher.getTeacherId()) {
                                System.out.println("Teacher found");
                                System.out.println("\r\n");
                                System.out.println("Teacher Id: " + teacher.getTeacherId() + "\r\n" +
                                        "Teacher Name " + teacher.getTeacherName() + "\r\n");
                            }
                        }

                    }
                }
            }
        }
    }
}
