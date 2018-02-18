package com.dbquerylang.handlers;

public class Extract {
	public void extractFile(String arr1[],int l )
	{
		for(int i=1;i<l;i++) {
			if(arr1[i].contains(".csv"))
			{
				System.out.print("\n"+arr1[i]);	
				break;
			}
		
				//
		}
	}
	public void extractBase(String arr1[],int l )
	{
		for(int i=0;i<l;i++) {
			if(arr1[i].equalsIgnoreCase("where"))
			{
			break;	
			}
			System.out.print("\n"+arr1[i]+"\n");
				//
		}
	}
	public void extractFilter(String arr1[],int l )
	{
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
		System.out.print("\n");
		for(int i=1;i<l;i++) {
			if(arr1[i].equalsIgnoreCase("from"))
			{
			break;	
			}
			System.out.print("\n"+arr1[i]);
				//
		}
	}
	
	public void extractOrderBy(String arr1[],int l )
	{
		
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
		
		System.out.print("\n");
		for(int i=0;i<l-1;i++) {
			if(arr1[i].equalsIgnoreCase("group")&&arr1[i+1].equalsIgnoreCase("by"))
			{
				System.out.println(arr1[i+2]+"  ");
			}
				//
		}
	}
	

}
