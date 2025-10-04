package dev.padjokej.intro;

public class Prime {
    public static void main(String[] args) {
        if (args.length < 1)
            return;
        int nMax = Integer.parseInt(args[0]);

        long startTime = System.currentTimeMillis();
        for (int i = 2; i <= nMax; i++) {
            boolean a = (!isPair(i) && isPrime(i));
                //System.out.println(i);
        }
        long delta = (System.currentTimeMillis() - startTime);
        System.out.println("Time to execute : " + delta / 1000.0 + "s");
    }

    static boolean isPair(int n) {
        return (n % 2 == 0);
    }

    static boolean isDivisor(int a, int b) {
        return (a % b == 0);
    }

    static boolean isPrime(int a) {
        for (int i = 3; i * i < a; i++) {
            if (!isPair(i) && isDivisor(a, i)) {
                return false;
            }
        }
        return true;
    }
}
