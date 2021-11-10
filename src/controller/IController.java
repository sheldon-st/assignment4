package controller;

import java.util.Scanner;

/**
 * Interface for the controller to manage user input, storing images modifications of images and
 * displaying images to the view.
 */
public interface IController {
  /**
   * Starts the program.
   */
  void startProgram();

  void setScanner(Scanner s);
}