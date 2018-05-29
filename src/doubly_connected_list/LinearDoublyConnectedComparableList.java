package doubly_connected_list;

import exceptions.ExceptionNotEqualClass;

import java.util.Scanner;

import static doubly_connected_list.ConstructorMethods.numberOfElements;

/**
 * Описание линейного двусвязного списка со сравниваемыми элементами.
 */
public class LinearDoublyConnectedComparableList {

    /**
     * Элемент списка.
     */
    static class ElementOfList {
        //Объект элемента списка:
        private ObjectOfComparableList objectOfElement;

        private ElementOfList leftElement;
        private ElementOfList rightElement;

        /**
         * Конструктор элемента списка.
         *
         * @param objectOfComparableList - объект, реализовывающий интерфейс
         *                               ObjectOfComparableList
         */
        ElementOfList(ObjectOfComparableList objectOfComparableList) {
            this.objectOfElement = objectOfComparableList;
        }

        ObjectOfComparableList getObjectOfElement() {
            return objectOfElement;
        }

        void setObjectOfElement(ObjectOfComparableList objectOfElement) {
            this.objectOfElement = objectOfElement;
        }

        ElementOfList getLeftElement() {
            return leftElement;
        }

        void setLeftElement(ElementOfList leftElement) {
            this.leftElement = leftElement;
        }

        ElementOfList getRightElement() {
            return rightElement;
        }

        void setRightElement(ElementOfList rightElement) {
            this.rightElement = rightElement;
        }

        int compare(ElementOfList element) throws ExceptionNotEqualClass {
            return this.objectOfElement.resultOfComparable(element.getObjectOfElement());
        }
    }

    //ГЛАВНЫЙ элемент:
    private ElementOfList headElement;

    //Резервный объект. Может понадобиться, если список станет пустым.
    private ObjectOfComparableList reserveObject;

    /**
     * Конструктор списка:
     *
     * @param scanner        - сканнер.
     * @param theFirstObject - самый первый ОБЪЕКТ, который войдёт в список,
     *                       но ещё не элемент списка.
     */
    public LinearDoublyConnectedComparableList(Scanner scanner,
                                               ObjectOfComparableList theFirstObject) {
        reserveObject = theFirstObject;

        //Самый первый элемент списка:
        this.headElement = new ElementOfList(theFirstObject);

        int numberOfElements;

        System.out.println("\nСоздание списка...");
        System.out.println("Каким образом будет происходить первоначальное (данное) создание списка?");
        System.out.println("1 - элементы будут последовательно добавляться в начало");
        System.out.println("2 - элементы будут последовательно добавляться в конец");
        System.out.println("3 - элементы будут добавляться так, чтобы список был упорядочен по возрастанию");
        System.out.println("4 - элементы будут добавляться так, чтобы список был упорядочен по убыванию");
        switch (scanner.nextInt()) {
            case 1: {
                numberOfElements = numberOfElements(scanner);
                this.headElement = ConstructorMethods.addElementInBeginOrEndOfList(this.headElement,
                        numberOfElements, true, scanner);
                break;
            }
            case 2: {
                numberOfElements = numberOfElements(scanner);
                this.headElement = ConstructorMethods.addElementInBeginOrEndOfList(this.headElement,
                        numberOfElements, false, scanner);
                break;
            }
            case 3: {
                numberOfElements = numberOfElements(scanner);
                try {
                    this.headElement = ConstructorMethods.addingItemsInAscendingOrDescendingOrder(this.headElement,
                            numberOfElements, true, scanner);
                } catch (ExceptionNotEqualClass exceptionNotEqualClass) {
                    exceptionNotEqualClass.printStackTrace();
                }
                break;
            }
            case 4: {
                numberOfElements = numberOfElements(scanner);
                try {
                    this.headElement = ConstructorMethods.addingItemsInAscendingOrDescendingOrder(this.headElement,
                            numberOfElements, false, scanner);
                } catch (ExceptionNotEqualClass exceptionNotEqualClass) {
                    exceptionNotEqualClass.printStackTrace();
                }
                break;
            }
        }
    }

    public ElementOfList getHeadElement() {
        return this.headElement;
    }

    public void setHeadElement(ElementOfList headElement) {
        this.headElement = headElement;
    }

    ObjectOfComparableList getReserveObject() {
        return reserveObject;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        //Если список пуст:
        if (!WorkWithList.listIsNotEmpty(this)) {
            return "Список пуст!";
        } else {
            ElementOfList elementOfList = headElement;
            while (true) {
                stringBuffer.append(elementOfList.objectOfElement.toString() + " ");
                if (elementOfList.getRightElement() != null) {
                    elementOfList = elementOfList.getRightElement();
                } else {
                    break;
                }
            }
        }
        return String.valueOf(stringBuffer);
    }


    /**
     * Метод очистки списка.
     */
    public void clear() {
        ElementOfList elementOfList=headElement;

        while (true){
            if(elementOfList.getRightElement()!=null){
                elementOfList=elementOfList.getRightElement();
                WorkWithList.clearElementInfo(elementOfList.getLeftElement());
            } else {
                WorkWithList.clearElementInfo(elementOfList);
                break;
            }
        }

        this.reserveObject = null;
        System.out.println("\nПамять очищена.\n");
    }
}
