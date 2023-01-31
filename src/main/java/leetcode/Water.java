package leetcode;

/**
 * @author Mr_chen
 * @date 2020-10-22
 * @Project algorithm
 **/
public class Water {
    public static void main(String[] args) {
        int [] temp = new int[]{5,4,1,2};
        System.out.println(trap(temp));
    }
    public static int trap(int[] height) {
        int sum = 0;
        int begin = findBegin(height,0);
        int end = findEnd(height,begin);
        while (begin<end && end <height.length){

            int temp = caculate(begin,end,height);
            if(temp>0) {
                sum += temp;
            }
            begin = end;
            end = findEnd(height,begin);
        }
        return sum;
    }
    private static  int findBegin(int []height,int begin){
        while (begin<height.length-1 && 0 == height[begin]){
            begin++;
        }
        return begin;
    }

    private static int findEnd(int[] height,int begin){
        int end = begin +1;
        if(end >= height.length -1){
            return (height.length-1);
        }
        int max = height[end];
        int maxIndex = end;
        while(end <height.length-1 && height[begin] > height[end]){
            end+=1;
            if(height[end] >=max){
                max = height[end];
                maxIndex = end;
            }
        }
        if(end==height.length-1 && height[begin] > height[end]){
            return  maxIndex;
        }
        return end;
    }

    private static int caculate(int begin,int end,int[]numbers){
        System.out.println(String.format("begin:%d,end:%d",begin,end));
        int length = end - begin-1;
        int height = Math.min(numbers[begin],numbers[end]);

        int sum =  length * height;
        for(int i = begin+1; i< end; ++i){
            sum -=numbers[i];
        }
        System.out.println("sum"+sum);
        return sum;
    }

}
