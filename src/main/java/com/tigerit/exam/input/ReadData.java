package com.tigerit.exam.input;

import com.tigerit.exam.IO;
import sun.util.PreHashedMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by emon on 4/25/16.
 */
public class ReadData {

    public static int testCase = 0;
    public int tableNumber = 0;
    public String tableName;
    public int numberOfColumn;
    public int numberOfRecord;



    public static HashMap<String,int[][]> tablesName = new HashMap<>();
    public static HashMap<String,List<String>> tableColumnsName = new HashMap<>();
    public static HashMap<String,Integer> numberOfRecordFortable = new HashMap<>();
    public static HashMap<String,Integer> numberOfColumnFortable = new HashMap<>();
    public List<int[][]> listOfTable = new ArrayList<>();
    public List<String[]> listOfcolumnNames = new ArrayList<>();
    public static List<String[]> listOfQueries = new ArrayList<>();
    private int numberOfQueries = 0;



    public void setDataForTest(){

        testCase = IO.readLineAsInteger();
        for (int i=0;i<testCase;i++){
            System.out.println("Test: "+testCase);
            tableNumber = IO.readLineAsInteger();
            for (int j=0;j<tableNumber;j++){
                tableName = IO.readLine();
                numberOfColumn = IO.readLineAsInteger();
                numberOfRecord=IO.readLineAsInteger();
                List<String> columnNames = new ArrayList<>();
                for(int k=0;k<numberOfColumn;k++){
                    String colName = IO.readLine();
                    columnNames.add(colName);
                }

                int[][] table = new int[100][110];

                for (int x =0; x<numberOfRecord;x++){
                    for (int y = 0;y<numberOfColumn;y++){
                        table[x][y]=IO.readLineAsInteger();
                    }
                }
                tableColumnsName.put(tableName.toString(),columnNames);
                tablesName.put(tableName.toString(),table);
                numberOfRecordFortable.put(tableName.toString(),numberOfRecord);
                numberOfColumnFortable.put(tableName.toString(),numberOfColumn);
            }
            numberOfQueries = IO.readLineAsInteger();

            for (int n = 0;n<numberOfQueries;n++){
                String[] query = new String[4];
                for(int q=0;q<4;q++){
                    query[q] = IO.readLine();
                    query[q]= query[q].toLowerCase();
                    //System.out.println(query[q]);
                    if(q==0 && query[q].contains("select")){
                        query[q] = query[q].replace("select","");
                        query[q] = query[q].replaceAll("\\s","");
                        //System.out.println(query[q]);
                    }
                    if(q==1 && query[q].contains("from")){
                        query[q]=query[q].replace("from","");
                        query[q] = query[q].replaceFirst("\\s","");
                        //System.out.println(query[q]);
                    }
                    if(q==2 && query[q].contains("join")){
                        query[q]=query[q].replace("join","");
                        query[q] = query[q].replaceFirst("\\s","");
                        //System.out.println(query[q]);
                    }
                    if(q==3 && query[q].contains("on")){
                        query[q]=query[q].replace("on","");
                        query[q] = query[q].replaceAll("\\s","");
                        //System.out.println(query[q]);
                    }
                }

                //System.out.println("end..........");
                listOfQueries.add(query);
            }

        }

    }

}
