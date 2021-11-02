package model;

/**
 * This interface represents an image model.
 */
public interface IModel {

   void setPath(String i);

  String getPath();

  void setImage();

  int[][][] getImage();

}
