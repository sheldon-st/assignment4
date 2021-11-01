package controller;

import model.IModel;
import view.IView;
import java.io.InputStream;
import java.util.Scanner;

public class IMETextController implements controller.IController {
    private Scanner in;
    private IView view;
    private IModel model;

    public IMETextController(IModel model,InputStream in,IView view) {
        this.model = model;
        this.view = view;
        this.in = new Scanner(in);

    }

    public void go() {
        boolean quit = false;

        while (!quit) {
            //tell view to show the string so far.
            view.showString(this.model.getString());
            //tell view to show options
            view.showOptions();
            //accept user input
            String option = in.next();
            switch (option) {
                case "load":
                    //prints command
                    view.showStringEntry();
                    view.showString(option);

                    view.showString("Attempting to load image from given path ... ");


                    //accept string input for path (CHECK HERE)
                    String input = in.next();
                    //give path to model
                    model.setPath(input);
                    view.showString(this.model.getPath());


                    //accept string input for name (CHECK HERE)
                    input = in.next();
                    //give path to model
                    model.setName(input);
                    view.showString(this.model.getName());

                    //try and load image
                    model.setImage();
                    view.showString("Image successfully loaded");
                    break;
                case "save":
                    //prints command
                    view.showStringEntry();
                    view.showString(option);

                    view.showString("Attempting to save image to given path ... ");

                    //accept string input for path (CHECK HERE)
                    input = in.next();
                    //give path to model
                    model.setPath(input);
                    view.showString(this.model.getPath());


                    //accept string input for name (CHECK HERE)
                    input = in.next();
                    //give path to model
                    model.setName(input);
                    view.showString(this.model.getName());

                    view.showString("Image saved? ");
                    break;
                case "E":
                    //ask for string input
                    view.showStringEntry();
                    in.nextLine();
                    input = in.nextLine();
                    //give to model
                    model.setString(input);
                    break;
                case "Q":
                    quit = true;
                    break;
                default:
                    view.showOptionError();
            }
        }
    }
}
