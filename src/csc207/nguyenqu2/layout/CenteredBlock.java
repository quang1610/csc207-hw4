package csc207.nguyenqu2.layout;

public class CenteredBlock implements TextBlock {
  private TextBlock text;
  private int width;

  public CenteredBlock(TextBlock text, int width) throws Exception {
    if (width < text.width()) {
      throw new Exception("Invalid width!");
    }
    this.text = text;
    this.width = width;
  }

  public String row(int i) throws Exception {
    if ((i < 0) || (i > height())) {
      throw new Exception("Invalid row!");
    } else {
      int spaces = (width() - this.text.width());
      int lSpace;
      int rSpace;
      if (spaces % 2 == 0) {
        lSpace = spaces / 2;
        rSpace = lSpace;
      } else {
        lSpace = (spaces - 1) / 2;// placed more to left when text can't be centered perfectly
        rSpace = lSpace + 1;
      }
      return TBUtils.spaces(lSpace) + this.text.row(i) + TBUtils.spaces(rSpace);
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
