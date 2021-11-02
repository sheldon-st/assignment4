package model;

public class FilterImage implements Filter {
  protected IModel model;

  public FilterImage(IModel model) {
    this.model = model;
  }

  public IModel getModel(){
    return this.model;

  }

  public void redScale() {
    for (int i = 0; i < model.getImage().length; i++) {
      for (int j = 0; j < model.getImage()[0].length; j++) {
        model.getImage()[i][j][1] = 0;
        model.getImage()[i][j][2] = 0;
      }
    }
  }
    public void blueScale() {
      for (int i = 0; i < model.getImage().length; i++) {
        for (int j = 0; j < model.getImage()[0].length; j++) {
          model.getImage()[i][j][0] = 0;
          model.getImage()[i][j][1] = 0;
        }
      }

  }
  public void greenScale() {
    for (int i = 0; i < model.getImage().length; i++) {
      for (int j = 0; j < model.getImage()[0].length; j++) {
        model.getImage()[i][j][0] = 0;
        model.getImage()[i][j][2] = 0;
      }
    }
  }
}