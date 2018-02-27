package com.dbquerylang.handlers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
//import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import org.json.simple.JSONArray;

public class Query {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ArrayList<IPLStats> al= new ArrayList<IPLStats>();
	
	//String csvFile="/home/mukyadav/Development/STS/Query/src/main/resources/ipl.csv"	;
	String csvFile="/home/sapient/Desktop/Mukesh/SDev/STS/Query/src/main/resources/ipl.csv"	;

	String line="";
	String cvsSplitBy="[,]";
	FileReader file=null;
	BufferedReader br=null;
	try {
		file = new FileReader(csvFile);
		br=new BufferedReader(file);
		try {
			br.readLine();
			while((line = br.readLine()) != null)
			{
				
				String match[]=line.split(cvsSplitBy);
				
				//System.out.println(match[3]);
					IPLStats ipl= new IPLStats();
					
					ipl.setId(match[0]);
					ipl.setSeason(match[1]);
					ipl.setCity(match[2]);
					ipl.setDate(match[3]);
					ipl.setTeam1(match[4]);
					ipl.setTeam2(match[5]);
					ipl.setToss_winner(match[6]);
					ipl.setToss_decision(match[7]);
					ipl.setResult(match[8]);
					ipl.setDl_applied(match[9]);
					ipl.setWinner(match[10]);
					ipl.setWin_by_runs(match[11]);
					ipl.setWin_by_wickets(match[12]);
					ipl.setPlayer_of_match(match[13]);
					//handling , in ""
					if(match[14].contains("\""))
					{	
						
						String ar[]=match[14].split("\"");
						match[14]="";
						for(int k=0;k<ar.length;k++)
						{
							match[14]=match[14]+ar[k]+" ";
						}
						String ar1[]=match[15].split("\"");
						match[14]=match[14]+" ,"+ar1[0];
						match[15]="";
						for(int k=1;k<ar1.length;k++)
						{
							match[15]=match[15]+ar1[k]+" ";
						}
						ipl.setVenue(match[14].trim());
						ipl.setUmpire1(match[16].trim());
						ipl.setUmpire2(match[17]);
						//System.out.println("");
						
					}
					else {

						ipl.setVenue(match[14].trim());
						ipl.setUmpire1(match[15].trim());
					
					ipl.setUmpire2(match[16]);
					}
					//ipl.setUmpire3(match[17]);
					
					al.add(ipl);
					
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

/*	Iterator<IPLStats> itr =al.iterator();
	while(itr.hasNext())
	{
		IPLStats matches=itr.next();
		System.out.println(matches.umpire1);
		
	}*/
	
																							//issue in win_by_runs		
	final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
	String query="select * from ipl.csv where  city ='Delhi' or city ='Bangalore' and  id <20  order by id group by city";
	System.out.println(query);
	//for spllitting and keeping the delimiter
	String arr[]=query.split(String.format(WITH_DELIMITER,"[,'*!<>=\\s]"));
	int j=0,k=arr.length, diff=0;
	String arr1[]=new String[k];
	for(int i=0; i<arr.length;i++)
	{
		/*if(arr[i].contains("'")) {
			arr[i]=arr[i].substring(1,arr[i].length()-1);
			
		}*/
			
		//for removing spaces from the array
		if(arr[i].matches("[',\\s]")) {
			diff++;
			continue;
			}
		
		arr1[j++]=arr[i];
		/*if(arr1[j-1].contains("=")) {
			int l=j;
			while(!(arr1[l].equalsIgnoreCase("and")||
					arr1[l].equalsIgnoreCase("or")||
					arr1[l].equalsIgnoreCase("order")||
					arr1[l].equalsIgnoreCase("group"))) {
			arr1[j]=arr1[j]+" "+arr1[l++]+" ";
			diff++;
			}
		}*/
		
	}
	
	//deciphering the query
	ArrayList<Restrictions> re=null;
	ArrayList<LogicalOperators> or=null;
	
	Extract ex=new Extract();
	boolean fileCheck=ex.extractFile(arr1,arr1.length-diff );
	if(fileCheck) {
	ex.extractBase(arr1,arr1.length-diff );
	boolean flag=ex.extractFilter(arr1,arr1.length-diff );
	ArrayList<QueryParameterclass> paraList= ex.extractField(arr1,arr1.length-diff );
	if(flag) {
	 re=ex.extractLogical(arr1,arr1.length-diff );
	 or=ex.extractLogicalOperators(arr1,arr1.length-diff );
	
	ex.extractOrderBy(arr1,arr1.length-diff );
	ex.extractGroupBy(arr1,arr1.length-diff );
	ex.extractAggregate(arr1,arr1.length-diff );}
	//executing the base 
	Executor exec=new Executor();
	exec.execute(paraList, al,re,or);
	if(re!=null) {
	//executing based on filter	
	ExecuteLogical execL=new ExecuteLogical();
	try {
		execL.executeLogical(paraList,re, or);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (org.json.simple.parser.ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	}
	/*for(int l=0; l<arr1.length-diff;l++)
	{
		System.out.println(arr1[l]);
		
	}*/
	
	
	
	}

}
