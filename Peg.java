public class Peg {
    private char color;
    private boolean counted;
    
    public Peg(char color) {
        this.color = color;
        counted = false;
    }
        
    public void Count() {
        counted = true;
    }
    
    public char getColor() {
        return color;
    }
    
    public boolean getCounted() {
        return counted;
    }
    
    public void clearCount() {
        counted = false;
    }
}