package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class SectionDAO {
    // INSERT YOUR CODE HERE
    private static final String QUERY_SEARCH = "SELECT * FROM section "
            + "WHERE subjectid = ? AND num = ? ORDER BY crn";
    
    private final DAOFactory daoFactory;
    
    // Constructor
    SectionDAO(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
    public String find(int termid, String subjectid, String num) {
        String result = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        
        try {
            Connection conn = daoFactory.getConnection();
            
            if (conn.isValid(0)) {
                // INSERT YOUR CODE HERE
                ps = conn.prepareStatement(QUERY_SEARCH);
                ps.setString(1, subjectid);
                ps.setString(2, num);
                
                boolean hashresults = ps.execute();
                if (hashresults) {
                    rs = ps.getResultSet();
                    rsmd = rs.getMetaData();
                    while(rs.next()) {
                        result += DAOUtility.getResultSetAsJson(rs);
                    }
                }
            }
        }
        catch (Exception e) { e.printStackTrace(); }
        finally {
            if (rs != null) {
                try { rs.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
            if (ps != null) {
                try { ps.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        return result;
    }
}
