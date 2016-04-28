package com.tigerit.exam;


import com.tigerit.exam.input.ReadData;
import com.tigerit.exam.utils.QueryAnalyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.tigerit.exam.IO.*;

/**
 * All of your application logic should be placed inside this class.
 * Remember we will load your application from our custom container.
 * You may add private method inside this class but, make sure your
 * application's execution points start from inside run method.
 */
public class Solution implements Runnable {

    boolean allColumn = false;
    public static String firstTableName;
    public static String firstTableShortName=null;
    public static String secondTableName;
    public static String secondTableShortName;
    public static String[] joinColumns = new String[2];
    String[] query;
    public static List<String> columnNamesForQuery = new ArrayList<>();
    public static HashMap<String,String> findTableNameByShortName = new HashMap<>();


    QueryAnalyzer queryAnalyzer = new QueryAnalyzer();

    @Override
    public void run() {
        // your application entry point

        // sample input process
        //String string = readLine();

        //Integer integer = readLineAsInteger();

        new ReadData().setDataForTest();



        for (int i=0;i<ReadData.listOfQueries.size();i++){

            query = ReadData.listOfQueries.get(i);
            List<String> analyzedDataForSelect = queryAnalyzer.analyzeQuery(query[0],null);
            if (analyzedDataForSelect.size()==1 && analyzedDataForSelect.contains("*")){
                List<String> analyzedData = queryAnalyzer.analyzeQuery(query[0],null);
                if(analyzedData.size()==1 && analyzedData.contains("*")){
                    allColumn = true;
                }
                dataOrganizer(analyzedData);
            }


            else {

                List<String> analyzedData = queryAnalyzer.analyzeQuery(query[0],",");
                for (int k=0;k<analyzedData.size();k++){
                    if(analyzedData.get(k)!=null || analyzedData.get(k).isEmpty())
                        columnNamesForQuery.add(analyzedData.get(k));
                    //columnNamesForQuery[k]=queryAnalyzer.replaceByTableName(columnNamesForQuery[k]);
                }
                dataOrganizer(analyzedData);

            }




        }

        int[][] tab = ReadData.tablesName.get(firstTableName);
        System.out.println(firstTableName);
        for(int i = 0;i<(int)ReadData.numberOfRecordFortable.get(firstTableName);i++){
            for(int k=0;k<(int)ReadData.numberOfRecordFortable.get(firstTableName);k++){
                System.out.print(tab[i][k]+ " ");
            }
            System.out.println();
        }

        tab = ReadData.tablesName.get(secondTableName);
        System.out.println(secondTableName);
        for(int i = 0;i<(int)ReadData.numberOfRecordFortable.get(secondTableName);i++){
            for(int k=0;k<(int)ReadData.numberOfRecordFortable.get(secondTableName);k++){
                System.out.print(tab[i][k]+ " ");
            }
            System.out.println();
        }
        System.out.println("query column");

        for (int i=0;i<columnNamesForQuery.size();i++){
            System.out.println(columnNamesForQuery.size());
            /*if(i==0){
                String[] a = queryAnalyzer.analyzeQuery(columnNamesForQuery[i]," ");
                columnNamesForQuery[i]=a[1].replaceAll("\\s"," ");
            }

            System.out.println(columnNamesForQuery[i]);*/
        }

        System.out.println("join");

        for (int i=0;i<joinColumns.length;i++){
            System.out.println(columnNamesForQuery.get(i).toString());
        }


        // sample output process
        //printLine(string);
        //printLine(integer);
    }

    public void dataOrganizer(List<String> analyzedData){
        for (int j=1;j<4;j++){

            if(j==1){
                analyzedData = queryAnalyzer.analyzeQuery(query[j],null);
                if(analyzedData.size()==1){
                    firstTableName = analyzedData.get(0);
                }
                else {
                    firstTableName = analyzedData.get(0);
                    firstTableShortName = analyzedData.get(1);
                    findTableNameByShortName.put(firstTableShortName,firstTableName);
                }
            }
            else if(j==2){
                analyzedData = queryAnalyzer.analyzeQuery(query[j],null);
                if(analyzedData.size()==1)
                    secondTableName = analyzedData.get(0);
                else {
                    secondTableName = analyzedData.get(0);
                    secondTableShortName = analyzedData.get(1);
                    findTableNameByShortName.put(secondTableShortName,secondTableName);
                }
            }
            else if(j==3){
                analyzedData = queryAnalyzer.analyzeQuery(query[j],"=");
                joinColumns[0]=analyzedData.get(0);
                joinColumns[1]=analyzedData.get(1);
                if(firstTableShortName!=null){
                    /*joinColumns[0]=queryAnalyzer.replaceByTableName(joinColumns[0]);
                    joinColumns[1]=queryAnalyzer.replaceByTableName(joinColumns[1]);*/
                }

            }

        }
    }
}
