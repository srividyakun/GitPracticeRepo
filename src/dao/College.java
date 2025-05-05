package dao;

import java.util.ArrayList;
import java.util.List;

public class College {
    int collegeId;
    String collegeName;
    CollegeAddress collegeAddress;
    List<Department> departmentList;

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public CollegeAddress getCollegeAddress() {
        return collegeAddress;
    }

    public void setCollegeAddress(CollegeAddress collegeAddress) {
        this.collegeAddress = collegeAddress;
    }

    public List<Department> getDepartmentList() {
        //todo check deparmentList == null return arrylist
        if(departmentList == null){
            return new ArrayList<>();
        }
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
}
