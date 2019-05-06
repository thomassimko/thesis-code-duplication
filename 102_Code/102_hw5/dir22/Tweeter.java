/*import javax.xml.*;
import java.lang.*;
import java.util.*;
import java.io.*;*/


public class Tweeter
{
  public static void main(String [] args)
  {
    //Source url: http://search.twitter.com/search.rss?q=from:keen_csc102
    TwitFeedReader TFR = new TwitFeedReader();
    TwitGUI TG = new TwitGUI(TFR);
      }
}
