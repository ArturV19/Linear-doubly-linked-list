package objects_of_comparable_list;

import doubly_connected_list.ObjectOfComparableList;
import exceptions.ExceptionNotEqualClass;

import java.util.Scanner;

/**
 * Целое число для списка.
 */
public class IntegerOfList implements ObjectOfComparableList {
    private int integer;

    public IntegerOfList(int integer) {
        this.integer = integer;
    }

    @Override
    public int resultOfComparable(Object b) throws ExceptionNotEqualClass {
        IntegerOfList integerOfList;
        if (b.getClass() != IntegerOfList.class) {
            throw new ExceptionNotEqualClass();
        } else {
            integerOfList = (IntegerOfList) b;
        }
        return Integer.compare(this.integer, (integerOfList.integer));
    }

    @Override
    public ObjectOfComparableList getObjectFromKeyboard(Scanner scanner) {
        System.out.println("Введите целое число:");
        int integer = scanner.nextInt();
        return new IntegerOfList(integer);
    }

    @Override
    public String toString() {
        return String.valueOf(integer);
    }
}
