package controller;

import model.IMEModel;
import model.IModel;
import model.ImageUtil;
import model.SingleImageModel;
import view.IView;
import java.io.InputStream;
import java.util.Scanner;

public class IMETextController implements IController {
    private Scanner in;
    private IView view;

    private IMEModel galleryModel;


    /**
     * Constructor for IMETextController
     * @param model the model to be used
     * @param in the scanner to be used
     * @param view the view to be used
     */
    public IMETextController(IModel model,InputStream in,IView view) {
        this.view = view;
        this.in = new Scanner(in);
        this.galleryModel = new IMEModel();
    }

    /**
     * Starts the program.
     */
    public void go() {
        boolean quit = false;

        while (!quit) {
            //tell view to show the string so far.
            //view.showString(this.model.getString());
            //tell view to show options
            view.showOptions();
            //accept user input
            String option = in.next();
            view.showString(option);
            String input = in.next();
            IModel tempImage = new SingleImageModel();

            switch (option) {
                case "load":
                    tempImage = new SingleImageModel();
                    //prints command
                    //view.showStringEntry();
                    view.showString("Attempting to load image from given path ... ");

                    //accept string input for path (CHECK HERE)

                    //give path to model
                    tempImage.setImage(ImageUtil.readImage(input));
                    //view.showString(tempImage.getPath());
                    //adds to gallery
                    //accept string input for name (CHECK HERE)
                    String name = in.next();

                    //try and load image
                    galleryModel.loadImage(name, tempImage);
                    view.showString("Image successfully loaded");


                    for (IModel i : galleryModel.getGallery()) {
                        System.out.println(i.getImage());
                    }

                    //System.out.println(galleryModel.images.get("k1"));

                    break;
                case "save":
                    //prints command
                    //view.showStringEntry();
                    view.showString(option);

                    view.showString("Attempting to save image to given path ... ");

                    //accept string input for path (CHECK HERE)
                   // input = in.next();
                    //give path to model
                    //String dest = in.next();

                   // view.showString(this.model.getPath());

                    //accept string input for name (CHECK HERE)
                    name = in.next();
                    //view.showString(this.model.getName());
                    //give path to model
                    galleryModel.saveImage(input, name);

                    view.showString("Image saved... ");
                    break;
                case "horizontal-flip":
                    //prints command
                    //view.showStringEntry();
                    view.showString(option);

                    view.showString("Attempting to flip given image ... ");

                    //accept string input for dest (CHECK HERE)
                    //String source = in.next();
                    System.out.println(input);

                    //accept string input for dest (CHECK HERE)
                    String dest = in.next();
                    System.out.println(dest);


                    tempImage = new SingleImageModel(galleryModel.getImage(input));

                    System.out.println(tempImage);
                    //tempImage.setImage(galleryModel.getImage(source));
                    tempImage.flipHorizontally();

                    galleryModel.loadImage(dest, tempImage);

                    for (IModel i : galleryModel.getGallery()) {
                        System.out.println(i.getImage());
                    }

                    view.showString("Image flipped... ");
                    break;
                case "vertical-flip":
                    //prints command
                    //view.showStringEntry();
                    view.showString(option);

                    view.showString("Attempting to flip given image ... ");

                    //accept string input for dest (CHECK HERE)
                    //String source = in.next();
                    System.out.println(input);

                    //accept string input for dest (CHECK HERE)
                    dest = in.next();
                    System.out.println(dest);


                    tempImage = new SingleImageModel(galleryModel.getImage(input));

                    System.out.println(tempImage);
                    //tempImage.setImage(galleryModel.getImage(source));
                    tempImage.flipVertically();

                    galleryModel.loadImage(dest, tempImage);

                    for (IModel i : galleryModel.getGallery()) {
                        System.out.println(i.getImage());
                    }

                    view.showString("Image flipped... ");
                    break;
                case "brighten":
                    //prints command
                    //view.showStringEntry();
                    view.showString(option);

                    view.showString("Attempting to brighten given image ... ");

                    //accept string input for dest (CHECK HERE)
                    //String source = in.next();
                    System.out.println(input);
                    int incrementInt = 0;
                    try {
                        incrementInt = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        view.showString("Invalid input");
                    }


                    //accept string input for dest (CHECK HERE)
                    String source = in.next();
                    System.out.println(source);

                    //accept string input for dest (CHECK HERE)
                    dest = in.next();
                    System.out.println(dest);


                    tempImage = new SingleImageModel(galleryModel.getImage(source));

                    System.out.println(tempImage);
                    //tempImage.setImage(galleryModel.getImage(source));
                    tempImage.brighten(incrementInt);

                    galleryModel.loadImage(dest, tempImage);

                    for (IModel i : galleryModel.getGallery()) {
                        System.out.println(i.getImage());
                    }

                    view.showString("Image flipped... ");
                    break;
                case "E":
                    //ask for string input
                    //view.showStringEntry();
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
// horizontal-flip k1 k3
// vertical-flip k1 k3
// brighten 10 k1 k10
// brighten 50 k1 k20

// save res/Koala3.ppm k3