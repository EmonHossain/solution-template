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

        List<String> data = new ArrayList<>();
        StringTokenizer tokenizer=null;
        //new

        if(str.equals("*")){
            data.add("*");
            return data;
        }
        else{
            tokenizer = new StringTokenizer(str,delima);
            //System.out.println("token element size : "+tokenizer.countTokens());
            while (tokenizer.hasMoreElements()){
                data.add(tokenizer.nextElement().toString());
            }

            return data;
        }

    }

}
