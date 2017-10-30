public class BFPrint{
  static  final char RIGHT = '>';
  static final char LEFT = '<';
  static final char INCREMENT = '+';
  static final char DECREMENT = '-';
  static final char PRINT = '.';
  static final char INPUT = ',';
  static final char LOOPSTART = '[';
  static final char LOOPEND = ']';

  public static void main(String[] args){
    System.out.println(bfGenerator(parseArgs(args)));
  }

  private static int[] parseArgs(String[] args){
      String arguments = "";
      char[] argToken;
      int[] argNumerized;

      for(String arg : args){
        arguments = arguments.concat(arg + " ");
      }
      if(arguments.length() > 0){
        arguments = arguments.substring(0, arguments.length() - 1);
      }
      argToken = arguments.toCharArray();
      argNumerized = new int[argToken.length];
      for(int i = 0; i < argToken.length; i++){
        argNumerized[i] = (int) argToken[i];
      }

      return argNumerized;
  }

  private static String bfGenerator(int[] args){
    StringBuilder BFCodeBuffer = new StringBuilder();
    for(int e : args){
        int sqrt = (int)Math.sqrt(e);
        int dif = e-(sqrt*sqrt);

        for(int i = 0; i < dif%sqrt; i++){
            BFCodeBuffer.append(INCREMENT);
        }

        BFCodeBuffer.append(RIGHT);

        for(int i = 0; i < (dif/sqrt)+sqrt; i++){
            BFCodeBuffer.append(INCREMENT);
        }

        BFCodeBuffer.append(LOOPSTART);
        BFCodeBuffer.append(DECREMENT);
        BFCodeBuffer.append(LEFT);

        for(int i = 0; i < sqrt; i++){
            BFCodeBuffer.append(INCREMENT);
        }
        BFCodeBuffer.append(RIGHT);
        BFCodeBuffer.append(LOOPEND);
    }
    for(int i = 0; i < args.length; i++){
        BFCodeBuffer.append(LEFT);
    }
    BFCodeBuffer.append(LOOPSTART);
    BFCodeBuffer.append(PRINT);
    BFCodeBuffer.append(RIGHT);
    BFCodeBuffer.append(LOOPEND);

    return(BFCodeBuffer.toString());

  }


}
