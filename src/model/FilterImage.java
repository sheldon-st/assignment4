package model;

public class FilterImage implements Filter {
  protected int[][][] image;

  public FilterImage(int[][][] image) {
    this.image = copyImage(image);
  }

  public int[][][] getNewImage() {
    return this.image;

  }

  public void redScale() {
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        image[i][j][1] = 0;
        image[i][j][2] = 0;
      }
    }
  }

  public void blueScale() {
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        image[i][j][0] = 0;
        image[i][j][1] = 0;
      }
    }

  }

  public void greenScale() {
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        image[i][j][0] = 0;
        image[i][j][2] = 0;
      }
    }
  }

  public int[][][] copyImage(int[][][] imgToCopy) {
    int[][][] newImage = new int[imgToCopy.length][imgToCopy[0].length][3];
    for (int i = 0; i < imgToCopy.length; i++) {
      for (int j = 0; j < imgToCopy[0].length; j++) {
        newImage[i][j][0] =  imgToCopy[i][j][0];
        newImage[i][j][1] =  imgToCopy[i][j][1];
        newImage[i][j][2] =  imgToCopy[i][j][2];
      }
    }
      return newImage;
    }

}