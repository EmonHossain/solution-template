package com.tigerit.exam;

import com.tigerit.exam.input.ReadData;
import com.tigerit.exam.utils.ColumnMapper;
import com.tigerit.exam.utils.QueryAnalyzer;

import java.util.List;

/**
 * Created by emon on 4/28/16.
 */
public class JoinTable {
    int[][] firstTable = ReadData.tablesName.get(Solution.firstTableName);
    int[][] secondTable = ReadData.tablesName.get(Solution.secondTableName);
    List<String> columnNameForFirstTable = ReadData.tableColumnsName.get(Solution.firstTableName);
    List<String> columnNameForSecondTable = ReadData.tableColumnsName.get(Solution.secondTableName);
    QueryAnalyzer queryAnalyzer = new QueryAnalyzer();
    public void joinTwoTableForAllColumn(List<String> joinOn){




        //join here
        List<String> firstTbNameAndColName = queryAnalyzer.analyzeQuery(joinOn.get(0),".");
        List<String> secondTbNameAndColName = queryAnalyzer.analyzeQuery(joinOn.get(1),".");

        List<Integer> values_1 = ColumnMapper.columnValue.get(firstTbNameAndColName.get(1));
        List<Integer> values_2 = ColumnMapper.columnValue.get(secondTbNameAndColName.get(1));

        for(int i=0;i<columnNameForFirstTable.size();i++){
            System.out.print(columnNameForFirstTable.get(i)+" ");
        }
        for(int i=0;i<columnNameForSecondTable.size();i++){
            if(i<columnNameForSecondTable.size()-1)
                System.out.print(columnNameForSecondTable.get(i)+" ");
            else
                System.out.print(columnNameForSecondTable.get(i));
        }
        System.out.println();

        for (int i=0;i<values_1.size();i++){
            if(values_1.get(i)==values_2.get(i)){
                for (int j=0;j<columnNameForFirstTable.size();j++){
                    List<Integer> colValue = ColumnMapper.columnValue.get(columnNameForFirstTable.get(j));
                    if(j<columnNameForFirstTable.size()-1)
                        System.out.print(colValue.get(i)+" ");
                    else
                        System.out.print(colValue.get(i));
                }
                for (int j=0;j<columnNameForSecondTable.size();j++){
                    List<Integer> colValue = ColumnMapper.columnValue.get(columnNameForSecondTable.get(j));
                    if(j<columnNameForSecondTable.size()-1)
                        System.out.print(colValue.get(i)+" ");
                    else
                        System.out.print(colValue.get(i));
                }
                System.out.println();
            }
        }

    }

    public void joinTwoTableForSpechificColumn(List<String> selectedColumn,List<String> joinOn){
        List<String> firstTbNameAndColName = queryAnalyzer.analyzeQuery(joinOn.get(0),".");
        List<String> secondTbNameAndColName = queryAnalyzer.analyzeQuery(joinOn.get(1),".");

        List<Integer> values_1 = ColumnMapper.columnValue.get(firstTbNameAndColName.get(1));
        List<Integer> values_2 = ColumnMapper.columnValue.get(secondTbNameAndColName.get(1));

        for (int i=0;i<selectedColumn.size();i++){
            if (i<selectedColumn.size()-1)
                System.out.print(selectedColumn.get(i)+" ");
            else
                System.out.print(selectedColumn.get(i));
        }

        System.out.println();


/*
        for (int i=0;i<values_1.size();i++){
            if(values_1.get(i)==values_2.get(i)){
                for (int j=0;j<columnNameForFirstTable.size();j++){
                    List<Integer> colValue = ColumnMapper.columnValue.get(columnNameForFirstTable.get(j));
                    if(j<columnNameForFirstTable.size()-1)
                        System.out.print(colValue.get(i)+" ");
                    else
                        System.out.print(colValue.get(i));
                }
                for (int j=0;j<columnNameForSecondTable.size();j++){
                    List<Integer> colValue = ColumnMapper.columnValue.get(columnNameForSecondTable.get(j));
                    if(j<columnNameForSecondTable.size()-1)
                        System.out.print(colValue.get(i)+" ");
                    else
                        System.out.print(colValue.get(i));
                }
                System.out.println();
            }
        }*/
    }
}
