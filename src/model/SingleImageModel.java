package model;

/**
 * This class represents a single image model.
 */
public class SingleImageModel implements IModel {
  private int[][][] image;
  private String imagePath;

  /**
   * Constructor for SingleImageModel with no parameters.
   */
  public SingleImageModel() {
    imagePath = "";
    image = null;
  }

  /**
   * Constructor for SingleImageModel with given image path.
   *
   * @param imagePath given image path
   */
  public SingleImageModel(String imagePath) {
    this.imagePath = imagePath;
    image = ImageUtil.readPPM(this.imagePath);
  }

  /**
   * Constructor for SingleImageModel with given image.
   *
   * @param image given image
   */
  public SingleImageModel(int[][][] image) {
    this.imagePath = "";
    this.image = image;
  }

  @Override
  public void setImage() {
    this.image = ImageUtil.readPPM(this.imagePath);
  }


  @Override
  public int[][][] getImage() {
    return this.image;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof SingleImageModel) {
      SingleImageModel other = (SingleImageModel) o;
      return this.image.equals(other.image);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return image.hashCode();
  }

  @Override
  public void setPath(String i) {
    imagePath = i;
  }

  @Override
  public String getPath() {
    return "Image Path:" + imagePath;
  }

}