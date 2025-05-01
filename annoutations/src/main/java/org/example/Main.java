package org.example;

import lombok.SneakyThrows;

public class Main {

  @SneakyThrows
  public static void main(String[] args) {
    var testClass = new TestClass();

    var injectRandomIntAnnotationProcessor = new InjectRandomIntAnnotationProcessor();

    injectRandomIntAnnotationProcessor.processAnnotation(testClass);

    testClass.printNum();
  }
}