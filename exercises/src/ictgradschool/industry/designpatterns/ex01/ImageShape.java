package ictgradschool.industry.designpatterns.ex01;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by anhyd on 3/04/2017.
 */
public class ImageShape extends Shape {

    private Image image;

    public ImageShape(int x, int y, int deltaX, int deltaY, String fileName, double scale) {
        super(x, y, deltaX, deltaY);

        try {
            this.image = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.fWidth = (int)(this.image.getWidth(null) * scale);
        this.fHeight = (int)(this.image.getHeight(null) * scale);

    }


    @Override
    public void paint(Painter painter) {

        painter.drawImage(this.image, fX, fY, fWidth, fHeight);

    }
}
