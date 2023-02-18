package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class RegistrationDAO {
    private static final String QUERY_EXISTS = "SELECT ? FROM registration "
            + "WHERE EXISTS (SELECT studentid FROM registration WHERE "
            + "studentid = ? AND termid = ? AND crn = ?)";
    private static final String QUERY_REGISTER = "INSERT INTO registration "
            + "VALUES (?, ?, ?)";
    private static final String QUERY_DELETE_THREE_VALUES = "DELETE FROM "
            + "registration WHERE studentid = ? AND termid = ? AND crn = ?";
    private static final String QUERY_DELETE_TWO_VALUES = "DELETE FROM "
            + "registration WHERE studentid = ? AND termid = ?";
    
    private final DAOFactory daoFactory;
    
    RegistrationDAO(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
    public boolean create(int studentid, int termid, int crn) {
        boolean result = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            Connection conn = daoFactory.getConnection();
            
            if (conn.isValid(0)) {
                // INSERT YOUR CODE HERE
                ps = conn.prepareStatement(QUERY_REGISTER,
                        Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, studentid);
                ps.setInt(2, termid);
                ps.setInt(3, crn);
                int updateCount = ps.executeUpdate();
                if (updateCount > 0) {
                    result = true;
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
        System.out.println(result);
        return result;
    }

    public boolean delete(int studentid, int termid, int crn) {
        System.out.println("delete");
        boolean result = false;
        PreparedStatement ps = null;
        
        try {
            Connection conn = daoFactory.getConnection();

            if (conn.isValid(0)) {
                ps = conn.prepareStatement(QUERY_DELETE_THREE_VALUES);
                ps.setInt(1, studentid);
                ps.setInt(2, termid);
                ps.setInt(3, crn);
                int updateCount = ps.executeUpdate();
                System.out.println(updateCount);
                if (updateCount > 0) {
                    result = true;
                }
            }
        }
        catch (Exception e) { e.printStackTrace(); }
        finally {
            if (ps != null) {
                try { ps.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        System.out.println(result);
        return result;
    }
    
    public boolean delete(int studentid, int termid) {
        boolean result = false;
        PreparedStatement ps = null;
        
        try {
            Connection conn = daoFactory.getConnection();
            
            if (conn.isValid(0)) {
                ps = conn.prepareStatement(QUERY_DELETE_TWO_VALUES);
                ps.setInt(1, studentid);
                ps.setInt(2, termid);
                int updateCount = ps.executeUpdate();
                if (updateCount > 0) {
                    result = true;
                }
                
            }
        }
        catch (Exception e) { e.printStackTrace(); }
        finally {
            if (ps != null) {
                try { ps.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        return result;
    }

    public String list(int studentid, int termid) {
        String result = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        
        try {
            Connection conn = daoFactory.getConnection();
            
            if (conn.isValid(0)) {
                // INSERT YOUR CODE HERE
                
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
