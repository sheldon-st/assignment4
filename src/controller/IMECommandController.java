package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import controller.commands.Brighten;
import controller.commands.Components;
import controller.commands.HorizontalFlip;
import controller.commands.Load;
import controller.commands.Save;
import controller.commands.VerticalFlip;
import model.IMEModel;
import view.IView;

/**
 * This is a controller that is very similar to the
 * CommandController class. The main difference
 * is that the main is replaced with the controller
 * method processCommand
 */
public class IMECommandController implements IController {
  private IMEModel model;
  private IView view;
  private InputStream in;
  private Scanner s;

  /**
   * Constructor for the IMECommandController.
   *
   * @param model
   * @param view
   * @param in    input stream
   */
  public IMECommandController(IMEModel model, InputStream in, IView view) {
    this.model = new IMEModel();
    this.view = view;
    this.in = in;

    this.s = new Scanner(in);
  }

  /**
   * This method is the main method of the controller.
   * It will take in a stream of commands and process it.
   */
  public void go() {
    boolean quit = false;
    String[] line = null;
    view.showOptions();

    while (!quit) {
      view.showString("Enter Command:");
      while (s.hasNextLine()) {
        //tell view to show the string so far.
        //view.showString(this.model.getString());
        //tell view to show options
        IMECommand cmd = null;
        //accept user input
        //String array of scanner line seperated by spaces
        line = s.nextLine().split(" ");
        try {
          switch (line[0].toLowerCase()) {
            case "load":
              cmd = new Load(line[1], line[2]);
              view.showString("Attempting to load image " + line[2] + " from " + line[1] + "...");
              break;
            case "save":
              cmd = new Save(line[1], line[2]);
              view.showString("Attempting to save image " + line[2] + " to " + line[1] + "...");
              break;
            case "horizontal-flip":
              cmd = new HorizontalFlip(line[1], line[2]);
              view.showString("Attempting to create a copy of " + line[1] + " flipped horizontally" +
                      " referred to henceforth by " + line[2] + "...");
              break;
            case "vertical-flip":
              cmd = new VerticalFlip(line[1], line[2]);
              view.showString("Attempting to create a copy of " + line[1] + " flipped vertically" +
                      " referred to henceforth by " + line[2] + "...");
              break;
            case "brighten":
              try {
                int increment = Integer.parseInt(line[1]);
                cmd = new Brighten(increment, line[2], line[3]);
                view.showString("Attempting to create a copy of " + line[2] + " brightened by " +
                        line[1] + ", referred to henceforth by " + line[3] + "...");
                break;
              } catch (NumberFormatException e) {
                view.showString("Increment must be an integer:" + cmd);
                break;
              }
            case "red-component":
              cmd = new Components.RedComponent(line[1], line[2]);
              view.showString("Attempting to create a greyscale copy of " + line[1] +
                      "'s red component, referred to henceforth by " + line[2] + "...");
              break;
            case "blue-component":
              cmd = new Components.BlueComponent(line[1], line[2]);
              view.showString("Attempting to create a greyscale copy of " + line[1] +
                      "'s blue component, referred to henceforth by " + line[2] + "...");
              break;
            case "green-component":
              cmd = new Components.GreenComponent(line[1], line[2]);
              view.showString("Attempting to create a greyscale copy of " + line[1] +
                      "'s green component, referred to henceforth by " + line[2] + "...");
              break;
            case "intensity-component":
              cmd = new Components.IntensityComponent(line[1], line[2]);
              view.showString("Created a greyscale copy of " + line[1] +
                      "'s intensity component, referred to henceforth by " + line[2] + "...");
              break;
            case "value-component":
              cmd = new Components.ValueComponent(line[1], line[2]);
              view.showString("Attempting to create a greyscale copy of " + line[1] +
                      "'s value component, referred to henceforth by " + line[2] + "...");
              break;
            case "luma-component":
              cmd = new Components.LumaComponent(line[1], line[2]);
              view.showString("Attempting to create a greyscale copy of " + line[1] +
                      "'s luma component, referred to henceforth by " + line[2] + "...");
              break;
            case "run":
              String data = "";
              data = new String(Files.readAllBytes(Paths.get(line[1])));
              // System.out.print(data);
              this.s = new Scanner(data);
              view.showString("Attempting to run script at " + line[1] + "...");
              break;
            case "m":
              view.showOptions();
              //ask for string input
              //give to model
              break;
            case "q":
              quit = true;
              view.showString("Quitting program... Thank You!");
              break;
            default:
              view.showString(String.format("Unknown command :%s", line[0]));
              cmd = null;
              break;
          }
          if (cmd != null) {
            cmd.go(model);
            view.showString("Executed Command: " + Arrays.toString(line));
          }
        } catch (NullPointerException e) {
          view.showString("Cannot find image:" + Arrays.toString(line));
        } catch (IndexOutOfBoundsException e) {
          view.showString("Invalid Command Parameters:" + Arrays.toString(line));
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }
        view.showString("********************************************************************************");
      }
    }
  }

  public void setScanner(Scanner s) {
    this.s = s;
  }
}
