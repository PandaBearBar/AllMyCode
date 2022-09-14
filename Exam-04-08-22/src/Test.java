import java.lang.invoke.SwitchPoint;
import java.text.Format;
import java.util.Scanner;

public class Test {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean isUse = true;
    private static int nowNum = 0;
    private static double results;
    private static char lastChar = 'N';
    private static char lastOp = 'N';
    public static void main(String[] args) {
        Start();
        Main();
        End();
    }
    public static void Start(){
        System.out.println("Hello User ;)");
    }
    private static void Main() {
        while(isUse){
            Menu();
            switch (lastChar){
                case 'N':
                    Cal();
                    break;
                default:
                    SecondOfCal();
                    break;
            }
        }
    }

    private static void SecondOfCal() {
        switch (lastOp){
            case 'N':
                results = ((double) nowNum);
                break;
            case '+':
                results += ((double) nowNum);
                break;
            case '-':
                results -= ((double) nowNum);
                break;
            case '*':
                results *= ((double) nowNum);
                break;
            case 'P':
                results = Math.pow(results, 2);
                break;
            case 'S':
                results = Math.sqrt(results);
                break;
            case '/':
                results /= ((double) nowNum);;
                break;
            case 'C':
                results = nowNum = 0;
                break;
            default:
                System.out.println("Error");
        }
        if (lastChar == '='){
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println(results);
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");
        }
        lastOp = lastChar;
        nowNum = 0;
        lastChar = 'N';

    }

    private static void Cal() {
        char res = scanner.next().charAt(0);
        switch (res){
            case '0':
            case '1':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                lastChar = 'N';
                nowNum = nowNum*10 + toNum(res);
                break;
            case '+':
            case '-':
            case '*':
            case 'P':
            case 'S':
            case '/':
            case 'C':
            case '=':
                lastChar = res;
                break;
            case 'Q':
                isUse = false;
                break;
            default:
                System.out.println("Error - result unrecognized command");
                break;


        }
    }

    private static int toNum(char res) {
        return Integer.parseInt(res +"");
    }

    private static void Menu() {
        System.out.println("Our Menu:\n" +
                "0~9 Ur Chose Of Numbers\n" +
                "+ Ur Add Command\n" +
                "- Ur Sub Command\n" +
                "P Ur Pow Command\n" +
                "S Ur Sqr Command\n" +
                "/ Ur Dev Command\n" +
                "= Ur Eql Command\n" +
                "C Ur Clr Command\n" +
                "Q Ur Exit♥(2Hell)");
        System.out.println(nowNum);
        System.out.println(lastOp);
        System.out.println(lastChar);
        System.out.println(results);
    }

    private static void End() {
        System.out.println("Ok... Bye");
    }

}