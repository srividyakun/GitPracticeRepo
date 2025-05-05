package service.impl;

import dao.College;
import dao.Colleges;
import dao.Department;
import dao.Teacher;
import service.CollegeService;
import service.DepartmentService;

import java.util.List;
import java.util.Scanner;

public class CollegeServiceImpl implements CollegeService {
    public static final Scanner scanner = new Scanner(System.in);
    DepartmentService departmentService = new DepartmentServiceImpl();
    CollegeAddressServiceImpl collegeAddressServiceimpl = new CollegeAddressServiceImpl();
    static Colleges colleges = new Colleges();

    @Override
    /**
     * Create a collegeData object and set values(id address, add departments if needed)
     * add data to the collegeobject
     */
    public void createCollege() {
        College college = new College();
        System.out.println("Enter college Id");
        college.setCollegeId(scanner.nextInt());
        System.out.println("Enter college name");
        college.setCollegeName(scanner.next());
        //add college address
        college.setCollegeAddress(collegeAddressServiceimpl.addCollegeAddress());
        //each college may have multiple departments, add multiple departments
        //college.setDepartmentList(departmentService.addDepartments());
        //get colleges list and add the college created to it.
        colleges.getCollegeList().add(college);
    }

    @Override
    /**
     * 1- get all the list of colleges and search the college that need to be updated and update the data in sameobject
     * 2-declare a college reference and assign it to the selectedCollege from the list and update the selected college and remove the college object assigned to the reference
     */
    public void updateCollege() {
        College college;
        List<College> allColleges = colleges.getCollegeList();
        System.out.println("Enter college id to be updated?");
        int id = scanner.nextInt();
        for (College selectedCollege : allColleges) {
            if (id == (selectedCollege.getCollegeId())) {
                college = selectedCollege;
                System.out.println("Enter college name");
                selectedCollege.setCollegeName(scanner.next());
                selectedCollege.setCollegeAddress(collegeAddressServiceimpl.updateCollegeAddress(selectedCollege.getCollegeAddress()));
                //todo send collegeaddressobject
                //college.setCollegeAddress(collegeAddressServiceimpl.updateCollegeAddress());
                colleges.getCollegeList().remove(college);
                colleges.getCollegeList().add(selectedCollege);
            }
        }
    }

    @Override
    public void deleteCollege() {
        List<College> allColleges = colleges.getCollegeList();
        System.out.println("Enter college id to delete?");
        int id = scanner.nextInt();
        //todo check other way to avoid duplicate iteration
        if (allColleges != null) {
            boolean isExist = false;
            for (College selectedCollege : allColleges) {
                if (id == (selectedCollege.getCollegeId())) {
                    allColleges.remove(selectedCollege);
                    isExist = true;
                    break;
                }
            }
            if (isExist != true) {
                System.out.println("College with College ID :" + id + " does not exist");
            }
        } else {
            System.out.println("No colleges exist");
        }
    }

    public boolean isCollegeExist(int id) {

        List<College> allColleges = colleges.getCollegeList();
        for (College selectedCollege : allColleges) {
            if (id == (selectedCollege.getCollegeId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void searchCollege() {
        //todo handle collegeList when null
        List<College> collegeList = colleges.getCollegeList();
        System.out.println("Enter college id");
        int searchCollgeId = scanner.nextInt();
        if (collegeList != null) {
            for (College collegeData : collegeList) {
                if (collegeData.getCollegeId() == searchCollgeId) {
                    System.out.println("College Found");
                    printCollegeDetails(collegeData);
                    break;
                }
            }
        }
    }

    private void printCollegeDetails(College collegeData) {
        System.out.println("*************College Details**************");
        System.out.println("\r\n");
        System.out.println("College Name: " + collegeData.getCollegeName() + "\r\n" +
                "CollegeId No: " + collegeData.getCollegeId() + "\r\n" +
                "College Address :  " + "\r\n" +
                "Street Name :  " + collegeData.getCollegeAddress().getStreetName() + "\r\n" +
                "Street No :  " + collegeData.getCollegeAddress().getStreetNo() + "\r\n");
        List<Department> departmentList = collegeData.getDepartmentList();
        if (departmentList != null) {
            for (Department departmentData : departmentList) {
                System.out.println("Department Id: " + departmentData.getDepartmentId() + "\r\n" +
                        "Department Name :  " + departmentData.getDepartmentName() + "\r\n");
                List<Teacher> teachersList = departmentData.getTeachers();
                if (teachersList != null) {
                    for (Teacher teacherData : teachersList) {
                        System.out.println("Teacher Id: " + teacherData.getTeacherId() + "\r\n" +
                                "Teacher Name :  " + teacherData.getTeacherName() + "\r\n");
                    }
                }
            }
        }

    }

    @Override
    public void searchAllColleges() {

    }
}
