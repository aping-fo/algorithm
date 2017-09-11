package algorithm;

/**
 * Created by aping.foo
 * 2个字符串最长公共字串
 */
public class Exercise18 {

    public static void main(String[] args) {
        String s1 = "abcdefghijklmnop";
        String s2 = "abcsafjklmnopqrstuvw";
        func(s1,s2);
    }


    /**
     * 首先大家想到的方法可能是使用一个双层遍历的方式
     * 即外层长字符串，内层短字符串对比
     * 下面首先来采用这种常规方法
     *
     * @param s1
     * @param s2
     */
    public static void func(String s1, String s2) {
        String max = s1.length() >= s2.length() ? s1 : s2;
        String min = s1.length() >= s2.length() ? s2 : s1;

        int l = 0;
        String s = "";
        for (int i = 0; i < min.length(); i++) { //从第0个元素开始
            for (int j = i + 1; j <= min.length(); j++) {
                if(!max.contains(min.substring(i, j))){
                    //如果不包含改字串，提前退出该层循环
                    break;
                }
                if (max.contains(min.substring(i, j)) && j - i > l) {
                    l = j - i; //长度
                    s = min.substring(i, j);
                }
            }
        }
        System.out.println(s);
    }
}
