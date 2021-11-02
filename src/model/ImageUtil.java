package model;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

/**
 * This class contains utility methods to read a PPM image from file and simply print its contents.
 * Feel free to change this method as required.
 */
public class ImageUtil {

  /**
   * Read an image file in the PPM format and print the colors.
   *
   * @param filename the path of the file. 
   */
  public static int[][][] readPPM(String filename) {
    Scanner sc;
    
    try {
        sc = new Scanner(new FileInputStream(filename));
    }
    catch (FileNotFoundException e) {
        System.out.println("File "+filename+ " not found!");
        return null;
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
        String s = sc.nextLine();
        if (s.charAt(0)!='#') {
            builder.append(s+System.lineSeparator());
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
    System.out.println("Width of image: "+width);
    int height = sc.nextInt();
    System.out.println("Height of image: "+height);
    int maxValue = sc.nextInt();
    System.out.println("Maximum value of a color in this file (usually 255): "+maxValue);

    int[][][] imagePixels = new int[height][width][3];

    for (int i=0;i<height;i++) {
        for (int j=0;j<width;j++) {
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

  public static void writePPM(int[][][] imagePixels, int width, int height, String filename) {
    try {
      BufferedImage bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          bImage.setRGB(j, i, (imagePixels[i][j][0] << 16) | (imagePixels[i][j][1] << 8) |
                  imagePixels[i][j][2]);
        }
      }

      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
      writer.write(("P3\n" + width + " " + height + "\n255\n"));

      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          writer.write(imagePixels[i][j][0] + "\n" + imagePixels[i][j][1] + "\n" + imagePixels[i][j][2] + "\n");
        }
      }
      writer.flush();
      writer.close();
      System.out.println("Saving ran");
    }

    catch (Exception e) {
      System.out.println("Error: " + e);
    }
  }

  /**
   * Reads an image from a file and returns it.
   *
   * @return the given image.
   */
  public static int[][][] readImage(String imagePath) {
    System.out.println(ImageUtil.readPPM(imagePath));
    return ImageUtil.readPPM(imagePath);
  }
}

