import java.util.Arrays;

public class KthsSmallestTwoSworted {
/*
 * Find kths smallest element of two sworted arrays in O(n+m)
 */
	public static void main(String[] args) {
		int[] a = new int[] { 0, 2, 6, 9, 12, 13, 18, 20 };
		int[] b = new int[] { 1, 5, 14, 17, 19 };
		int k = 7; // 12 zuruck
		int m = 8;
		int n = 5;
		int[][] ranges=new int[][] {{0,m-1},{0,n-1}};
		
		System.out.println(kthSmallest(a,b,ranges,k,0));
	}
	public static int kthSmallest(int[] a,int[] b,int[][] ranges,int k,int x) {
		int mid1=(ranges[0][0]+ranges[0][1])/2;
		int mid2=(ranges[1][0]+ranges[1][1])/2;
		System.out.print("mid1="+mid1+" ,"+a[mid1]+", ");
		System.out.print("mid2="+mid2+" ,"+b[mid2]+", ");
		System.out.print("k="+k+", ");
		System.out.println(Arrays.deepToString(ranges));
		if(x==10) {
			return 0;
		}
		if (k==0) {
				Math.min(a[ranges[0][0]],b[ranges[1][0]]);
		}
		if(a[mid1]>b[mid2]) {
			if(k<(ranges[1][1]-ranges[1][0])/2) {
				ranges[1][1]=mid2-1;
			}else {
				k=k-((mid2+1)-ranges[1][0]);
				ranges[1][0]=mid2+1;
			}
		}else {
			if(k<(ranges[0][1]-ranges[0][0])/2) {
				ranges[0][1]=mid1-1;
			}else {
				k=k-((mid1+1)-ranges[0][0]);
				ranges[0][0]=mid1+1;
			}
		}
		return kthSmallest(a,b,ranges,k,x+1);
		
	}

}
