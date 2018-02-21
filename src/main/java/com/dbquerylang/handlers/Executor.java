package com.dbquerylang.handlers;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Executor {
	
	public boolean verifyOperation(Restrictions operator,IPLStats ipl) {
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
					return true;
					return false;
					
					//System.out.println("<===========<=================<==");
				}
				if(operator.getOperator().equals(">"))
				{
					if(valueInt>=Integer.valueOf(operator.getOperand2()))
					return true;
					return false;
					//System.out.println(">===========>=================<==");

					
				}
				if(operator.getOperator().equals("!"))
				{
					//considering operand2 is m=integer only
					if(valueInt!=Integer.valueOf(operator.getOperand2()))
					return true;
					return false;
					//System.out.println("!===========!=================<==");
					
				}
			}
			else if(operator.getOperator1().equals("")){
				if(operator.getOperator().equals("<"))
				{
					if(valueInt<Integer.valueOf(operator.getOperand2()))
						return true;
						return false;
					//System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					
				}
				if(operator.getOperator().equals(">"))
				{
					if(valueInt>Integer.valueOf(operator.getOperand2()))
						return true;
						return false;
					//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					
				}
				if(operator.getOperator().equals("!"))
				{
					
					//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					
				}
				if(operator.getOperator().equals("="))
				{
					if(Pattern.matches("[a-zA-Z]*", operator.getOperand2()))
					{
						if(value.equalsIgnoreCase(operator.getOperand2()))
						{
							return true;
						}
						return false;
					}
					if(valueInt == Integer.valueOf(operator.getOperand2()))
						return true;
						return false;
					//System.out.println("==============================");

				}
				
			}
		return false;
		
	}
	
	
	
	
	
	
	
	public void execute(ArrayList<QueryParameterclass> al,ArrayList<IPLStats> ipl,
			ArrayList<Restrictions> res,ArrayList<LogicalOperators> or)
	{
		JSONObject obj = new JSONObject();

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
			JSONArray umpire2 = new JSONArray();
		
			


	
		ArrayList<Flags> flagAl=new ArrayList<Flags>();
		
		Iterator<IPLStats> itr1=ipl.iterator();
		while(itr1.hasNext()) {

			IPLStats ipls=itr1.next();
			
			Iterator<Restrictions> itrR=res.iterator();
			while(itrR.hasNext())
			{
				Flags fl=new Flags();
				Restrictions operator=itrR.next();
				fl.setFlag(verifyOperation(operator,ipls));
				flagAl.add(fl);
				
			}
			Iterator<Flags> itrf=flagAl.iterator();
			Iterator<LogicalOperators> itrLo=or.iterator();
			boolean finalFlag=false;
			while(itrf.hasNext())
			{//To be handled
				finalFlag=itrf.next().getFlag();
				while(itrLo.hasNext()) {
				LogicalOperators op=itrLo.next();
				 itrf.next();
				if(finalFlag==true&&op.getOperator().equalsIgnoreCase("and")) {
					
					if(itrf.next().getFlag()==true)
					{
						finalFlag=true;
					}
					else {
						finalFlag=false;
					}
				}else if(finalFlag==false&&op.getOperator().equalsIgnoreCase("and")) {
					
						itrf.next();
						finalFlag=false;
					}
				else if(finalFlag==true&&op.getOperator().equalsIgnoreCase("or")) {
					
						itrf.next();
						finalFlag=true;
					}
				else if(finalFlag==false&&op.getOperator().equalsIgnoreCase("or")) {
					
					if(itrf.next().getFlag()==true)
					{
						finalFlag=true;
					}
					else {
						finalFlag=false;
					}
				}
				}
				
				
				
				
				}
					
				
			//}
			if(finalFlag) {
			
		Iterator<QueryParameterclass> itr3= al.iterator();
		while(itr3.hasNext()) {
			
			QueryParameterclass para=itr3.next();
		if(para.getPara().equals("*"))
		{	
			
			
			id.add(ipls.getId());
			city.add(ipls.getCity());
			date.add(ipls.getDate());
			team1.add(ipls.getTeam1());
			team2.add(ipls.getTeam2());
			toss_winner.add(ipls.getToss_winner());
			toss_decision.add(ipls.getToss_decision());
			result.add(ipls.getResult());
			dl_applied.add(ipls.getDl_applied());
			winner.add(ipls.getWinner());
			win_by_runs.add(ipls.getWin_by_runs());
			win_by_wickets.add(ipls.getWin_by_wickets());
			player_of_match.add(ipls.getPlayer_of_match());
			venue.add(ipls.getVenue());
			umpire1.add(ipls.getUmpire1());
			umpire2.add(ipls.getUmpire2());



		}
		if(para.getPara().equalsIgnoreCase("id")) {
			
			id.add(ipls.getId());

		}
		

		
		 if(para.getPara().equalsIgnoreCase("city")) {
			
			city.add(ipls.getCity());

			}
	
			
		
		 if(para.getPara().equalsIgnoreCase("date")) {
	
			city.add(ipls.getDate());

			}
	
			
		
		if(para.getPara().equalsIgnoreCase("team1")) {
		
			team1.add(ipls.getTeam1());

			}
			
			
		
		
		 if(para.getPara().equalsIgnoreCase("team2")) {

			team2.add(ipls.getTeam2());

			}
		
			
		
		
		 if(para.getPara().equalsIgnoreCase("toss_winner")) {
	
			toss_winner.add(ipls.getToss_winner());

			}
	
			
		
		 if(para.getPara().equalsIgnoreCase("toss_decision")) {
	
			toss_decision.add(ipls.getToss_decision());

			}
	
			
		
		 if(para.getPara().equalsIgnoreCase("result")) {

			result.add(ipls.getResult());

			}
		
			
		
		 if(para.getPara().equalsIgnoreCase("dl_applied")) {

			dl_applied.add(ipls.getDl_applied());

			}
		
			
		
		 if(para.getPara().equalsIgnoreCase("winner")) {

			winner.add(ipls.getWinner());

			}

			
		
		 if(para.getPara().equalsIgnoreCase("win_by_runs")) {

			win_by_runs.add(ipls.getWin_by_runs());

			}
		
		 if(para.getPara().equalsIgnoreCase("win_by_wickets")) {
			win_by_wickets.add(ipls.getWin_by_wickets());

			}
			
		
		 if(para.getPara().equalsIgnoreCase("player_of_match")) {

			player_of_match.add(ipls.getPlayer_of_match());

			}
	
			
		
		 if(para.getPara().equalsIgnoreCase("venue")) {

			venue.add(ipls.getVenue());

			}

			
		
		 if(para.getPara().equalsIgnoreCase("umpire1")) {

			umpire1.add(ipls.getUmpire1());

			}

			
		
		 if(para.getPara().equalsIgnoreCase("umpire2")) {

			umpire2.add(ipls.getUmpire2());
	
			
		}
		
		
		}
		//}
		
		
		
		
		
		Iterator<QueryParameterclass> itr2= al.iterator();
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
		
		
		}
			}
		}

		
        try {
        	FileWriter file = new FileWriter("test.json");

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	

}
