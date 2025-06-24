import java.io.*;
import java.util.*;

class Word implements Comparable<Word> {
    public String word;
    public int cnt;

    public Word(String word, int cnt) {
        this.word = word;
        this.cnt = cnt;
    }


    @Override
    public int compareTo(Word o) {
        if (this.cnt != o.cnt) {
            return o.cnt - this.cnt;
        } else if (this.word.length() != o.word.length()) {
            return o.word.length() - this.word.length();
        } else {
            return this.word.compareTo(o.word);
        }
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> sh = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) continue;
            sh.put(word, sh.getOrDefault(word, 0) + 1);
        }

        List<Word> list = new ArrayList<>();
        for (String key : sh.keySet()) {
            list.add(new Word(key, sh.get(key)));
        }

        Collections.sort(list);

        for (var x : list) {
            bw.write(x.word);
            bw.newLine();
        }
        bw.flush();

    }

}