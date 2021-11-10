package controller;

import model.IMEModel;

/**
 * Interface for IME command objects. These objects are used to execute commands provided by
 * the controller.
 */
public interface IMECommand {

  /**
   * Execute the command.
   *
   * @param m The model to use.
   */
  void startProgram(IMEModel m);
}
