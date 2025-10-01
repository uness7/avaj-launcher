/*************************************/
/*     @author Youness Zioual       */
/*************************************/

import java.util.LinkedList;

public class Main {
	public static void main(String[] arg) {
		String fileName = "";

		if (arg.length != 1) {
			System.out.println("something is wrong");
			return ;
		}

		fileName = arg[0];

		Utils utils = new Utils();
		LinkedList<String> list = utils.parseFileToList(fileName);
        LinkedList<Node> res = utils.parse(list);

        for (Node current : res) {
            System.out.println(current.toString());
        }
	}
}

