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
public class VerticalFlip implements IMECommand {
  private String source;
  private String dest;

  public VerticalFlip(String source, String dest) {
    this.source = source;
    this.dest = dest;
  }

  @Override
  public void go(IMEModel m) {
    Filter tempImage =
            new FilterImage(m.images.get(source).getImage());
    tempImage.flipVertically();
    m.images.put(dest, new SingleImageModel(tempImage.getNewImage()));
  }
}