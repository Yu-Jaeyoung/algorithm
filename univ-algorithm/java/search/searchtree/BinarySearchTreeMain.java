package searchtree;

import java.util.Scanner;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        while (true) {
            String input = scanner.next();
            if (input.equals("exit")) {
                break;
            }

            int value = Integer.parseInt(input);
            bst.insert(value);
        }

        bst.print();

        System.out.println("검색하고자 하는 값은 ?");
        int foundValue = scanner.nextInt();
        TreeNode<Integer> search = bst.search(foundValue);

        if (search == null) {
            System.out.println("없음");
        } else {
            System.out.println(search.item);
        }

        scanner.close();
    }
}
