public class App {

    public static void main(String[] args) {
        Baralho baralho = new Baralho();
        System.out.println("--------------------------------------");
        baralho.embaralhamento();
        baralho.embaralhamento();
        //System.out.println(baralho.toString());
        System.out.println(baralho.removeCarta().toString());
        System.out.println(baralho.removeCarta().toString());

    }
}
