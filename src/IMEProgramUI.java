import controller.IController;

import controller.IMECommandController;
import model.IMEModel;
import model.IModel;
import model.SingleImageModel;
import view.IView;
import view.TextView;

import controller.IMETextController;

public class IMEProgramUI {
    public static void main(String []args) {
        IMEModel model = new IMEModel();
        IView view = new TextView(System.out);
        IController controller = new IMECommandController(model,System.in,view);
        controller.go();
    }
}
