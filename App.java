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
                System.out.print(c.toString());
            }

            System.out.println("Sua combinação é : " + baralho.combPoker(mão).toString());
            loop = false;
        }
        
        System.out.println("Sua mão é: ");
        Vector<Carta> mão1 = new Vector<Carta>();
        mão1.add(new Carta(11,Carta.Naipe.ESPADAS));
        mão1.add(new Carta(8,Carta.Naipe.COPAS));
        mão1.add(new Carta(8,Carta.Naipe.OURO));
        mão1.add(new Carta(8,Carta.Naipe.BASTOS));
        mão1.add(new Carta(2,Carta.Naipe.BASTOS));
        for(Carta c:mão1){
            System.out.print(c.toString());
        }

        System.out.println("Sua combinação é : " + baralho.combPoker(mão1).toString());

    }
}
