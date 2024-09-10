package test.java;

/**
 * DO NOT DISTRIBUTE.
 *
 * This code is intended to support the education of students associated
 * with the Tandy School of Computer Science at the University of Tulsa.
 * It is not intended for distribution and should remain within private
 * repositories that belong to Tandy faculty, students, and/or alumni.
 */
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.ByteArrayOutputStream;
import main.java.Main;
import org.junit.After;
import org.junit.Test;
import test.java.TUGrader.DisplayName;
import test.java.TUGrader.TestGroup;

/**
 * This class provides a set of unit tests for the
 * {@link Main} class using the JUnit testing
 * framework, the Java Reflection API, and
 * the TUGrader.
 */
public class MainTest {

  // **************************************************
  // Setup and cleanup
  // **************************************************

  @After
  public void cleanup() {
    TUGrader.resetStdIO();
  }

  // **************************************************
  // Helper methods
  // **************************************************

  public String getOutput(String input) {
    ByteArrayOutputStream stdout = TUGrader.captureStdout();
    TUGrader.flushToStdin(input);
    Main.main(new String[0]);
    return stdout.toString();
  }

  // **************************************************
  // Sample Tests
  // **************************************************

  @Test
  @TestGroup({"sample", "test1"})
  @DisplayName("should compute the sum, product, minimum, and maximum of the first sample input")
  public void sampleTest1() {
    String stdin = "10\n1 2 3 4 5 6 7 8 9 10\n";
    String[] outputs = getOutput(stdin).split(" ");
    assertThat("incorrect sum", Integer.parseInt(outputs[0].trim()), is(equalTo(55)));
    assertThat("incorrect product", Long.parseLong(outputs[1].trim()), is(equalTo(3_628_800l)));
    assertThat("incorrect minimum", Integer.parseInt(outputs[2].trim()), is(equalTo(1)));
    assertThat("incorrect maximum", Integer.parseInt(outputs[3].trim()), is(equalTo(10)));
  }

  @Test
  @TestGroup({"sample", "test2"})
  @DisplayName("should compute the sum, product, minimum, and maximum of the second sample input")
  public void sampleTest2() {
    String stdin = "10\n-1 2 3 4 5 6 7 8 9 10\n";
    String[] outputs = getOutput(stdin).split(" ");
    assertThat("incorrect sum", Integer.parseInt(outputs[0].trim()), is(equalTo(53)));
    assertThat("incorrect product", Long.parseLong(outputs[1].trim()), is(equalTo(-3_628_800l)));
    assertThat("incorrect minimum", Integer.parseInt(outputs[2].trim()), is(equalTo(-1)));
    assertThat("incorrect maximum", Integer.parseInt(outputs[3].trim()), is(equalTo(10)));
  }

  // **************************************************
  // Algorithm Tests
  // **************************************************

  @Test
  @TestGroup({"secret", "test3"})
  @DisplayName("should compute the sum, product, minimum, and maximum of \n\n10\n-1 2 -3 4 -5 6 -7 8 -9 10\n")
  public void algoTest3() {
    String stdin = "10\n-1 2 -3 4 -5 6 -7 8 -9 10\n";
    String[] outputs = getOutput(stdin).split(" ");
    assertThat("incorrect sum", Integer.parseInt(outputs[0].trim()), is(equalTo(5)));
    assertThat("incorrect product", Long.parseLong(outputs[1].trim()), is(equalTo(-3_628_800l)));
    assertThat("incorrect minimum", Integer.parseInt(outputs[2].trim()), is(equalTo(-9)));
    assertThat("incorrect maximum", Integer.parseInt(outputs[3].trim()), is(equalTo(10)));
  }

  @Test
  @TestGroup({"secret", "test4"})
  @DisplayName("should compute the sum, product, minimum, and maximum of \n\n9\n1 -2 3 -4 5 -6 7 -8 9\n")
  public void algoTest4() {
    String stdin = "9\n1 -2 3 -4 5 -6 7 -8 9\n";
    String[] outputs = getOutput(stdin).split(" ");
    assertThat("incorrect sum", Integer.parseInt(outputs[0].trim()), is(equalTo(5)));
    assertThat("incorrect product", Long.parseLong(outputs[1].trim()), is(equalTo(362_880l)));
    assertThat("incorrect minimum", Integer.parseInt(outputs[2].trim()), is(equalTo(-8)));
    assertThat("incorrect maximum", Integer.parseInt(outputs[3].trim()), is(equalTo(9)));
  }

  @Test
  @TestGroup({"secret", "test5"})
  @DisplayName("should compute the sum, product, minimum, and maximum of \n\n8\n1 -1 2 -2 3 -3 4 -4\n")
  public void algoTest5() {
    String stdin = "8\n1 -1 2 -2 3 -3 4 -4\n";
    String[] outputs = getOutput(stdin).split(" ");
    assertThat("incorrect sum", Integer.parseInt(outputs[0].trim()), is(equalTo(0)));
    assertThat("incorrect product", Long.parseLong(outputs[1].trim()), is(equalTo(576l)));
    assertThat("incorrect minimum", Integer.parseInt(outputs[2].trim()), is(equalTo(-4)));
    assertThat("incorrect maximum", Integer.parseInt(outputs[3].trim()), is(equalTo(4)));
  }

