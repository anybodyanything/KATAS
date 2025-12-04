
import main.katas.PickPeaks;

public class Main {
    public static void main(String[] args) {
        PickPeaks pickPeaks = new PickPeaks();
        int[] array = {1, 2, 2, 2, 2};
        int[] array2 = {1, 2, 2, 2, 1};
        int[] array3 = {0, 1, 2, 5, 1, 0};
        int[] array4 = {3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3};
        System.out.println(pickPeaks.getPeaks(array));
        System.out.println(pickPeaks.getPeaks(array2));
        System.out.println(pickPeaks.getPeaks(array3));
        System.out.println(pickPeaks.getPeaks(array4));
    }


}
