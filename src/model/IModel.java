package model;

/**
 * This interface represents an image model.
 */
public interface IModel {

  /**
   * Set the image array.
   */
  void setImage();

  /**
   * Get the image array.
   *
   * @return image array
   */
  int[][][] getImage();

  /**
   * Sets path to given string.
   *
   * @param i represents string of given path
   */
  void setPath(String i);

  /**
   * Gets path of Model
   *
   * @return String representing path of model.
   */
  String getPath();

}
