class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

        if(numerator==0) return "0";

        StringBuilder result=new StringBuilder();

        if((numerator<0)^(denominator<0)){
            result.append("-");
        }

        long num=Math.abs((long)numerator); //to avoid overflow
        long den=Math.abs((long)denominator);

        //integer part
        result.append(num/den);
        long remainder=num%den;

        if(remainder==0){
            return result.toString();
        }

        result.append(".");

        //remainder-> index in result
        Map<Long,Integer> map=new HashMap<>();

        while(remainder!=0){
            if(map.containsKey(remainder)){
                //recurring
                int idx=map.get(remainder);
                result.insert(idx,"(");
                result.append(")");
                break;
            }

            map.put(remainder,result.length());
            remainder*=10;
            result.append(remainder/den);
            remainder%=den;
        }

        return result.toString();
        
    }
}