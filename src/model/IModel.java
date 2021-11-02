package model;

/**
 * Interface for the Imagemodel.
 */
public interface IModel {
  /**
   * Set the image to a given array.
   */
  void setImage(int[][][] image);

  /**
   * Get the image array.
   */
  int[][][] getImage();

  /**
   * Flip the image horizontally.
   */
  void flipHorizontally();

  /**
   * Flip the image vertically.
   */
  void flipVertically();

  /**
   * Brighten the image by a given factor.
   */
  void brighten(int increment);
}
