package service.impl;

import dao.College;
import dao.Department;
import service.DepartmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentServiceImpl implements DepartmentService {
    Scanner scanner = new Scanner(System.in);
    // dont create instance variable when creating data, because it creates a new object when a class is called
    //List<College> colleges = CollegeServiceImpl.colleges.getCollegeList();

    @Override
    public Department addDepartmentDetails() {
        Department department = new Department();
        System.out.println("Enter department Id");
        department.setDepartmentId(scanner.nextInt());
        System.out.println("Enter department name");
        department.setDepartmentName(scanner.next());
        return department;
    }

    public void addDepartment() {
        System.out.println("Select the college id :");
        List<Department> departmentList = new ArrayList<>();
        int collegeId = scanner.nextInt();
        List<College> collegeList = CollegeServiceImpl.colleges.getCollegeList();
        if (collegeList != null) {
            for (College college : collegeList) {
                if (collegeId == college.getCollegeId()) {
                    college.getDepartmentList().add(addDepartmentDetails());
                    break;
                }
            }
            //no need to add department data to college again
            //collegeList.add(college);
        }
    }


    @Override
    public List<Department> addDepartments() {
        List<Department> departmentList = new ArrayList<>();
        do {
            departmentList.add(addDepartmentDetails());
            System.out.println("Do you want to add another department: 'yes' or 'no'");
        } while (!scanner.next().equalsIgnoreCase("No"));
        return departmentList;
    }

    @Override
    public void updateDepartment() {
        //todo update department which should reflect in all colleges
        //add flag to verify if no dept exist
        List<College> colleges = CollegeServiceImpl.colleges.getCollegeList();
        //departmentList holds list of departments data which should be independent to every method should be a local variable
        // wrong- user cannot select the already iterated college
        System.out.println("Enter department id to be updated ");
        int departmentId = scanner.nextInt();
        System.out.println("enter new department name");
        String departmentName = scanner.next();
        if (colleges != null) {
            for (College selectedCollege : colleges) {
                List<Department> departmentList = selectedCollege.getDepartmentList();
                if (departmentList != null) {
                    for (Department departmentData : departmentList) {
                        if (departmentId == departmentData.getDepartmentId()) {
                            departmentData.setDepartmentName(departmentName);
                            //departmentList.add(departmentData);
                            //selectedCollege.setDepartmentList(departmentList);
                            //colleges.add(selectedCollege);
                            break;
                        }
                    }
                }
            }
        }else {
            System.out.println("College does not exist");
        }
    }

    /*public List<Department> updateDepartment(int id) {
        List<Department> departmentList = new ArrayList<>();
        for (College selectedCollege : colleges) {
            if (id == (selectedCollege.getCollegeId())) {
                departmentList = selectedCollege.getDepartmentList();
                if (departmentList != null) {
                    for (Department departmentData : departmentList) {
                        System.out.println("Update department data for department id :" + departmentData.getDepartmentId());
                        System.out.println("enter new department name");
                        departmentData.setDepartmentName(scanner.next());
                        departmentList.add(departmentData);
                    }
                }
            }
        }
        return departmentList;
    }*/

    @Override
    public void deleteDepartment() {
        List<Department> departmentList = new ArrayList<>();
        System.out.println("Enter college id to delete department ");
        int collegeId = scanner.nextInt();
        for (College selectedCollege : CollegeServiceImpl.colleges.getCollegeList()) {
            if (collegeId == (selectedCollege.getCollegeId())) {
                departmentList = selectedCollege.getDepartmentList();
                if (departmentList != null) {
                    System.out.println("Enter department id to search department ");
                    int departmentId = scanner.nextInt();
                    for (Department departmentData : departmentList) {
                        if (departmentId == departmentData.getDepartmentId()) {
                            departmentList.remove(departmentData);
                            System.out.println("deleted department from college");
                            break;
                        }
                    }
                }
                break;
            }
        }
    }

    @Override
    public void searchDepartment() {
        List<Department> departmentList = new ArrayList<>();
        System.out.println("Enter college id to search department ");
        int collegeId = scanner.nextInt();
        for (College selectedCollege : CollegeServiceImpl.colleges.getCollegeList()) {
            if (collegeId == (selectedCollege.getCollegeId())) {
                departmentList = selectedCollege.getDepartmentList();
                if (departmentList != null) {
                    System.out.println("Enter department id to search department ");
                    int departmentId = scanner.nextInt();
                    for (Department departmentData : departmentList) {
                        if (departmentId == departmentData.getDepartmentId()) {
                            System.out.println("Department id found");
                            printDepartmentDetails(departmentData);
                            break;
                        }
                    }
                }
            }
        }
    }

    private void printDepartmentDetails(Department departmentData) {
        System.out.println("*************Department Details**************");
        System.out.println("\r\n");
        System.out.println("Department Id: " + departmentData.getDepartmentId() + "\r\n" +
                "Department Name " + departmentData.getDepartmentName() + "\r\n");
    }
}
