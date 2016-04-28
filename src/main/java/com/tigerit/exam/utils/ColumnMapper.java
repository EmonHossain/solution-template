package com.tigerit.exam.utils;

import com.tigerit.exam.Solution;
import com.tigerit.exam.input.ReadData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by emon on 4/28/16.
 */
public class ColumnMapper {

    public static HashMap<String,List<Integer>> columnValue = new HashMap<>();

    public void mapColumNameWithValue(){
        int[][] firstTable = ReadData.tablesName.get(Solution.firstTableName);
        int[][] secondTable = ReadData.tablesName.get(Solution.secondTableName);
        List<String> columnNameForFirstTable = ReadData.tableColumnsName.get(Solution.firstTableName);
        List<String> columnNameForSecondTable = ReadData.tableColumnsName.get(Solution.secondTableName);

        //System.out.println("column size  "+columnNameForFirstTable.size());

        for (int i=0;i<columnNameForFirstTable.size();i++){
            String name = columnNameForFirstTable.get(i);
            List<Integer> value = new ArrayList<>();
            int index = columnNameForFirstTable.indexOf(name);
            for (int j=0;j<ReadData.numberOfRecordFortable.get(Solution.firstTableName);j++){
                value.add(firstTable[j][index]);
                //System.out.println("value added with column : "+firstTable[j][index]);
            }
            columnValue.put(name,value);
        }


        //System.out.println("column size  "+columnNameForFirstTable.size());
        for (int i=0;i<columnNameForSecondTable.size();i++){
            String name = columnNameForSecondTable.get(i);
            List<Integer> value = new ArrayList<>();
            int index = columnNameForSecondTable.indexOf(name);
            for (int j=0;j<ReadData.numberOfRecordFortable.get(Solution.secondTableName);j++){
                value.add(secondTable[j][index]);
                //System.out.println("value added with column : "+secondTable[j][index]);
            }
            columnValue.put(name,value);
        }
    }

}
