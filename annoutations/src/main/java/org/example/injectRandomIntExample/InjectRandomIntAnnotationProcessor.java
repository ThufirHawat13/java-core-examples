package org.example.injectRandomIntExample;

import java.lang.reflect.Field;
import java.util.Random;
import lombok.Getter;
import lombok.Setter;
import org.example.injectRandomIntExample.InjectRandomInt;

public class InjectRandomIntAnnotationProcessor {

  public void processAnnotation(Object obj) throws IllegalAccessException {
    for (Field field : obj.getClass().getDeclaredFields()) {
      if (field.isAnnotationPresent(InjectRandomInt.class)) {
        field.setAccessible(true);
        field.setInt(obj,
            generateRandomInt(
                initBounds(field.getAnnotation(InjectRandomInt.class)))
        );
      }
    }
  }

  private Bounds initBounds(InjectRandomInt annotation) {
    Bounds result = new Bounds();

    if (annotation.includeBounds()) {
      result.setLowerBound(annotation.lowerBound());
      result.setUpperBound(annotation.upperBound() + 1);
    } else {
      result.setLowerBound(annotation.lowerBound() + 1);
      result.setUpperBound(annotation.upperBound());
    }

    return result;
  }

  private int generateRandomInt(Bounds bounds) {
    return new Random().nextInt(
        bounds.getLowerBound(),
        bounds.getUpperBound());
  }

  @Setter
  @Getter
  private static class Bounds {

    private int lowerBound;
    private int upperBound;
  }
}
