public class Testing
{
   public static void main(String [] args)
   {
       StringList iList = new IterativeStringList();
       
       Check.check(iList.size(), 0);
       
       iList.addToEnd("Hi");
       iList.addToEnd("Ho");
       iList.addToEnd("Hum");
       
       Check.check(iList.size(), 3);
       
       Check.check(iList.get(0), "Hi");
       Check.check(iList.get(1), "Ho");
       Check.check(iList.get(2), "Hum");
       
       Check.check(iList.indexOf("Hi"), 0);
       Check.check(iList.indexOf("Ho"), 1);
       Check.check(iList.indexOf("Hum"), 2);
       Check.check(iList.indexOf("zap"), -1);
       
       iList.add(0, "pip");
       Check.check(iList.get(0), "pip");
       Check.check(iList.get(1), "Hi");
       Check.check(iList.get(2), "Ho");
       Check.check(iList.get(3), "Hum");
       
       Check.check(iList.size(), 4);
       
       iList.remove(0);
       Check.check(iList.get(0), "Hi");
       Check.check(iList.get(1), "Ho");
       Check.check(iList.get(2), "Hum");
       
       iList.remove(1);
       Check.check(iList.get(1), "Hum");
       
       StringList lowList = iList.toLowerCase();
       Check.check(lowList.get(0), "hi");
       Check.check(lowList.get(1), "hum");
       
       StringList upList = iList.toUpperCase();
       Check.check(upList.get(0), "HI");
       Check.check(upList.get(1), "HUM");
       
       iList.addToEnd("pie");
       iList.addToEnd("plum");
       
       StringList startList = iList.startsWith("p");
       Check.check(startList.get(0), "pie");
       Check.check(startList.get(1), "plum");
       Check.check(startList.size(), 2);
       
       iList.addToEnd("mum");
       
       StringList subList = iList.hasSubstring("um");
       Check.check(subList.get(0), "Hum");
       Check.check(subList.get(1), "plum");
       Check.check(subList.get(2), "mum");
       Check.check(subList.size(), 3);
       
       
       // ************RecursiveOO Testing************************
       
       
       RecursiveOOList rList = new RecursiveOOList();
       
       rList.add(0, "Hi");
       rList.add(1, "Howdy");
       
       Check.check(rList.get(0), "Hi");
       Check.check(rList.get(1), "Howdy");
       
       
   }
}