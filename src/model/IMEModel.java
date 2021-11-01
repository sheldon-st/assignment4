package model;

import java.util.Dictionary;
import java.util.Hashtable;

public class IMEModel {
  private Dictionary images = new Hashtable();


  public IMEModel() {
    //input = "";
  //  imageName = "";
  //  imagePath = "";
  }

  //
  public void addImage(String imageName, String imagePath) {
    images.put(imageName, new SingleImageModel(imagePath));
  }

  //
  public void saveImage(String imageName, String imagePath) {
    //images.put(imageName, imagePath);
  }

  // duplicates an image with given name as a new image
  public void duplicateImage(String imageName, String newImageName) {
    images.put(newImageName, images.get(imageName));
  }

  // duplicates a ppm image with name to greyscale
  public void greyscaleImage(String imageName, String newImageName) {


  }
}