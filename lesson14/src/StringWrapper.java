import java.io.*;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringWrapper implements Iterable<String>{
    private BufferedReader reader;
    private FileInputStream stream;
    private Path path;

    public StringWrapper(Path file) throws FileNotFoundException{
        this.path = file;
        stream = new FileInputStream(path.toString());
    }
    @Override
    public Iterator<String> iterator() {
        reader = new BufferedReader(new InputStreamReader(stream));
        return new Iterator<String>() {
            private String line;
            private boolean calledHasNext = false;
            @Override
            public boolean hasNext() {
                if(!calledHasNext){
                    try {
                        line = reader.readLine();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    calledHasNext = true;
                }
                return (line!=null);
            }

            @Override
            public String next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                calledHasNext = false;
                return line;
            }
        };
    }

    public Path getPath() {
        return path;
    }
}
