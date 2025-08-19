class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

       find(candidates,0,target,result,ans);
       return result;  
    }
     public static void find(int[] candidates,int start,int target,List<List<Integer>> result,List<Integer> ans)
    {
        int n = candidates.length;
        if(start == n)
        {
            if(target == 0)result.add(new ArrayList<>(ans));
            return;
        }

            if(candidates[start] <= target)
            {
                target -= candidates[start];
                ans.add(candidates[start]);

                find(candidates,start,target,result,ans);

                target += candidates[start];
                ans.remove(ans.size()-1);
            }
            find(candidates,start+1,target,result,ans);
    }
}