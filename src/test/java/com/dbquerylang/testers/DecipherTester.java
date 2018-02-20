package com.dbquerylang.testers;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.dbquerylang.handlers.Extract;
@RunWith(JUnitPlatform.class)
public class DecipherTester {
	
	Extract ext;
	@BeforeAll
	public static void init() {
		
		System.out.println("called before all testCase");
	}
	@BeforeEach
	public void setup()
	{
		ext= new Extract();
		System.out.println("called before each test case");
		
	}
	/*@Test
	public void testExtractFile()
	{
		ext= new Extract();
		String query[]= {"abc","bcd","ipl.csv"};
		boolean fileName= ext.extractFile(query,2 );
		assertEquals(false, fileName);
		
		System.out.println("called before all testCase");
	}
	@Test
	public void testExtractOrderBy()
	{
		
		
		String query[]= {"abc","bcd","ipl.csv","order by","team1"};
		String fileName= ext.extractOrderBy(query, 5);
		assertEquals(false, fileName);
		
		System.out.println("called before all testCase");
	}*/
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
