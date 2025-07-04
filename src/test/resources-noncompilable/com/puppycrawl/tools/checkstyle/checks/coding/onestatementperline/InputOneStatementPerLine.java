/*
OneStatementPerLine
treatTryResourcesAsStatement = (default)false


*/

// non-compiled with eclipse: extra semicolumn in imports
package com.puppycrawl.tools.checkstyle.checks.coding.onestatementperline;

/**
 * This file contains test inputs for InputOneStatementPerLine
 * which cause compilation problem in Eclipse 4.2.2 but still must be tested.
 */

/**
 * Two import statements and one 'empty' statement
 * which are not on the same line are legal.
 */
import java.awt.event.ActionEvent;
import java.lang.annotation.Annotation;
; // non-compiled with eclipse
import java.lang.String;
import java.lang.Integer;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import javax.swing.JCheckBox;

public class InputOneStatementPerLine {
  /**
   * According to java language specifications,
   * statements end with ';'. That is why ';;'
   * may be considered as two empty statements on the same line
   * and rises violation.
   */
  ;; // violation 'Only one statement per line allowed.'
  static {
    new JCheckBox().addActionListener((final ActionEvent e) -> {good();});
    List<Integer> ints = new LinkedList<Integer>();
    ints.stream().map( t -> { return t * 2;} ).filter( t -> { return false;});

    // violation below 'Only one statement per line allowed.'
    ints.stream().map( t -> { int m = t * 2; return m; } );

    ints.stream().map( t -> { int m = t * 2; return m; } ); int i = 3;
    // 2 violations above:
    // 'Only one statement per line allowed.'
    // 'Only one statement per line allowed.'

    // violation below 'Only one statement per line allowed.'
    ints.stream().map( t -> t * 2); int k = 4;
    ints.stream().map( t -> t * 2);
    List<Integer> ints2 = new LinkedList<Integer>();
    ints.stream().map( t -> { return ints2.stream().map(w -> { return w * 2; });});

    // violation below 'Only one statement per line allowed.'
    ints.stream().map( t -> { return ints2.stream().map(w -> { int m=w; return m; });});
    ints.stream().map( t -> {
      return ints2.stream().map(
          w -> {
            int m = w * 2;
            return m;
          });
    });
    ints.stream().map( t -> {
      int l = 0;
      for (int j = 0;j < 10;j++) {
        l = j + l;
      }
      return l;
    });
  }

  private static void good() {
  }

  InputOneStatementPerLine method(foo a) {
    foo obj = () -> {
      method(() ->
             {method(null);}).method(null);
    };
    return this;
  }

  interface foo {
    void method();
  }

}
