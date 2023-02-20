package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;

public class DAOUtility {
    public static final int TERMID_SP23 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        JsonArray records = new JsonArray();
        ResultSetMetaData rsmd = null;

        try {
            if (rs != null) {
                // INSERT YOUR CODE HERE
                String str_val;
                rsmd = rs.getMetaData();
                while(rs.next()) {
                    JsonObject temp_obj = new JsonObject();
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        String col_name = rsmd.getColumnName(i);
                        Object col_val = rs.getString(i);
                        if (rsmd.getColumnType(i) == Types.TIME) {
                            Time time_val = (Time)col_val;
                            temp_obj.put(col_name, time_val.toString());
                        } else {
                            if (col_val != null) {
                                str_val = col_val.toString();
                            } else {
                                str_val = "";
                            }
                            temp_obj.put(col_name, str_val);
                        }
                    }
                    records.add(temp_obj);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Jsoner.serialize(records);
    }
}
