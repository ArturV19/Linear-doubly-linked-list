import exceptions.ExceptionNotEqualClass;
import menu.MainMenu;

/**
 * Точка входа в приложение.
 *
 * @author Артур Воеков, группа 6344-010302D.
 */
public class MainClass {
    public static void main(String[] args) {
        try {
            MainMenu.run();
        } catch (ExceptionNotEqualClass exceptionNotEqualClass) {
            exceptionNotEqualClass.printStackTrace();
        }
    }
}