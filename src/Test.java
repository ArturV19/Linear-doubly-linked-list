import doubly_connected_list.LinearDoublyConnectedComparableList;
import objects_of_comparable_list.IntegerOfList;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        IntegerOfList integerOfList = new IntegerOfList(4);

        Scanner scanner = new Scanner(System.in);

        LinearDoublyConnectedComparableList linearDoulbyConnectedComparableList =
                new LinearDoublyConnectedComparableList(scanner, integerOfList);

        System.out.println("g");
    }
}
