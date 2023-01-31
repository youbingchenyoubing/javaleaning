package leetcode;

/**
 * @author Mr_chen
 * @date 2020-10-20
 * @Project algorithm
 **/
public class Sort {

    public static  int search(int[] nums, int target) {
        //[A,B] if  mid in A if mid in B if mid in AB
        int result  = -1;
        int begin = 0;
        int end = nums.length -1;
        while(begin<=end){
            int mid = (begin+end)/2;
            if(target == nums[mid]) {
                return mid;
            }
            if(target == nums[begin]){
                return begin;
            }
            if(target == nums[end]){
                return end;
            }
            //正常情况 落在B
            if(nums[begin]< nums[mid] && nums[mid] < nums[end]){
                if(target>nums[mid]){
                    begin = mid+1;
                }
                else{
                    end=mid-1;
                }
            }
            //正常情况，落在A
            else if(nums[begin]> nums[mid] && nums[mid]> nums[end]){
                if(target > nums[mid]){
                    end = mid-1;
                }
                else{
                    begin = mid+1;
                }
            }
            // 交叉情况，落在B
            else if(nums[begin]>nums[mid] && nums[mid]<nums[end]){
                if(target < nums[mid]){
                    end = mid-1;
                }
                else if(target<nums[end]){
                    begin = mid+1;
                }
                else{
                    end = mid -1;
                }
            }
            // 交叉情况，落在A
            else{
                if(target > nums[mid]){
                    begin = mid +1;
                }
                else if(target < nums[begin]){
                    begin = mid +1;
                }
                else{
                    end = mid-1;
                }
            }

        }
        return result;

    }

    public static void main(String[] args) {
        int [] nums = new int[]{5,1,3};
        int target = 3;
        System.out.println(search(nums,target));
    }
}

//5,6,7,1,2,3,4