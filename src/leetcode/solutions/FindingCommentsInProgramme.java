package leetcode.solutions;

import java.io.*;
import java.util.*;

public class FindingCommentsInProgramme {
	public static void main(String args[] ) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<String> input = new ArrayList<>();
		String line = br.readLine();
		while (line!=null) {
			input.add(line);
			line = br.readLine();
		}

		List<String> output = new ArrayList<>();
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i).indexOf("//") != -1) {
				output.add(input.get(i).substring(input.get(i).indexOf("//")));

			} else if (input.get(i).indexOf("/*") != -1) {
				if (input.get(i).indexOf("*/") != -1) {
					output.add(input.get(i).substring(input.get(i).indexOf("/*"), input.get(i).indexOf("*/") + 2));

				} else {
					while (input.get(i).indexOf("*/") == -1) {
						output.add(input.get(i));
						i++;
						if (i >= input.size())
							break;
					}
					output.add(input.get(i).substring(0, input.get(i).indexOf("*/") + 2));
				}
			}
		}

		for (String i : output) {
			System.out.println(i.trim());
		}

	}
}
