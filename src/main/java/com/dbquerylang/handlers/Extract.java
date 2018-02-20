package com.dbquerylang.handlers;

import java.util.ArrayList;

public class Extract {
	
	//file name extractin and validation
	public boolean extractFile(String arr1[],int l )
	{
		boolean flag=false;
		System.out.println("extractFile");	
		for(int i=1;i<l;i++) {
			if(arr1[i].contains(".csv"))
			{
				flag=true;
				System.out.print(arr1[i]+"\n");	
				break;
			}
		
				//
		}
		if(flag==false)
		{
			System.out.println("File Not Valid In the Query");
		}
		return flag;
	}
	
	//base query extraction
	public void extractBase(String arr1[],int l )
	{
		System.out.println("extractBase");	
		for(int i=0;i<l;i++) {
			if(arr1[i].equalsIgnoreCase("where"))
			{
			break;	
			}
			System.out.print(arr1[i]+"\n");
				//
		}
	}
	//filter extraction
	public void extractFilter(String arr1[],int l )
	{
		System.out.println("extractFilter");	
		int flag=100;
		System.out.print("\n");
		for(int i=0;i<l;i++) {
			if(arr1[i].equalsIgnoreCase("where"))
			{
			flag=i;;	
			}
			if(i>flag)
			System.out.print(arr1[i]+"  ");
				//
		}
	}
	//Logical operation extraction
	public ArrayList<Restrictions> extractLogical(String arr1[],int l )
	{
		System.out.println("\nextractLogical");	
		int flag=100;
		ArrayList<Restrictions> al=null;
		for(int i=0;i<l;i++) {
			if(arr1[i].equalsIgnoreCase("Order")||
					arr1[i].equalsIgnoreCase("group"))
			{
				
				break;
			}
			if(arr1[i].equalsIgnoreCase("where"))
			{
			flag=i;;	
			}
			if(i>flag)
			{
				if(!(arr1[i].equalsIgnoreCase("and")||
						arr1[i].equalsIgnoreCase("or")||
						arr1[i].equalsIgnoreCase("not")||
						arr1[i].equalsIgnoreCase("&&")||
						arr1[i].equalsIgnoreCase("||")||
						arr1[i].equalsIgnoreCase("!")
						))		{
					
					
						Restrictions res= new Restrictions();
						al= new ArrayList<Restrictions>();
						res.setOperand1(arr1[i++]);
						//Code to be checked
						if((arr1[i].equals("<")&&arr1[i+1].equals("="))||
								(arr1[i].equals(">")&&arr1[i+1].equals("="))||
								(arr1[i].equals("!")&&arr1[i+1].equals("="))) {
							
							res.setOperator(arr1[i++]);
							res.setOperator1(arr1[i++]);
						}
						else
						res.setOperator(arr1[i++]);
						res.setOperand2(arr1[i]);
						al.add(res);
						if(res.getOperator1().equals(""))
						System.out.print(res.getOperand1()+" "+res.getOperator()+" "+res.getOperand2());
						else
							System.out.print(res.getOperand1()+" "+res.getOperator()+res.getOperator1()+" "+res.getOperand2());
						
				}
				else
					System.out.print("\n");
			}
				//
		}
	 return al;
	}
	
	//Logical Operators
	public ArrayList<LogicalOperators> extractLogicalOperators(String arr1[],int l )
	{
		System.out.println("\nextractLogicalOperators");	
		int flag=100;
		System.out.print("\n");
		for(int i=0;i<l;i++) {
			if(arr1[i].equalsIgnoreCase("where"))
			{
			flag=i;;	
			}
			if(i>flag)
			{
				if(!(arr1[i].equalsIgnoreCase("and")||
						arr1[i].equalsIgnoreCase("or")||
						arr1[i].equalsIgnoreCase("not")||
						arr1[i].equalsIgnoreCase("&&")||
						arr1[i].equalsIgnoreCase("||")||
						arr1[i].equalsIgnoreCase("!")))
				{
					//System.out.print(arr1[i]+"  ");
				}
				else
				{
					ArrayList<LogicalOperators> al= new ArrayList<LogicalOperators>();
					LogicalOperators operators= new LogicalOperators();
					operators.setOperator(arr1[i]);
					al.add(operators);
					System.out.print(operators.getOperator()+"  ");
					return al;
			}
			}
				//
		}
		return null;
	}
	//Query Fields
	public ArrayList<QueryParameterclass> extractField(String arr1[],int l )
	{
		ArrayList<QueryParameterclass> al= new ArrayList<QueryParameterclass>();
		System.out.println("\nextractField");	
		for(int i=1;i<l;i++) {
			if(arr1[i].equalsIgnoreCase("from"))
			{
			break;	
			}
			if(!(arr1[i].contains("sum(")||
					arr1[i].contains("min(")||
					arr1[i].contains("max(")||
					arr1[i].contains("avg(")||
					arr1[i].contains("count(")
					))
			{
				
				QueryParameterclass para=new QueryParameterclass();
				para.setPara(arr1[i]);
				al.add(para);
				System.out.print(para.getPara()+"\n");	
			}
		
			//System.out.print(arr1[i]+"\n");
				//
		}
		return al;
	}
	
	public String extractOrderBy(String arr1[],int l )
	{
		System.out.println("extractOrderBy");
		for(int i=0;i<l-1;i++) {
			if(arr1[i].equalsIgnoreCase("order")&&arr1[i+1].equalsIgnoreCase("by"))
			{
				OrderBy or= new OrderBy();
				or.setOrderBy(arr1[i+2]);
				System.out.println(or.getOrderBy()+"  ");
				return or.getOrderBy();
			}
			
				//
		}
		return null;
	}
	public String extractGroupBy(String arr1[],int l )
	{
		System.out.println("extractGroupBy");
		for(int i=0;i<l-1;i++) {
			if(arr1[i].equalsIgnoreCase("group")&&arr1[i+1].equalsIgnoreCase("by"))
			{
				GroupBy gr= new GroupBy();
				gr.setGroupBy(arr1[i+2]);
				System.out.println(gr.getGroupBy()+"  ");
				return gr.getGroupBy();
			}
				//
		}
		return null;
	}
	public void extractAggregate(String arr1[],int l )
	{
		System.out.println("extractAggregate");	
		for(int i=1;i<l;i++) {
			if(arr1[i].contains("sum(")||
					arr1[i].contains("min(")||
					arr1[i].contains("max(")||
					arr1[i].contains("avg(")||
					arr1[i].contains("count(")
					)
			{
				ArrayList<AggregateFunctions> al= new ArrayList<AggregateFunctions>();
				AggregateFunctions agr= new AggregateFunctions();
				agr.setFunc(arr1[i]);
				al.add(agr);
				System.out.print(agr.getFunc()+"\n");	
				
			}
		
				//
		}
		
	}
	
}
