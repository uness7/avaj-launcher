/*************************************/
/*     @author Youness Zioual       */
/*************************************/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Utils {
  public Utils() {}

  public LinkedList<Node> parse(LinkedList<String> content) {
    System.out.println("inside parse function");

    LinkedList<Node> result = new LinkedList<>();

    if (!isContentValid(content)) {
      // throw an exception
      System.out.println("Content is invalid");
      return result; // the result here is empty, we should return an exception instead
    }

    ListIterator<String> it = content.listIterator();

    while (it.hasNext()) {
      String line = it.next();
	  String[] elements = line.split(" ");
      System.out.println("first el " + elements[0]);
	  if (!line.contains("Balloon") && !line.contains("JetPlane") && !line.contains("Helicopter") ) {
		  result.add(new Node(NodeType.FIRST_LINE, "None", toInt(elements[0]), toInt(elements[0]), toInt(elements[0])));
	  } else if (line.startsWith("Balloon")) {
		  result.add(new Node(NodeType.BALOON, elements[1], toInt(elements[2]), toInt(elements[3]), toInt(elements[4])));
	  } else if (line.startsWith("JetPlane")) {
		  result.add(new Node(NodeType.JETPLANE, elements[1], toInt(elements[2]), toInt(elements[3]), toInt(elements[4])));
	  } else if (line.startsWith("Helicopter")) {
		  result.add(new Node(NodeType.HELICOPTER, elements[1], toInt(elements[2]), toInt(elements[3]), toInt(elements[4])));
	  } else {
        System.out.println("THIS CODE MUST NOT BE REACHABLE!");
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
	  buffer.close();
    } catch (IOException e) {
      System.out.println("Exception " + e);
    }
    return input;
  }

  public boolean isContentValid(LinkedList<String> content) {
    String[] aircrafts = {"Balloon", "JetPlane", "Helicopter"};
    ListIterator<String> it = content.listIterator();
    String firstElement = it.next();

    if (!isFirstLineValid(firstElement)) {
      System.out.println("first line is invalid");
      return false;
    }

    while (it.hasNext()) {
      String line = it.next();
      String[] elements = line.split(" ");
      List<String> list = Arrays.asList(elements);
      ListIterator<String> it1 = list.listIterator();
      int numberOfElements = 0;

      //list.forEach(System.out::println);


      if (!isPositiveNumber(elements)) {
        System.out.println("number is invalid because it's negative");
        return false;
      }

      while (it1.hasNext()) {
        it1.next();
        numberOfElements++;
      }

      if (numberOfElements != 5) {
        System.out.println("number is invalid because it's not equal to 5");
        return false;
      }

      //list.forEach(System.out::println);
//      if (!list.contains(aircrafts[0])
//              && !list.contains(aircrafts[1])
//              && !list.contains(aircrafts[2])) {
//        System.out.println("invalid aircraft type");
//        return false;
//      }
    }

    return true;
  }

  private boolean isFirstLineValid(String line) {
    try {
      int result = Integer.parseInt(line);
    } catch (Exception e) {
      System.out.println("Exception " + e);
      return false;
    }
    return true;
  }

  public boolean isPositiveNumber(String[] els) {
    for (String el : els) {
      if (Objects.equals(el, els[0]) || Objects.equals(el, els[1])) {
        continue;
      }

      try {
        int number = Integer.parseInt(el);
        if (number < 0) {
          return false;
        }
      } catch (Exception e) {
        System.out.println("Exception " + e);
        return false;
      }
    }
    return true;
  }

  private int toInt(String value) {
    return Integer.parseInt(value);
  }
}
