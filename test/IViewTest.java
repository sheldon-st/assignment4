import org.junit.Test;

import java.io.PrintStream;

import controller.IMECommandController;
import model.IMEModel;
import model.IModel;
import view.IView;
import view.TextView;

import static org.junit.jupiter.api.Assertions.*;

public class IViewTest {
  // creates a new model, view and controller then tests the main method with different inputs
  @Test
  public void testShowString(){

    PrintStream printStream = new PrintStream(System.out);
    TextView view = new TextView(printStream);
    IMEModel model = new IMEModel();
    IMECommandController controller = new IMECommandController(model, System.in, view);
    view.showString("test");
    assertEquals("test", System.out.);
  }

  }
