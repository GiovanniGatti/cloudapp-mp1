import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class MP1 {
	private static final int DEFAULT_SIZE = 1024;
	Random generator;
	String userName;
	String inputFileName;
	String delimiters = " \t,;.?!-:@[](){}_*/";
	String[] stopWordsArray = { "i", "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "your", "yours",
			"yourself", "yourselves", "he", "him", "his", "himself", "she", "her", "hers", "herself", "it", "its",
			"itself", "they", "them", "their", "theirs", "themselves", "what", "which", "who", "whom", "this", "that",
			"these", "those", "am", "is", "are", "was", "were", "be", "been", "being", "have", "has", "had", "having",
			"do", "does", "did", "doing", "a", "an", "the", "and", "but", "if", "or", "because", "as", "until", "while",
			"of", "at", "by", "for", "with", "about", "against", "between", "into", "through", "during", "before",
			"after", "above", "below", "to", "from", "up", "down", "in", "out", "on", "off", "over", "under", "again",
			"further", "then", "once", "here", "there", "when", "where", "why", "how", "all", "any", "both", "each",
			"few", "more", "most", "other", "some", "such", "no", "nor", "not", "only", "own", "same", "so", "than",
			"too", "very", "s", "t", "can", "will", "just", "don", "should", "now" };

	private static class WordCounter {
		private String word;
		private int count = 0;

		private WordCounter(String word) {
			this.word = word;
		}

		public String getWord() {
			return word;
		}

		public int getCount() {
			return count;
		}

		public void count() {
			count++;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((word == null) ? 0 : word.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			WordCounter other = (WordCounter) obj;
			if (word == null) {
				if (other.word != null)
					return false;
			} else if (!word.equals(other.word))
				return false;
			return true;
		}
	}

	private static class SelectiveWordCounter {
		private final Map<Integer, WordCounter> counter = new HashMap<Integer, WordCounter>();

		public SelectiveWordCounter() {
		}

		public void addWordCount(String word) {
			// if(counter.
		}
	}

	void initialRandomGenerator(String seed) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA");
		messageDigest.update(seed.toLowerCase().trim().getBytes());
		byte[] seedMD5 = messageDigest.digest();

		long longSeed = 0;
		for (int i = 0; i < seedMD5.length; i++) {
			longSeed += (seedMD5[i] & 0xffL) << (8 * i);
		}

		this.generator = new Random(longSeed);
	}

	Integer[] getIndexes() throws NoSuchAlgorithmException {
		Integer n = 10000;
		Integer number_of_lines = 50000;
		Integer[] ret = new Integer[n];
		this.initialRandomGenerator(this.userName);
		for (int i = 0; i < n; i++) {
			ret[i] = generator.nextInt(number_of_lines);
		}
		return ret;
	}

	public MP1(String userName, String inputFileName) {
		this.userName = userName;
		this.inputFileName = inputFileName;
	}

	public String[] process() throws Exception {
		String[] ret = new String[20];

		String contents = readFile(inputFileName);

		Set<WordCounter> selectiveWordCounter = new HashSet<WordCounter>();

		return ret;
	}

	private String readFile(String inputFileName) throws IOException {
		File file = new File(inputFileName);
		if (!file.exists() || !file.isFile() || !file.canRead()) {
			throw new UnsupportedOperationException("It can only process readable text files");
		}

		StringBuilder contents = new StringBuilder(DEFAULT_SIZE);

		try (InputStream in = Files.newInputStream(FileSystems.getDefault().getPath(file.getPath()));
				BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				contents.append(line + "\n");
			}
		}

		return contents.toString();
	}

	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			System.out.println("MP1 <User ID>");
		} else {
			String userName = args[0];
			String inputFileName = "./input.txt";
			MP1 mp = new MP1(userName, inputFileName);
			String[] topItems = mp.process();
			for (String item : topItems) {
				System.out.println(item);
			}
		}
	}
}
