package ictgradschool.industry.designpatterns.ex01;

import java.util.ArrayList;
import java.util.List;

public class NestingShape extends Shape {

    List<Shape> list = new ArrayList<>();


    public NestingShape() {
        super();
    }

    public NestingShape(int x, int y) {
        super(x, y);
    }

    public NestingShape(int x, int y, int deltaX, int deltaY) {
        super(x, y, deltaX, deltaY);
    }

    public NestingShape(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x, y, deltaX, deltaY, width, height);
    }

    @Override
    public void move(int width, int height) {
        super.move(width, height);
        for (Shape s : list) {
            s.move(fWidth, fHeight);
        }
    }


    @Override
    public void paint(Painter painter) {
        painter.drawRect(fX, fY, fWidth, fHeight);
        painter.translate(fX, fY);
        if (list != null) {
            for (Shape s : list) {
                s.paint(painter);
            }

        }
        painter.translate(-fX, -fY);

    }


    public void add(Shape child) throws IllegalArgumentException {
        if ((child.parent()) != null) {
            throw new IllegalArgumentException("Already have a child");
        }
//        if(child.fX +child.fWidth >= fWidth || child.fY +child.fHeight >= fHeight || child.fx<0 || child.fy<0)
        if (child.fWidth >= this.fWidth || child.fHeight >= this.fHeight) {
            throw new IllegalArgumentException("Not fit within the bounds of the proposed NestingShape object");
        }
        list.add(child);


        child.parent = this;
    }


    public void remove(Shape child) {
        if (list.remove(child)) {
            child.parent = null;

        }

    }


    public Shape shapeAt(int index) throws IndexOutOfBoundsException {
//        for (int i = 0; i < list.size(); i++) {
//            int number = shapeAt(i);
//
//            if (i > list.size()) {
//                throw new IndexOutOfBoundsException();
//            }
//
//        }

        return list.get(index);
    }

    //
    public int shapeCount() {

        return list.size();
    }


    public int indexOf(Shape child) {
//        int i = 0;
//        if (!list.contains(child)) {
//            return -1;
//        } else {
//            for (i = 0; i < shapeCount() - 1; i++) {
//                if (child == list.get(i)) {
//                    return i;
//                }
//            }
//        }
//        return i;
      return list.indexOf(child);
    }


    public boolean contains(Shape child) {

        return list.contains(child);
    }
}

