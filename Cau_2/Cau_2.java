package Cau_2;

public class Cau_2 {
    public static boolean checkPrime(int n) {
        if (n < 2) {
            return false;
        } else
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        return true;
    }

    public static int sumPrime(int a[][]) {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (checkPrime(a[i][j]) == true) {
                    sum += a[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int a[][] = {{2, 2, 3}, {1, 2, 3}};
        int b[][] = {{-2, 22, -3}, {1, 22, -3}};
        int sum = sumPrime(a);
        int sum1 = sumPrime(b);
        if (sum == 0){
            System.out.println("Khong co so nguyen to");
        }else
            System.out.println(sum);
        if (sum1 == 0){
            System.out.println("Khong co so nguyen to");
        }else
            System.out.println(sum1);
    }
}
