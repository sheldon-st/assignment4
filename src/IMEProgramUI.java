import controller.IController;

import model.IModel;
import model.SingleImageModel;
import view.IView;
import view.TextView;

import controller.IMETextController;

public class IMEProgramUI {
    public static void main(String []args) {
        IModel model = new SingleImageModel();
        IView view = new TextView(System.out);
        IController controller = new IMETextController(model,System.in,view);
        controller.go();
    }
}
