package controller;

import model.IMEModel;
import model.IModel;
import model.SingleImageModel;
import view.IView;
import java.io.InputStream;
import java.util.Scanner;

public class IMETextController implements controller.IController {
    private Scanner in;
    private IView view;
    private IModel model;

    private IMEModel galleryModel;


    public IMETextController(IModel model,InputStream in,IView view) {

        this.view = view;
        this.in = new Scanner(in);

        this.galleryModel = new IMEModel();
        this.model = model;
    }

    public void go() {
        boolean quit = false;

        while (!quit) {
            //tell view to show the string so far.
            //view.showString(this.model.getString());
            //tell view to show options
            view.showOptions();
            //accept user input
            String option = in.next();
            switch (option) {
                case "load":
                    IModel tempImage = new SingleImageModel();
                    //prints command
                    //view.showStringEntry();
                    view.showString(option);
                    view.showString("Attempting to load image from given path ... ");


                    //accept string input for path (CHECK HERE)
                    String input = in.next();
                    //give path to model
                    tempImage.setPath(input);
                    view.showString(tempImage.getPath());
                    //adds to gallery
                    //accept string input for name (CHECK HERE)
                    input = in.next();

                    //try and load image
                    tempImage.setImage();
                    galleryModel.loadImage(input, tempImage);
                    view.showString("Image successfully loaded");



                    for (IModel i : galleryModel.getGallery()) {
                        System.out.println(i.getImage());
                    }

                    System.out.println(galleryModel.images.get("k1"));

                    break;
                case "save":
                    //prints command
                    view.showStringEntry();
                    view.showString(option);

                    view.showString("Attempting to save image to given path ... ");

                    //accept string input for path (CHECK HERE)
                   // input = in.next();
                    //give path to model
                    String path = in.next();

                    view.showString(this.model.getPath());

                    //accept string input for name (CHECK HERE)
                    input = in.next();
                    //view.showString(this.model.getName());
                    //give path to model
                    galleryModel.saveImage(path, input);

                    view.showString("Image saved... ");
                    break;
                case "E":
                    //ask for string input
                    view.showStringEntry();
                    in.nextLine();
                    input = in.nextLine();
                    //give to model
                    //model.setString(input);
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


// comments for testing
// load res/Koala.ppm k1
// save res/Koala2.ppm k1