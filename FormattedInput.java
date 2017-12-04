import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Алена on 27.04.2017.
 */
public class FormattedInput {
    public ArrayList<Object> res = new ArrayList<>();
    boolean flag = false;
    int f = 0;

    Object[] scanf(String format) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nВведите данные: ");
        String s = "";
        if(sc.hasNextLine()) {
            s = sc.nextLine();
            f = 1;
            sscanf(format, s);
        }
        return res.toArray();
    }

    Object[] sscanf(String format, String in) {
        int integer = 0;
        double Double = 0.000000000000000000000;
        char symbol = '0';
        String str = "";

        String s = "";

        int j = 0;
        for(j = 0; j < in.length(); j++)
            if(in.charAt(j) != ' ')
                break;

        int tmp = 0;
        int k = 0;
        for (int i = 0; i < format.length(); i++) {
            if (format.charAt(i) == ' ' || format.charAt(i) == '%') {
                continue;
            }
            if (in.charAt(j) == ' ')
                j++;
            if (format.charAt(i) == 'd') {
                tmp = j;
                while (in.charAt(j) != ' ') {
                    if ((int)in.charAt(j) >= 48 && (int)in.charAt(j) <= 57)
                        s = s + in.charAt(j);
                    else {
                        System.out.print("   Вы ввели не целое число ");

                        k++;
                        break;
                    }
                    j++;
                    if (j == in.length())
                        break;
                }
                if (k == 0) {
                    integer = Integer.parseInt(s);
                    res.add(integer);
                    flag = true;
                }
                else
                    flag = false;
                k = 0;
                s = "";
            } else if (format.charAt(i) == 'f') {
                while (in.charAt(j) != ' ') {
                    if (in.charAt(j) >= '0' && in.charAt(j) <= '9' || in.charAt(j) == '.')
                        s = s + in.charAt(j);
                    else {
                        System.out.println("\nВы ввели не дробное число");
                        k++;
                        break;
                    }
                    j++;
                    if (j == in.length())
                        break;
                }
                if (k == 0) {
                    Double = Float.parseFloat(s);
                    res.add(Double);
                    flag = true;
                }
                else
                    flag = false;
                k = 0;
                s = "";
            } else if (format.charAt(i) == 's') {
                while (in.charAt(j) != ' ') {
                    str = str + in.charAt(j);
                    j++;
                    if (j == in.length())
                        break;
                }
                s = "";
                res.add(str);
            } else if (format.charAt(i) == 'c') {
                symbol = in.charAt(j);
                j++;
                res.add(symbol);
            }
            if(flag == false && f == 1) {
                scanf(format);
            }
            else if(flag == false && f == 0)
                System.out.println("вы ввели неверные данные");
        }
        return res.toArray();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < res.size(); i++) {
                result.append(" ").append(res.get(i));
        }
        return  res.toString();
    }

    public boolean equals(Object obj) {

        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(!( obj instanceof FormattedInput))
            return false;

        FormattedInput a = (FormattedInput) obj;
        if (a.res.size() != this.res.size())
            return false;

        for (int i = 0; i < res.size(); i++) {
            if(!a.res.get(i).equals(res.get(i)))
                return false;
        }
        return true;
    }
}
