package tank.test;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * @author ：hyf
 * @date ：Created in 2020/7/29 20:28
 * @description：
 * @modified By：
 * @version: $
 */
public class ImageTest {

    @Test
    public void test(){

        try {
            BufferedImage read = ImageIO.read(ImageTest.class.getClassLoader()
                    .getResourceAsStream("images/bulletD.gif"));
            assertNotNull(read);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
