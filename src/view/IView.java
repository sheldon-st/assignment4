package view;

/**
 * Interface for the IME view.
 */
public interface IView {
    /**
     * Prints the given message to the console.
     * @param s
     */
    void showString(String s);

    /**
     * Prints the menu to the console.
     */
    void showOptions();

    /**
     * Prints the error message to the console.
     */
    void showOptionError();
}
