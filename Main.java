import java.io.IOException;

/**
 * Created by Алена on 27.04.2017.
 */
public class Main {
    public static void main(String[] args){
        FormattedInput input = new FormattedInput();
       // input.sscanf("%d %s %c %f", "1 qwerty d 1.999999999999999999999");
        FormattedInput input2 = new FormattedInput();
       // input2.scanf("%d %s %c %f");

        if(input.equals(input2))
            System.out.println(1);
        else
            System.out.println(0);

        TranscriptWriter trans = null;
        try {
            trans = new TranscriptWriter("C:\\Users\\Алена\\IdeaProjects\\lab6\\TXT\\dop.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        trans.add("ч","ch");
        trans.add("с","s");
        trans.add("р","r");
        try {
            trans.write("чсзвоар");
        } catch (IOException e) {
            e.printStackTrace();
        }
        EncodingConverter ec = new EncodingConverter();
        ec.EConverter("C:\\Users\\Алена\\IdeaProjects\\lab6\\TXT\\input.txt","C:\\Users\\Алена\\IdeaProjects\\lab6\\TXT\\output.txt", "utf8","utf16" );
    }

}
