class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        List myList=new ArrayList();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                myList.add(matrix[i][j]);
            }
        }
        Collections.sort(myList);
        System.out.println(myList);
        int value =Integer.parseInt(myList.get(k-1).toString());
        return value;
    }
}
