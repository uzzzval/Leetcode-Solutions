package leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		Set rowList=new HashSet();
		Set columnList=new HashSet();

		int length=matrix.length;
		int width=matrix[0].length;

		if(length!=0 && width!=0){
			for(int i=0;i<length;i++){
				for(int j=0;j<width;j++){ 
					if(matrix[i][j]==0){
						rowList.add(i);
						columnList.add(j);
					}
				}
			}
			for(int i=0;i<length;i++){
				for(int j=0;j<width;j++){
					if(rowList.contains(i)){
						matrix[i][j]=0;
					}
          
					if(columnList.contains(j)){
						matrix[i][j]=0;
					}
				}
			}
		}
	}
}
