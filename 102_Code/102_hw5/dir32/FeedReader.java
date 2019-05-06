import java.util.List;
import java.util.Calendar;

public interface FeedReader
{
   /**
      Adds a new source to the list of sources from which feeds are
      retrieved.
      @param: src The URL of the source.
   */
   void addSource(String src);

   /**
      Returns the list of sources that this reader is working with.
   */
   List<String> getSources();

   /**
      Returns a list of feed items pulled from the current list of sources.
   */
   List<RSSItem> retrieveFeedItems();

   /**
      Returns a list of those sources found to be bad during the
      last retrieval of feed items.
   */
   List<String> getBadSources();

   /**
      Removes the currently identified set of bad sources from the
      full set of sources.
   */
   void removeBadSources();
}
