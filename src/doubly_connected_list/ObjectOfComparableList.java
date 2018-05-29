package doubly_connected_list;

import exceptions.ExceptionNotEqualClass;

import java.util.Scanner;

/**
 * Интерефейс позволяет объектам классов, реализующих его (данный интерфейс)
 * быть частью линейного двусвязного списка.
 */
public interface ObjectOfComparableList {

    /**
     * Результат сравнения.
     *
     * @param b - другой объект для сравнения.
     * @return - результат сравнения:
     * -1 - первый объект меньше
     * 0 - объекты равны
     * 1 - первый объект больше
     * @throws ExceptionNotEqualClass - если сравниваемые объекты разных классов.
     */
    int resultOfComparable(Object b) throws ExceptionNotEqualClass;

    /**
     * Получение элемента с клавиатуры.
     *
     * @return - введённый элемент.
     */
    ObjectOfComparableList getObjectFromKeyboard(Scanner scanner);
}
