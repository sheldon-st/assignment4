package controller.commands;

import controller.IMECommand;
import model.Filter;
import model.FilterImage;
import model.IMEModel;
import model.SingleImageModel;

/**
 * This class is used to brighten the image.
 */
public class Brighten implements IMECommand {
  private int increment;
  private String source;
  private String dest;

  /**
   * Constructor for Brighten.
   *
   * @param increment the amount to brighten the image by
   * @param source    the source image
   * @param dest      the destination image
   */
  public Brighten(int increment, String source, String dest) {
    this.increment = increment;
    this.source = source;
    this.dest = dest;
  }

  /**
   * Executes the command.
   *
   * @param m the model
   */
  @Override
  public void go(IMEModel m) {
    Filter tempImage =
            new FilterImage(m.images.get(source).getImage());
    tempImage.brighten(increment);
    m.images.put(dest, new SingleImageModel(tempImage.getNewImage()));
  }
}
