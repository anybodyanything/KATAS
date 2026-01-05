import katas.LeetCode.RemoveElement;
import katas.LeetCode.TestStudy;

public class Main {
    public static void main(String[] args) {
        RemoveElement actual = new RemoveElement();
        TestStudy testStudy = new TestStudy();
        int[] one = {0,1,1,2,2,4};
        int[] two = {0,1,1,2,2,4};
        int[] three = {0,1,2,2,3,0,4,2};
        int[] four = {0,1,2,2,3,0,4,2};
        int[] nums = {3,3};

        actual.swapWithLast(one, 2);
        testStudy.removeElement(two, 2);
        actual.swapWithLast(three, 3);
        testStudy.removeElement(four, 3);

    }


}
