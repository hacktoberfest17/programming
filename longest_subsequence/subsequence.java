package recurrsion;

public class subsequence {
    public static void main(String[] args) {
        String processed="";
        String unprocessed="abc";
        //subseq(processed,unprocessed);
        permutation(processed,unprocessed);
    }
    public static void subseq(String processed,String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        unprocessed = unprocessed.substring(1);
        subseq(processed + ch, unprocessed);
        subseq(processed, unprocessed);
        //subseq(processed+(int)ch,unprocessed);
    }
    public static void permutation(String processed,String unprocessed){
        if (unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch=unprocessed.charAt(0);
        unprocessed=unprocessed.substring(1);
        for (int i = 0; i <=processed.length() ; i++) {
            String first=processed.substring(0,i);
            String second=processed.substring(i);
            permutation(first+ch+second,unprocessed);

        }

    }
}
