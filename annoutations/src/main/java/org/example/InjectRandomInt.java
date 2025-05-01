package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {

  int lowerBound() default Integer.MIN_VALUE;
  int upperBound() default Integer.MAX_VALUE;
  boolean includeBounds() default true;
}
