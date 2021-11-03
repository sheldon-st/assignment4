import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import model.IMEModel;
import model.IModel;
import model.SingleImageModel;

import static org.junit.Assert.*;

public class SingleImageModelTest {

  private IMEModel galleryModel = new IMEModel();
  private int[][][] koalaImage;
  private int[][][] veniceImage;
  private final String venPath = "res/venice.ppm";
  private final String koPath = "res/Koala.ppm";
  private final int veniceWidth = 615;
  private final int veniceHeight = 410;
  private final int KoalaWidth = 1024;
  private final int koalaHeight = 768;
  private final int rbg = 3;


  @Test
  public void testConstructorIModel()  {
    IModel empty = new SingleImageModel();
    IModel koala = new SingleImageModel(koPath);
    IModel koalaImage = new SingleImageModel(koala.getImage());
    IModel venice = new SingleImageModel(venPath);
  }


  /**
   * Tests the getImage method of the IMEModel class and the getImage method of the ImageModel class.
   */
  @Test
  public void getImage() {
    IModel koala = new SingleImageModel(koPath);
    galleryModel.loadImage("k1", koala);
    galleryModel.loadImage("k2", koala);
    assertEquals(galleryModel.images.get("k1").getImage(), galleryModel.images.get("k2").getImage());
    assertEquals(koalaHeight, galleryModel.images.get("k1").getImage().length);
    assertEquals(KoalaWidth, galleryModel.images.get("k1").getImage()[0].length);
    assertEquals(rbg, galleryModel.images.get("k1").getImage()[0][0].length);
  }

  /**
   * Tests the getImage method of the IMEModel class and the getImage method of the ImageModel class.
   */
  @Test
  public void loadImage() {
    IModel venice = new SingleImageModel(venPath);
    galleryModel.loadImage("k1", venice);
    galleryModel.loadImage("k2", venice);
    assertEquals(galleryModel.images.get("k1").getImage(), galleryModel.images.get("k2").getImage());
    assertEquals(veniceHeight, galleryModel.images.get("k1").getImage().length);
    assertEquals(veniceWidth, galleryModel.images.get("k1").getImage()[0].length);
    assertEquals(rbg, galleryModel.images.get("k1").getImage()[0][0].length);
  }

  @Test
  public void saveImage() throws IOException {
    IModel venice = new SingleImageModel(venPath);
    galleryModel.loadImage("k1", venice);
    galleryModel.loadImage("k2", venice);
    galleryModel.saveImage("res/venice2.ppm","k1");
    galleryModel.saveImage("res/venice3.ppm","k2");
    assertTrue(Files.mismatch(Paths.get("res/venice2.ppm"),
            Paths.get("res/venice3.ppm")) == -1L);
  }

  @Test
  public void testEquals() {
  }

  @Test
  public void testHashCode() {
  }

  @Test
  public void setPath() {
  }

  @Test
  public void getPath() {
  }
}