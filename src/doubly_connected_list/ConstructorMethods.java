package doubly_connected_list;

import exceptions.ExceptionNotEqualClass;

import java.util.Scanner;

/**
 * Методы для организации линейного двусвязного списка.
 */
class ConstructorMethods {

    /**
     * Ввод количества элементов при создании списка.
     *
     * @param scanner - сканер.
     * @return - количество элементов, вводимое с клавиатуры.
     */
    static int numberOfElements(Scanner scanner) {
        System.out.println("\nВведите количество добавляемых элементов (кроме самого первого):");
        return scanner.nextInt();
    }

    /**
     * Добавление с клавиатуры элементов в список.
     * В зависимости от предыдущего выбора пользователя либо в начало,
     * либо в конец.
     *
     * @param headElement       - самый первый элемент списка.
     * @param numberOfElements  - количество добавляемых в список элементов (кроме самого первого).
     * @param addElementInBegin - определяет, добавлять элементы в начало или в конец списка.
     * @return - элемент, который станет головным.
     */
    static LinearDoublyConnectedComparableList.ElementOfList addElementInBeginOrEndOfList(
            LinearDoublyConnectedComparableList.ElementOfList headElement,
            int numberOfElements,
            boolean addElementInBegin,
            Scanner scanner) {

        //Элемент, введённый с клавиатуры:
        LinearDoublyConnectedComparableList.ElementOfList keyboardElement = headElement;

        // Элемент, введённый в предыдущей итерации цикла
        LinearDoublyConnectedComparableList.ElementOfList previousElement;

        //Объект внутри первоночального ГЛАВНОГО элемента:
        ObjectOfComparableList firstInnerObject = headElement.getObjectOfElement();

        //Добавление элементов в начало:
        if (addElementInBegin) {
            for (int index = 0; index < numberOfElements; index++) {
                previousElement = keyboardElement;

                //Объект, введённый с клавиатуры на данной итерации цикла:
                ObjectOfComparableList objectFromKeyboard =
                        firstInnerObject.getObjectFromKeyboard(scanner);

                keyboardElement =
                        new LinearDoublyConnectedComparableList.ElementOfList(objectFromKeyboard);

                //Предыдущий "первый" элемент ссылается налево на только что введённый,
                //Только что введённый ссылается направо на предыдущий "первый":
                previousElement.setLeftElement(keyboardElement);
                keyboardElement.setRightElement(previousElement);
            }

            return keyboardElement;
        }

        //Добавление элементов в конец:
        else {
            for (int index = 0; index < numberOfElements; index++) {
                previousElement = keyboardElement;

                //Объект, введённый с клавиатуры на данной итерации цикла:
                ObjectOfComparableList objectFromKeyboard =
                        firstInnerObject.getObjectFromKeyboard(scanner);

                keyboardElement =
                        new LinearDoublyConnectedComparableList.ElementOfList(objectFromKeyboard);

                //Предыдущий "первый" элемент ссылается налево на только что введённый,
                //Только что введённый ссылается направо на предыдущий "первый":
                previousElement.setRightElement(keyboardElement);
                keyboardElement.setLeftElement(previousElement);
            }
        }

        return headElement;
    }


    /**
     * Добавление с клавиатуры элементов в список.
     * В зависимости от предыдущего выбора пользователя либо по возрастанию,
     * либо по убыванию.
     *
     * @param headElement         - самый первый элемент списка.
     * @param numberOfElements    - количество добавляемых в список элементов (кроме самого первого).
     * @param addElementAscending - определяет, добавлять элементы по возрастанию, или по убыванию.
     * @return - элемент, который станет головным.
     * @throws ExceptionNotEqualClass - в случае, если произойдёт ошибка сравнения.
     */
    static LinearDoublyConnectedComparableList.ElementOfList addingItemsInAscendingOrDescendingOrder(
            LinearDoublyConnectedComparableList.ElementOfList headElement,
            int numberOfElements,
            boolean addElementAscending,
            Scanner scanner) throws ExceptionNotEqualClass {

        //Элемент, конструируемый на основе объекта, введённого с клавиатуры:
        LinearDoublyConnectedComparableList.ElementOfList keyboardElement;

        //Элемент, рассматриваемый в данный момент:
        LinearDoublyConnectedComparableList.ElementOfList elementCurrentlyUnderConsideration;

        //Элемент, стоящий слева от "рассматриваемого" в данный момент.
        //Нужен не всегда.
        LinearDoublyConnectedComparableList.ElementOfList leftOfConsiderationElement;

        //Объект внутри первоночального ГЛАВНОГО элемента:
        ObjectOfComparableList firstInnerObject = headElement.getObjectOfElement();

        //Длина списка:
        int lengthOfList = 1;

        //Если элементы добавляются по-возрастанию:
        if (addElementAscending) {
            for (int index = 0; index < numberOfElements; index++) {
                elementCurrentlyUnderConsideration = headElement;

                //Объект, введённый с клавиатуры на данной итерации цикла:
                ObjectOfComparableList objectFromKeyboard =
                        firstInnerObject.getObjectFromKeyboard(scanner);

                keyboardElement =
                        new LinearDoublyConnectedComparableList.ElementOfList(objectFromKeyboard);

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
                            headElement = keyboardElement;

                            break;
                        }
                    }
                }

                lengthOfList++;
            }
        }

        //Если элементы добавляются по-убыванию:
        else {
            for (int index = 0; index < numberOfElements; index++) {
                elementCurrentlyUnderConsideration = headElement;

                //Объект, введённый с клавиатуры на данной итерации цикла:
                ObjectOfComparableList objectFromKeyboard =
                        firstInnerObject.getObjectFromKeyboard(scanner);

                keyboardElement =
                        new LinearDoublyConnectedComparableList.ElementOfList(objectFromKeyboard);

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
                            headElement = keyboardElement;

                            break;
                        }
                    }
                }

                lengthOfList++;
            }
        }

        return headElement;
    }

}
