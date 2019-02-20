package csc207.nguyenqu2.layout;

public class RightJustified implements TextBlock{
  private TextBlock text;
  private int width;
  public RightJustified(TextBlock text, int width) throws Exception{
    if(width < text.width()) {
      throw new Exception("Invalid width!");
    }
    this.text = text;
    this.width  = width;
  }
  
  public String row(int i) throws Exception {
    if((i<0)||(i>height())){
      throw new Exception("Invalid row!");
    }
    else {
      int spaces = (this.width() - this.text.width());
      return TBUtils.spaces(spaces)+this.text.row(i);
    }
    
  }
  public int width() {
    this.width = Math.max(this.text.width(), this.width);
    return this.width;
  }
  public int height() {
    return this.text.height();
  }

}
