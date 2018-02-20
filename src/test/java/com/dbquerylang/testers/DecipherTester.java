package com.dbquerylang.testers;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.*;
import com.dbquerylang.handlers.Extract;

import junit.framework.Assert;

@RunWith(JUnitPlatform.class)
public class DecipherTester {
	
	//Bank bank;
	Extract ext;
	@BeforeAll
	public static void init() {
		
		System.out.println("called before all testCase");
	}
	@BeforeEach
	public void setup()
	{
		//bank= new Bank(); 
		ext= new Extract();
		System.out.println("called before each test case");
		
	}
	@Test
	public void testExtractFile()
	{
		//double balance= bank.deposit(2000);
		//assertEquals(8000, balance);
		String arr1[]= {"aafas","vfbh","hvgkj","ipl.csv","gfghtj"};
		boolean file=ext.extractFile(arr1, 5);
		assertEquals(true, file);
		
		System.out.println("called before all testCase");
	}
	@Test
	public void testExtracGroupBy()
	{
		//double balance= bank.deposit(2000);
		//assertEquals(8000, balance);
		String arr1[]= {"aafas","vfbh","group","by","gfghtj"};
		String file=ext.extractGroupBy(arr1, 5);
		assertEquals("gfghtj", file);
		
		System.out.println("called before all testCase");
	}
	@Test
	public void testExtracOrderBy()
	{
		//double balance= bank.deposit(2000);
		//assertEquals(8000, balance);
		String arr1[]= {"select","*","order","by","id","group","by","city"};
		String file=ext.extractOrderBy(arr1, 8);
		assertEquals("id", file);
		
		System.out.println("called before all testCase");
	}
	@AfterEach
	public void tearDown() {
		ext=null;
		System.out.println("called after testCase");
	}
	@AfterAll
	public static void cleanup() {
		System.out.println("called after all testCase");
		
	}
	
	

}
