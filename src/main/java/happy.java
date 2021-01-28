import java.util.ArrayList;
import java.util.Random;

public class happy {
    public static void main(String[] args) {
        Random df = new Random();

//引用nextInt()方法
        int index = 10;

        int[] arr = new int[index];

        boolean flag = true;

        for(int i=0;i<index;i++){
            int number = df.nextInt(80)+1;
            int j=0;
            while (arr[j]!=number){
                j++;
                if(j==index){
                    break;
                }
            }

            if(j==index){
                arr[i]=number;
            }else {
                i--;
            }

        }

        for (int i =0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        for (int i:arr){
            System.out.print(i+",");
        }

    }

}
