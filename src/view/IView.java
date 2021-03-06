package view;

/**
 * Interface for the view to display the interface of the image processing environment.
 */
public interface IView {
  /**
   * Prints the given string to the view.
   */
  void showString(String s);

  /**
   * menu to the view.
   */
  void showOptions();

  /**
   * Prints the error message to the console .
   */
  void showOptionError();
}
