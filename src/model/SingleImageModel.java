package model;

import java.io.DataOutputStream;

public class SingleImageModel implements IModel {
  private int[][][] image;
  private String imagePath;

  public SingleImageModel() {
    imagePath = "";
    image = null;
  }

  public SingleImageModel(String imagePath) {
    this.imagePath = imagePath;
    image = ImageUtil.readPPM(this.imagePath);
  }

  public SingleImageModel(int[][][] image) {
    this.imagePath = "";
    this.image = image;
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
    this.image = ImageUtil.readPPM(this.imagePath);
  }


  @Override
  public int[][][] getImage() {
    System.out.println(this.image);
    return this.image;
  }


  @Override
  public boolean equals(Object o) {
    if (o instanceof SingleImageModel) {
      SingleImageModel other = (SingleImageModel) o;
      return this.image.equals(other.image);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return image.hashCode();
  }


}