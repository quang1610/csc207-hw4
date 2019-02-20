package csc207.nguyenqu2.layout;

public class Grid implements TextBlock {
  private int width;
  private int height;
  private char c;
  
  public Grid(int width, int height, char c) throws Exception {
    if((width < 0) || (height < 0)) {
      throw new Exception("Invalid Grid size!");
    }
    this.width = width;
    this.height = height;
    this.c = c;
  }
  
  public String row(int row) throws Exception{
    if (row >= this.height) {
      throw new Exception("Invalid Grid row number!");
    } else {
      String currentString = new String() + c; 
      while (currentString.length() < this.width) {
        currentString = currentString.concat(currentString);
      } // while
      
      return currentString.substring(0, this.width);
    }
  }
  
  public int width() {
    return this.width;
  }
  
  public int height() {
    return this.height;
  }
}
