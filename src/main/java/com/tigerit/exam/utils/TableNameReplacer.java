package com.tigerit.exam.utils;

/**
 * Created by emon on 4/28/16.
 */
public class TableNameReplacer {

    public String replaceTableShortNameByTableName(String combinedName,String firstTableName,String secondTableName,String firstShortName,String secondShortName){

        if (combinedName.contains(firstShortName))
            combinedName = combinedName.replace(firstShortName,firstTableName);
        else
            combinedName = combinedName.replace(secondShortName,secondTableName);
        return combinedName;
    }
}
