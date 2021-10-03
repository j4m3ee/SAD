package com.solid.lsp;

public class Square {

//    Class Square cannot be extends Rectangle because Square have not method setWidth and setHight,
//    so You should change Relation between both class.

    private Rectangle objSquare;

    Square(int side) {
        objSquare = new Rectangle(side,side);
    }

//    Override method of super class is reason to break lsp.

//    @Override
//    public void setWidth(int width) {this.setSide(width);
//    }
//
//    @Override
//    public void setHeight(int height) {
//        this.setSide(height);
//    }

    public void setSide(int side) {
        objSquare.setWidth(side);
        objSquare.setHeight(side);
    }

    public int getSide(){
        return objSquare.getWidth();
    }

    public int getArea(){
        return objSquare.getArea();
    }

}
