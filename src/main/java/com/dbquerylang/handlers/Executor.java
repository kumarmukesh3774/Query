package com.dbquerylang.handlers;

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
		if(itr.next().equals("*"))
		{
			Iterator<IPLStats> itr1=ipl.iterator();
			while(itr1.hasNext()) {
			id.add(itr1.next().getId());
			city.add(itr1.next().getCity());
			date.add(itr1.next().getDate());
			team1.add(itr1.next().getTeam1());
			team2.add(itr1.next().getTeam2());
			toss_winner.add(itr1.next().getToss_winner());
			toss_decision.add(itr1.next().getToss_decision());
			result.add(itr1.next().getResult());
			dl_applied.add(itr1.next().getDl_applied());
			winner.add(itr1.next().getWinner());
			win_by_runs.add(itr1.next().getWin_by_runs());
			win_by_wickets.add(itr1.next().getWin_by_wickets());
			player_of_match.add(itr1.next().getPlayer_of_match());
			venue.add(itr1.next().getVenue());
			umpire1.add(itr1.next().getUmpire1());
			umpire2.add(itr1.next().getUmpire2());

		}
		}
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

}
