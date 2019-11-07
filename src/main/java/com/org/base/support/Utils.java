package com.org.base.support;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;


public class Utils {

    public static String MasterData = System.getProperty("user.dir") + "\\Master_Data.xlsx";


    public static String readConfigPropertiesFile(String key) {
        ResourceBundle rb = ResourceBundle.getBundle("config");
        return rb.getString(key);
    }

    public Map<Integer, Map<String, String>> getRecordFromSheet(String sheetName, String RecordName) {

        Map<Integer, Map<String, String>> AllRows = new HashMap<Integer, Map<String, String>>();
        Fillo fillo = new Fillo();
        Connection connection = null;
        Recordset recordset = null;

        try {

            connection = fillo.getConnection(MasterData);
            String strQuery = "Select * from " + sheetName + " where TestCase = '" + RecordName + "'";
            System.out.println(strQuery);
            recordset = connection.executeQuery(strQuery);
            int i = 0;
            while (recordset.next()) {
                Map<String, String> singleRow = new HashMap<>();
                i++;
                ArrayList allColmn = recordset.getFieldNames();
                Iterator ite = allColmn.iterator();

                while (ite.hasNext()) {

                    String clmnName = ite.next().toString();
                    String value = recordset.getField(clmnName).toString();
                    singleRow.put(clmnName, value);
                }
                AllRows.put(i, singleRow);
            }
        } catch (FilloException e) {
            //recordset.close();
            connection.close();
        } finally {
//            recordset.close();
            connection.close();
        }
        return AllRows;
    }

}