package it.unimi.di.sweng.lasergame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ShareScore {
	
	Integer score = null; 
	Integer record = null;
	public ShareScore(int score){
		this.score = score;
		record = getRecord();
	}
	
	public ShareScore(){
		record = getRecord();
	}
	
	public int getRecord(){
		int record=0;
		if(!new File("src/myscore.txt").exists()){
			return record;
		}
		try(BufferedReader br = new BufferedReader(new FileReader("src/myscore.txt"))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	System.out.println(line);
		    }
		}catch(IOException e){
			e.printStackTrace();
		}
		return record;
	}
	
	public int getScore(){
		return score;
	}
	
	public void setNewRecord(int newrecord){
		record = newrecord;
	}
	
	public void Share(){
		try{
			String content1 = "Punteggio attuale: ";
			String content2 = "RECORD: ";
			File file = new File("src/myscore.txt");
			
			if(!file.exists()){
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content1+score+"\n");
			bw.write(content2+record);
			bw.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
