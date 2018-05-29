package doubly_connected_list;

import exceptions.ExceptionNotEqualClass;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Набор статических методов для работы с
 * линейным двусвязным списком.
 */
public class WorkWithList {

    /**
     * Поиск элемента с заданным значением информационного поля.
     *
     * @param linearDoublyConnectedComparableList - линейный двусвязный список.
     */
    public static void searchElement(
            LinearDoublyConnectedComparableList linearDoublyConnectedComparableList,
            Scanner scanner)
            throws ExceptionNotEqualClass {

        //Если список пуст:
        if (!listIsNotEmpty(linearDoublyConnectedComparableList)) {
            System.out.println("Ошибка! Список пуст!");
            return;
        }

        //Индексы искомых элементов:
        ArrayList<Integer> indexes =
                getIndexesOfTheDesiredElements(linearDoublyConnectedComparableList, scanner);

        //В зависимости от того, сколько было найдено элементов:
        switch (indexes.size()) {
            case 0: {
                System.out.println("Элементов с заданным значением информационного поля не найдено.");
                break;
            }
            case 1: {
                System.out.println("В списке присутствует единственный элемент с заданным значением информационного поля.");
                System.out.println("Это элемент с индексом: " + indexes.get(0) + " (индексация начинается с нуля).");
                break;
            }
            case 2: {
                System.out.println("В списке присутствует несколько элементов с заданным значением информационного поля.");
                System.out.println("Это элементы с индексами: " + indexes.toString() + " (индексация начинается с нуля).");
            }
        }
    }


    /**
     * Удаление элемента с заданным значением информационного поля.
     *
     * @param linearDoublyConnectedComparableList - линейный двусвязный список.
     */
    public static void deleteElement(
            LinearDoublyConnectedComparableList linearDoublyConnectedComparableList,
            Scanner scanner)
            throws ExceptionNotEqualClass {

        //Если список пуст:
        if (!listIsNotEmpty(linearDoublyConnectedComparableList)) {
            System.out.println("Ошибка! Список пуст!");
            return;
        }

        //Индексы искомых элементов:
        ArrayList<Integer> indexes =
                getIndexesOfTheDesiredElements(linearDoublyConnectedComparableList, scanner);

        //В зависимости от того, сколько было найдено элементов:
        switch (indexes.size()) {
            case 0: {
                System.out.println("Элементов с заданным значением информационного поля не найдено.");
                break;
            }
            case 1: {
                int indexOfDeletedElement = indexes.get(0);

                System.out.println("В списке присутствует единственный элемент с заданным значением информационного поля.");
                System.out.println("Это элемент с индексом: " + indexOfDeletedElement + " (индексация начинается с нуля).");
                deleteSelectedElement(linearDoublyConnectedComparableList, indexOfDeletedElement);
                System.out.println("Элемент удалён.");

                break;
            }
            case 2: {
                System.out.println("В списке присутствует несколько элементов с заданным значением информационного поля.");
                System.out.println("Это элементы с индексами: " + indexes.toString() + " (индексация начинается с нуля).");
                System.out.println("Какой именно элемент удалить?");

                Integer userChoise = scanner.nextInt();

                if (indexes.contains(userChoise)) {
                    System.out.println("\n Удаление элемента с индексом: " + userChoise);
                    deleteSelectedElement(linearDoublyConnectedComparableList, userChoise);
                } else {
                    System.out.println("\n Ошибка! Элемент с таким индексом не существует, либо значение его " +
                            "информационного поле не соответствует введённому ранее.");
                }
            }
        }
    }


