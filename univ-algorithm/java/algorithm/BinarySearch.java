public class BinarySearch {
    public static void main(String[] args) {
        Integer[] list = new Integer[]{12, 25, 37, 43, 51, 64, 77, 84, 95};

        int index = binarySearch(list, 0, list.length - 1, 37);
        if (index == -1) {
            System.out.println("값이 없습니다.");
        } else {
            System.out.println("값은 " + index + "위치에 있습니다.");
        }
    }

    private static int binarySearch(Integer[] list, int low, int high, int x) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (x == list[mid]) {
            return mid;
        } else if (x < list[mid]) {
            return binarySearch(list, low, mid - 1, x);
        } else {
            return binarySearch(list, mid + 1, high, x);
        }
    }
}
