package service;

import dao.Department;

import java.util.List;

public interface DepartmentService {

    Department addDepartmentDetails();

    List<Department> addDepartments();

    void addDepartment();

    void updateDepartment();

    void deleteDepartment();

    void searchDepartment();


}
