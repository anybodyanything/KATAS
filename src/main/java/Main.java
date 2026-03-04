import katas.LeetCode.easy.ContainsDuplicate;


public class Main {
    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();

        System.out.println(containsDuplicate.containsNearbyDuplicate(new int[]{-1, -1}, 1));
        System.out.println(containsDuplicate.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(containsDuplicate.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));

    }

}
