package ex06array;

public class Rank {

	void totRank() {
	
		
		int rank[]=new int[5];
		Array01 ar=new Array01();
		
		
		//석차
		  for(int i = 0 ; i < 5 ; i++){
			  	
			   for(int j = 1; j < 5 ; j++){
				   if(ar.total[i] < ar.total[j]) {
					   rank[i] = rank[i]+1;
				   }
			       else if(ar.total[i] == ar.total[j])
			    	   rank[i] = rank[i];
			   		}
			   System.out.print("석차:"+(rank[i]+1));
			  }
		  
	}

}

