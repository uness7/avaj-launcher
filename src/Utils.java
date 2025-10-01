/*************************************/
/*     @author Youness Zioual       */
/*************************************/

// then check if the content is all valid

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.List;
import java.util.Arrays;


// the first line contains a positive number that represent the number of times
// the simulation is run!

// the rest follows this format - type name longitude, latitude height
// coordinates are positive numbers

// name that can ONLY be Baloon, Helicopter, JetPlane

public class Utils {
  public Utils() {
  }

  public LinkedList<Node> parse(LinkedList<String> content) {

    if (!validateContent(content)) {
      // throw an exception
      return null;
    }

    LinkedList<Node> result = new LinkedList<Node>();
    ListIterator<String> it = content.listIterator();

    it.next();
    System.out.println(it.next());

    while (it.hasNext()) {
      String line = it.next();

      if (line.startsWith("Baloon")) {
        System.out.println("It's a fucking baloon");
      } else if (line.startsWith("JetPlane")) {
        System.out.println("It's a fucking JetPlane");
      } else if (line.startsWith("Helicopter")) {
        System.out.println("It's a fucking JetPlane");
      } else {
        System.out.println("Aircraft is not recognized");
      }
    }

    return result;
  }

  public LinkedList<String> parseFileToList(String fileName) {
    LinkedList<String> input = new LinkedList<>();

    try {
      FileReader fileReader = new FileReader(fileName);
      BufferedReader buffer = new BufferedReader(fileReader);
      String line;

      while ((line = buffer.readLine()) != null) {
        input.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return input;
  }

  public boolean validateContent(LinkedList<String> content) {
    String[] aircrafts = {"Baloon", "JetPlane", "Helicopter"};
    ListIterator<String> it = content.listIterator();
    String firstElement = it.next();

    if (!isFirstLineValid(firstElement)) {
      return false;
    }

    while (it.hasNext()) {
      String line = it.next();
      String[] elements = line.split(" ");
      List<String> list = Arrays.asList(elements);
      ListIterator<String> it1 = list.listIterator();
      int numberOfElements = 0;

      if (!isPositiveNumber(elements)) {
        return false;
      }

      while (it1.hasNext()) {
        it1.next();
        numberOfElements++;
      }

      if (numberOfElements != 5) {
        return false;
      }

      if (!list.contains(aircrafts[0]) 
          && !list.contains(aircrafts[1])
          && !list.contains(aircrafts[2])) {
        return false;
          }
    }

    return true;
  }

  private boolean isFirstLineValid(String line) {
    try {
      int result = Integer.parseInt(line);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public boolean isPositiveNumber(String[] els) {
    for (String el : els) {
      if (el == els[0] || el == els[1]) continue;
      try {
        int number = Integer.parseInt(el);
        if (number < 0) {
          return false;
        }
      } catch (Exception e) {
        e.printStackTrace();
        return false;
      }
    }
    return true;
  }
}
