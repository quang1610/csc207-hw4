package csc207.nguyenqu2.layout;

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextBlock block = new TextLine("Hello");

    // Print out the block
    TBUtils.print(pen, block);

    TextBlock block1 = new HComposition(new TextLine("Hello"), new BoxedBlock(new TextLine("goodbye")));
    TBUtils.print(pen, block1);
    
    TextBlock block2 = new TruncatedBlock(block1, 4);
    TBUtils.print(pen, block2);
    // Clean up after ourselves.
    
    TBUtils.print(pen, new BoxedBlock(new Grid(7, 5, '*')));
    
    TextBlock block3 = new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock block4 = new BoxedBlock(new CenteredBlock(block3, 11));
    TBUtils.print(pen, block4);

    TextBlock top = new CenteredBlock(new TextLine("Hello"), 11);
    TextBlock bottom = new CenteredBlock(new TextLine("Goodbye"), 11);
    TextBlock block5 = new BoxedBlock(new VComposition(top,bottom));
    TBUtils.print(pen, block5);
    
    TextBlock top2 = new RightJustified(new TextLine("Hello"), 11);
    TextBlock bottom2 = new RightJustified(new TextLine("Goodbye"), 11);
    TextBlock block6 = new BoxedBlock(new VComposition(top2,bottom2));
    TBUtils.print(pen, block6);
    
    TextBlock block7 = new BlockPair(block6);
    TBUtils.print(pen, block7);
    
    TextLine tb1 = new TextLine("Hello");
    TextLine tb2 = new TextLine("World");
    TextBlock compound = new BoxedBlock(new CenteredBlock(new BoxedBlock(new CenteredBlock(new VComposition(tb1, tb2), 7)), 15));
    //TextBlock compound = new CenteredBlock(new VComposition(tb1, tb2), 7);
    pen.println("ORIGINAL");
    TBUtils.print(pen, compound);
    tb2.setContents("Someone");
    pen.println("UPDATED");
    TBUtils.print(pen, compound);
    tb1.setContents("Nice to meet you,");
    pen.println("RE-UPDATED");
    TBUtils.print(pen, compound);
    
    System.out.println("test");
    pen.close();
  } // main(String[])

} // class TBExpt
