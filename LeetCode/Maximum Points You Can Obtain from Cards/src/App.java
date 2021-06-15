class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int resSum = 0;
        int minResSum = 0;
        int start = 0;
        int resSize = cardPoints.length - k;

        for (int i = 0; i < resSize; i++)
        {
            resSum += cardPoints[i];
        }

        int totalCount = 0;

        for (int i : cardPoints)
        {
            totalCount += i;
        }
        minResSum = resSum;

        for (int end = resSize; end < cardPoints.length; end++)
        {
            resSum -= cardPoints[start++];
            resSum += cardPoints[end];
            minResSum = resSum < minResSum ? resSum : minResSum;
        }


        return totalCount - minResSum;

    }
}


public class App {
    public static void main(String[] args) throws Exception {
        
        Solution

    }
}
