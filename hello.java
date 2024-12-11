import java.util.Scanner;

class hello {

    static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fact(n - 1);

    }

    static void fib(int n) {
        int a = 0;
        int b = 1;
        int c;
        System.out.print(a + " ");
        System.out.print(b + " ");
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    static void arm(int n) {
        int sum = 0;
        int temp = n;
        while (n > 0) {
            int rem = n % 10;
            sum = sum + (rem * rem * rem);
            n = n / 10;
        }
        if (temp == sum) {
            System.out.println("Armstrong");
        } else {
            System.out.println("Not Armstrong");
        }
    }

    static void prime(int n) {
        int flag = 0;
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }
    }

    public static void main(String[] args) {
        System.out.println(fact(5));
        fib(10);
        System.out.println();
        arm(154);
        prime(7);
    }
}