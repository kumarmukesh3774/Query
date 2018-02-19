package com.dbquerylang.handlers;

public class Extract {
	public void extractFile(String arr1[],int l )
	{
		System.out.println("extractFile");	
		for(int i=1;i<l;i++) {
			if(arr1[i].contains(".csv"))
			{
				System.out.print(arr1[i]+"\n");	
				break;
			}
		
				//
		}
	}
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
	public void extractLogical(String arr1[],int l )
	{
		System.out.println("\nextractLogical");	
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
					System.out.print(arr1[i]+"  ");
				}
				else
					System.out.print("\n");
			}
				//
		}
	}
	
	
	public void extractLogicalOperators(String arr1[],int l )
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
					System.out.print(arr1[i]+"  ");
			}
				//
		}
	}
	
	public void extractField(String arr1[],int l )
	{
		System.out.println("\nextractField");	
		for(int i=1;i<l;i++) {
			if(arr1[i].equalsIgnoreCase("from"))
			{
			break;	
			}
			System.out.print(arr1[i]+"\n");
				//
		}
	}
	
	public void extractOrderBy(String arr1[],int l )
	{
		System.out.println("extractOrderBy");
		System.out.print("\n");
		for(int i=0;i<l-1;i++) {
			if(arr1[i].equalsIgnoreCase("order")&&arr1[i+1].equalsIgnoreCase("by"))
			{
				System.out.println(arr1[i+2]+"  ");
			}
			
				//
		}
	}
	public void extractGroupBy(String arr1[],int l )
	{
		System.out.println("extractGroupBy");
		for(int i=0;i<l-1;i++) {
			if(arr1[i].equalsIgnoreCase("group")&&arr1[i+1].equalsIgnoreCase("by"))
			{
				System.out.println(arr1[i+2]+"  ");
			}
				//
		}
	}
	
}
