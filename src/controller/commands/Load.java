package controller.commands;

import controller.IMECommand;
import model.IMEModel;
import model.IModel;
import model.SingleImageModel;

/**
 * This class represents the command to load a file.
 */
public class Load implements IMECommand {

  private String path;
  private String name;

  public Load(String path, String name) {
    this.path = path;
    this.name = name;
  }

  @Override
  public void go(IMEModel m) {
    IModel tempImage = new SingleImageModel(path);
    m.loadImage(name, tempImage);
  }
}
