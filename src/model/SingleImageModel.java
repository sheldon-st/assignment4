package model;
import java.io.DataOutputStream;

/**
 * This class represents a single image model.
 */
public class SingleImageModel implements IModel {
  public int width;
  public int height;
  private int[][][] image;

  /**
   * Constructor for SingleImageModel with no parameters.
   */
  public SingleImageModel() {
    this.width = 0;
    this.height = 0;

    image = null;
  }

  /**
   * Constructor for copying SingleImageModel from source.
   *
   * @param source the image to copy.
   */
  public SingleImageModel(SingleImageModel source) {
    image = source.image;
    this.width = source.width;
    this.height = source.height;

  }

  /**
   * This method sets the image to the given image.
   *
   * @param image the image to set.
   */
  @Override
  public void setImage(int[][][] image) {
    // use image utility to get image
    System.out.println("Sets image to:");
    this.image = image;
    this.height = image.length;
    this.width = image[0].length;
  }

  /**
   * This method returns the image array.
   *
   * @return the image array.
   */
  @Override
  public int[][][] getImage() {
    System.out.println("Gets image:");

    System.out.println(this.image);

    return this.image;
  }

  /**
   * Flips the image array horizontally.
   */
  public void flipHorizontally() {
    System.out.println("flipping image: ");
    System.out.println(this.image.length );
    System.out.println(this.width);
    System.out.println(this.height);

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width/2; j++) {
        int[] tmp = image[i][width-j-1].clone();
        image[i][width-j-1] = image[i][j].clone();
        image[i][j] = tmp;
      }
    }
  }

  /**
   * Flips the image array vertically.
   */
  public void flipVertically() {
    System.out.println("flipping image: ");
    System.out.println(this.image.length );
    System.out.println(this.width);
    System.out.println(this.height);

    for (int i = 0; i < height/2; i++) {
      for (int j = 0; j < width; j++) {
        int[] tmp = image[height-i-1][j].clone();
        image[height-i-1][j] = image[i][j].clone();
        image[i][j] = tmp;
      }
    }
  }

  /**
   * This method brightens the image array by the given increment.
   *
   * @param increment the increment to brighten the image by.
   */
  public void brighten(int increment) {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        for (int k = 0; k < 3; k++) {
          image[i][j][k] = Math.min(image[i][j][k] + increment, 255);
        }
      }
    }
  }

  // health = Math.min(health + 15, 100);

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
}