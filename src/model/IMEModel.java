package model;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Class to represent IME model.
 */
public class IMEModel {
  public HashMap<String, IModel> images;

  /**
   * Constructor.
   */
  public IMEModel() {
    images = new HashMap<>();
  }

  /**
   * Gets the image with the given name from the gallery.
   *
   * @param source Name the name of the image to get
   * @return The image with the given name.
   */
  public SingleImageModel getImage(String source) {
    return (SingleImageModel) images.get(source);
  }

  /**
   * Loads an image to the gallery.
   *
   * @param imageName Name of the image to add
   * @param image Image to add
   */
  public void loadImage(String imageName, IModel image) {
    images.put(imageName, image);
  }

  /**
   * Saves an image from the gallery to a file.
   *
   * @param imageName Name of the image to save
   */
  public void saveImage(String imagePath, String imageName) {
    SingleImageModel image = (SingleImageModel) images.get(imageName);

    ImageUtil.writePPM(image.getImage(), image.getImage()[0].length,image.getImage().length,
            imagePath);
    System.out.println("Height: " + image.getImage().length);
    System.out.println("Width: " + image.getImage()[0].length);
  }

  /**
   * Returns the gallery list.
   *
   * @return the gallery.
   */
  public IModel[] getGallery() {
    return images.values().toArray(new IModel[0]);
  }
}