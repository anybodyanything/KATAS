import katas.LeetCode.RemoveElement;

public class Main {
    public static void main(String[] args) {
        RemoveElement actual = new RemoveElement();
        int[] one = {0,1,1,2,2,4};
        int[] two = {0,1,1,2,2,4};
        int[] three = {0,1,2,2,3,0,4,2};
        int[] four = {0,1,2,2,3,0,4,2};
        int[] nums = {3,3};

        actual.swapWithLast(one, 2);
        actual.swapWithLast(three, 3);

    }


}
