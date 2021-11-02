package model;

public interface Filter {
  void redScale();
  void blueScale();
  void greenScale();
  int[][][] getNewImage();
  int[][][] copyImage(int[][][] imgToCopy);
}
