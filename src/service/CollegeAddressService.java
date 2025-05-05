package service;

import dao.CollegeAddress;

public interface CollegeAddressService {

    CollegeAddress addCollegeAddress();
    CollegeAddress updateCollegeAddress(CollegeAddress collegeAddress);
    void deleteCollegeAddress();
}
