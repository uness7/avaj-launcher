/*************************************/
/*     @author Youness Zioual       */
/*************************************/

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
	public static void main(String arg[]) {

		String fileName = "";

		if (arg.length > 1 || arg.length == 0) {
			System.out.println("something is wrong");
			return ;
		}

		fileName = arg[0];

		Utils utils = new Utils();
		LinkedList<String> list = utils.parseFileToList(fileName);
        LinkedList<Node> res = utils.parse(list);
        //ListIterator<Node> it = res.listIterator();

		if (utils.validateContent(list)) {
			utils.parse(list);
		}
	}
}

