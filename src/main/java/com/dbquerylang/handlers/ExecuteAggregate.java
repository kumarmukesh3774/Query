package com.dbquerylang.handlers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ExecuteAggregate {
	
	public int min(QueryParameterclass para)
	{
		
		int min=9999;
		JSONParser parser = new JSONParser();
		JSONObject jsonObject=null;
        try {

            Object obj = parser.parse(new FileReader("test.json"));

            jsonObject = (JSONObject) obj;

            JSONArray operand1 = (JSONArray) jsonObject.get(para);
            Iterator iterator = operand1.iterator();
            while(iterator.hasNext()) {
            	int num=Integer.valueOf(iterator.next().toString());
    			if(num<min)
    				min=num;
            	
            	//System.out.println(iterator.next());
            	
            }
            	
       
            //System.out.println(jsonObject);


            // loop array

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return min;
		
		
	}
	public int max(QueryParameterclass para)
	{
		
		int max=0;
		JSONParser parser = new JSONParser();
		JSONObject jsonObject=null;
        try {

            Object obj = parser.parse(new FileReader("test.json"));

            jsonObject = (JSONObject) obj;

            JSONArray operand1 = (JSONArray) jsonObject.get(para);
            Iterator iterator = operand1.iterator();
            while(iterator.hasNext()) {
            	int num=Integer.valueOf(iterator.next().toString());
    			if(num>max)
    				max=num;
            	
            	//System.out.println(iterator.next());
            	
            }
            	
       
            //System.out.println(jsonObject);


            // loop array

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return max;
		
		
	}
	public int avg(QueryParameterclass para)
	{
		
		int sum=0;
		int count=1;
		JSONParser parser = new JSONParser();
		JSONObject jsonObject=null;
        try {

            Object obj = parser.parse(new FileReader("test.json"));

            jsonObject = (JSONObject) obj;

            JSONArray operand1 = (JSONArray) jsonObject.get(para);
            Iterator iterator = operand1.iterator();
            while(iterator.hasNext()) {
            	int num=Integer.valueOf(iterator.next().toString());
    			sum=sum+num;
            	//System.out.println(iterator.next());
            	
            }
            	
       
            //System.out.println(jsonObject);


            // loop array

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return sum/count;
		
		
	}



}
