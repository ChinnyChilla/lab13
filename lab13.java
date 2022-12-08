import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;

class lab13 {
	private static ArrayList<Integer> arraylist = new ArrayList<>();

	public static void main(String[] args) {

	}

	public void readData(String filename) {
		try {
			arraylist = new ArrayList<>();
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String currentLine = input.readLine();
			while (currentLine != null) {
				arraylist.add(Integer.parseInt(currentLine));
				currentLine = input.readLine();
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public long getTotalCount() {
		Stream<Integer> st = arraylist.stream();
		return st.count();
	}

	public long getOddCount() {
		Stream<Integer> st = arraylist.stream();
		return st.filter(num -> num % 2 == 1).count();
	}

	public long getEvenCount() {
		Stream<Integer> st = arraylist.stream();
		return st.filter(num -> num % 2 == 0).count();
	}

	public long getDistinctGreaterThanFiveCount() {
		Stream<Integer> st = arraylist.stream();
		return st.distinct().filter(num -> num > 5).count();
	}

	public Integer[] getResult1() {
		Stream<Integer> st = arraylist.stream();
		return st.filter(num -> num % 2 == 0 && num < 50 && num > 5).sorted().toArray(Integer[]::new);
	}

	public Integer[] getResult2() {
		Stream<Integer> st = arraylist.stream();
		return st.limit(50).map((num) -> num * num * 3).toArray(Integer[]::new);
	}

	public Integer[] getResult3() {
		Stream<Integer> st = arraylist.stream();
		return st.filter(num -> num % 2 == 1).map(num -> num * 2)
				.sorted()
				.skip(20)
				.distinct()
				.toArray(Integer[]::new);
	}
}