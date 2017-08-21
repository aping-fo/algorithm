package algorithm;

/**
 * Created by aping.foo
 * N的阶乘末尾有多少个O
 *
 */
public class Exercise14 {

    public static void main(String[] args) {
        int n = fun2(20);
        System.out.println(n);
        n = fun1(11);
        System.out.println(n);
    }

    /**
     * 要计算Z，最直接的方法就是求出N的阶乘的所有因式(1,2,3,...,N)分解中5的指数。然后求和
     *时间复杂度 O(N)
     * @param n
     */
    private static int fun1(int n) {
        int num = 0;
        int i, j;

        for (i = 5; i <= n; i += 5) {
            j = i;
            while (j % 5 == 0) {
                num++;
                j /= 5;
            }
        }
        return num;
    }


    /**
     * Z = N/5 + N /(5*5) + N/(5*5*5).....直到N/(5的K次方)等于0
     * 公式中 N/5表示不大于N的数中能被5整除的数贡献一个5，N/(5*5)表示不大于N的数中能被25整除的数再贡献一个5.......
     *  时间复杂度 O(logN)
     * @param n
     * @return
     */
    private static int fun2(int n) {
        int num = 0;

        while (n > 0) {
            num += n / 5;
            n = n / 5;
        }

        return num;
    }
}
