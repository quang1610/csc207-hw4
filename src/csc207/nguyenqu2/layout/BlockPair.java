package csc207.nguyenqu2.layout;

public class BlockPair implements TextBlock{
  private TextBlock text;
  public BlockPair(TextBlock text) throws Exception{
    this.text = text;
  }
  public String row(int i) throws Exception {
    if((i<0)||(i>height())){
      throw new Exception("Invalid row!");
    }
    else {
      return this.text.row(i)+this.text.row(i);
    }
    
  }
  public int width() {
    return this.text.width();
  }
  public int height() {
    return this.text.height();
  }
}
