package controller;
import org.junit.Test;

import java.util.Scanner;

import model.IMEModel;
import model.IModel;
import model.SingleImageModel;
import view.IView;
import view.TextView;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class IMECommandControllerTests {
  IMEModel model = new IMEModel();
  IView view = new TextView(System.out);
  IController controller = new IMECommandController(model,System.in,view);

  @Test
  public void testLoadCommand() {
    String testLoadString = "load res/venice.ppm v";
    Scanner s = new Scanner(testLoadString);
    controller.setScanner(s);
    controller.go();
    assertEquals(model.images.size(), 410);

  }
}

