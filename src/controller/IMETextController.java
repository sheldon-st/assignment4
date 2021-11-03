package controller;

import java.io.InputStream;
import java.util.Scanner;

import model.Filter;
import model.FilterImage;
import model.IMEModel;
import model.IModel;
import model.SingleImageModel;
import view.IView;

/**
 * Class implements' controller interface it takes in a.
 */

public class IMETextController implements IController {
  private Scanner in;
  private IView view;
  private IMEModel galleryModel;


  /**
   * Constructor for IMETextController
   *
   * @param model the model to be used
   * @param in    the scanner to be used
   * @param view  the view to be used
   */
  public IMETextController(IMEModel model, InputStream in, IView view) {
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
      switch (option) {
        case "load":

          //prints command
          view.showString(option);
          view.showString("Attempting to load image from given path ... ");
          //accept string input for path (CHECK HERE)
          String input = in.next();
          //give path to model
          IModel tempImage = new SingleImageModel(input);
          //adds to gallery
          //accept string input for name (CHECK HERE)
          input = in.next();
          //try and load image
          tempImage.setImage();
          galleryModel.loadImage(input, tempImage);
          view.showString("Image successfully loaded");
          break;

        case "save":
          //prints command
          view.showStringEntry();
          view.showString(option);
          view.showString("Attempting to save image to given path ... ");
          String path = in.next();
          //accept string input for name (CHECK HERE)
          input = in.next();
          //give path to model
          galleryModel.saveImage(path, input);
          view.showString("Image saved... ");
          break;

        case "red-component":
          //prints command
          view.showStringEntry();
          view.showString(option);
          //accept string input for name (CHECK HERE)
          String imageName = in.next();
          String newImg = in.next();
          //give path to model
          Filter newModel =
                  new FilterImage(galleryModel.images.get(imageName).getImage());
          newModel.redScale();
          galleryModel.images.put(newImg, new SingleImageModel(newModel.getNewImage()));
          view.showString("Image saved... ");
          break;

        case "blue-component":
          //prints command
          view.showStringEntry();
          view.showString(option);
          //accept string input for name (CHECK HERE)
          imageName = in.next();
          newImg = in.next();
          newModel =
                  new FilterImage(galleryModel.images.get(imageName).getImage());
          newModel.blueScale();
          galleryModel.images.put(newImg, new SingleImageModel(newModel.getNewImage()));
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
          //accept string input for name (CHECK HERE)
          imageName = in.next();
          newImg = in.next();
          newModel =
                  new FilterImage(galleryModel.images.get(imageName).getImage());
          newModel.greenScale();
          galleryModel.images.put(newImg, new SingleImageModel(newModel.getNewImage()));
          view.showString("Image saved... ");
          break;

        case "intensity-component":
          //prints command
          view.showStringEntry();
          view.showString(option);
          //accept string input for name (CHECK HERE)
          imageName = in.next();
          newImg = in.next();
          newModel =
                  new FilterImage(galleryModel.images.get(imageName).getImage());
          newModel.intensityScale();
          galleryModel.images.put(newImg, new SingleImageModel(newModel.getNewImage()));
          view.showString("Image saved... ");
          break;

        case "value-component":
          view.showStringEntry();
          view.showString(option);
          //accept string input for name (CHECK HERE)
          imageName = in.next();
          newImg = in.next();
          newModel =
                  new FilterImage(galleryModel.images.get(imageName).getImage());

          newModel.valueScale();
          galleryModel.images.put(newImg, new SingleImageModel(newModel.getNewImage()));
          view.showString("Image saved... ");
          break;
        case "luma-component":
          view.showStringEntry();
          view.showString(option);
          view.showString("Attempting to create a greyscale image with the " +
                  "red-component of the image with the given name, and refer to it " +
                  "henceforth in the program by the given destination name. ");
          //accept string input for name (CHECK HERE)
          imageName = in.next();
          newImg = in.next();
          newModel =
                  new FilterImage(galleryModel.images.get(imageName).getImage());
          newModel.lumaScale();
          galleryModel.images.put(newImg, new SingleImageModel(newModel.getNewImage()));
          view.showString("Image saved... ");
          break;

        case "horizontal-flip":
          //prints command
          //view.showStringEntry();
          view.showString(option);
          view.showString("Attempting to flip given image ... ");
          imageName = in.next();
          newImg = in.next();
          newModel =
                  new FilterImage(galleryModel.images.get(imageName).getImage());
          newModel.flipHorizontally();
          galleryModel.images.put(newImg, new SingleImageModel(newModel.getNewImage()));
          view.showString("Image flipped... ");
          break;
        case "vertical-flip":
          //prints command
          //view.showStringEntry();
          view.showString(option);
          view.showString("Attempting to flip given image ... ");
          imageName = in.next();
          newImg = in.next();
          newModel =
                  new FilterImage(galleryModel.images.get(imageName).getImage());
          newModel.flipVertically();
          galleryModel.images.put(newImg, new SingleImageModel(newModel.getNewImage()));
          view.showString("Image flipped... ");
          break;
        case "brighten":
          //prints command
          view.showString(option);
          view.showString("Attempting to brighten given image ... ");
          int incrementInt = 0;
          try {
            incrementInt = Integer.parseInt(in.next());
          } catch (NumberFormatException e) {
            view.showString("Invalid input");
          }
          imageName = in.next();
          newImg = in.next();
          newModel =
                  new FilterImage(galleryModel.images.get(imageName).getImage());
          newModel.brighten(incrementInt);
          galleryModel.images.put(newImg, new SingleImageModel(newModel.getNewImage()));
          view.showString("Image flipped... ");
          break;
        case "E":
          //ask for string input
          in.nextLine();
          input = in.nextLine();
          //give to model
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
