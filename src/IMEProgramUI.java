import controller.IController;
import controller.IMECommandController;
import model.IMEModel;
import view.IView;
import view.TextView;

/**
 * This class is the main class of the program. It creates the view, model,
 * and controller.
 */
public class IMEProgramUI {
  /**
   * The main method.
   * @param args The command line arguments.
   */
  public static void main(String[] args) {
    IMEModel model = new IMEModel();
    IView view = new TextView(System.out);
    IController controller = new IMECommandController(model, System.in, view);
    controller.startProgram();
  }
}
