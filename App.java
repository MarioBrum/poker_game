import java.util.Vector;//para os testes

public class App {
     //jframe?
    public static void main(String[] args) {
        Baralho baralho = new Baralho();
        baralho.embaralhamento();
        Vector<Carta> mão = new Vector<Carta>();
        boolean loop = true;
        while(loop){
            System.out.println("Sua mão é: ");
            mão.add(baralho.removeCarta());
            mão.add(baralho.removeCarta());
            mão.add(baralho.removeCarta());
            mão.add(baralho.removeCarta());
            mão.add(baralho.removeCarta());
            for(Carta c:mão){
                System.out.println(c.toString());
            }

            System.out.println("Sua combinação é : " + baralho.combPoker(mão).toString());
            loop = false;
        }
    }
}
