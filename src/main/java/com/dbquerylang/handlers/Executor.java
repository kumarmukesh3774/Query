package com.dbquerylang.handlers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Executor {
	
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
		
			


	
		
		
		Iterator<IPLStats> itr1=ipl.iterator();
		while(itr1.hasNext()) {

			IPLStats ipls=itr1.next();
			
			
			Iterator<Restrictions> itrR=res.iterator();
			while(itrR.hasNext())
			{
				Restrictions operator=itrR.next();
				if(operator.getOperator1().equals("="))
				{
					if(operator.getOperator().equals("<"))
					{

					}
					if(operator.getOperator().equals(">"))
					{
						System.out.println("<===========<=================<==");

						
					}
					if(operator.getOperator().equals("!"))
					{
						
						
					}
				}
				else if(operator.getOperator1()==null){
					if(operator.getOperator().equals("<"))
					{
						
						
					}
					if(operator.getOperator().equals(">"))
					{
						
						
					}
					if(operator.getOperator().equals("!"))
					{
						
						
					}
					if(operator.getOperator().equals("="))
					{
						System.out.println("==============================");
	
					}
					
				}
				
			}
		
			
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
			obj.put("id", id);

		
		 if(para.getPara().equalsIgnoreCase("city")) {
			
			city.add(ipls.getCity());

			}
			obj.put("city", city);	
			
		
		 if(para.getPara().equalsIgnoreCase("date")) {
	
			city.add(ipls.getDate());

			}
			obj.put("date", date);	
			
		
		if(para.getPara().equalsIgnoreCase("team1")) {
		
			team1.add(ipls.getTeam1());

			}
			obj.put("team1", team1);	
			
		
		
		 if(para.getPara().equalsIgnoreCase("team2")) {

			team2.add(ipls.getTeam2());

			}
			obj.put("team2", team2);	
			
		
		
		 if(para.getPara().equalsIgnoreCase("toss_winner")) {
	
			toss_winner.add(ipls.getToss_winner());

			}
			obj.put("toss_winner", toss_winner);	
			
		
		 if(para.getPara().equalsIgnoreCase("toss_decision")) {
	
			toss_decision.add(ipls.getToss_decision());

			}
			obj.put("toss_decision", toss_decision);	
			
		
		 if(para.getPara().equalsIgnoreCase("result")) {

			result.add(ipls.getResult());

			}
			obj.put("result", result);	
			
		
		 if(para.getPara().equalsIgnoreCase("dl_applied")) {

			dl_applied.add(ipls.getDl_applied());

			}
			obj.put("dl_applied", dl_applied);	
			
		
		 if(para.getPara().equalsIgnoreCase("winner")) {

			winner.add(ipls.getWinner());

			}
			obj.put("winner", winner);	
			
		
		 if(para.getPara().equalsIgnoreCase("win_by_runs")) {

			win_by_runs.add(ipls.getWin_by_runs());

			}
			obj.put("win_by_runs", win_by_runs);	
			
		
		 if(para.getPara().equalsIgnoreCase("win_by_wickets")) {
			win_by_wickets.add(ipls.getWin_by_wickets());

			}
			obj.put("win_by_wickets", win_by_wickets);	
			
		
		 if(para.getPara().equalsIgnoreCase("player_of_match")) {

			player_of_match.add(ipls.getPlayer_of_match());

			}
			obj.put("player_of_match", player_of_match);	
			
		
		 if(para.getPara().equalsIgnoreCase("venue")) {

			venue.add(ipls.getVenue());

			}
			obj.put("venue", venue);	
			
		
		 if(para.getPara().equalsIgnoreCase("umpire1")) {

			umpire1.add(ipls.getUmpire1());

			}
			obj.put("umpire1", umpire1);	
			
		
		 if(para.getPara().equalsIgnoreCase("umpire2")) {

			umpire2.add(ipls.getUmpire2());

			
			obj.put("umpire2", umpire2);	
			
		}
		
		
		}
		}
		
		
		
		
		
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

		
        try {
        	FileWriter file = new FileWriter("test.json");

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	

}
