import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class IMEProgramTest {
  // creates a new model, view and controller then tests the main method with different inputs
  @Test
  public void testMain(){
    IMEProgramUI program = new IMEProgramUI();

    program.main(new String[]{""});
    program.main(new String[]{"load k1 "});

  }
}