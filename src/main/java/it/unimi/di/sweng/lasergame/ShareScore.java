package it.unimi.di.sweng.lasergame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Observable; //<----

public class ShareScore extends Observable // <---- aggiunto extends Observable
{
	
	private Integer score = 0; 
	private Integer record = 0;
	
	public ShareScore(int score){
		getRecord();
		setScore(score);
	}
	
	public ShareScore(){
		record = getRecord();
	}
	
	public int getRecord(){
		int newrecord=0;
		if(!new File("src/myscore.txt").exists()){
			record=newrecord;
			return newrecord;
		}
		try(BufferedReader br = new BufferedReader(new FileReader("src/myscore.txt"))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	if(line.contains("RECORD: ")){
		    		line = line.substring(8, line.length());
		    		newrecord = Integer.parseInt(line); 
		    	}
		    	
		    }
		}catch(IOException e){
			e.printStackTrace();
		}
		record=newrecord;
		return newrecord;
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int score){
		this.score = score;
		setNewRecord(score);
		
		this.setChanged(); //<----
		this.notifyObservers(score); //<----
	}
	
	public void setNewRecord(int newrecord){
		if(newrecord>record) 
			record = newrecord;
	}
	
	public void share(){
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
