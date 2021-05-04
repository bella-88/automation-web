package commons;

import java.util.Random;

public class AbstactTest {

  public int randomDataAccountID() {
    Random rand = new Random();

    int number = rand.nextInt(2) - 1;
    return number;
  }

  public String randomEmailNumber() {
    Random rand = new Random();
    rand.nextInt(99999);
    String randomEmail = "bella" + randomEmailNumber() + "@gmail.com";
    return randomEmail;
  }
}
