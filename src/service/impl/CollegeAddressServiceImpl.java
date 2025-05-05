package service.impl;

import dao.CollegeAddress;
import service.CollegeAddressService;

import java.util.Scanner;

public class CollegeAddressServiceImpl implements CollegeAddressService {

Scanner scanner = new Scanner(System.in);

    @Override
    public CollegeAddress addCollegeAddress() {
        CollegeAddress collegeAddress = new CollegeAddress();
        System.out.println("Enter Street name");
        collegeAddress.setStreetName(scanner.next());
        System.out.println("Enter street no:");
        collegeAddress.setStreetNo(scanner.nextInt());
        return collegeAddress;
    }

    @Override
    public CollegeAddress updateCollegeAddress(CollegeAddress collegeAddress) {
        // send collegeaddress object and update the details and return
        System.out.println("Enter Street name");
        collegeAddress.setStreetName(scanner.next());
        System.out.println("Enter street no:");
        collegeAddress.setStreetNo(scanner.nextInt());
        return collegeAddress;
    }

    @Override
    public void deleteCollegeAddress() {

    }
}
