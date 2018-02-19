package com.dbquerylang.handlers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Executor {
	
	public void execute(ArrayList<QueryParameterclass> al,ArrayList<IPLStats> ipl )
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
        JSONArray winner = new JSONArray();
        JSONArray win_by_runs = new JSONArray();
        JSONArray win_by_wickets = new JSONArray();
        JSONArray player_of_match = new JSONArray();
        JSONArray venue = new JSONArray();
        JSONArray umpire1 = new JSONArray();
        JSONArray umpire2 = new JSONArray();


		Iterator<QueryParameterclass> itr= al.iterator();
		while(itr.hasNext()) {
			QueryParameterclass para=itr.next();
		if(para.getPara().equals("*"))
		{	
			Iterator<IPLStats> itr1=ipl.iterator();
			while(itr1.hasNext()) {
			IPLStats ipls=itr1.next();
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
		else if(para.getPara().equalsIgnoreCase("id")) {
			Iterator<IPLStats> itr1=ipl.iterator();
			while(itr1.hasNext()) {
			IPLStats ipls=itr1.next();
			id.add(ipls.getId());

		}
			obj.put("id", id);

		}
		else if(para.getPara().equalsIgnoreCase("city")) {
			Iterator<IPLStats> itr1=ipl.iterator();
			while(itr1.hasNext()) {
			IPLStats ipls=itr1.next();
			city.add(ipls.getCity());

			}
			obj.put("city", city);	
			
		}
		else if(para.getPara().equalsIgnoreCase("date")) {
			Iterator<IPLStats> itr1=ipl.iterator();
			while(itr1.hasNext()) {
			IPLStats ipls=itr1.next();
			city.add(ipls.getDate());

			}
			obj.put("date", date);	
			
		}
		else if(para.getPara().equalsIgnoreCase("team1")) {
			Iterator<IPLStats> itr1=ipl.iterator();
			while(itr1.hasNext()) {
			IPLStats ipls=itr1.next();
			team1.add(ipls.getTeam1());

			}
			obj.put("team1", team1);	
			
		}
		
		else if(para.getPara().equalsIgnoreCase("team2")) {
			Iterator<IPLStats> itr1=ipl.iterator();
			while(itr1.hasNext()) {
			IPLStats ipls=itr1.next();
			team2.add(ipls.getTeam2());

			}
			obj.put("team2", team2);	
			
		}
		
		else if(para.getPara().equalsIgnoreCase("toss_winner")) {
			Iterator<IPLStats> itr1=ipl.iterator();
			while(itr1.hasNext()) {
			IPLStats ipls=itr1.next();
			toss_winner.add(ipls.getToss_winner());

			}
			obj.put("toss_winner", toss_winner);	
			
		}
		else if(para.getPara().equalsIgnoreCase("toss_decision")) {
			Iterator<IPLStats> itr1=ipl.iterator();
			while(itr1.hasNext()) {
			IPLStats ipls=itr1.next();
			toss_decision.add(ipls.getToss_decision());

			}
			obj.put("toss_decision", toss_decision);	
			
		}
		else if(para.getPara().equalsIgnoreCase("result")) {
			Iterator<IPLStats> itr1=ipl.iterator();
			while(itr1.hasNext()) {
			IPLStats ipls=itr1.next();
			result.add(ipls.getResult());

			}
			obj.put("result", result);	
			
		}
		else if(para.getPara().equalsIgnoreCase("dl_applied")) {
			Iterator<IPLStats> itr1=ipl.iterator();
			while(itr1.hasNext()) {
			IPLStats ipls=itr1.next();
			dl_applied.add(ipls.getDl_applied());

			}
			obj.put("dl_applied", dl_applied);	
			
		}
		else if(para.getPara().equalsIgnoreCase("winner")) {
			Iterator<IPLStats> itr1=ipl.iterator();
			while(itr1.hasNext()) {
			IPLStats ipls=itr1.next();
			winner.add(ipls.getWinner());

			}
			obj.put("winner", winner);	
			
		}
		else if(para.getPara().equalsIgnoreCase("win_by_runs")) {
			Iterator<IPLStats> itr1=ipl.iterator();
			while(itr1.hasNext()) {
			IPLStats ipls=itr1.next();
			win_by_runs.add(ipls.getWin_by_runs());

			}
			obj.put("win_by_runs", win_by_runs);	
			
		}
		else if(para.getPara().equalsIgnoreCase("win_by_wickets")) {
			Iterator<IPLStats> itr1=ipl.iterator();
			while(itr1.hasNext()) {
			IPLStats ipls=itr1.next();
			win_by_wickets.add(ipls.getWin_by_wickets());

			}
			obj.put("win_by_wickets", win_by_wickets);	
			
		}
		else if(para.getPara().equalsIgnoreCase("player_of_match")) {
			Iterator<IPLStats> itr1=ipl.iterator();
			while(itr1.hasNext()) {
			IPLStats ipls=itr1.next();
			player_of_match.add(ipls.getPlayer_of_match());

			}
			obj.put("player_of_match", player_of_match);	
			
		}
		else if(para.getPara().equalsIgnoreCase("venue")) {
			Iterator<IPLStats> itr1=ipl.iterator();
			while(itr1.hasNext()) {
			IPLStats ipls=itr1.next();
			venue.add(ipls.getVenue());

			}
			obj.put("venue", venue);	
			
		}
		else if(para.getPara().equalsIgnoreCase("umpire1")) {
			Iterator<IPLStats> itr1=ipl.iterator();
			while(itr1.hasNext()) {
			IPLStats ipls=itr1.next();
			umpire1.add(ipls.getUmpire1());

			}
			obj.put("umpire1", umpire1);	
			
		}
		else if(para.getPara().equalsIgnoreCase("umpire2")) {
			Iterator<IPLStats> itr1=ipl.iterator();
			while(itr1.hasNext()) {
			IPLStats ipls=itr1.next();
			umpire2.add(ipls.getUmpire2());

			}
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
