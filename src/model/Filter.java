package model;

public interface Filter {
  void redScale();
  void blueScale();
  void greenScale();
   void valueScale();
   void intensityScale();
  void lumaScale();
  int[][][] getNewImage();
  int[][][] copyImage(int[][][] imgToCopy);
}
