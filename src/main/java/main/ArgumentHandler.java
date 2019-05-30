package main;

public class ArgumentHandler {

    public static boolean checkLiterals = false;
    public static boolean checkLeft = true;
    public static int minGraphSize = 6;
    public static boolean verbose = false;
    public static boolean strictEdges = false;
    public static boolean checkMethodLeft = false;

    public static String getHelp() {
        return (
                "-s [int] -- Change the minimum size of the graph \n" +
                "-v -- Verbose \n" +
                "-e -- Strict edge comparison \n" +
                "-ignoreLeft -- Ignores left check \n" +
                "-l -- hard check literals\n" +
                "-c -- check method left expression"
        );
    }

    public static void parseArgs(String[] args) {

        try {
            for (int i = 1; i < args.length; i++) {
                if(args[i].equalsIgnoreCase("-s")) {
                    minGraphSize = Integer.parseInt(args[++i]);
                } else if(args[i].equalsIgnoreCase("-v")) {
                    verbose = true;
                } else if(args[i].equalsIgnoreCase("-e")) {
                    strictEdges = true;
                } else if(args[i].equalsIgnoreCase("-ignoreLeft")) {
                    checkLeft = false;
                } else if(args[i].equalsIgnoreCase("-l")) {
                    checkLiterals = true;
                } else if(args[i].equalsIgnoreCase("-c")) {
                    checkMethodLeft = true;
                } else if(args[i].equalsIgnoreCase("-h")) {
                    System.out.println(getHelp());
                    System.exit(0);
                } else {
                    throw new Exception();
                }
            }
        } catch(Exception e) {
            System.err.println("Invalid arguments.");
            System.exit(1);
        }

    }


}
