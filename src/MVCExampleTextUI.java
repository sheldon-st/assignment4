package src;

import src.controller.IController;
import src.controller.TextController;
import src.model.IModel;
import src.model.Model;
import src.view.IView;
import src.view.TextView;

public class MVCExampleTextUI {
    public static void main(String []args) {
        IModel model = new Model();
        IView view = new TextView(System.out);
        IController controller = new TextController(model,System.in,view);
        controller.go();
    }
}
