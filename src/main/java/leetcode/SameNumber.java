package leetcode;

/**
 * @author Mr_chen
 * @date 2020-10-22
 * @Project algorithm
 **/
public class SameNumber {
    public static void main(String[] args) {
      int [] numbers = new int[]{1,2,4,3,3};
      System.out.println(findTheSameNumbers(numbers));
    }

    public static int findTheSameNumbers(int []numbers){
        int result = -1;

        int begin = 0;
        int end = numbers.length -1;
        while (begin <= end){
            if(begin==end){
                return begin;
            }
            int mid = (begin+end) >> 1;
            int count = countRange(numbers,begin,mid);
            if(count > (mid-begin+1)){
                end = mid;
            }
            else{
                begin = mid+1;
            }
        }

        return result;
    }

    private static  int countRange(int [] numbers,int begin, int end){
        int count = 0;
        for (int number:numbers) {
            if(number>=begin && number<=end) {
                ++count;
            }

        }
        return count;
    }

}
