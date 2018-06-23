import java.util.Arrays;

//√∞≈›∑®≈≈–Ú
public class BubbleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10,20,50,30,40,80,70,90,60};
		System.out.println("≈≈–Ú÷Æ«∞£∫"+Arrays.toString(arr));
		int len=arr.length;
		for(int i=0;i<len-1;i++) {
			for(int j=0;j<len-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp;
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		System.out.println("≈≈–Ú÷Æ∫Û£∫"+Arrays.toString(arr));
	}
}