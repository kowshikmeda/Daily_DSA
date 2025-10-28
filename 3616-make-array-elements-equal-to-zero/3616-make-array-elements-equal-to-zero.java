class Solution {
    public int countValidSelections(int[] nums) {
        int validSelec = 0;
        int suffixSum = 0;
        for(int num : nums){
            suffixSum += num;
        }
        int prefixSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                if(prefixSum - suffixSum == 1 || prefixSum - suffixSum == 0){
                    validSelec++;
                }
                if(suffixSum - prefixSum == 1 || suffixSum - prefixSum == 0){
                    validSelec++;
                }
            }else{
                prefixSum += nums[i];
                suffixSum -= nums[i];
            }
        }
        return validSelec;
    }
}