package com.tigerit.exam;

import com.tigerit.exam.input.ReadData;
import com.tigerit.exam.utils.ColumnMapper;
import com.tigerit.exam.utils.QueryAnalyzer;

import java.util.ArrayList;
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
                    //if(j<columnNameForFirstTable.size()-1)
                        System.out.print(colValue.get(i)+" ");
                    /*else
                        System.out.print(colValue.get(i));*/
                }
                for (int j=0;j<columnNameForSecondTable.size();j++){
                    List<Integer> colValue = ColumnMapper.columnValue.get(columnNameForSecondTable.get(j));
                    if(j<columnNameForSecondTable.size()-1)
                        System.out.print(colValue.get(i)+" ");
                    else
                        System.out.print(colValue.get(i));
                }
                //last space line
                System.out.println();
            }
        }
        System.out.println();

    }

    public void joinTwoTableForSpechificColumn(List<String> selectedColumn,List<String> joinOn){
        List<String> firstTbNameAndColName = queryAnalyzer.analyzeQuery(joinOn.get(0),".");
        List<String> secondTbNameAndColName = queryAnalyzer.analyzeQuery(joinOn.get(1),".");

        List<Integer> values_1 = ColumnMapper.columnValue.get(firstTbNameAndColName.get(1));
        List<Integer> values_2 = ColumnMapper.columnValue.get(secondTbNameAndColName.get(1));
        List<List<String>> selectedcolandtable = new ArrayList<>();

        for (String str : selectedColumn){
            List<String> tableNameAndColumns = queryAnalyzer.analyzeQuery(str,".");
            selectedcolandtable.add(tableNameAndColumns);
        }

        List<String> actualColName = new ArrayList<>();

        for (List<String> name:selectedcolandtable){
            actualColName.add(name.get(1));
        }

        for (int i=0;i<actualColName.size();i++){
            if (i<actualColName.size()-1)
                System.out.print(actualColName.get(i)+" ");
            else
                System.out.print(actualColName.get(i));
        }

        System.out.println();

        int tableOneColcount=0;

        for (int i=0;i<selectedColumn.size();i++){
            //int count=0;
            if(selectedColumn.get(i).contains(Solution.firstTableName)){
                tableOneColcount++;
            }
        }

        int tableTwoColcount=0;
        for (int i=0;i<selectedColumn.size();i++){
            if(selectedColumn.get(i).contains(Solution.secondTableName)){
                tableTwoColcount++;
            }
        }



        for (int i=0;i<values_1.size();i++){
            if(values_1.get(i)==values_2.get(i)){
                for (int j=0;j<columnNameForFirstTable.size();j++){
                    int index=0;
                    List<Integer> colValue = ColumnMapper.columnValue.get(columnNameForFirstTable.get(j));

                    for (int f=0;f<actualColName.size();f++) {
                        String name = actualColName.get(f);
                        if (columnNameForFirstTable.get(j).equals(name)){
                            if(i<columnNameForFirstTable.size()-1)
                                System.out.print(colValue.get(i)+" ");
                            else
                                System.out.print(colValue.get(i)+" ");
                        }

                    }

                }
                for (int j=0;j<columnNameForSecondTable.size();j++){
                    List<Integer> colValue = ColumnMapper.columnValue.get(columnNameForSecondTable.get(j));
                    for (int f=0;f<actualColName.size();f++) {
                        String name = actualColName.get(f);
                        if (columnNameForSecondTable.get(j).equals(name)){
                            if(j<columnNameForSecondTable.size()-1)
                                System.out.print(colValue.get(i)+" ");
                            else
                                System.out.print(colValue.get(i));
                        }

                    }


                }
                System.out.println();
            }
        }

    }
}
