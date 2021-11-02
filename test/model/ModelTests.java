package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTests {
  /**
   Tests the getImage method of the IMEModel class and the getImage method of the ImageModel class.
   */
  @Test
  void getImage() {
    IMEModel model = new IMEModel();
    IModel tempImage = new SingleImageModel();
    tempImage.setImage(ImageUtil.readImage("res/koala.ppm"));
    model.loadImage("k1", tempImage);
    model.loadImage("k2", tempImage);

    assertEquals(model.getImage("k1").getImage(), model.getImage("k2").getImage());
    assertEquals(model.getImage("k1").getImage(), ImageUtil.readImage("res/koala.ppm"));
  }

  /**
   Tests the getImage method of the IMEModel class and the getImage method of the ImageModel class.
   */
  @Test
  void loadImage() {
  }

  @Test
  void saveImage() {
  }
}