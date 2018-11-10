class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        
        int count = 0;
        int length = grid.length;
        int height = grid[0].length;
        int[] row_max = new int[length];
        int[] col_max = new int[height];
        
        for(int i=0;i<length;i++){
            int max_row_val = 0;
            for(int j=0;j<height;j++){
                if(grid[i][j]>max_row_val){
                    max_row_val = grid[i][j];
                }
                
                row_max[i] = max_row_val;
                if(col_max[j]<grid[i][j])
                    col_max[j]=grid[i][j];
                
            }
        }
        
        for(int i=0;i<length;i++){
            int max_row_val = 0;
            for(int j=0;j<height;j++){
                int min = Math.min(col_max[j],row_max[i]);
                if(grid[i][j]<min){
                    count = count + (min - grid[i][j]);
                }
            }
        }
        
        return count;
    }
}
