class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>>list = new ArrayList<>();
    helpr(1,list,new ArrayList<>(),n,k,0);
    return list;
    }
    public void helpr(int st,List<List<Integer>>list,List<Integer>temp,int n,int k,int sum){
        if(temp.size() == k){
           if(sum == n){
            list.add(new ArrayList<>(temp));
           }
           return;
        }
        for(int i=st;i<=9;i++){
         temp.add(i);
         helpr(i+1,list,temp,n,k,sum+i);
         temp.remove(temp.size()-1);
        }
    }
}