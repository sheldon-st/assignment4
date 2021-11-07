package model;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * This class contains utility methods to read a PPM image from file return a 3D int representation
 * of the file, and write a image into a PPM file.
 */
public class ImageUtil {


  /**
   * Read an image file in the PPM format and return a 3D int representation of the image.
   *
   * @param filename name of file to be read
   * @return 3D int representation of the image of read PPM file
   */
  public static int[][][] readPPM(String filename) {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filename));
    } catch (FileNotFoundException e) {
      System.out.println("Failed to load.");
      System.out.println("File " + filename + " not found!");
      return null;
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();
    System.out.println("Loading Image ...");
    System.out.println("Image Size: " + width + " by " + height +
            " px.");

    int[][][] imagePixels = new int[height][width][3];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        imagePixels[i][j][0] = r;
        imagePixels[i][j][1] = g;
        imagePixels[i][j][2] = b;

      }
    }
    return imagePixels;
  }

  /**
   * Writes given image with given width. height and name into a PPM file.
   *
   * @param imagePixels Represents an image
   * @param width       represents width of image
   * @param height      represents height of image
   * @param filename    represents file name of image
   */
  public static void writePPM(int[][][] imagePixels, int width, int height, String filename) {
    try {
      BufferedImage bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          bImage.setRGB(j, i, (imagePixels[i][j][0] << 16) | (imagePixels[i][j][1] << 8) |
                  imagePixels[i][j][2]);
        }
      }


      BufferedWriter writer =
              new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
      writer.write(("P3\n" + width + " " + height + "\n255\n"));

      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          writer.write(imagePixels[i][j][0] + "\n" + imagePixels[i][j][1] + "\n"
                  + imagePixels[i][j][2] + "\n");

        }
      }
      writer.flush();
      writer.close();
      System.out.println("Saving ran");
    } catch (Exception e) {
      System.out.println("Error: " + e);
    }
  }
}

