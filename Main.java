import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,0,-1};
        List<List<Integer>> res = (new Solution()).threeSum(nums);
    }
}

class Solution{
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if(nums[0] > 0 || nums.length < 3) return res;
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1;
            int R = nums.length - 1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while(nums[L] == nums[L-1] && L-1 != i) L++;
                    while(nums[R-1] == nums[R] && R-1 != i) R--;
                    L++;
                    R--;
                }
                else if(sum < 0) L++;
                else R--;
            }
        }
        return res;
    }
}
