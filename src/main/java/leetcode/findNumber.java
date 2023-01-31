package leetcode;

/**
 * @author Mr_chen
 * @date 2020-10-24
 * @Project algorithm
 **/
public class findNumber {

    public static void main(String[] args) {
        int module = ((int)Math.pow(10,9)+7);
        System.out.println(module);
        numWays(46);
    }

    public static  int numWays(int n) {
        if(n ==0 ) {return 1;}
        int f = 1;
        int g = 2;
        int module = ((int)Math.pow(10,9)+7);
        while(--n>0){
            g=f+g;
            f=g-f;
            if(f > module){
                f = f % module;
            }
            if(g > module){
                g = g%module;
            }
        }

        return f;
    }
}



