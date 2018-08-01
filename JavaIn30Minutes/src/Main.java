public class Main {

    public static void main(String[] args) {
        int[] arr = new int[3];// 0,0,0

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println("-------------");
        arr[0] = 1;
        arr[1] = 10;
        arr[2] = 20;

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}