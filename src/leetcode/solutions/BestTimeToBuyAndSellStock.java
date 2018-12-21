package leetcode.solutions;

class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int length=prices.length;
        if(length==0) return 0;
        int lowest=prices[0];
        int diff=0;
        for(int i=1;i<length;i++){
            if(prices[i]>lowest){
                if(prices[i]-lowest>diff){
                    diff=prices[i]-lowest;
                }
            }else{
                lowest=prices[i];
            }
        }
        return diff;
    }
}
