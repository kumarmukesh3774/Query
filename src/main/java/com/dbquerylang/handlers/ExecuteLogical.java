package com.dbquerylang.handlers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ExecuteLogical {
	
	public void executeLogical(ArrayList<QueryParameterclass> al,ArrayList<Restrictions> re,ArrayList<LogicalOperators> or) {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject=null;
        try {

            Object obj = parser.parse(new FileReader("test.json"));

            jsonObject = (JSONObject) obj;
           
            Iterator<QueryParameterclass> itr=al.iterator();
            while(itr.hasNext()) {
            	String s=itr.next().getPara();
            JSONArray operand = (JSONArray)jsonObject.get(s);
            
            Iterator iterator = operand.iterator();
            System.out.println("\n==============="+s+"===============\n");
            while(iterator.hasNext()) {
            	
            	System.out.println(String.format("%.40s   ", iterator.next()));;
            }
            	
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

		/*Iterator<Restrictions> itr=re.iterator();
		while(itr.hasNext()) {
			Restrictions res=itr.next();
			System.out.println(res.getOperand2()+"========");
            JSONArray operand1 = (JSONArray) jsonObject.get("venue");
            Iterator iterator = operand1.iterator();

            
           Iterator<QueryParameterclass> itr1= al.iterator();
            
			if(res.getOperator().equals("=")) {
	            while (iterator.hasNext()) {
	            	Object str= iterator.next();
	            	if(str.toString().equalsIgnoreCase(res.getOperand2()))
	            	{
	            		//while(itr1.hasNext())
	                    System.out.println("ghhjkk");
	            		
	            	}
			
	               
	            }
				
				
				
			}
				
			
		}*/
 		
	}

}
