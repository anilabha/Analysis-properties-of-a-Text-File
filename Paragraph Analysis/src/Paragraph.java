import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Paragraph {
	static BufferedReader b;

	public static void main(String[] args) throws IOException {

		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("--------------------------------------------------------");
		System.out.println("|                 Paragraph  Analysis                  |");

		System.out.println("|              Creayed By Anilabha Baral               |");

		System.out.println("********************************************************");
		System.out.println("Enter The txt file Path: ");

		try {

			String str = inp.readLine();

			FileReader f = new FileReader(str);
			b = new BufferedReader(f);

			String i = b.readLine();
			// String i=k.replace(".", " .");

			// String a[] = i.split(" ");
			System.out.println("Enter your Choise:\n" + "1.Count How many Words Presnt in this Text File?\n"
					+ "2.Count How many Sentences Presnt in this Text File?\n"
					+ "3.Check a word is present in this Text File?\n"
					+ "4.Count How many times a word repeats in this Text File?\n"
					+ "5.Count How many times a letter repeats in this Text File?\n" + "6.Count Total Lines No\n"
					+ "7.Count Total Paragraph No\n");
			Scanner sc = new Scanner(System.in);
			char choice = sc.next().charAt(0);

			switch (choice) {
			case '1':// tested

				wordcount(i);
				break;

			case '2':// tested

				sentencecount(i);
				break;

			case '3':
				System.out.println("Enter the word you want to search : ");
				String search = sc.next();

				searchword(i, search);
				break;

			case '4':
				System.out.println("Enter the word you want to know how many times it repeats : ");

				String sea = sc.next();

				repeatword(i, sea);
				break;
			case '5':// tested
				System.out.println("Enter the letter you want to know how many times it repeats : ");

				char se = sc.next().charAt(0);

				repeatletter(i, se);
				break;

			case '6':
				Linecount(i);
				break;
			case '7':
				paragraphcount(i);
				break;
			default:// tested
				System.out.println("You entered a wrong choice !!!");

				break;

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

//      Functions Are--->
//		1.wordcount(i);
//		2.sentencecount(i);
//		3.repeatletter(i, 'a');
//		4.repeatword(i, "an");
//		5.searchword(i, "simple");
//		6.Linecount(i);
//		7.paragraphcount(i);

	}

	public static void wordcount(String a) throws IOException {// tested

		int count = 0;
		while (a != null) {

			for (int j = 0; j < a.length(); j++) {
				if (a.charAt(j) == ' ' || a.charAt(j) == '.') {
					count++;
				}
			}
			a = b.readLine();

		}
		System.out.println();
		System.out.println("This paragraph has : " + count + " Words");

	}

	public static void paragraphcount(String a) throws IOException {// tested

		int count = 1;
		while (a != null) {

			if (a.equals("")) {
				count++;
			}
			a = b.readLine();

		}
		System.out.println();
		System.out.println("This has : " + count + " paragraph");

	}

	public static void Linecount(String a) throws IOException {// tested

		int count = 0;
		while (a != null) {
			String k[] = a.split("\n");
			int n = k.length;

			for (int h = n; h > 0; h--) {

				count++;

			}
			a = b.readLine();
		}
		System.out.println();

		if (count == 0 || count == 1) {
			System.out.println("This has : " + count + " Line");
		} else {
			System.out.println("This has : " + count + " Lines");

		}

	}

	public static void sentencecount(String a) throws IOException {// tested

		int count = 0;
		while (a != null) {
//		String a[] = i.split(". ");

			for (int j = 0; j < a.length(); j++) {
				if (a.charAt(j) == '.' || a.charAt(j) == '\n') {
					count++;
				}
			}
			a = b.readLine();
		}
		System.out.println();

		if (count == 0 || count == 1) {
			System.out.println("This paragraph has : " + count + " Sentence");
		} else {
			System.out.println("This paragraph has : " + count + " Sentences");

		}

	}

	public static void repeatletter(String a, char search) throws IOException {// tested
		int count = 0;
		while (a != null) {
			int n = a.length();
			for (int i = 0; i < n; i++) {
				if (a.charAt(i) == search) {
					count++;
				}

			}
			a = b.readLine();

		}
		System.out.println();
		System.out.println("The letter " + search + " is repeat itself in the paragraph : " + count + " Times");

	}

	public static void repeatword(String y, String search) throws IOException {
		String k = y.replace(".", " .");

		int count = 0;
		while (k != null) {
			String a[] = k.split(" ");

			int n = a.length;
			for (int j = 0; j < n; j++) {

				if (a[j].contains(search)) {
					count++;

				}

			}
			k = b.readLine();
		}

		System.out.println();
		System.out.println("The word " + search + " is repeat itself in the paragraph : " + count + " Times");
	}

	public static void searchword(String y, String search) throws IOException {
		// String a[] = k.split(" ");
		String k = y.replace(".", " .");
		boolean count = false;
		while (k != null) {
			String a[] = k.split(" ");

			int n = a.length;
			for (int j = 0; j < n; j++) {

				if (a[j].contains(search)) {
					count = true;

				}

			}
			k = b.readLine();
		}

		if (count) {
			System.out.println("Search Result : Yes!. The word " + search + " is present in the paragraph");
		} else {
			System.out.println("Search Result : No! The word " + search + " is not present in the paragraph !!");
		}
	}

}
