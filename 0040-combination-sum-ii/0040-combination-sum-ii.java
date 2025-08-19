class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

       Arrays.sort(candidates);
       find(candidates,0,target,result,ans);
       return result;
    }
      public static void find(int[] candidates,int start,int target,List<List<Integer>> result,List<Integer> ans)
    {
        if(target == 0)
        {
            result.add(new ArrayList<>(ans));
            return;
        }

        for(int i = start;i<candidates.length;i++)
        {
            if( i  >start && candidates[i] == candidates[i - 1]) continue;
            if(candidates[i] <= target)
            {
                target -= candidates[i];
                ans.add(candidates[i]);

                find(candidates,i+1,target,result,ans);

                target += candidates[i];
                ans.remove(ans.size()-1);
            }
        }
        return;
    }
}