    /**
     * Добавление элемента в список.
     *
     * @param linearDoublyConnectedComparableList - линейный двусвязный список.
     */
    public static void addElementInList(
            LinearDoublyConnectedComparableList linearDoublyConnectedComparableList,
            Scanner scanner) throws ExceptionNotEqualClass {

        //Если список пуст:
        if (!listIsNotEmpty(linearDoublyConnectedComparableList)) {
            ObjectOfComparableList objectFromKeyboard =
                    linearDoublyConnectedComparableList.getReserveObject().getObjectFromKeyboard(scanner);
            LinearDoublyConnectedComparableList.ElementOfList headElement =
                    new LinearDoublyConnectedComparableList.ElementOfList(objectFromKeyboard);
            linearDoublyConnectedComparableList.setHeadElement(headElement);
            return;
        }

        //Если в списке всего один элемент:
        else if (getLengthOfList(linearDoublyConnectedComparableList) == 1) {
            System.out.println("В списке всего один элемент. Каким образом добавить новый?");
            System.out.println("1 - в начало списка (добавляемый элемент станет \"головой\" списка)");
            System.out.println("2 - в конец списка");
            System.out.println("3 - по возрастанию");
            System.out.println("4 - по убыванию");
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1: {
                    addElementInBeginOfList(linearDoublyConnectedComparableList, scanner);
                    break;
                }
                case 2: {
                    addElementInEndOfList(linearDoublyConnectedComparableList, scanner);
                    break;
                }
                case 3: {
                    addElementInAscendingOrder(linearDoublyConnectedComparableList, scanner);
                    break;
                }
                case 4: {
                    addElementInDescendingOrder(linearDoublyConnectedComparableList, scanner);
                    break;
                }
                default: {
                    break;
                }
            }
        } else {
            System.out.println("1 - в начало списка (добавляемый элемент станет \"головой\" списка)");
            System.out.println("2 - в конец списка");
            if (checkListForOrderAscending(linearDoublyConnectedComparableList)) {
                System.out.println("3 - в порядке по возрастанию");
            }
            if (checkListForOrderDescending(linearDoublyConnectedComparableList)) {
                System.out.println("4 - в порядке по убыванию");
            }
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1: {
                    addElementInBeginOfList(linearDoublyConnectedComparableList, scanner);
                    break;
                }
                case 2: {
                    addElementInEndOfList(linearDoublyConnectedComparableList, scanner);
                    break;
                }
                case 3: {
                    if (checkListForOrderAscending(linearDoublyConnectedComparableList)) {
                        addElementInAscendingOrder(linearDoublyConnectedComparableList, scanner);
                    } else {
                        System.out.println("Ошибка! Элемент не добавлен!");
                    }
                    break;
                }
                case 4: {
                    if (checkListForOrderDescending(linearDoublyConnectedComparableList)) {
                        addElementInDescendingOrder(linearDoublyConnectedComparableList, scanner);
                    } else {
                        System.out.println("Ошибка! Элемент не добавлен!");
                    }
                    break;
                }
                default: {
                    System.out.println("Ошибка! Элемент не добавлен!");
                    break;
                }
            }
        }
    }

    /**
     * Получение длины списка.
     *
     * @param linearDoublyConnectedComparableList - линейный двусвязный список.
     * @return - длина списка.
     */
    public static int getLengthOfList(
            LinearDoublyConnectedComparableList linearDoublyConnectedComparableList) {

        //Если список пуст:
        if (!listIsNotEmpty(linearDoublyConnectedComparableList)) {
            System.out.println("Внимание! Список пуст!");
            return 0;
        }

        LinearDoublyConnectedComparableList.ElementOfList elementOfList = linearDoublyConnectedComparableList.getHeadElement();

        int length = 0;

        while (true) {
            length++;
            if (elementOfList.getRightElement() == null) {
                break;
            }
            elementOfList = elementOfList.getRightElement();
        }

        return length;
    }


    /**
     * Проверка того, что список не пуст.
     *
     * @param linearDoublyConnectedComparableList - линейный двусвязный список.
     * @return - результат проверки.
     */
    public static boolean listIsNotEmpty(
            LinearDoublyConnectedComparableList linearDoublyConnectedComparableList) {

        if (linearDoublyConnectedComparableList.getHeadElement() == null) {
            return false;
        }
        return true;
    }


    /**
     * Получение индексов искомых элементов.
     * Используется в методе поиска элемента с заданным значением информационного поля и
     * в методе удаления элемента с заданным значением информационного поля.
     *
     * @param linearDoublyConnectedComparableList - линейный двусвязный список.
     * @return - индексы искомых элементов.
     */
    private static ArrayList<Integer> getIndexesOfTheDesiredElements(
            LinearDoublyConnectedComparableList linearDoublyConnectedComparableList,
            Scanner scanner)
            throws ExceptionNotEqualClass {

        System.out.println("Введите искомый элемент:");
        ObjectOfComparableList finderObject =
                linearDoublyConnectedComparableList.getHeadElement().getObjectOfElement().getObjectFromKeyboard(scanner);

        //Главный (самый левый) элемент списка:
        LinearDoublyConnectedComparableList.ElementOfList headElement = linearDoublyConnectedComparableList.getHeadElement();

        LinearDoublyConnectedComparableList.ElementOfList selectedElement = headElement;

        int index = 0;

        ArrayList<Integer> indexes = new ArrayList<Integer>();

        while (true) {
            if (selectedElement.getObjectOfElement().resultOfComparable(finderObject) == 0) {
                indexes.add(index);
            }

            index++;

            if (selectedElement.getRightElement() != null) {
                selectedElement = selectedElement.getRightElement();
            } else {
                break;
            }
        }

        return indexes;
    }


    /**
     * Удаление элемента с соответствующим индексом.
     * Предпологается, что индекс указан без ошибки.
     *
     * @param linearDoublyConnectedComparableList - линейный двусвязный список.
     * @param index                               - индекс удаляемого элемента.
     */
    private static void deleteSelectedElement(
            LinearDoublyConnectedComparableList linearDoublyConnectedComparableList,
            int index) {

        LinearDoublyConnectedComparableList.ElementOfList selectedElement =
                linearDoublyConnectedComparableList.getHeadElement();

        for (int i = 0; i < index; i++) {
            selectedElement = selectedElement.getRightElement();
        }


        //Если слева и справа от удаляемого элемента есть другие элементы:
        if ((selectedElement.getLeftElement() != null) && (selectedElement.getRightElement() != null)) {
            selectedElement.getLeftElement().setRightElement(selectedElement.getRightElement());
            selectedElement.getRightElement().setLeftElement(selectedElement.getLeftElement());
            return;
        }

        //Если удаляемый элемент - единственный:
        else if ((selectedElement.getRightElement() == null) && (selectedElement.getLeftElement() == null)) {
            selectedElement.setObjectOfElement(null);
            linearDoublyConnectedComparableList.setHeadElement(null);
            return;
        }

        //Если удаляемый элемент - крайний справа:
        else if (selectedElement.getRightElement() == null) {
            selectedElement.getLeftElement().setRightElement(null);

            //НУЖНО ЛИ?
            clearElementInfo(selectedElement);
            return;
        }

        //Если удаляемый элемент - самый первый:
        else if (selectedElement.getLeftElement() == null) {
            selectedElement.getRightElement().setLeftElement(null);
            linearDoublyConnectedComparableList.setHeadElement(selectedElement.getRightElement());
            return;
        }
    }


    /**
     * Проверка списка на упорядоченность ПО ВОЗРАСТАНИЮ.
     *
     * @param linearDoublyConnectedComparableList - линейный двусвязный список.
     * @return - результат проверки.
     */
    public static boolean checkListForOrderAscending(
            LinearDoublyConnectedComparableList linearDoublyConnectedComparableList)
            throws ExceptionNotEqualClass {

        //"Текущий" элемент:
        LinearDoublyConnectedComparableList.ElementOfList selectedEment = linearDoublyConnectedComparableList.getHeadElement();

        while (true) {

            //Если справа от "текущего" элемента есть ещё элемент:
            if (selectedEment.getRightElement() != null) {

                //Если "текущий" элемент равен или меньше элемента справа:
                if (selectedEment.getObjectOfElement().resultOfComparable(selectedEment.getRightElement().getObjectOfElement()) < 1) {
                    selectedEment = selectedEment.getRightElement();
                } else {
                    return false;
                }
            }

            //Если справа больше нет элементов:
            else {
                break;
            }
        }
        return true;
    }

    /**
     * Проверка списка на упорядоченность ПО УБЫВАНИЮ.
     *
     * @param linearDoublyConnectedComparableList - линейный двусвязный список.
     * @return - результат проверки.
     */
    public static boolean checkListForOrderDescending(
            LinearDoublyConnectedComparableList linearDoublyConnectedComparableList)
            throws ExceptionNotEqualClass {

        //"Текущий" элемент:
        LinearDoublyConnectedComparableList.ElementOfList selectedEment = linearDoublyConnectedComparableList.getHeadElement();

        while (true) {

            //Если справа от "текущего" элемента есть ещё элемент:
            if (selectedEment.getRightElement() != null) {

                //Если "текущий" элемент равен или больше элемента справа:
                if (selectedEment.getObjectOfElement().resultOfComparable(selectedEment.getRightElement().getObjectOfElement()) > -1) {
                    selectedEment = selectedEment.getRightElement();
                } else {
                    return false;
                }
            }

            //Если справа больше нет элементов:
            else {
                break;
            }
        }
        return true;
    }


    /**
     * Добавление какого-либо элемента в начало списка.
     * <p>
     * ВНИМАНИЕ! Для корректной работы метода список НЕ ДОЛЖЕН БЫТЬ ПУСТЫМ!
     *
     * @param linearDoublyConnectedComparableList - линейный двусвязный список.
     * @param scanner                             - сканер для ввода элемента.
     */
    private static void addElementInBeginOfList(
            LinearDoublyConnectedComparableList linearDoublyConnectedComparableList,
            Scanner scanner) {

        LinearDoublyConnectedComparableList.ElementOfList newElement =
                new LinearDoublyConnectedComparableList.ElementOfList(linearDoublyConnectedComparableList.getHeadElement().getObjectOfElement().getObjectFromKeyboard(scanner));
        newElement.setRightElement(linearDoublyConnectedComparableList.getHeadElement());
        linearDoublyConnectedComparableList.getHeadElement().setLeftElement(newElement);
        linearDoublyConnectedComparableList.setHeadElement(newElement);
    }


    /**
     * Добавление какого-либо элемента в начало списка.
     * <p>
     * ВНИМАНИЕ! Для корректной работы метода список НЕ ДОЛЖЕН БЫТЬ ПУСТЫМ!
     *
     * @param linearDoublyConnectedComparableList - линейный двусвязный список.
     * @param scanner                             - сканер для ввода элемента.
     */
    private static void addElementInEndOfList(
            LinearDoublyConnectedComparableList linearDoublyConnectedComparableList,
            Scanner scanner) {

        LinearDoublyConnectedComparableList.ElementOfList newElement =
                new LinearDoublyConnectedComparableList.ElementOfList(linearDoublyConnectedComparableList.getHeadElement().getObjectOfElement().getObjectFromKeyboard(scanner));

        LinearDoublyConnectedComparableList.ElementOfList elementOfList =
                linearDoublyConnectedComparableList.getHeadElement();

        while (true) {
            if(elementOfList.getRightElement()!=null) {
                elementOfList = elementOfList.getRightElement();
            } else {
                break;
            }
        }

        elementOfList.setRightElement(newElement);
        newElement.setLeftElement(elementOfList);
    }


    /**
     * Добавление какого-либо элемента в список в порядке по возрастанию.
     * <p>
     * ВНИМАНИЕ! Для корректной работы метода список НЕ ДОЛЖЕН БЫТЬ ПУСТЫМ!
     * ВНИМАНИЕ! Для корректной работы метода список должен быть УПОРЯДОЧЕН ПО ВОЗРАСТАНИЮ!
     * Список из одного элемента считается упорядоченным по возрастанию.
     *
     * @param linearDoublyConnectedComparableList - линейный двусвязный список.
     * @param scanner                             - сканер для ввода элемента.
     */
    private static void addElementInAscendingOrder(
            LinearDoublyConnectedComparableList linearDoublyConnectedComparableList,
            Scanner scanner)
            throws ExceptionNotEqualClass {

        //Введённый с клавиатуры элемент:
        LinearDoublyConnectedComparableList.ElementOfList keyboardElement =
                new LinearDoublyConnectedComparableList.ElementOfList(linearDoublyConnectedComparableList.getHeadElement().getObjectOfElement().getObjectFromKeyboard(scanner));

        //Рассматриваемый в данный момент элемент:
        LinearDoublyConnectedComparableList.ElementOfList elementCurrentlyUnderConsideration =
                linearDoublyConnectedComparableList.getHeadElement();

        //Элемент, стоящий слева от "рассматриваемого" в данный момент.
        //Нужен не всегда.
        LinearDoublyConnectedComparableList.ElementOfList leftOfConsiderationElement;

        int lengthOfList = getLengthOfList(linearDoublyConnectedComparableList);

        for (int i = 0; i < lengthOfList; i++) {

            //Если введённый элемент больше "рассматриваемого":
            if (keyboardElement.compare(elementCurrentlyUnderConsideration) == 1) {

                //Если введённый с клавиатуры элемент больше самого правого элемента в списке:
                if (i == lengthOfList - 1) {
                    elementCurrentlyUnderConsideration.setRightElement(keyboardElement);
                    keyboardElement.setLeftElement(elementCurrentlyUnderConsideration);
                    break;
                } else {
                    elementCurrentlyUnderConsideration = elementCurrentlyUnderConsideration.getRightElement();
                }
            }

            //Если введённый элемент меньше или равен "рассматриваемому":
            else {

                //Если слева от рассматриваемого уже есть элемент:
                if (i > 0) {
                    leftOfConsiderationElement = elementCurrentlyUnderConsideration.getLeftElement();
                    leftOfConsiderationElement.setRightElement(keyboardElement);
                    keyboardElement.setLeftElement(leftOfConsiderationElement);
                    keyboardElement.setRightElement(elementCurrentlyUnderConsideration);
                    elementCurrentlyUnderConsideration.setLeftElement(keyboardElement);
                    break;
                }

                //Если введённый элемент меньше самого левого элемента в списке:
                else {
                    keyboardElement.setRightElement(elementCurrentlyUnderConsideration);
                    elementCurrentlyUnderConsideration.setLeftElement(keyboardElement);

                    //Введённый элемент становится головным:
                    linearDoublyConnectedComparableList.setHeadElement(keyboardElement);

                    break;
                }
            }
        }
    }


    /**
     * Добавление какого-либо элемента в список в порядке по убыванию.
     * <p>
     * ВНИМАНИЕ! Для корректной работы метода список НЕ ДОЛЖЕН БЫТЬ ПУСТЫМ!
     * ВНИМАНИЕ! Для корректной работы метода список должен быть УПОРЯДОЧЕН ПО УБЫВАНИЮ!
     * Список из одного элемента считается упорядоченным по убыванию.
     *
     * @param linearDoublyConnectedComparableList - линейный двусвязный список.
     * @param scanner                             - сканер для ввода элемента.
     */
    private static void addElementInDescendingOrder(
            LinearDoublyConnectedComparableList linearDoublyConnectedComparableList,
            Scanner scanner)
            throws ExceptionNotEqualClass {

        //Введённый с клавиатуры элемент:
        LinearDoublyConnectedComparableList.ElementOfList keyboardElement =
                new LinearDoublyConnectedComparableList.ElementOfList(linearDoublyConnectedComparableList.getHeadElement().getObjectOfElement().getObjectFromKeyboard(scanner));

        //Рассматриваемый в данный момент элемент:
        LinearDoublyConnectedComparableList.ElementOfList elementCurrentlyUnderConsideration =
                linearDoublyConnectedComparableList.getHeadElement();

        //Элемент, стоящий слева от "рассматриваемого" в данный момент.
        //Нужен не всегда.
        LinearDoublyConnectedComparableList.ElementOfList leftOfConsiderationElement;

        int lengthOfList = getLengthOfList(linearDoublyConnectedComparableList);

        for (int i = 0; i < lengthOfList; i++) {

            //Если введённый элемент меньше "рассматриваемого":
            if (keyboardElement.compare(elementCurrentlyUnderConsideration) == -1) {

                //Если введённый с клавиатуры элемент меньше самого правого элемента в списке:
                if (i == lengthOfList - 1) {
                    elementCurrentlyUnderConsideration.setRightElement(keyboardElement);
                    keyboardElement.setLeftElement(elementCurrentlyUnderConsideration);
                    break;
                } else {
                    elementCurrentlyUnderConsideration = elementCurrentlyUnderConsideration.getRightElement();
                }
            }

            //Если введённый элемент больше или равен "рассматриваемому":
            else {

                //Если слева от рассматриваемого уже есть элемент:
                if (i > 0) {
                    leftOfConsiderationElement = elementCurrentlyUnderConsideration.getLeftElement();
                    leftOfConsiderationElement.setRightElement(keyboardElement);
                    keyboardElement.setLeftElement(leftOfConsiderationElement);
                    keyboardElement.setRightElement(elementCurrentlyUnderConsideration);
                    elementCurrentlyUnderConsideration.setLeftElement(keyboardElement);
                    break;
                }

                //Если введённый элемент больше самого левого элемента в списке:
                else {
                    keyboardElement.setRightElement(elementCurrentlyUnderConsideration);
                    elementCurrentlyUnderConsideration.setLeftElement(keyboardElement);

                    //Введённый элемент становится головным:
                    linearDoublyConnectedComparableList.setHeadElement(keyboardElement);

                    break;
                }
            }
        }
    }


    /**
     * Удаление информации внутри элемента.
     *
     * @param elementOfList - элемент, информация внутри которого удаляется.
     */
    protected static void clearElementInfo(
            LinearDoublyConnectedComparableList.ElementOfList elementOfList) {

        elementOfList.setLeftElement(null);
        elementOfList.setRightElement(null);
        elementOfList.setObjectOfElement(null);
    }
}