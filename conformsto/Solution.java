package conformsto;

class Solution {
    private boolean conformsTo(int a, int b){
        return (a & b) == b;
    }
    public int solution(int A, int B, int C) {
        
        final int maxMask = 0x3fffffff; 
        A &= maxMask;
        B &= maxMask;
        C &= maxMask;
        int mask = ~(A & B & C) & 0x3fffffff;
        
        final int maxNumberOfBits = 30;
        for (int i = 0; i < maxNumberOfBits; i++) {
            if((mask & 1) == 0){
                mask = mask >> 1;
                A >>= 1;
                B >>= 1;
                C >>= 1;
            }
            else
                break;
        }
        A &= mask;
        B &= mask;
        C &= mask;
        int count = 0;
        while(mask != 0){
            if(conformsTo(mask, A) || conformsTo(mask, B) || conformsTo(mask, C))
                count++;
            mask--;
        }
        return count;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(1_073_741_727, 1_073_741_631, 1_073_741_679));
    }
}