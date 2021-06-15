import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution {

    private int n;
    private int sum = 0;
    private int maxLog;

    public boolean checkPowersOfThree(int n) {
        
        this.n = n;
        this.maxLog = (int) ((1.0 / Math.log10(3)) * Math.log10(n));
        this.sum = n;
        return isPowerOfThree(maxLog);
    }

    final protected boolean isPowerOfThree(int power) {

        if (this.sum == 0)
            return true;
        if (this.sum < 0)
            return false;
        if (power < 0)
            return false;

        this.sum -= Math.pow(3, power);
        boolean withThisPower = isPowerOfThree(power - 1);
        if (withThisPower)
            return true;
        this.sum += Math.pow(3, power);

        return isPowerOfThree(power - 1);
    }

    public static void main(String[] args) throws Exception {
        
        
    }

    @Test
    public void test() {

        Solution solution = new Solution();
        assertEquals(true, solution.checkPowersOfThree(12));
    }


}
