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

    public  int testCase = 0;
    public int tableNumber = 0;
    public String tableName;
    public int numberOfColumn;
    public int numberOfRecord;
    public String[] columnNames = new String[110];


    public static HashMap<String,int[][]> tablesName = new HashMap<>();
    public static HashMap<String,String[]> tableColumnsName = new HashMap<>();
    public static HashMap<String,Integer> numberOfRecordFortable = new HashMap<>();
    public static HashMap<String,Integer> numberOfColumnFortable = new HashMap<>();
    public List<int[][]> listOfTable = new ArrayList<>();
    public List<String[]> listOfcolumnNames = new ArrayList<>();
    public static List<String[]> listOfQueries = new ArrayList<>();
    private int numberOfQueries = 0;



    public void setDataForTest(){

        testCase = IO.readLineAsInteger();
        for (int i=0;i<testCase;i++){
            tableNumber = IO.readLineAsInteger();
            for (int j=0;j<tableNumber;j++){
                tableName = IO.readLine();
                numberOfColumn = IO.readLineAsInteger();
                numberOfRecord=IO.readLineAsInteger();
                for(int k=0;k<numberOfColumn;k++){
                    columnNames[k]=IO.readLine();
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
            String[] query = new String[4];
            for (int n = 0;n<numberOfQueries;n++){
                for(int q=0;q<4;q++){
                    query[q] = IO.readLine();
                }
                listOfQueries.add(query);
            }

        }





        int[][] tab = tablesName.get("table_a");

        for(int i = 0;i<(int)numberOfRecordFortable.get("table_a");i++){
            for(int k=0;k<(int)numberOfColumnFortable.get("table_a");k++){
                System.out.print(tab[i][k]+ " ");
            }
            System.out.println();
        }
        //System.out.println(listOfTable.size());

    }




}
