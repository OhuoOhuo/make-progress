package arithmetic.leetcode;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class 盛最多水的容器 {

    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int res = Math.min(height[start], height[end]) * (end - start);
        while (start < end) {
            res = Math.max(res, Math.min(height[start], height[end]) * (end - start));
            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1};
        System.out.println(maxArea(arr));
    }

}
