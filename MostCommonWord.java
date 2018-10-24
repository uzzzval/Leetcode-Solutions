class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String paragraph1 = paragraph.replaceAll(","," ");
        List<String> wordList = Arrays.asList(paragraph1.split(" "));
        List<String> bannedList = Arrays.asList(banned);
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0;i<wordList.size();i++){
            String local = wordList.get(i);
            String newLocal = local.replaceAll("[.,!?:;']","").toLowerCase();
            if(!bannedList.contains(newLocal) && !newLocal.equals("")){
               if(!map.containsKey(newLocal)){
                map.put(newLocal,1);
            }else{
                map.put(newLocal,map.get(newLocal)+1);
            } 
            }
        }
        String most = "";
        int mostValue = 0;
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
           Map.Entry pair = (Map.Entry)it.next();
            int currentValue = Integer.parseInt(pair.getValue()+"");
           if(currentValue>mostValue){
              most = pair.getKey()+"";
              mostValue = currentValue;
           }
               
        }
        System.out.println(map);
        return most;
    }
}
