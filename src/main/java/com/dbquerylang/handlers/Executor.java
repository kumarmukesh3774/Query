package com.dbquerylang.handlers;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;
import java.util.regex.Pattern;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Executor {
	
	public int verifyOperation(Restrictions operator,IPLStats ipl) {
			String value=null;
			int valueInt=0;
			Date date=null;
			if(operator.getOperand1().equalsIgnoreCase("id")) {
				
				valueInt=ipl.getId();

			}
			if(operator.getOperand1().equalsIgnoreCase("city")) {
				
				value=ipl.getCity();

			}
			if(operator.getOperand1().equalsIgnoreCase("date")) {
				
				date=ipl.getDate();

			}
			if(operator.getOperand1().equalsIgnoreCase("team1")) {
				
				value=ipl.getTeam1();

			}
			if(operator.getOperand1().equalsIgnoreCase("team2")) {
				
				value=ipl.getTeam2();

			}
			if(operator.getOperand1().equalsIgnoreCase("toss_winner")) {
				
				value=ipl.getToss_winner();

			}
			if(operator.getOperand1().equalsIgnoreCase("toss_decision")) {
				
				value=ipl.getToss_decision();

			}
			if(operator.getOperand1().equalsIgnoreCase("result")) {
				
				value=ipl.getResult();

			}
			if(operator.getOperand1().equalsIgnoreCase("dl_applied")) {
				
				valueInt=ipl.getDl_applied();

			}
			if(operator.getOperand1().equalsIgnoreCase("winner")) {
				
				value=ipl.getWinner();

			}
			if(operator.getOperand1().equalsIgnoreCase("win_by_runs")) {
				
				valueInt=ipl.getWin_by_runs();

			}
			if(operator.getOperand1().equalsIgnoreCase("win_by_wickets")) {
				
				valueInt=ipl.getWin_by_wickets();

			}
			if(operator.getOperand1().equalsIgnoreCase("player_of_match")) {
				
				value=ipl.getPlayer_of_match();

			}
			if(operator.getOperand1().equalsIgnoreCase("venue")) {
				
				value=ipl.getVenue();

			}
			if(operator.getOperand1().equalsIgnoreCase("umpire1")) {
				
				value=ipl.getUmpire1();

			}
			if(operator.getOperand1().equalsIgnoreCase("umpire2")) {
				
				value=ipl.getUmpire2();

			}
			
			

			
			
			
			
			if(operator.getOperator1().equals("="))
			{
				if(operator.getOperator().equals("<"))
				{
					if(valueInt<=Integer.valueOf(operator.getOperand2()))
					return 1;
					return 0;
					
					//System.out.println("<===========<=================<==");
				}
				if(operator.getOperator().equals(">"))
				{
					if(valueInt>=Integer.valueOf(operator.getOperand2()))
					return 1;
					return 0;
					//System.out.println(">===========>=================<==");

					
				}
				if(operator.getOperator().equals("!"))
				{
					//considering operand2 is m=integer only
					if(valueInt!=Integer.valueOf(operator.getOperand2()))
					return 1;
					return 0;
					//System.out.println("!===========!=================<==");
					
				}
			}
			else if(operator.getOperator1().equals("")){
				if(operator.getOperator().equals("<"))
				{
					if(valueInt<Integer.valueOf(operator.getOperand2()))
						return 1;
						return 0;
					//System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					
				}
				if(operator.getOperator().equals(">"))
				{
					if(valueInt>Integer.valueOf(operator.getOperand2()))
						return 1;
						return 0;
					//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					
				}
				if(operator.getOperator().equals("!"))
				{
					
					//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					
				}
				if(operator.getOperator().equals("="))
				{
					
					if(Pattern.matches("[a-zA-Z]*", operator.getOperand2().substring(0, 2)))
					{
						if(value.equalsIgnoreCase(operator.getOperand2()))
						{
							return 1;
						}
						return 0;
					}
					if(valueInt == Integer.valueOf(operator.getOperand2()))
						return 1;
						return 0;
					//System.out.println("==============================");

				}
				
			}
		return 0;
		
	}
	
	
	
	
	
	
	
	public void execute(ArrayList<QueryParameterclass> al,ArrayList<IPLStats> ipl,
			ArrayList<Restrictions> res,ArrayList<LogicalOperators> or)
	{
		
        try {
        	FileWriter file = new FileWriter("test.json");

          
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject object=new JSONObject();
        JSONArray match = new JSONArray();
		/*JSONObject obj = new JSONObject();

			JSONArray id = new JSONArray();
			JSONArray city = new JSONArray();
			JSONArray date = new JSONArray();
			JSONArray team1 = new JSONArray();
			JSONArray team2 = new JSONArray();
			JSONArray toss_winner = new JSONArray();
			JSONArray toss_decision = new JSONArray();
			JSONArray result = new JSONArray();
			JSONArray dl_applied = new JSONArray();
			JSONArray  winner = new JSONArray();
			JSONArray win_by_runs = new JSONArray();
			JSONArray win_by_wickets = new JSONArray();
			JSONArray player_of_match = new JSONArray();
			JSONArray venue = new JSONArray();
			JSONArray umpire1 = new JSONArray();
			JSONArray umpire2 = new JSONArray();*/
		
			

			Stack st = new Stack();
			

			
	
		ArrayList<Flags> flagAl=new ArrayList<Flags>();
		
		Iterator<IPLStats> itr1=ipl.iterator();
		int i=0;
		int finalFlag=0;
		while(itr1.hasNext()) {

			IPLStats ipls=itr1.next();
			//System.out.println("======================================");
			Iterator<LogicalOperators> itrLo=or.iterator();

			Iterator<Restrictions> itrR=res.iterator();
			Restrictions operator=null;
			//creating a stack of logical operators and operands of the conditions
			while(itrR.hasNext())
			{
				/*Flags fl=new Flags();
				Restrictions operator=itrR.next();
				fl.setFlag(verifyOperation(operator,ipls));
				flagAl.add(fl);*/
				
				operator=itrR.next();
				int fl=verifyOperation(operator,ipls);
				
				st.push(new Integer(fl));
				//System.out.println(st.peek());
				if(itrLo.hasNext()) {
					LogicalOperators lop=itrLo.next();
					//System.out.println(itrLo.next().getOperator().equalsIgnoreCase("and"));
				if(lop.getOperator().equalsIgnoreCase("and")) {
					st.push(new Integer(2));
					//System.out.println(st.peek());	
				}
				else if(lop.getOperator().equalsIgnoreCase("or")) {
					st.push(new Integer(-2));
					//System.out.println(st.peek());
				}
				}
				//System.out.println(st.peek());
				
				//System.out.println(fl.getFlag()+" "+i++);
			
				
			}
			//System.out.println("===================================="+st.empty());
			while(!st.empty()) {
				//System.out.println((Integer)st.pop());
				try{
					int log=0;
					int flag1Int=(Integer)st.pop();
					boolean flag1=(flag1Int==1)?true:false;
					//System.out.println(st.empty());

					if(st.empty())
					{
						break;
					}
					
						log=(Integer)st.pop();
						//System.out.println(st.peek());	
				
			
					
				if(log==2 ) {
					boolean flag2=((Integer)st.pop()==1)?true:false;
					//System.out.println(st.peek());
					if(flag1&&flag2) {
						finalFlag=1;
					}
					else {
						finalFlag=0;
					}
						
				}
				if(log==-2 ) {
					boolean flag2=((Integer)st.pop()==1)?true:false;
					//System.out.println(st.peek());
					if(flag1||flag2) {
						finalFlag=1;
					}
					else {
						finalFlag=0;
					}
						
				}
				//System.out.println(finalFlag);
				//System.out.println(st.empty());

				if(st.empty()) {
					break;
				}
				st.push(new Integer(finalFlag));
				//System.out.println(st.peek());


			}catch(EmptyStackException e){
				
				System.out.println("Empty Stack");
			}
				
			}
			//System.out.println(finalFlag+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+ i++);
				
					
			
			//}
			
			if(finalFlag==1) {
				JSONObject obj=obj = new JSONObject();
				
		Iterator<QueryParameterclass> itr3= al.iterator();
		while(itr3.hasNext()) {
			 
			QueryParameterclass para=itr3.next();
		if(para.getPara().equals("*"))
		{	
			
			
			obj.put("id",ipls.getId());
			obj.put("city",ipls.getCity());
			obj.put("date",ipls.getDate().toString());
			obj.put("team1",ipls.getTeam1());
			obj.put("team2",ipls.getTeam2());
			obj.put("toss_winner", ipls.getToss_winner());
			obj.put("toss_decision", ipls.getToss_decision());
			obj.put("result", ipls.getResult());	
			obj.put("dl_applied", ipls.getDl_applied());
			obj.put("winner", ipls.getWinner());
			obj.put("win_by_runs", ipls.getWin_by_runs());
			obj.put("win_by_wickets", ipls.getWin_by_wickets());
			obj.put("player_of_match", ipls.getPlayer_of_match());
			obj.put("venue", ipls.getVenue());
			obj.put("umpire1", ipls.getUmpire1());
			obj.put("umpire2", ipls.getUmpire2());
			


		}
		if(para.getPara().equalsIgnoreCase("id")) {

			obj.put("id",ipls.getId());
		}
		

		
		 if(para.getPara().equalsIgnoreCase("city")) {
			
				obj.put("city",ipls.getCity());

			}
	
			
		
		 if(para.getPara().equalsIgnoreCase("date")) {
	
				obj.put("date",ipls.getDate().toString());

			}
	
			
		
		if(para.getPara().equalsIgnoreCase("team1")) {
		

			obj.put("team1",ipls.getTeam1());

		}	
			
		
		
		 if(para.getPara().equalsIgnoreCase("team2")) {


				obj.put("team2",ipls.getTeam2());

			}
		
			
		
		
		 if(para.getPara().equalsIgnoreCase("toss_winner")) {
	
				obj.put("toss_winner", ipls.getToss_winner());

			}
	
			
		
		 if(para.getPara().equalsIgnoreCase("toss_decision")) {
	
				obj.put("toss_decision", ipls.getToss_decision());

			}
	
			
		
		 if(para.getPara().equalsIgnoreCase("result")) {

				obj.put("result", ipls.getResult());	

			}
		
			
		
		 if(para.getPara().equalsIgnoreCase("dl_applied")) {

				obj.put("dl_applied", ipls.getDl_applied());

		
		 }
		
		 if(para.getPara().equalsIgnoreCase("winner")) {

				obj.put("winner", ipls.getWinner());
			
			}

			
		
		 if(para.getPara().equalsIgnoreCase("win_by_runs")) {

				obj.put("win_by_runs", ipls.getWin_by_runs());
			}
		
		 if(para.getPara().equalsIgnoreCase("win_by_wickets")) {
				obj.put("win_by_wickets", ipls.getWin_by_wickets());

			}
			
		
		 if(para.getPara().equalsIgnoreCase("player_of_match")) {

				obj.put("player_of_match", ipls.getPlayer_of_match());

			}
	
			
		
		 if(para.getPara().equalsIgnoreCase("venue")) {

				obj.put("venue", ipls.getVenue());

			}

			
		
		 if(para.getPara().equalsIgnoreCase("umpire1")) {

				obj.put("umpire1", ipls.getUmpire1());
		
			}

			
		
		 if(para.getPara().equalsIgnoreCase("umpire2")) {

				obj.put("umpire2", ipls.getUmpire2());	
			
		}
		 
		
		
		}
		match.add(obj);
		object.put("matches", match);
		System.out.println("\n");

		
		
		
		
		//}
		
		
		
		
		
		/*Iterator<QueryParameterclass> itr2= al.iterator();
		while(itr2.hasNext()) {
			
			QueryParameterclass para=itr2.next();
			
		if(para.getPara().equals("*"))
		{	


			obj.put("id", id);
			obj.put("city", city);
			obj.put("date", date);
			obj.put("team1", team1);
			obj.put("team2", team2);
			obj.put("toss_winner", toss_winner);
			obj.put("toss_decision", toss_decision);
			obj.put("result", result);
			obj.put("dl_applied", dl_applied);
			obj.put("winner", winner);
			obj.put("win_by_runs", win_by_runs);
			obj.put("win_by_wickets", win_by_wickets);
			obj.put("player_of_match", player_of_match);
			obj.put("venue", venue);
			obj.put("umpire1", umpire1);
			obj.put("umpire2", umpire2);

		}
		if(para.getPara().equalsIgnoreCase("id")) {

			obj.put("id", id);
		}

		
		 if(para.getPara().equalsIgnoreCase("city")) {
			
				obj.put("city", city);	
			}
		
			
		
		 if(para.getPara().equalsIgnoreCase("date")) {
	
				obj.put("date", date);	

			}
			
		
		if(para.getPara().equalsIgnoreCase("team1")) {
		
			obj.put("team1", team1);	

			}
			
		
		
		 if(para.getPara().equalsIgnoreCase("team2")) {

				obj.put("team2", team2);	

			}
			
		
		
		 if(para.getPara().equalsIgnoreCase("toss_winner")) {
	
				obj.put("toss_winner", toss_winner);	

			}
			
		
		 if(para.getPara().equalsIgnoreCase("toss_decision")) {
	
				obj.put("toss_decision", toss_decision);	

			}
			
		
		 if(para.getPara().equalsIgnoreCase("result")) {

				obj.put("result", result);	

			}
			
		
		 if(para.getPara().equalsIgnoreCase("dl_applied")) {

				obj.put("dl_applied", dl_applied);	

			}
			
		
		 if(para.getPara().equalsIgnoreCase("winner")) {

				obj.put("winner", winner);	

			}
			
		
		 if(para.getPara().equalsIgnoreCase("win_by_runs")) {

				obj.put("win_by_runs", win_by_runs);	

			}
			
		
		 if(para.getPara().equalsIgnoreCase("win_by_wickets")) {
				obj.put("win_by_wickets", win_by_wickets);	

			}
			
		
		 if(para.getPara().equalsIgnoreCase("player_of_match")) {

				obj.put("player_of_match", player_of_match);	

			}
			
		
		 if(para.getPara().equalsIgnoreCase("venue")) {

				obj.put("venue", venue);	

			}
			
		
		 if(para.getPara().equalsIgnoreCase("umpire1")) {

				obj.put("umpire1", umpire1);	

			}
			
		
		 if(para.getPara().equalsIgnoreCase("umpire2")) {

				obj.put("umpire2", umpire2);	
			
		 	}
		
		
		}*/
			}
			

			
			
		}
        try {
        	FileWriter file = new FileWriter("test.json",true);

            file.write(object.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

		

		
	}
	

}
