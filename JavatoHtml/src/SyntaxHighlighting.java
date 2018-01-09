import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class SyntaxHighlighting {

	static final String keywords[] = { "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
			"class", "const", "continue", "default", "do", "double", "else", "extends", "final", "finally", "float",
			"for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new",
			"package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch",
			"synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while" };

	static final Set<String> keywordSet = new HashSet<String>(Arrays.asList(keywords));

	public static String convertToHTML() throws IOException {

		Scanner s = new Scanner(System.in);
		String javaFile = "";

		while (s.hasNext()) {
			javaFile = s.nextLine();
			if (javaFile.substring(javaFile.length() - 5, javaFile.length()).equals(".java")) {
				break;
			} else
				System.out.println("Not a valid file");
		}
		s.close();

		BufferedWriter writer = new BufferedWriter(
				new FileWriter(javaFile.substring(0, javaFile.length() - 5) + ".html"));
		BufferedReader reader = new BufferedReader(new FileReader(javaFile));
		boolean isLongComment = false;

		while (reader.ready()) {
			String line = reader.readLine().trim();
			String input = new String();

			// comments
			if (line.length() > 2 && line.substring(0, 2).equals("//")) {
				input = "<span style=\"color:green\">" + line + "</span>";
			} else if (isLongComment && line.length() > 2
					&& line.substring(line.length() - 2, line.length()).equals("*/")) {
				isLongComment = false;
				input = "<span style=\"color:green\">" + line + "</span>";
			} else if (isLongComment)
				input = "<span style=\"color:green\">" + line + "</span>";
			else if (!isLongComment && line.length() > 2 && line.substring(0, 2).equals("/*")) {
				isLongComment = true;
				input = "<span style=\"color:green\">" + line + "</span>";
			} else
				input = parseLine(line);

			writer.write(input);
			writer.write("<br>");
			writer.flush();
		}
		writer.close();
		reader.close();
		
		return javaFile;

	}

	public static String parseJavaFile(File javaFile) throws IOException {

		String parsed = new String("");
		BufferedReader reader = new BufferedReader(new FileReader(javaFile));

		while (true) {

			String line = reader.readLine();
			if (line == null)
				break;
			// if (line.length() >= 2 && line.substring(0, 2).equals("//")) parsed += line;
			System.out.println(parseLine(line));
		}

		reader.close();
		System.out.print(parsed);
		return parsed;
	}

	public static String parseLine(String line) {
		String parsed = "";
		//An attempt was made to include indents,did not work.
		/*int spaceIndex = 0;
		while (spaceIndex < line.length()) {
			if (Character.isWhitespace(line.charAt(spaceIndex))) {
				parsed += "&emsp;";
				spaceIndex++;
			}
			else break;
		}*/
		for (int i = 0; i < line.length(); i++) {
			String c = line.substring(i, i + 1);
			String token = "";

			// deal with keywords
			while (Character.isLetter(c.charAt(0))) {
				token += c;
				if (i != line.length() - 1) {
					i++;
					c = line.substring(i, i + 1);
				} else
					break;
			}
			if (keywordSet.contains(token)) {
				parsed += "<span style=\"color:navy; font-weight:bold\">";
				parsed += token;
				parsed += "</span>";
			}
			// deal with true/false literals.
			else if (token.equals("true") || token.equals("false")) {
				parsed += "<span style=\"color:blue\">";
				parsed += token;
				parsed += "</span>";
			} else
				parsed += token;

			if (!c.equals("\"") && !c.equals("'") && !Character.isDigit(c.charAt(0))
					&& !Character.isLetter(c.charAt(0)))
				parsed += c;

			// deal with string literals
			if (c.equals("\"")) {
				String stringToken = "\"";
				i++;
				c = line.substring(i, i + 1);
				while (!c.equals("\"") && i != line.length() - 1) {
					stringToken += c;
					if (i != line.length() - 1) {
						i++;
						c = line.substring(i, i + 1);
					}
				}
				stringToken += "\"";
				parsed += "<span style=\"color:blue\">";
				parsed += stringToken;
				parsed += "</span>";
			}

			// deal with number literals
			if (Character.isDigit(c.charAt(0))) {
				String numberToken = "";
				while (Character.isDigit(c.charAt(0))) {
					numberToken += c;
					if (i != line.length() - 1) {
						i++;
						c = line.substring(i, i + 1);
					}
				}
				parsed += "<span style=\"color:blue\">";
				parsed += numberToken;
				parsed += "</span>";
				parsed += c;
			}

			// deal with char literals
			if (c.equals("'")) {
				String charToken = "'";
				i++;
				c = line.substring(i, i + 1);
				while (!c.equals("'") && i != line.length() - 1) {
					charToken += c;
					if (i != line.length() - 1) {
						i++;
						c = line.substring(i, i + 1);
					}
				}
				charToken += "'";
				parsed += "<span style=\"color:blue\">";
				parsed += charToken;
				parsed += "</span>";
			}
		}
		return parsed;
	}

	public static void main(String[] args) {
		try {
			System.out.println("Input java file name.");
			String file = convertToHTML();
			System.out.println(file + " converted into " +  file.substring(0, file.length() - 5) 
			+ ".html.");
		} catch (IOException e) {
			System.out.println("File not found.");
		}

	}

}
