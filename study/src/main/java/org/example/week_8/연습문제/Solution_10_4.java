package org.example.week_8.연습문제;

public class Solution_10_4 {
    int search(Listy list, int value) {
        int index = 1;
        while (list.elementAt(index) != -1 && list.elementAt(index) < value) {
            index *= 2;
        }
        return binarySearch(list, value, index / 2, index);
    }

    int binarySearch(Listy list, int value, int low, int high) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            int middle = list.elementAt(mid);
            if (middle > value || middle == -1) {
                high = mid - 1;
            } else if (middle < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    class Listy{
        int length;
        public int elementAt(int index){
            if(length < index){
                return -1;
            }
            return index;
        }
    }
}
