/*
**  @author Youness Zioual
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public final class Utils {
  private Utils() {
  }

  public static LinkedList<Node> parse(LinkedList<String> content) {
    LinkedList<Node> result = new LinkedList<>();

    try {
      validateContent(content);
    } catch (NoSuchElementException e) {
      throw new InvalidInputFile("File content is not valid");
    }


    for (String line : content) {
      String[] elements = line.split(" ");

      if (!line.contains("Balloon") && !line.contains("JetPlane") && !line.contains("Helicopter")) {
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

  public static LinkedList<String> parseFileToList(String fileName) {
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
      throw new InvalidInputFile(e.getMessage());
    }
    return input;
  }

  public static void validateContent(LinkedList<String> content) throws InvalidInputFile {
    ListIterator<String> it = content.listIterator();

    try {
      String firstElement = it.next();

      if (!isFirstLineValid(firstElement)) {
        throw new InvalidInputFile("First line should be a positive integer.");
      }
    } catch (NoSuchElementException e) {
      throw new InvalidInputFile(e.getMessage());
    }

    while (it.hasNext()) {
      String line = it.next();
      String[] elements = line.split(" ");
      List<String> list = Arrays.asList(elements);
      ListIterator<String> it1 = list.listIterator();
      int numberOfElements = 0;


      if (!isPositiveNumber(elements)) {
        throw new InvalidInputFile("Coordinates can only be positive integers.");
      }

      while (it1.hasNext()) {
        it1.next();
        numberOfElements++;
      }

      if (numberOfElements != 5) {
        throw new InvalidInputFile("Every line should contain five elements as follows: TYPE NAME ID LONGITUDE LATITUDE HEIGHT");
      }
    }

  }

  private static boolean isFirstLineValid(String line) {
    try {
      Integer.parseInt(line);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  public static boolean isPositiveNumber(String[] els) {
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
        return false;
      }
    }
    return true;
  }

  private static int toInt(String value) {
    return Integer.parseInt(value);
  }
}
