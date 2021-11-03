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
public class Components{

  public static class RedComponent implements IMECommand {
    private String source;
    private String dest;

    public RedComponent(String source, String dest) {
      this.source = source;
      this.dest = dest;
    }

    @Override
    public void go(IMEModel m) {
      Filter tempImage =
              new FilterImage(m.images.get(source).getImage());
      tempImage.redScale();
      m.images.put(dest, new SingleImageModel(tempImage.getNewImage()));
    }
  }

  public static class BlueComponent implements IMECommand {
    private String source;
    private String dest;

    public BlueComponent(String source, String dest) {
      this.source = source;
      this.dest = dest;
    }

    @Override
    public void go(IMEModel m) {
      Filter tempImage =
              new FilterImage(m.images.get(source).getImage());
      tempImage.blueScale();
      m.images.put(dest, new SingleImageModel(tempImage.getNewImage()));
    }
  }

  public static class GreenComponent implements IMECommand {
    private String source;
    private String dest;

    public GreenComponent(String source, String dest) {
      this.source = source;
      this.dest = dest;
    }

    @Override
    public void go(IMEModel m) {
      Filter tempImage =
              new FilterImage(m.images.get(source).getImage());
      tempImage.greenScale();
      m.images.put(dest, new SingleImageModel(tempImage.getNewImage()));
    }
  }

  public static class IntensityComponent implements IMECommand {
    private String source;
    private String dest;

    public IntensityComponent(String source, String dest) {
      this.source = source;
      this.dest = dest;
    }

    @Override
    public void go(IMEModel m) {
      Filter tempImage =
              new FilterImage(m.images.get(source).getImage());
      tempImage.intensityScale();
      m.images.put(dest, new SingleImageModel(tempImage.getNewImage()));
    }
  }

  public static class ValueComponent implements IMECommand {
    private String source;
    private String dest;

    public ValueComponent(String source, String dest) {
      this.source = source;
      this.dest = dest;
    }

    @Override
    public void go(IMEModel m) {
      Filter tempImage =
              new FilterImage(m.images.get(source).getImage());
      tempImage.valueScale();
      m.images.put(dest, new SingleImageModel(tempImage.getNewImage()));
    }
  }

  public static class LumaComponent implements IMECommand {
    private String source;
    private String dest;

    public LumaComponent(String source, String dest) {
      this.source = source;
      this.dest = dest;
    }

    @Override
    public void go(IMEModel m) {
      Filter tempImage =
              new FilterImage(m.images.get(source).getImage());
      tempImage.lumaScale();
      m.images.put(dest, new SingleImageModel(tempImage.getNewImage()));
    }
  }
}
