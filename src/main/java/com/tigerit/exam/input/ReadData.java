package com.tigerit.exam.input;

import com.tigerit.exam.IO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emon on 4/25/16.
 */
public class ReadData {

    public static int testCase = 0;
    public static int tableNumber = 0;
    public static String[] tableName = new String[15];
    public static int[] numberOfColumn = new int[110];
    public static int[] numberOfRecord = new int[110];
    public static String[] columnNames = new String[110];
    public static int[][] table = new int[100][110];
    public static List<int[][]> listOfTable = new ArrayList<>();
    public static List<String[]> listOfcolumnNames = new ArrayList<>();
    public static List<String> listOfQueries = new ArrayList<>();
    private int numberOfQueries = 0;

    public void setDataForTest(){

        testCase = IO.readLineAsInteger();
        for (int i=0;i<testCase;i++){
            tableNumber = IO.readLineAsInteger();
            for (int j=0;j<tableNumber;j++){
                tableName[j]= IO.readLine();
                numberOfColumn[j] = IO.readLineAsInteger();
                numberOfRecord[j]=IO.readLineAsInteger();
                for(int k=0;k<numberOfColumn[j];k++){
                    columnNames[k]=IO.readLine();
                }
                for (int x =0; x<numberOfRecord[j];x++){
                    for (int y = 0;y<numberOfColumn[j];y++){
                        table[x][y]=IO.readLineAsInteger();
                    }
                }
                listOfcolumnNames.add(columnNames);
                listOfTable.add(table);
            }
            numberOfQueries = IO.readLineAsInteger();
            for (int n = 0;n<numberOfQueries;n++){
                String query = IO.readLine();
                listOfQueries.add(query);
            }

        }

        System.out.println(listOfTable.size());

    }




}
