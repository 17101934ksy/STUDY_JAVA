package stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx5 {

    static int sum = 0;

    public static void main(String[] args) throws IOException {
        String[] strArrays = {"a", "b", "c"};
        Stream<String> stream = Arrays.stream(strArrays);
        stream.forEach(a -> System.out.println("a = " + a)  );

        IntStream intStream = IntStream.rangeClosed(1, 100);
        intStream.forEach(a -> sum += a);
        System.out.println("sum = " + sum);

        Path path = Paths.get("/home/koseyun/IdeaProjects/algorithm/src/stream/StreamEx1.java");
        Stream<String> fileStream;

        Stream<String> testStream = Files.lines(path, Charset.defaultCharset());
        testStream.forEach(System.out::print);

        File file = path.toFile();
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        Stream<String> lines = br.lines();
        lines.forEach(System.out::print);

    }
}
