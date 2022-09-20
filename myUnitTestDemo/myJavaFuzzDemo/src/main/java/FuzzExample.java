import  com.gitlab.javafuzz.core.*;
import  java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
public class FuzzExample extends AbstractFuzzTarget {
    public void fuzz(byte[] data) {
        try {
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(data));
        } catch (IOException e) {
            // ignore as we expect this exception
        }
    }
}
