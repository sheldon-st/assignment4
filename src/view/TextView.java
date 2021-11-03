package view;

import java.io.PrintStream;

public class TextView implements view.IView {
  private PrintStream out;

  public TextView(PrintStream out) {
    this.out = out;
  }

  public void showString(String s) {
    out.println(s);
  }

  public void showOptions() {
    //print the UI
    out.println("Menu: ");
    out.println(" load [image-path] [image-name]: loads an image from [image-path] " +
            "to be referred to as [image-name]");
    out.println(" save [image-path] [image-name]: saves image [image-name] " +
            "to path [image-path]");

    // todo in code
    out.println(" Image Visualization: creates a new image of specified component " +
            "from [image-name] to be referred to as [dest-image-name]");
    out.println("  red-component [image-name] [dest-image-name]");
    out.println("  green-component [image-name] [dest-image-name]");
    out.println("  blue-component [image-name] [dest-image-name]");
    out.println("  value-component [image-name] [dest-image-name]");
    out.println("  luma-component [image-name] [dest-image-name]");
    out.println("  intensity-component [image-name] [dest-image-name]");

    // flips
    out.println(" horizontal-flip [image-name] [dest-image-name]: " +
            "flip an image horizontally to create a new image referred to as [image-name]");
    out.println(" vertical-flip [image-name] [dest-image-name]: " +
            "flip an image vertically to create a new image referred to as [image-name]");

    // brighten
    out.println(" brighten [increment] [image-name] [dest-image-name]" +
            "brighten the image by the given increment (+/-) to create a new image referred to"
            + "as [dest-image-name]");
    out.println(" M: See the full menu again");
    out.println(" Q: Quit the program");
    out.println("********************************************************************************");

  }

  public void showStringEntry() {
    out.print("\nCommand: ");
  }

  public void showOptionError() {
    out.print("\nInvalid option. Please try again.");
  }
}
