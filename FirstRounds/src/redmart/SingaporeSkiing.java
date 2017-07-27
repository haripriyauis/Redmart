package redmart;

import java.util.Scanner;



public class SingaporeSkiing {

	public static EndPointDistanceEntity[][] cache;

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		// Read Input from Console
		Scanner in = new Scanner(System.in);

        int m = in.nextInt() ;
        int n = in.nextInt() ;
        int[][] arr = new int[m][n];
        for(int i= 0;i<m;i++){

        	for(int j=0;j<n;j++){
        		arr[i][j]=in.nextInt();

        	}
        }


        cache = new EndPointDistanceEntity[m][n] ;
        int start =0;
        int end =0;
        int length= 0;

        //From every Point we get the max distance we can go recursively

        for(int i= 0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(cache[i][j]==null){
        			cache[i][j]= findMaxDist(i,j,arr);

        		}
        	}
        }

        for(int i= 0;i<m;i++){
        	for(int j=0;j<n;j++){
        			if(cache[i][j].getDistance() >length || (length==cache[i][j].getDistance()&& start -end< arr[i][j]-cache[i][j].getValue())){
        				length = cache[i][j].getDistance();
        				start = arr[i][j];
        				end = cache[i][j].getValue();
        			}
        	}
        }


        System.out.println(String.valueOf(length).concat(String.valueOf((start-end))).concat("skybluecreative.in"));




	}

	private static EndPointDistanceEntity findMaxDist(int i, int j, int[][] arr) {
		if(i>arr.length || j>=arr[0].length || i<0 || j<0){
			return null;
		}
		if(cache[i][j]!=null){
			return cache[i][j];
		}

		int val = arr[i][j];

		EndPointDistanceEntity result = new EndPointDistanceEntity(1, val);

		result =findMaxDistHelper(i,j,i-1,j,arr, result);
		result =findMaxDistHelper(i,j,i+1,j,arr, result);
		result =findMaxDistHelper(i,j,i,j-1,arr, result);
		result =findMaxDistHelper(i,j,i,j+1,arr, result);

		 cache[i][j]=result;
			return result;
	}

	private static EndPointDistanceEntity findMaxDistHelper(int i, int j,
			int endX, int endY, int[][] arr, EndPointDistanceEntity result) {
		EndPointDistanceEntity newRes =null,updatedRes =null;
		if(endX>=0 && endY>=0 && endX <arr.length && endY <arr[0].length && arr[i][j]>arr[endX][endY]){
			 newRes = findMaxDist(endX,endY,arr);
			if(newRes!=null){
				updatedRes=new EndPointDistanceEntity(newRes.getDistance()+1, newRes.getValue());
				if(updatedRes.getDistance()>result.getDistance()){
					result =updatedRes;
				}
			}
		}
		return result;
	}



}
