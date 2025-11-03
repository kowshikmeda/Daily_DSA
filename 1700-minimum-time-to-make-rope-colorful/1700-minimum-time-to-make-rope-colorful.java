class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res = 0, sum = 0, max = 0;
        char curr = '.';

        for(int i=0;i<colors.length();i++){
            if(i == 0){
                curr = colors.charAt(i);
                sum += neededTime[i];
                max = Math.max(max, neededTime[i]);
                continue;
            }

            if(colors.charAt(i) == curr){
                sum+=neededTime[i];
                max = Math.max(max, neededTime[i]);
            } else {
                if(sum!=max)res += (sum-max);
                sum = 0;
                max = 0;
                curr = colors.charAt(i);
                sum += neededTime[i];
                max = Math.max(max, neededTime[i]);
            }

            if(i == colors.length()-1){
                if(sum!=max)res += (sum-max);
            }
        }

        return res;
    }
}