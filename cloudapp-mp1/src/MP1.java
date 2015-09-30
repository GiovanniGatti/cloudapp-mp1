import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public class MP1 {
    private static final int DEFAULT_SIZE = 1024;
    public static final int OUTPUT_LIMIT = 20;
    private CountRegister register = new CountRegister();
    Random generator;
    String userName;
    String inputFileName;
    String delimiters = " \t,;.?!-:@[](){}_*/";
    String[] stopWordsArray = { "i", "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "your", "yours",
            "yourself", "yourselves", "he", "him", "his", "himself", "she", "her", "hers", "herself", "it", "its",
            "itself", "they", "them", "their", "theirs", "themselves", "what", "which", "who", "whom", "this", "that",
            "these", "those", "am", "is", "are", "was", "were", "be", "been", "being", "have", "has", "had", "having",
            "do", "does", "did", "doing", "a", "an", "the", "and", "but", "if", "or", "because", "as", "until",
            "while",
            "of", "at", "by", "for", "with", "about", "against", "between", "into", "through", "during", "before",
            "after", "above", "below", "to", "from", "up", "down", "in", "out", "on", "off", "over", "under", "again",
            "further", "then", "once", "here", "there", "when", "where", "why", "how", "all", "any", "both", "each",
            "few", "more", "most", "other", "some", "such", "no", "nor", "not", "only", "own", "same", "so", "than",
            "too", "very", "s", "t", "can", "will", "just", "don", "should", "now" };

    private static class Word {
        private final String word;
        private final String[] stopWords;

        public Word(String word, String[] stopWords) {
            this.word = word.trim().toLowerCase();
            this.stopWords = stopWords;
        }

        public String getWord() {
            return word;
        }

        public boolean isStopWord() {
            return Arrays.asList(stopWords).contains(word);
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
            Word other = (Word) obj;
            if (word == null) {
                if (other.word != null)
                    return false;
            } else if (!word.equals(other.word))
                return false;
            return true;
        }
    }

    private static class Counter implements Comparable<Counter> {
        private final Word word;
        private int count = 1;

        private Counter(Word word) {
            this.word = word;
        }

        public Word getWord() {
            return word;
        }

        public int getCount() {
            return count;
        }

        public void count() {
            count++;
        }

        @Override
        public int compareTo(Counter o) {
            return getCount() - o.getCount();
        }
    }

    private static class CountRegister {
        private final Map<Word, Counter> register = new HashMap<Word, Counter>();

        public void count(Word word) {
            if (!word.isStopWord()) {
                if (register.containsKey(word)) {
                    register.get(word).count();
                } else {
                    register.put(word, new Counter(word));
                }
            }
        }

        public List<Word> getOrdered(int topLimit) {
            List<Counter> countValues = new ArrayList<Counter>(register.values());
            Collections.sort(countValues, Collections.reverseOrder());
            List<Word> words = new ArrayList<Word>();
            for (int i = 0; i < topLimit && i < countValues.size(); i++) {
                words.add(countValues.get(i).getWord());
            }
            return words;
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
        List<String> contents = readFile(inputFileName);

        if (userName == null) {
            for (String line : contents) {
                processLine(line);
            }
        } else {
            List<Integer> indexes = Arrays.asList(getIndexes());
            for (int i : indexes) {
                processLine(contents.get(i));
            }
        }

        String[] ret = new String[OUTPUT_LIMIT];
        List<Word> topWords = register.getOrdered(OUTPUT_LIMIT);
        for (int i = 0; i < OUTPUT_LIMIT && i < topWords.size(); i++) {
            ret[i] = topWords.get(i).getWord();
        }

        return ret;
    }

    private void processLine(String line) {
        StringTokenizer tokenizer = new StringTokenizer(line, delimiters);
        while (tokenizer.hasMoreTokens()) {
            register.count(new Word(tokenizer.nextToken(), stopWordsArray));
        }
    }

    private List<String> readFile(String inputFileName) throws IOException {
        File file = new File(inputFileName);
        if (!file.exists() || !file.isFile() || !file.canRead()) {
            throw new UnsupportedOperationException("It can only process readable text files");
        }

        List<String> lines = new ArrayList<String>(DEFAULT_SIZE);

        try (InputStream in = Files.newInputStream(FileSystems.getDefault().getPath(file.getPath()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
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
