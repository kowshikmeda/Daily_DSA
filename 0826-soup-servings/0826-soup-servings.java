class Solution {
    Map<String, Double> hm=new HashMap<>();
    public double soupServings(int n) {
        if (n>5000) return 1; // Optimization for large n
        n=(int) Math.ceil(n/25.0);
        return Solve(n, n);
    }
    private double Solve(int a, int b) {
        if(a<=0 && b<=0) return 0.5;
        if(a<=0) return 1.0;
        if(b<=0) return 0.0;
        String key = a+"," +b;
        if (hm.containsKey(key)) return hm.get(key);
        double result = 0.25 * (
            Solve(a - 4, b) +
            Solve(a - 3, b - 1) +
            Solve(a - 2, b - 2) +
            Solve(a - 1, b - 3)
        );
        hm.put(key, result);
        return result;
    }
}