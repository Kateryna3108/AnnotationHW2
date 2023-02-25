import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

@SaveTo(path = "/Users/katerynahavrylova/IdeaProjects/AnnotationHW2/text.txt")
public class Container {
    private String text = "I need to save this text";

    @Saver
    public void save(String path) {
        File file = new File(path);
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println(text);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Saved");
    }
}
