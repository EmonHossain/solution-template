package com.tigerit.exam.utils;

import com.tigerit.exam.Solution;
import com.tigerit.exam.input.ReadData;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by emon on 4/25/16.
 */
public class QueryAnalyzer {
    public List<String> analyzeQuery(String str,String delima){
        //str.toLowerCase();
        //str.replaceFirst("select"," ");
        List<String> data = new ArrayList<>();
        StringTokenizer tokenizer=null;
        int flag = 0,i=0;
        if(delima==null) {
            tokenizer = new StringTokenizer(str, " ");
            tokenizer.nextToken();
        }
        else if (delima!=null)
            tokenizer = new StringTokenizer(str,delima);
            //tokenizer.nextToken();
        while (tokenizer.hasMoreElements()){
            if(flag==1){
                data.add(tokenizer.nextElement().toString());
            }
            flag=1;
        }
        return data;
    }


    /*public String replaceByTableName(String str){
        System.out.println(str);
        String[] value = analyzeQuery(str,".");
        String var=null;
        try {
            System.out.println(Solution.findTableNameByShortName.get(value[0].toString()));
            System.out.println(value[0].toString());
            var = str.replaceFirst(value[0].toString(),Solution.findTableNameByShortName.get(value[0].toString()));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return var;
    }*/


}
