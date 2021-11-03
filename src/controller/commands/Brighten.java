package controller.commands;

import controller.IMECommand;
import model.Filter;
import model.FilterImage;
import model.IMEModel;
import model.IModel;
import model.SingleImageModel;

/**
 *
 */
public class Brighten implements IMECommand {

  private int increment;
  private String source;
  private String dest;

  public Brighten(int increment, String source, String dest) {
    this.increment = increment;
    this.source = source;
    this.dest = dest;
  }

  @Override
  public void go(IMEModel m) {
    Filter tempImage =
            new FilterImage(m.images.get(source).getImage());
    tempImage.brighten(increment);
    m.images.put(dest, new SingleImageModel(tempImage.getNewImage()));
  }
}
