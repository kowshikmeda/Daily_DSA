class Pair{
    int first;
    int second;

}

class StockSpanner {
    Stack<Pair> st=new Stack();
    int idx;
    public StockSpanner() {
        st.clear();
        idx=-1;
    }
    
    public int next(int price) {
       idx=idx+1;
       while(!st.isEmpty() && st.peek().first<=price){
        st.pop();
       } 
       int ans=idx-(st.isEmpty()?-1:st.peek().second);
       Pair p=new Pair();
       p.first=price;
       p.second=idx;
       st.push(p);
       return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */