// Java program for Naive txttern Searching

public class nieveSearch {

	static void search(String txt, String pattern)
	{
		int l1 = txt.length();
		int l2 = pattern.length();
		int i = 0, j = l2 - 1;

		for (i = 0, j = l2 - 1; j < l1;) {

			if (pattern.equals(txt.substring(i, j + 1))) {
				System.out.println("txttern found at index "
								+ i);
			}
			i++;
			j++;
		}
	}
	
	// Driver's code
	public static void main(String args[])
	{
		String txt = "AABAACAADAABAAABAA";
		String pattern = "AABA";
	
		// Function call
		search(txt, pattern);
	}
}
// This code is contributed by D. Vishnu Rahul Varma

