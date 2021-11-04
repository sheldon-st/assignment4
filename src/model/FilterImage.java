package model;

/**
 * This class implements the Filter interface. It represents a class with the possible filters on
 * an image such as grayscale, value, luma, and intensity component.
 */
public class FilterImage implements Filter {
  protected int[][][] image;
  private int width;
  private int height;

  /**
   * Constructor for FilterImage takes in image to apply the filter on and copies into a new blank
   * image and applies the filter.
   *
   * @param image image to be filtered
   */
  public FilterImage(int[][][] image) {
    this.image = copyImage(image);
    this.height = image.length;
    this.width = image[0].length;
  }

  /**
   * Returns the image array.
   *
   * @return
   */
  @Override
  public int[][][] getNewImage() {
    return this.image;
  }

  /**
   * Greyscale from red component.
   */
  @Override
  public void redScale() {
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        image[i][j][1] = image[i][j][0];
        image[i][j][2] = image[i][j][0];
      }
    }
  }

  /**
   * Greyscale from blue component.
   */
  @Override
  public void blueScale() {
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        image[i][j][0] = image[i][j][2];
        image[i][j][1] = image[i][j][2];
      }
    }

  }

  /**
   * Greyscale from green component.
   */
  @Override
  public void greenScale() {
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        image[i][j][0] = image[i][j][1];
        image[i][j][2] = image[i][j][1];
      }
    }
  }

  /**
   * Greyscale from value component.
   */
  @Override
  public void valueScale() {
    int maxVal = 0;
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        maxVal = Math.max(Math.max(image[i][j][0], image[i][j][1]), image[i][j][2]);
        image[i][j][0] = maxVal;
        image[i][j][1] = maxVal;
        image[i][j][2] = maxVal;
      }
    }
  }

  /**
   * Greyscale from intensity component.
   */
  @Override
  public void intensityScale() {
    int avgVal = 0;
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        avgVal = (image[i][j][0] + image[i][j][1] + image[i][j][2]) / 3;
        image[i][j][0] = avgVal;
        image[i][j][1] = avgVal;
        image[i][j][2] = avgVal;
      }
    }
  }

  /**
   * Greyscale from luma component.
   */
  @Override
  public void lumaScale() {
    int luma = 0;
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        luma = (int) Math.round((0.2126 * image[i][j][0]) + (0.7152 * image[i][j][1]) +
                (0.0722 * image[i][j][2]));
        image[i][j][0] = luma;
        image[i][j][1] = luma;
        image[i][j][2] = luma;
      }
    }
  }

  /**
   * Copies the given image.
   *
   * @param imgToCopy given image to make a copy of
   * @return new image array
   */
  @Override
  public int[][][] copyImage(int[][][] imgToCopy) {
    int[][][] newImage = new int[imgToCopy.length][imgToCopy[0].length][3];
    for (int i = 0; i < imgToCopy.length; i++) {
      for (int j = 0; j < imgToCopy[0].length; j++) {
        newImage[i][j][0] = imgToCopy[i][j][0];
        newImage[i][j][1] = imgToCopy[i][j][1];
        newImage[i][j][2] = imgToCopy[i][j][2];
      }
    }
    return newImage;
  }

  /**
   * Flips the image horizontally.
   */
  @Override
  public void flipHorizontally() {
    System.out.println("flipping image: ");
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width / 2; j++) {
        int[] tmp = image[i][width - j - 1].clone();
        image[i][width - j - 1] = image[i][j].clone();
        image[i][j] = tmp;
      }
    }
  }

  /**
   * Flips the image vertically.
   */
  @Override
  public void flipVertically() {
    System.out.println("flipping image: ");
    System.out.println(this.image.length);
    System.out.println(this.width);
    System.out.println(this.height);

    for (int i = 0; i < height / 2; i++) {
      for (int j = 0; j < width; j++) {
        int[] tmp = image[height - i - 1][j].clone();
        image[height - i - 1][j] = image[i][j].clone();
        image[i][j] = tmp;
      }
    }
  }

  /**
   * Brightens the image by the given increment.
   *
   * @param increment the amount to brighten the image by
   */
  @Override
  public void brighten(int increment) {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        for (int k = 0; k < 3; k++) {
          image[i][j][k] = Math.min(image[i][j][k] + increment, 255);
        }
      }
    }
  }
}