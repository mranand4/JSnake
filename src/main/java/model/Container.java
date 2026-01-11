package model;

public class Container {

    public int r = 0;
    public int c = 1;

    public void incrementRow() {
        r = r + 1;
        if(r == 15) r = 0;
    }
}
