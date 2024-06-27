import java.util.Arrays;

public class MinProduct3num {

  /*
   * 
   * * Find minimum product among all combinations of triplets in an array
   * https://www.techiedelight.com/find-minimum-product-triplets-array/
   */
  public static int minProduct(int[] arr) {
    int product = 1;
    if (arr.length == 0) {
      return product;
    } else if (arr.length <= 3) {
      for (int i = 0; i < arr.length; i++) {
        product = product * arr[i];
      }
      return product;
    }
  int min3[]=new int[3];
	int max3[]=new int[3];
	for(int i=0;i<3;i++){
		min3[i]=arr[i];
		max3[i]=arr[i];
	}
  Arrays.sort(min3); //O(9) bubble sort
	Arrays.sort(max3); //O(9) bubble sort
	int minMul1=Integer.MIN_VALUE,minMul2=Integer.MIN_VALUE;
      for(int i=3;i<arr.length;i++){
        if(arr[i]<=min3[0] ){
          min3[2]=min3[1];
          min3[1]=min3[0];
          min3[0]=arr[i];
        }else if(arr[i]<=min3[1]){
          min3[2]=min3[1];
          min3[1]=arr[i];
        }else if(arr[i]<=min3[2]){
          min3[2]=arr[i];
        }
        if(arr[i]>=max3[2]){
          max3[0]=max3[1];
          max3[1]=max3[2];
          max3[2]=arr[i];
        } else if(arr[i]>=max3[1]){
          max3[0]=max3[1];
          max3[1]=arr[i];
        }else if(arr[i]>=max3[0]){
          max3[0]=arr[i];
        }
      }
    
    //2 pos/neg and a 0
  System.out.println(Arrays.toString(min3));
  System.out.println(Arrays.toString(max3));
  product=Math.min(min3[0]*max3[1]*max3[2], min3[0]*min3[1]*min3[2]);
    return product;
  }

  public static void main(String[] args) {
    int arr[]= new int[]{ 3, 4, 1, 2, 5 };
    System.out.println(minProduct( new int[]{ 3, 4, 1, 2, 5 }));
    System.out.println(minProduct( new int[]{1, 4, 10, -2, 4  }));
    System.out.println(minProduct( new int[]{  4, -1, 3, 5, 9 }));
  }
}