package controller;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import model.IMEModel;
import view.IView;
import view.TextView;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for IMECommandController class.
 */
public class IMECommandControllerTests {

  /**
   * Tests load and save operations for command IMECommandController.
   *
   * @throws IOException
   */
  @Test
  public void testLoadSaveCommands() throws IOException {
    IMEModel model = new IMEModel();
    IView view = new TextView(System.out);
    IController controller = new IMECommandController(model, System.in, view);
    String testLoadString = "load res/venice.ppm v" + "\nload res/venice.ppm v1" +
            "\nsave res/veniceTEST.ppm v" + "\nsave res/veniceTEST2.ppm v1" + "\n" + "q";
    Scanner s = new Scanner(testLoadString);
    controller.setScanner(s);
    controller.go();
    assertTrue(Files.mismatch(Paths.get("res/veniceTEST.ppm"),
            Paths.get("res/veniceTEST2.ppm")) == -1L);
  }

  /**
   * Tests for IMECommandController class for case that given image does not exist at source.
   */
  @Test
  public void testNoImageAtPath() {
    IMEModel model = new IMEModel();
    IView view = new TextView(System.out);
    String testLoadString = "load res/venice.ppm venice \nload res/paris.ppm paris " +
            "\nsave res/veniceCopy.ppm venice \nsave res/parisCopy.ppm paris \nq";
    Scanner s = new Scanner(testLoadString);
    IController controller = new IMECommandController(model, System.in, view);
    controller.setScanner(s);
    controller.go();
    assertTrue(Files.exists(Paths.get("res/veniceCopy.ppm")));
    assertFalse(Files.exists(Paths.get("res/parisCopy.ppm")));
  }

  /**
   * Tests for IMECommandController class for case that brighten input string is not an integer.
   */
  @Test
  public void testIncrementNotInt() throws IOException {
    IMEModel model = new IMEModel();
    IView view = new TextView(System.out);
    String testLoadString = "load res/venice.ppm v1 \nload res/venice.ppm v2" +
            "\nload res/venice.ppm vOriginal" +
            "\nbrighten 10 v1 v1brighter \nbrighten ten v2 v2brighter" +
            "\nsave res/vOriginal.ppm vOriginal \nsave res/vBrighter.ppm v1brighter \nsave res/vBrighterFailed.ppm v2brighter " +
            "\nq";
    Scanner s = new Scanner(testLoadString);
    IController controller = new IMECommandController(model, System.in, view);
    controller.setScanner(s);
    controller.go();
    assertFalse(Files.exists(Paths.get("res/vBrighterFailed.ppm")));
    assertFalse(Files.mismatch(Paths.get("res/vOriginal.ppm"),
            Paths.get("res/vbrighter.ppm")) == -1L);

  }

  /**
   * Tests for IMECommandController class for case that given image does not exist within the model.
   */
  @Test
  public void testImageNotLoaded() throws IOException {
    IMEModel model = new IMEModel();
    IView view = new TextView(System.out);
    String testLoadString = "load res/venice.ppm v1 \nload res/venice.ppm v2" +
            "\nload res/venice.ppm v3" +
            "\nbrighten 10 v1 v1brighter \nbrighten 10 v4 v2brighter" +
            "\nsave res/vOriginal.ppm v3 \nsave res/v1.ppm v1brighter \nsave res/vBrighterFailed.ppm v2brighter " +
            "\nsave res/randomPhoto.ppm randomSource " +
            "\nq";
    Scanner s = new Scanner(testLoadString);
    IController controller = new IMECommandController(model, System.in, view);
    controller.setScanner(s);
    controller.go();
    assertFalse(Files.exists(Paths.get("res/vBrighterFailed.ppm")));
    assertFalse(Files.exists(Paths.get("res/randomPhoto.ppm")));
    assertFalse(Files.mismatch(Paths.get("res/vOriginal.ppm"),
            Paths.get("res/vbrighter.ppm")) == -1L);
  }

  /**
   * Tests for IMECommandController class for case that command is either not recognized or first
   * word is recognized but arguments are not.
   */
  @Test
  public void testInvalidCommand() {
    IMEModel model = new IMEModel();
    IView view = new TextView(System.out);
    String testLoadString = "load res/venice.ppm venice \nload venice2 " +
            "\nbrighten venice venice3" +
            "\nsave res/veniceCopy.ppm venice \nsave res/veniceCopy3.ppm venice2 " +
            "\nsave res/veniceCopy3.ppm venice3 \nq";
    Scanner s = new Scanner(testLoadString);
    IController controller = new IMECommandController(model, System.in, view);
    controller.setScanner(s);
    controller.go();
    assertTrue(Files.exists(Paths.get("res/veniceCopy.ppm")));
    assertFalse(Files.exists(Paths.get("res/veniceCopy3.ppm")));
    assertFalse(Files.exists(Paths.get("res/veniceCopy3.ppm")));
  }
}
