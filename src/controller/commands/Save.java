package controller.commands;

import controller.IMECommand;
import model.IMEModel;
import model.IModel;
import model.SingleImageModel;

/**
 * This class represents the command to load a file.
 */
public class Save implements IMECommand {

  private String path;
  private String name;

  public Save(String path, String name) {
    this.path = path;
    this.name = name;
  }

  @Override
  public void go(IMEModel m) {
    m.saveImage(path, name);
  }
}
