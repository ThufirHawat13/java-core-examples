package org.example.injectRandomIntInFieldExample;

public class TestClass {

  @InjectRandomInt(
      lowerBound = 0,
      upperBound = 3,
      includeBounds = false)
  private int num;


  public void printNum() {
    System.out.println("NUM: " + num);
  }
}
