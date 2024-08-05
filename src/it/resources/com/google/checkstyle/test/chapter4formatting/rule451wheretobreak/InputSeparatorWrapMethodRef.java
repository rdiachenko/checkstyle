package com.google.checkstyle.test.chapter4formatting.rule451wheretobreak;

import java.util.Arrays;

/** Some javdoc. */
public class InputSeparatorWrapMethodRef {

  void goodCase() {
    String[] stringArray = {
      "Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda"
    };
    Arrays.sort(stringArray, String::compareToIgnoreCase);
  }

  void badCase() {
    String[] stringArray = {
      "Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda"
    };
    Arrays.sort(
        stringArray,
        String:: // violation ''::' should be on a new line.'
            compareToIgnoreCase);
  }

  void anotherCase() {
    java.util.function.BiFunction<String, Long, Long> r = (String label, Long value) -> { // OK
      return value;
    };

    java.util.function.Predicate<String> predicate = str -> // OK
            str.isEmpty();

    java.util.function.Function<String, String> s = (String label) ->
      // violation below ''{' at column 7 should be on the previous line.'
      {
        return label;
      };
  }
}
