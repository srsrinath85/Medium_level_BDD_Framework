package com.waf.dbhelper;

import java.util.List;
import java.util.Map;

public class dbexecutor {

    public String getQueries(String query, String value) {
        return String.format(query, value);
    }

    public int insertRegistrationDetails(String name, String city, String mobileNumber, String dob) {
        String insertQuery = String.format(Queries.insertUserQuery, name, city, mobileNumber, dob);
        return dbconfig.executeUpdate(insertQuery);
    }

//    public int insertRegistrationDetails(String name, String city, String mobileNumber, String dob) {
//        String insertQuery = String.format("INSERT INTO register (name, city, mobile, dob) VALUES ('%s', '%s', '%s', '%s')", name, city, mobileNumber, dob);
//        return dbconfig.executeUpdate(insertQuery);
//    }

    public List<Map<String, String>> getRegistrationDetails(String name) {
        return dbutil.getDBData(getQueries(Queries.selectUserQuery, name));
    }
}
