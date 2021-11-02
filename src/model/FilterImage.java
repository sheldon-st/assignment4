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
        image[i][j][1] = image[i][j][0];
        image[i][j][2] = image[i][j][0];
      }
    }
  }

  public void blueScale() {
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        image[i][j][0] = image[i][j][2];
        image[i][j][1] = image[i][j][2];
      }
    }

  }

  public void greenScale() {
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        image[i][j][0] = image[i][j][1];
        image[i][j][2] = image[i][j][1];
      }
    }
  }

  public void valueScale() {
    int maxVal=0;
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        maxVal = Math.max(Math.max(image[i][j][0],image[i][j][1]),image[i][j][2]);
        image[i][j][0] = maxVal;
        image[i][j][1] = maxVal;
        image[i][j][2] = maxVal;
      }
    }
  }

  public void intensityScale() {
    int avgVal=0;
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        avgVal = (image[i][j][0]+ image[i][j][1] + image[i][j][2]) / 3 ;
        image[i][j][0] = avgVal;
        image[i][j][1] = avgVal;
        image[i][j][2] = avgVal;
      }
    }
  }

  public void lumaScale() {
    int luma=0;
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        luma = (int) Math.round((0.2126 * image[i][j][0])+ (0.7152* image[i][j][1]) +
                (0.0722 * image[i][j][2]));
        image[i][j][0] = luma;
        image[i][j][1] = luma;
        image[i][j][2] = luma;
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