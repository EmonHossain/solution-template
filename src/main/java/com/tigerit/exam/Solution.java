package com.tigerit.exam;


import com.tigerit.exam.input.ReadData;
import com.tigerit.exam.utils.ColumnMapper;
import com.tigerit.exam.utils.QueryAnalyzer;
import com.tigerit.exam.utils.TableNameReplacer;

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

        TableNameReplacer replacer = new TableNameReplacer();

        for (int i=0;i<ReadData.listOfQueries.size();i++){

            //System.out.println(ReadData.listOfQueries.size());

            query = ReadData.listOfQueries.get(i);
            System.out.println("size of query : "+ReadData.listOfQueries.size());
            List<String> analyzedDataForSelect = queryAnalyzer.analyzeQuery(query[0],",");
            System.out.println("elements of query select : "+analyzedDataForSelect);

            List<String> analyzedDataForFrom = queryAnalyzer.analyzeQuery(query[1]," ");

            List<String> analyzedDataForJoin = queryAnalyzer.analyzeQuery(query[2]," ");

            List<String> analyzedDataForJoinOn = queryAnalyzer.analyzeQuery(query[3],"=");



            if(analyzedDataForFrom.size()==1){
                firstTableName = analyzedDataForFrom.get(0);
            }else {
                firstTableName = analyzedDataForFrom.get(0);
                firstTableShortName = analyzedDataForFrom.get(1);
                findTableNameByShortName.put(firstTableShortName,firstTableName);

                System.out.println(firstTableName+" "+firstTableShortName);
            }



            if(analyzedDataForJoin.size()==1){
                secondTableName = analyzedDataForJoin.get(0);
            }else {
                secondTableName = analyzedDataForJoin.get(0);
                secondTableShortName = analyzedDataForJoin.get(1);
                findTableNameByShortName.put(secondTableShortName,secondTableName);

                System.out.println(secondTableName+" "+secondTableShortName);
            }


            if(analyzedDataForSelect.size()>1 && firstTableShortName!=null){
                int index=0;
                for (String str : analyzedDataForSelect) {
                    analyzedDataForSelect.set(index, replacer.replaceTableShortNameByTableName(str, firstTableName,secondTableName, firstTableShortName,secondTableShortName));
                    index++;
                }
            }

            //print replaced value
            if(analyzedDataForSelect.size()>1) {
                for (String str : analyzedDataForSelect) {
                    System.out.println("replaced select value : " + str);
                }
            }


            if (analyzedDataForJoinOn.size()>1 && firstTableShortName!=null){
                int index=0;
                for (String str : analyzedDataForJoinOn){
                    analyzedDataForJoinOn.set(index, replacer.replaceTableShortNameByTableName(str, firstTableName,secondTableName, firstTableShortName,secondTableShortName));
                    index++;
                }
            }

            //print replaced value
            for (String str : analyzedDataForJoinOn){
                System.out.println("replaced join on value : "+str);
            }

            ColumnMapper columnMapper = new ColumnMapper();
            columnMapper.mapColumNameWithValue();


            JoinTable joinTable = new JoinTable();
            if(analyzedDataForSelect.size()==1 && analyzedDataForSelect.get(0).equals("*"))
                joinTable.joinTwoTableForAllColumn(analyzedDataForJoinOn);
            else
                joinTable.joinTwoTableForSpechificColumn(analyzedDataForSelect,analyzedDataForJoinOn);



        }

    }
}
