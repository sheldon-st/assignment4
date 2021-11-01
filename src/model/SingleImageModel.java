package model;

import java.io.DataOutputStream;

public class SingleImageModel implements model.IModel {
  private String input;

  private Pixel[][] image;
  private String imageName;
  private String imagePath;

  public SingleImageModel() {
    input = "";
    imageName = "";
    imagePath = "";
    image = null;
  }

  public SingleImageModel(String imagePath) {
    input = "";
    imageName = "";
    this.imagePath = imagePath;
    image = null;
  }

  @Override
  public void setString(String i) {
    input = i;
  }

  @Override
  public String getString() {
    return input;
  }

  @Override
  public void setName(String i) {
    imageName = i;
  }

  @Override
  public String getName() {
    return "Image Name:" + imageName;
  }

  @Override
  public void setPath(String i) {
    imagePath = i;
  }

  @Override
  public String getPath() {
    return "Image Path:" + imagePath;
  }

  @Override
  public void setImage() {
    // use image utility to get image
    image = ImageUtil.readPPM(this.imagePath);
    // image = new
  }
}