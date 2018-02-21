class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        
        Map map=new HashMap();
        map.put('U',0);
        map.put('D',0);
        map.put('R',0);
        map.put('L',0);
        for(int i=0;i<moves.length();i++){
            if(map.get(moves.charAt(i))!=null){
                int count=Integer.parseInt(map.get(moves.charAt(i)).toString());
                map.put(moves.charAt(i),count+1);
            }
        }
       
        int right=Integer.parseInt(map.get('R').toString());
        int left=Integer.parseInt(map.get('L').toString());
        int up=Integer.parseInt(map.get('U').toString());
        int down=Integer.parseInt(map.get('D').toString());
        
        if(right==left && up==down)
           return true;
        else 
           return false;
        
    }
}
