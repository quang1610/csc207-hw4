package csc207.nguyenqu2.layout;

public class TruncatedBlock implements TextBlock {
  private TextBlock text;
  private int width;
  
  public TruncatedBlock(TextBlock tb, int width) throws Exception{
    if((width < 0) || (width > tb.width()))
    {
      throw new Exception("Invalid width!");
    } else {
      this.width = width; 
      this.text = tb;
    }
  }
  
  public int height() {
    return this.text.height();
  }
  
  public int width() {
    this.width = Math.max(this.text.width(), this.width);
    return this.width;
  }
  
  public String row(int i) throws Exception {
    String row = this.text.row(i);
    row = row.substring(0, width());
    return row;
  }
}
