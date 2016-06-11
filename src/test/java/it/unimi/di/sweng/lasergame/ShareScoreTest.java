package it.unimi.di.sweng.lasergame;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Test;

public class ShareScoreTest {
	
	@After 
	public void deleteOutputFile() {
        File f = new File("src/myscore.txt");
		f.delete();
	}
	

	@Test
	public void testGets() {
		ShareScore s = new ShareScore();
		assertEquals(0,s.getRecord());
		s = new ShareScore(20);
		assertEquals(20,s.getScore());
	}
	
	@Test
	public void testFile(){
		ShareScore s = new ShareScore(20);
		s.setNewRecord(300);
		s.share();
		String result="";
		try(BufferedReader br = new BufferedReader(new FileReader("src/myscore.txt"))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	result=result.concat(line+'\n');
		    }
		}catch(IOException e){
			e.printStackTrace();
		}
		result=result.trim();
		assertEquals("Punteggio attuale: 20\nRECORD: 300",result);
	}
	
	@Test
	public void testRecordFromFile(){
		//caso 1
		ShareScore s = new ShareScore(200);
		s.share();
		assertEquals(200,s.getRecord());
		//caso 2
		s.setScore(400);
		s.share();
		assertEquals(400,s.getRecord());
		//caso 3
		s.setScore(100);
		s.share();
		assertEquals(400,s.getRecord());
	}

}
