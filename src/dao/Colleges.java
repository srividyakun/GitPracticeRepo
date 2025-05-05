package dao;

import java.util.ArrayList;
import java.util.List;

public class Colleges {
    List<College> collegeList = new ArrayList<>();

    public List<College> getCollegeList() {
        return collegeList;
    }

    public void setCollegeList(List<College> collegeList) {
        this.collegeList = collegeList;
    }
}
