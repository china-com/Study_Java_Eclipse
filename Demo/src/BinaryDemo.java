import java.util.Arrays;

public class BinaryDemo {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10,20,50,30,40,80,70,90,60};
		Arrays.sort(arr);
		getIndexByBinarySearch(60,arr);
	}
	
	public static int getIndexByBinarySearch(int searchNum ,int arr[]){
		int count=0;
		int minIndex=0;
		int maxIndex=arr.length-1;
		int middleIndex=(minIndex+maxIndex)/2;
		while(true){
			count++;
			if(searchNum<arr[middleIndex]) {
				maxIndex-=1;
			}else if(searchNum==arr[middleIndex]) {
				System.out.println("找到了"+arr[middleIndex]+"这个数据,下标为："+middleIndex);
				return middleIndex;
			}else {
				minIndex+=1;
			}
			middleIndex=(maxIndex+minIndex)/2;
			if(minIndex>maxIndex) {
				System.out.println("没有找到"+searchNum+"这个数据！");
				return -1;
			}
		}
	}
}
