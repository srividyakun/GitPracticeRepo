import service.CollegeService;
import service.DepartmentService;
import service.TeacherService;
import service.impl.CollegeServiceImpl;
import service.impl.DepartmentServiceImpl;
import service.impl.TeacherServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //created a new object to college services implementation
        CollegeService collegeServiceImpl = new CollegeServiceImpl();
        DepartmentService departmentServiceImpl = new DepartmentServiceImpl();
        TeacherService teacherServiceImpl = new TeacherServiceImpl();
        Scanner scanner = new Scanner(System.in);
        int selectedOption;
        String doYouWantToContinue;
        //do - executes the condition atleast once
        do {
            System.out.println("\r\n");
            System.out.println("*****************************************************");
            System.out.println("Select the following operation");
            System.out.println("1: Add College Details");
            System.out.println("2: Update college Details");
            System.out.println("3: Search college Details");//check if dep belong to other colleges if not then delete
            System.out.println("4: delete college Details");
            System.out.println("5: Add department details");
            System.out.println("6: update department details");//search with collgeid, get all list of depar and display,
            System.out.println("7: search department for a college");
            System.out.println("8: delete department");
            System.out.println("9: add new teacher");// strat with slecting collge and then select department and then add teacher details
            System.out.println("10: update teacher details");//get list of all teachers and ask with teacher to update
            System.out.println("11: search teacher details");
            System.out.println("12: delete teacher details");
            System.out.println("13: Exit");
            System.out.println("*****************************************************");
            System.out.println("\r\n");
            selectedOption = scanner.nextInt();
            System.out.println("Selected Option : " + selectedOption);
            switch (selectedOption) {
                case 1:
                    collegeServiceImpl.createCollege();
                    break;
                case 2:
                    collegeServiceImpl.updateCollege();
                    break;
                case 3:
                    collegeServiceImpl.searchCollege();
                    break;
                case 4:
                    collegeServiceImpl.deleteCollege();
                    break;
                case 5:
                    departmentServiceImpl.addDepartment();
                    break;
                case 6:
                    departmentServiceImpl.updateDepartment();
                    break;
                case 7:
                    departmentServiceImpl.searchDepartment();
                    break;
                case 8:
                    departmentServiceImpl.deleteDepartment();
                    break;
                case 9:
                    teacherServiceImpl.addTeacher();
                    break;
                case 10:
                    teacherServiceImpl.updateTeacher();
                    break;
                case 11:
                    teacherServiceImpl.searchTeacher();
                    break;
                case 12:
                    teacherServiceImpl.removeTeacher();
                    break;
                case 13:
                    System.out.println("No operations performed");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println("Do you want to continue : yes or no");
            doYouWantToContinue = scanner.next();
        }while (doYouWantToContinue.equalsIgnoreCase("Yes"));
    }
}
