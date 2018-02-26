package com.dbquerylang.handlers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Function;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ExecuteLogical {
	
	public void executeLogical(ArrayList<QueryParameterclass> al,
			ArrayList<Restrictions> re,ArrayList<LogicalOperators> or) 
					throws ParseException, org.json.simple.parser.ParseException {
		
		
		 JSONParser parser = new JSONParser();

	        try {

	            Object obj = parser.parse(new FileReader("test.json"));

	            JSONObject jsonObject = (JSONObject) obj;
	           // System.out.println(jsonObject);

	            // loop headers
				String s[]= {"ID","CITY","DATE","TEAM1","TEAM2","TOSS_WINNER","TOSS_DECISION",
						"RESULT","DL_APPLIED","WINNER","WIN_BY_RUNS","WIN_BY_WICKETS","PLAYER_OF_THE_MATCH","VENUE","UMPIRE1","UMPIRE2"};
				Iterator<QueryParameterclass> it= al.iterator();
				while(it.hasNext()) {
					
        
					QueryParameterclass para1=it.next();
					if(para1.getPara().equals("*")||para1.getPara().equalsIgnoreCase("id")) {
					System.out.print(String.format("%-5s|", s[0]));
					}
					if(para1.getPara().equals("*")||para1.getPara().equalsIgnoreCase("city")) {
					System.out.print(String.format("%-15s|", s[1]));
					}
					if(para1.getPara().equals("*")||para1.getPara().equalsIgnoreCase("date")) {
					System.out.print(String.format("%-15s|", s[2]));
					}
					if(para1.getPara().equals("*")||para1.getPara().equalsIgnoreCase("team1")) {
					System.out.print(String.format("%-30s|", s[3]));
					}
					if(para1.getPara().equals("*")||para1.getPara().equalsIgnoreCase("team2")) {
					System.out.print(String.format("%-30s|", s[4]));
					}
					if(para1.getPara().equals("*")||para1.getPara().equalsIgnoreCase("TOSS_WINNER")) {
					System.out.print(String.format("%-30s|", s[5]));
					}
					if(para1.getPara().equals("*")||para1.getPara().equalsIgnoreCase("TOSS_DECISION")) {
					System.out.print(String.format("%-15s|", s[6]));
					}
					if(para1.getPara().equals("*")||para1.getPara().equalsIgnoreCase("RESULT")) {
					System.out.print(String.format("%-6s|", s[7]));
					}
					if(para1.getPara().equals("*")||para1.getPara().equalsIgnoreCase("DL_APPLIED")) {
					System.out.print(String.format("%-10s|", s[8]));
					}
					if(para1.getPara().equals("*")||para1.getPara().equalsIgnoreCase("winner")) {
					System.out.print(String.format("%-30s|", s[9]));
					}
					if(para1.getPara().equals("*")||para1.getPara().equalsIgnoreCase("win_by_runs")) {
					System.out.print(String.format("%-11s|", s[10]));
					}
					if(para1.getPara().equals("*")||para1.getPara().equalsIgnoreCase("win_by_wickets")) {
					System.out.print(String.format("%-5s|", s[11]));
					}
					if(para1.getPara().equals("*")||para1.getPara().equalsIgnoreCase("player_of_match")) {
					System.out.print(String.format("%-20s|", s[12]));
					}
					if(para1.getPara().equals("*")||para1.getPara().equalsIgnoreCase("venue")) {
					System.out.print(String.format("%-55s|", s[13]));
					}
					if(para1.getPara().equals("*")||para1.getPara().equalsIgnoreCase("umpire1")) {
					System.out.print(String.format("%-20s|", s[14]));
					}
					if(para1.getPara().equals("*")||para1.getPara().equalsIgnoreCase("umpire2")) {
					System.out.print(String.format("%-20s|", s[15]));
					}
			
					
				}
	            System.out.println("\n");
	            
	            JSONArray json = (JSONArray) jsonObject.get("matches");
	            Iterator<JSONObject> iterator = json.iterator();
	            Iterator<QueryParameterclass> itrPara=null;
	            while (iterator.hasNext()) {
	            	JSONObject ob=iterator.next();
	            	itrPara=al.iterator();
	            	while(itrPara.hasNext()) {
	            		QueryParameterclass para=itrPara.next();
	            		
	            		
	            		if(para.getPara().equals("*"))
	            		{	
	            			System.out.print(String.format("%-5s|", ob.get("id")));
            				System.out.print(String.format("%-15s|", ob.get("city")));
            				System.out.print(String.format("%-15s|", ob.get("date")));
	            			System.out.print(String.format("%-30s|", ob.get("team1")));
            				System.out.print(String.format("%-30s|", ob.get("team2")));
            				System.out.print(String.format("%-30s|", ob.get("toss_winner")));
	            			System.out.print(String.format("%-15s|", ob.get("toss_decision")));
            				System.out.print(String.format("%-6s|", ob.get("result")));
            				System.out.print(String.format("%-10s|", ob.get("dl_applied")));
	            			System.out.print(String.format("%-30s|", ob.get("winner")));
            				System.out.print(String.format("%-11s|", ob.get("win_by_runs")));
            				System.out.print(String.format("%-14s|", ob.get("win_by_wickets")));
	            			System.out.print(String.format("%-20s|", ob.get("player_of_match")));
            				System.out.print(String.format("%-55s|", ob.get("venue")));
            				System.out.print(String.format("%-20s|", ob.get("umpire1")));
	            			System.out.print(String.format("%-20s|", ob.get("umpire2")));

	            			
	            			
	            			
	            		}
	            		
	            		
	            		
	            		
	            		
	            		if(para.getPara().equalsIgnoreCase("id")) {

	            			System.out.print(String.format("%.40s   ", ob.get("id")));
	            		}
	            		

	            		
	            		 if(para.getPara().equalsIgnoreCase("city")) {
	            			
	            				System.out.print(String.format("%.40s   ", ob.get("city")));

	            			}
	            	
	            			
	            		
	            		 if(para.getPara().equalsIgnoreCase("date")) {
	            	
	            				System.out.print(String.format("%.40s   ", ob.get("date")));

	            			}
	            	
	            			
	            		
	            		if(para.getPara().equalsIgnoreCase("team1")) {
	            		

	            			System.out.print(String.format("%.40s   ", ob.get("team1")));

	            		}	
	            			
	            		
	            		
	            		 if(para.getPara().equalsIgnoreCase("team2")) {


	            				System.out.print(String.format("%.40s   ", ob.get("team2")));

	            			}
	            		
	            			
	            		
	            		
	            		 if(para.getPara().equalsIgnoreCase("toss_winner")) {
	            	
	            				System.out.print(String.format("%.40s   ", ob.get("toss_winner")));

	            			}
	            	
	            			
	            		
	            		 if(para.getPara().equalsIgnoreCase("toss_decision")) {
	            	
	            				System.out.print(String.format("%.40s   ", ob.get("toss_decision")));

	            			}
	            	
	            			
	            		
	            		 if(para.getPara().equalsIgnoreCase("result")) {

	            				System.out.print(String.format("%.40s   ", ob.get("result")));

	            			}
	            		
	            			
	            		
	            		 if(para.getPara().equalsIgnoreCase("dl_applied")) {

	            				System.out.print(String.format("%.40s   ", ob.get("dl_applied")));

	            		
	            		 }
	            		
	            		 if(para.getPara().equalsIgnoreCase("winner")) {

	            				System.out.print(String.format("%.40s   ", ob.get("winner")));
	            			
	            			}

	            			
	            		
	            		 if(para.getPara().equalsIgnoreCase("win_by_runs")) {

	            				System.out.print(String.format("%.40s   ", ob.get("win_by_runs")));
	            			}
	            		
	            		 if(para.getPara().equalsIgnoreCase("win_by_wickets")) {
	            				System.out.print(String.format("%.40s   ", ob.get("win_by_wickets")));

	            			}
	            			
	            		
	            		 if(para.getPara().equalsIgnoreCase("player_of_match")) {

	            				System.out.print(String.format("%.40s   ", ob.get("player_of_match")));

	            			}
	            	
	            			
	            		
	            		 if(para.getPara().equalsIgnoreCase("venue")) {

	            				System.out.print(String.format("%.40s   ", ob.get("venue")));

	            			}

	            			
	            		
	            		 if(para.getPara().equalsIgnoreCase("umpire1")) {

	            				System.out.print(String.format("%.40s   ", ob.get("umpire1")));
	            		
	            			}

	            			
	            		
	            		 if(para.getPara().equalsIgnoreCase("umpire2")) {

	            				System.out.print(String.format("%.40s   ", ob.get("umpire2")));
	            			
	            		}
	            		 
	            		
	            	}
	            	System.out.println("\n");
	                
	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }

		
		
		
		
		/*JSONParser parser = new JSONParser();
		
        try {

            Object obj = parser.parse(new FileReader("test.json"));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray matches = (JSONArray) jsonObject.get("matches");
            
            Iterator iterator=matches.iterator();
            while(iterator.hasNext()) {
            System.out.println(iterator.next());
            
            }
            
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
        }*/

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
