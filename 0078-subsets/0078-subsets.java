class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //your code goes here
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> currSubset=new ArrayList<>();
        generate(nums,0,currSubset,res);
        return res;
    }
    void generate(int []nums,int idx,List<Integer> currSubset,List<List<Integer>> res){
        if(nums.length==idx){
            res.add(new ArrayList<>(currSubset));
            return ;
        }
        generate(nums,idx+1,currSubset,res);
        currSubset.add(nums[idx]);
        generate(nums,idx+1,currSubset,res);
        currSubset.remove(currSubset.size()-1);
    }
}