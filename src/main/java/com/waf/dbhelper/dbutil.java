package com.waf.dbhelper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dbutil {

    public static List<Map<String, String>> getDBData(String query) {
        List<Map<String, String>> dataList = new ArrayList<>();
        try {
            ResultSet rs = dbconfig.executeQuery(query);
            ResultSetMetaData metaData = rs.getMetaData();

            while (rs.next()) {
                Map<String, String> data = new HashMap<>();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    data.put(metaData.getColumnName(i), rs.getString(i));
                }
                dataList.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }
}
