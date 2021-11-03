
import org.junit.jupiter.api.Test;

import model.IMEModel;
import model.IModel;
import model.SingleImageModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModelTest {

  /**
   * Tests the getImage method of the IMEModel class and the getImage method of the ImageModel class.
   */
  @Test
  void getImage() {
    IMEModel model = new IMEModel();
    IModel tempImage = new SingleImageModel("res/Koala.ppm");
    model.loadImage("k1", tempImage);
    model.loadImage("k2", tempImage);

    assertEquals(model.images.get("k1").getImage(), model.images.get("k2").getImage());
    assertEquals(768, model.images.get("k1").getImage().length);
    assertEquals(1024, model.images.get("k1").getImage()[0].length);
    assertEquals(3, model.images.get("k1").getImage()[0][0].length);

  }

  /**
   * Tests the getImage method of the IMEModel class and the getImage method of the ImageModel class.
   */
  @Test
  void loadImage() {
  }

  @Test
  void saveImage() {
  }
}