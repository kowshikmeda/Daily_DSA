class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] original = digits(n);
        Arrays.sort(original);
        for (int i = 0; i < 31; i++) {
            int[] power = digits(1 << i);
            Arrays.sort(power);
            if (Arrays.equals(original, power))
                return true;
        }
        return false;
    }

    int[] digits(int x) {
        int[] d = new int[10];
        int len = 0;
        while (x > 0) {
            d[len++] = x % 10;
            x /= 10;
        }
        return Arrays.copyOf(d, len);
    }
}