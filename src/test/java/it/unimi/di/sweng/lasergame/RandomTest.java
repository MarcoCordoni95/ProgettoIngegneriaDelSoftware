package it.unimi.di.sweng.lasergame;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.mockito.Mockito;

import Model.RandomCells;





public class RandomTest {
	@Rule
	public Timeout globalTimeout = Timeout.seconds(2); // 2 seconds max
	
	
	@Test
	public void RandomTest(){
		RandomCells rand=new RandomCells();
		
		CellStrategy[][] board={{null,null,null,null,null},
								{null,null,null,null,null},
								{null,null,null,null,null},
								{null,null,null,null,null},
								{null,null,null,null,null}};
		
		
        
       board=rand.filler(board);
       
       for(int r=0;r<5;r++)
    	   for(int c=0;c<5;c++){
    		   
    		   assertThat(board[r][c]).isNotEqualTo(null);
    		   
    	   }
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
