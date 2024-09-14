package com.waf.dbhelper;

public interface Queries {

    String insertUserQuery = "INSERT INTO register_details(name, city, mobile, dob) VALUES ('%s', '%s', '%s', '%s')";
    String selectUserQuery = "SELECT * FROM register_details WHERE name='%s'";
}
