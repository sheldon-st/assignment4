package controller;

import model.Filter;
import model.FilterImage;
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

                case "red-component":
                    //prints command
                    view.showStringEntry();
                    view.showString(option);

                    view.showString("Attempting to create a greyscale image with the " +
                            "red-component of the image with the given name, and refer to it " +
                            "henceforth in the program by the given destination name. ");
                    //accept string input for name (CHECK HERE)
                    String imageName = in.next();
                    String newImg = in.next();
                    view.showString(this.model.getPath());
                    //give path to model

                    Filter newModel =
                            new  FilterImage(galleryModel.images.get(imageName).getImage());

                    newModel.redScale();

                    galleryModel.images.put(newImg, new SingleImageModel(newModel.getNewImage()));
                    view.showString("Image saved... ");
                    break;

                case "blue-component":
                    //prints command
                    view.showStringEntry();
                    view.showString(option);

                    view.showString("Attempting to create a greyscale image with the " +
                            "red-component of the image with the given name, and refer to it " +
                            "henceforth in the program by the given destination name. ");
                    //accept string input for name (CHECK HERE)
                     String prevName = in.next();
                     String newImgName = in.next();
                    view.showString(this.model.getPath());

                    Filter newBlueModel =
                            new  FilterImage(galleryModel.images.get(prevName).getImage());

                    newBlueModel.blueScale();

                    galleryModel.images.put(newImgName,
                            new SingleImageModel(newBlueModel.getNewImage()));
                    view.showString("Image saved... ");
                    break;

                case "green-component":
                    //prints command
                    view.showStringEntry();
                    view.showString(option);

                    view.showString("Attempting to create a greyscale image with the " +
                            "red-component of the image with the given name, and refer to it " +
                            "henceforth in the program by the given destination name. ");
                    //accept string input for name (CHECK HERE)
                    String imag = in.next();
                    String nImg = in.next();
                    view.showString(this.model.getPath());
                    //give path to model

                    Filter newGreenModel =
                            new  FilterImage(galleryModel.images.get(imag).getImage());

                    newGreenModel.greenScale();

                    galleryModel.images.put(nImg,
                            new SingleImageModel(newGreenModel.getNewImage()));
                    view.showString("Image saved... ");
                    break;

                case "intensity-component":
                    //prints command
                    view.showStringEntry();
                    view.showString(option);

                    view.showString("Attempting to create a greyscale image with the " +
                            "red-component of the image with the given name, and refer to it " +
                            "henceforth in the program by the given destination name. ");
                    //accept string input for name (CHECK HERE)
                    String originImage = in.next();
                    String newIm = in.next();
                    view.showString(this.model.getPath());
                    //give path to model
                    Filter valueImg =
                            new  FilterImage(galleryModel.images.get(originImage).getImage());

                    valueImg.valueScale();
                    galleryModel.images.put(newIm,
                            new SingleImageModel(valueImg.getNewImage()));
                    view.showString("Image saved... ");
                    break;

                case "value-component":
                    //prints command
                    view.showStringEntry();
                    view.showString(option);

                    view.showString("Attempting to create a greyscale image with the " +
                            "red-component of the image with the given name, and refer to it " +
                            "henceforth in the program by the given destination name. ");
                    //accept string input for name (CHECK HERE)
                     String originIm = in.next();
                     String newI = in.next();
                    view.showString(this.model.getPath());
                    //give path to model
                    Filter intenseImg =
                            new  FilterImage(galleryModel.images.get(originIm).getImage());

                    intenseImg.intensityScale();
                    galleryModel.images.put(newI,
                            new SingleImageModel(intenseImg.getNewImage()));
                    view.showString("Image saved... ");
                    break;

                case "luma-component":
                    //prints command
                    view.showStringEntry();
                    view.showString(option);

                    view.showString("Attempting to create a greyscale image with the " +
                            "red-component of the image with the given name, and refer to it " +
                            "henceforth in the program by the given destination name. ");
                    //accept string input for name (CHECK HERE)
                    String originI = in.next();
                    String img = in.next();
                    view.showString(this.model.getPath());
                    //give path to model
                    Filter lumaImg =
                            new  FilterImage(galleryModel.images.get(originI).getImage());

                    lumaImg.lumaScale();
                    galleryModel.images.put(img,
                            new SingleImageModel(lumaImg.getNewImage()));
                    view.showString("Image saved... ");
                    break;


                case "E":
                    //ask for string input
                    view.showStringEntry();
                    in.nextLine();
                    input = in.nextLine();
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
// load res/venice.ppm k1
// save res/veniceSave.ppm k1

// red-component k1 redK
// save res/redK.ppm redK
// blue-component k1 blueK
// save res/blueK.ppm blueK
// green-component k1 greenK
// save res/greenK.ppm greenK
// value-component k1 valueK
// save res/valueK.ppm valueK
// intensity-component k1 intensK
// save res/intensK.ppm intensK
// luma-component k1 lumaK
// save res/lumaK.ppm lumaK