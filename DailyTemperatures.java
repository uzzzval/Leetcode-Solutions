class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
    	    int[] returnArray=new int [temperatures.length];
    	    for(int i=0;i<temperatures.length;i++){
    	    	    returnArray[i]=noOfMinimumDays(temperatures,temperatures[i],i);
    	    }
		return returnArray;  
    }
	private int noOfMinimumDays(int[] temperatures, int currentTemp,int position) {
		int count=0;
		boolean found=false;
                int length=temperatures.length;
		for(int i=position+1;i<length;i++) {
		  if(temperatures[i]>currentTemp) {
			  count++;
			  found=true;
			  break;
		  }else {
			    count++;
		  } 
		}
		if(found)
			return count;
		else return 0;
	}      
}
