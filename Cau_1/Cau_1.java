package Cau_1;

public class Cau_1 {
    public static void result(int a[]){
        int count = 0;
        for (int i = 0; i < a.length ; i++) {
            if (a[i] % 3 == 0){
                count++;
                System.out.print(a[i] + "\t");
            }
        }
        if (count == 0){
            System.out.println("\nKhong co so chia het cho 3");
        }
    }

    public static void main(String[] args) {
        int a[] = {2,34,1,1,5,12,18,63,89,4,99};
        int b[] = {2,34,1,1,5,89,4};
        result(a);
        result(b);
    }
}
