package main.katas;

import java.util.ArrayList;

public class ListArray {

    public ArrayList[] getListArray() {
        ArrayList<Integer> listOne = new ArrayList<>();
        listOne.add(1);
        listOne.add(2);
        listOne.add(3);


        ArrayList<Integer> listTwo = new ArrayList<>();
        listTwo.add(4);
        listTwo.add(5);
        listTwo.add(6);

        ArrayList<Integer> listThree = new ArrayList<>();
        listThree.add(7);
        listThree.add(8);
        listThree.add(9);

        ArrayList[] listArray = new ArrayList[3];

        for (int i = 0; i < listArray.length; i++) {
            listArray[i] = new ArrayList<>();
        }

        listArray[0] = listOne;
        listArray[1] = listTwo;
        listArray[2] = listThree;

        return listArray;
    }



}
