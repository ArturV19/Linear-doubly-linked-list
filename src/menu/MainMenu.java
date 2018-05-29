package menu;

import doubly_connected_list.LinearDoublyConnectedComparableList;
import doubly_connected_list.ObjectOfComparableList;
import doubly_connected_list.WorkWithList;
import exceptions.ExceptionNotEqualClass;
import objects_of_comparable_list.IntegerOfList;

import java.util.Scanner;

/**
 * Главное меню программы.
 */
public class MainMenu {

    /**
     * Запуск главного меню.
     */
    public static void run() throws ExceptionNotEqualClass {
        System.out.println("Начало работы программы:");

        System.out.println("Вы хотите создать список?");
        System.out.println("1 - да");
        System.out.println("другое число - нет");

        Scanner scanner = new Scanner(System.in);

        int userChoice = scanner.nextInt();

        //Если пользователь ввёл не единицу, то произойдёт выход из главного меню:
        if (userChoice != 1) {
            return;
        }

        ObjectOfComparableList objectOfComparableList = getObjectOfComparableList(scanner);

        LinearDoublyConnectedComparableList linearDoublyConnectedComparableList =
                new LinearDoublyConnectedComparableList(scanner, objectOfComparableList);

        System.out.println("\n\nВы хотите продолжить работу со списком?");
        System.out.println("1 - да");
        System.out.println("другое число - нет");

        //Если пользователь ввёл не единицу, то произойдёт очистка списка и выход из главного меню:
        if (userChoice != 1) {
            linearDoublyConnectedComparableList.clear();
            return;
        }

        System.out.println("Работа со списком:");
        while (true) {
            System.out.println("\nЧто Вы хотите сделать?");
            System.out.println("1 - поиск элемента с заданным значением информационного поля.");
            System.out.println("2 - удаление элемента с заданным значением информационного поля.");
            System.out.println("3 - добавление элемента в список.");
            System.out.println("4 - вывод на экран длины списка.");
            System.out.println("5 - выяснить, является ли список пустым.");
            System.out.println("6 - проверка списка на упорядоченность по возрастанию.");
            System.out.println("7 - проверка списка на упорядоченность по убыванию.");
            System.out.println("8 - вывод списка на экран.");
            System.out.println("Другое число - выход из программы.\n");

            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1: {
                    try {
                        WorkWithList.searchElement(linearDoublyConnectedComparableList, scanner);
                    } catch (ExceptionNotEqualClass exceptionNotEqualClass) {
                        exceptionNotEqualClass.printStackTrace();
                    }
                    break;
                }
                case 2: {
                    try {
                        WorkWithList.deleteElement(linearDoublyConnectedComparableList, scanner);
                    } catch (ExceptionNotEqualClass exceptionNotEqualClass) {
                        exceptionNotEqualClass.printStackTrace();
                    }
                    break;
                }
                case 3: {
                    WorkWithList.addElementInList(linearDoublyConnectedComparableList, scanner);
                    break;
                }
                case 4: {
                    System.out.println("Длина списка = " + WorkWithList.getLengthOfList(linearDoublyConnectedComparableList));
                    break;
                }
                case 5: {
                    if (WorkWithList.listIsNotEmpty(linearDoublyConnectedComparableList)) {
                        System.out.println("Список не пуст.");
                    } else {
                        System.out.println("Список пуст.");
                    }
                    break;
                }
                case 6: {
                    if (WorkWithList.listIsNotEmpty(linearDoublyConnectedComparableList)) {
                        try {
                            if (WorkWithList.checkListForOrderAscending(linearDoublyConnectedComparableList)) {
                                System.out.println("Список упорядочен по возрастанию.");
                            } else {
                                System.out.println("Список НЕ упорядочен по возрастанию.");
                            }
                        } catch (ExceptionNotEqualClass exceptionNotEqualClass) {
                            exceptionNotEqualClass.printStackTrace();
                        }
                    } else {
                        System.out.println("Ошибка! Список пуст!");
                    }
                    break;
                }
                case 7: {
                    if (WorkWithList.listIsNotEmpty(linearDoublyConnectedComparableList)) {
                        try {
                            if (WorkWithList.checkListForOrderDescending(linearDoublyConnectedComparableList)) {
                                System.out.println("Список упорядочен по убыванию.");
                            } else {
                                System.out.println("Список НЕ упорядочен по убыванию.");
                            }
                        } catch (ExceptionNotEqualClass exceptionNotEqualClass) {
                            exceptionNotEqualClass.printStackTrace();
                        }
                    } else {
                        System.out.println("Ошибка! Список пуст!");
                    }
                    break;
                }
                case 8: {
                    System.out.println(linearDoublyConnectedComparableList.toString());
                    break;
                }
                default: {
                    linearDoublyConnectedComparableList.clear();
                    System.out.println("Выход из программы.");
                    System.exit(0);
                    break;
                }
            }
        }
    }

    /**
     * Программное задание первого элемента.
     */
    private static ObjectOfComparableList getObjectOfComparableList(Scanner scanner) {
        System.out.println("Введите первый элемент списка:");

        int integer = scanner.nextInt();

        ObjectOfComparableList integerOfList = new IntegerOfList(integer);
        return integerOfList;
    }
}
