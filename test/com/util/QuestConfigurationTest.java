package com.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuestConfigurationTest {

	@Test
	public void test() {
	
		String s = QuestConfiguration.getAnswerFile();
		
		System.out.println(s);
		assertNotNull(s);
		
		
		//fail("Not yet implemented");
	}

}