  @Test
  @TestGroup({"secret", "test6"})
  @DisplayName("should compute the sum, product, minimum, and maximum of \n\n7\n-5 6 -3 4 -1 2 0\n")
  public void algoTest6() {
    String stdin = "7\n-5 6 -3 4 -1 2 0\n";
    String[] outputs = getOutput(stdin).split(" ");
    assertThat("incorrect sum", Integer.parseInt(outputs[0].trim()), is(equalTo(3)));
    assertThat("incorrect product", Long.parseLong(outputs[1].trim()), is(equalTo(0l)));
    assertThat("incorrect minimum", Integer.parseInt(outputs[2].trim()), is(equalTo(-5)));
    assertThat("incorrect maximum", Integer.parseInt(outputs[3].trim()), is(equalTo(6)));
  }

  @Test
  @TestGroup({"secret", "test7"})
  @DisplayName("should compute the sum, product, minimum, and maximum of \n\n5\n-5 -4 -3 -2 -1\n")
  public void algoTest7() {
    String stdin = "5\n-5 -4 -3 -2 -1\n";
    String[] outputs = getOutput(stdin).split(" ");
    assertThat("incorrect sum", Integer.parseInt(outputs[0].trim()), is(equalTo(-15)));
    assertThat("incorrect product", Long.parseLong(outputs[1].trim()), is(equalTo(-120l)));
    assertThat("incorrect minimum", Integer.parseInt(outputs[2].trim()), is(equalTo(-5)));
    assertThat("incorrect maximum", Integer.parseInt(outputs[3].trim()), is(equalTo(-1)));
  }

  @Test
  @TestGroup({"secret", "test8"})
  @DisplayName("should compute the sum, product, minimum, and maximum of \n\n5\n-1 0 1 2 3\n")
  public void algoTest8() {
    String stdin = "5\n-1 0 1 2 3\n";
    String[] outputs = getOutput(stdin).split(" ");
    assertThat("incorrect sum", Integer.parseInt(outputs[0].trim()), is(equalTo(5)));
    assertThat("incorrect product", Long.parseLong(outputs[1].trim()), is(equalTo(0l)));
    assertThat("incorrect minimum", Integer.parseInt(outputs[2].trim()), is(equalTo(-1)));
    assertThat("incorrect maximum", Integer.parseInt(outputs[3].trim()), is(equalTo(3)));
  }

  @Test
  @TestGroup({"secret", "test9"})
  @DisplayName("should compute the sum, product, minimum, and maximum of \n\n9\n-1 3 2 -5 4 -9 6 8 7\n")
  public void algoTest9() {
    String stdin = "9\n-1 3 2 -5 4 -9 6 8 7\n";
    String[] outputs = getOutput(stdin).split(" ");
    assertThat("incorrect sum", Integer.parseInt(outputs[0].trim()), is(equalTo(15)));
    assertThat("incorrect product", Long.parseLong(outputs[1].trim()), is(equalTo(-362_880l)));
    assertThat("incorrect minimum", Integer.parseInt(outputs[2].trim()), is(equalTo(-9)));
    assertThat("incorrect maximum", Integer.parseInt(outputs[3].trim()), is(equalTo(8)));
  }

  @Test
  @TestGroup({"secret", "test10"})
  @DisplayName("should compute the sum, product, minimum, and maximum of \n\n12\n10 10 10 10 10 10 10 10 10 10 10 10\n")
  public void algoTest10() {
    String stdin = "12\n10 10 10 10 10 10 10 10 10 10 10 10\n";
    String[] outputs = getOutput(stdin).split(" ");
    assertThat("incorrect sum", Integer.parseInt(outputs[0].trim()), is(equalTo(120)));
    assertThat("incorrect product", Long.parseLong(outputs[1].trim()), is(equalTo(1_000_000_000_000l)));
    assertThat("incorrect minimum", Integer.parseInt(outputs[2].trim()), is(equalTo(10)));
    assertThat("incorrect maximum", Integer.parseInt(outputs[3].trim()), is(equalTo(10)));
  }

  // **************************************************
  // Implementation Tests
  // **************************************************

  @Test
  @TestGroup({"account", "test11"})
  @DisplayName("should implement Accountable")
  public void implTest11() {
    int[] input = new int[]{8, -9, 10, -3, 2, -1, 4, -5, 6, -7};
    assertThat("please remove this line from MainTest and uncomment the lines below to test your implementation", false);
    // int balance = 0;
    // main.java.Accountable account = new main.java.BankAccount();
    // assertThat("account should begin empty", account.getBalance(), is(equalTo(0)));
    // for (int amount : input) {
    //   balance += amount;
    //   assertThat("incorrect updated balance", account.updateBalance(amount), is(equalTo(balance)));
    //   assertThat("should show correct balance", account.getBalance(), is(equalTo(balance)));
    // }
    // assertThat("account should be greater than empty", account.compareTo(new main.java.BankAccount()), is(greaterThan(0)));
    // assertThat("account should be equal to itself", account.compareTo(account), is(equalTo(0)));
    // main.java.Accountable largeAccount = new main.java.BankAccount();
    // largeAccount.updateBalance(100);
    // assertThat("account should be less than a larger account", account.compareTo(largeAccount), is(lessThan(0)));
  }
}
