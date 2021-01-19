package ictgradschool.industry.designpatterns.ex02;

import ictgradschool.industry.designpatterns.ex01.NestingShape;
import ictgradschool.industry.designpatterns.ex01.Shape;
import ictgradschool.industry.designpatterns.examples.example01.filestore.Directory;
import ictgradschool.industry.designpatterns.examples.example01.filestore.TreeModelAdapter;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;


//An adapter class allowing a NestingShape to be displayed in a JTree

public class BounceTreeModelAdapter implements TreeModel {

    private List<TreeModelListener> listeners = new ArrayList<>();


    //the NestingShape we are visualizing
    private NestingShape root;

    public BounceTreeModelAdapter(NestingShape root) {
        this.root = root;
    }


    @Override
    public Object getRoot() {
        return root;
    }
 //* Gets the child of the given parent at the given index. We can assume that parent will always be a valid
    @Override
    public Object getChild(Object parent, int index) {

        NestingShape ns = (NestingShape) parent;

        return ns.shapeAt(index);
    }


    //gets the number of children the given parent has
    @Override
    public int getChildCount(Object parent) {
        if (parent instanceof NestingShape) {
            return ((NestingShape) parent).shapeCount();
        } else {
            return 0;
        }
    }


    //node: the node to check
    //return: true if the node is not a Nestingshape, false otherwise
    @Override
    public boolean isLeaf(Object node) {
        return !(node instanceof NestingShape);
    }

    @Override
    public void valueForPathChanged(TreePath treePath, Object o) {
//implementation not required
    }


    // gets the index of the given child in its parent.
    @Override
    public int getIndexOfChild(Object parent, Object child) {
        NestingShape ns = (NestingShape) parent;

        return ns.indexOf((Shape) child);
    }



    //Listener for any changes in this model. unused for now.
    @Override
    public void addTreeModelListener(TreeModelListener treeModelListener) {
        this.listeners.add(treeModelListener);

    }

    @Override
    public void removeTreeModelListener(TreeModelListener treeModelListener) {
      this.listeners.remove(treeModelListener);
    }
}
