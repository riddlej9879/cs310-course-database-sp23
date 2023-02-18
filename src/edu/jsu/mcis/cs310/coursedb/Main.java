package edu.jsu.mcis.cs310.coursedb;

import edu.jsu.mcis.cs310.coursedb.dao.*;

public class Main {
    public static void main(String[] args) {
        DAOFactory daoFactory = new DAOFactory("coursedb");
        SectionDAO sectionDAO = daoFactory.getSectionDAO();
        RegistrationDAO registrationDAO = daoFactory.getRegistrationDAO();
        String subid = "CS";
        String num = "310";
        num = "201";
        int studentid = 1;
        int termid = 1;
        int crn = 21100;
        int[] crns = {20966, 21016, 21901, 22170, 21797};
        
        if ( !daoFactory.isClosed() ) {
            System.out.println("Connected Successfully!");
            //System.out.println(registrationDAO.create(1, 1, 21233));
            System.out.println(registrationDAO.delete(studentid, termid));
        }
    }
}

// date and time is not serializable