package model;
import java.util.HashMap;

/**
 * This class contains all the images saved/loaded from the script into a hashmap.
 */
public class IMEModel {
  public HashMap<String, IModel> images;

  public IMEModel() {
    images = new HashMap<>();
  }

  // adds an image with the given path
  public void loadImage(String imageName, IModel image) {
    images.put(imageName, image);
  }

  // adds an image with the given path
  public void saveImage(String imagePath, String imageName) {
    SingleImageModel image = (SingleImageModel) images.get(imageName);

    ImageUtil.writePPM(image.getImage(), image.getImage()[0].length,image.getImage().length,
            imagePath);
    System.out.println("Height: " + image.getImage().length);
    System.out.println("Width: " + image.getImage()[0].length);
  }

  // duplicates an image with given name as a new image
  public void duplicateImage(String imageName, String newImageName) {
    images.put(newImageName, images.get(imageName));
  }

  // duplicates a ppm image with name to greyscale
  public void greyscaleImage(String imageName, String newImageName) {

  }

  // returns this classes images gallery
  public IModel[] getGallery() {
    return images.values().toArray(new IModel[0]);
  }
}