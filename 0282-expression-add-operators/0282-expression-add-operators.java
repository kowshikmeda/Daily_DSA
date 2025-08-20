class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        dfs(num,target,0,0,0,"",result);
        return result;
    }
    public void dfs(String num, int target, int index, long calc, long prevOpherand, String path, List<String> result){

        if(index==num.length()){
            if(calc==target){
                result.add(path);
            }
            return;
        }

        for(int i=index;i<num.length();i++){
            if(i!=index && num.charAt(index)=='0'){
                break;
            }

            String currentStr = num.substring(index,i+1);
            long current = Long.parseLong(currentStr);

            if(index==0){
                dfs(num,target,i+1,current,current,currentStr,result);
            }else{
                dfs(num,target,i+1,calc+current,current,path+"+"+currentStr,result);

                dfs(num,target,i+1,calc-current,-current,path+"-"+currentStr,result);


                dfs(num,target,i+1,calc-prevOpherand+prevOpherand* current,prevOpherand* current,path+"*"+currentStr,result);
            }
        }
    }
}