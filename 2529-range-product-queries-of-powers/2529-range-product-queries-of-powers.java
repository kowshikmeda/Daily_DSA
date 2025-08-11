class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int[] res = new int[queries.length]; 
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < 32; i++){
            if ((int) Math.pow(2, i) <= n){
                pos.add((int) Math.pow(2, i)); 
            } else {
                break; 
            }
        } 
        List<Integer> arr = new ArrayList<>(); 
        int sum = 0; 
        int index = pos.size() - 1; 
        while (sum < n){
            if (sum + pos.get(index) <= n){
                arr.add(pos.get(index)); 
                sum += pos.get(index); 
            } else {
                index--; 
            }
        }
        int[] powers = new int[arr.size()]; 
        for (int i = arr.size() - 1; i >= 0; i--){
            powers[arr.size() - 1 - i] = arr.get(i); 
        }
        //System.out.println(Arrays.toString(powers));
        long[] segment = new long[4 * powers.length]; 
        build(segment, powers, 0, powers.length - 1, 1);
        //System.out.println(Arrays.toString(segment));
        for (int i = 0; i < res.length; i++){ 
            res[i] = (int) (locate(segment, 1, 0, powers.length - 1, queries[i][0], queries[i][1]) % (long) 1000000007);
        }  
        return res; 
    }

    private void build(long[] segment, int[] powers, int l, int r, int index){
        if (l == r){
            segment[index] = powers[l]; 
        } else {
            int mid = l + (r - l)/2; 
            build(segment, powers, l, mid, index * 2); 
            build(segment, powers, mid + 1, r, index * 2 + 1); 
            segment[index] = ((segment[index * 2] % (long) 1000000007) * (segment[index * 2 + 1])  % (long) 1000000007) % (long) 1000000007; 
        }
    }

    private long locate(long[] segment, int index, int l, int r, int tl, int tr){
        if (tl <= l && tr >= r){
            return segment[index]; 
        } else {
            int mid = l + (r - l)/2; 
            long left = 1; 
            long right = 1; 
            if (tl <= mid){
                left = locate(segment, index * 2, l, mid, tl, tr); 
            } 
            if (tr >= mid + 1){
                right = locate(segment, index * 2 + 1, mid + 1, r, tl, tr); 
            }
            return ((left % (long) 1000000007) * (right % (long) 1000000007)) % (long) 1000000007; 
        }
    }
}