import java.util.Vector;//para os testes

public class App {
     //jframe?
    public static void main(String[] args) {
        Baralho baralho = new Baralho();
        baralho.embaralhamento();
        Vector<Carta> mao = new Vector<Carta>();
        //partida(baralho, mao);
        
        //TESTE TRINCA
        Vector<Carta> trinca = new Vector<Carta>();
        trinca.add(new Carta(1,Carta.Naipe.ESPADAS));
        trinca.add(new Carta(3,Carta.Naipe.ESPADAS));
        trinca.add(new Carta(1,Carta.Naipe.COPAS));
        trinca.add(new Carta(2,Carta.Naipe.OURO));
        trinca.add(new Carta(1,Carta.Naipe.OURO));
        System.out.println("Three of Kind : " + baralho.combPoker(trinca).toString());
        

        //TESTE QUADRA
        Vector<Carta> quadra = new Vector<Carta>();
        quadra.add(new Carta(1,Carta.Naipe.ESPADAS));
        quadra.add(new Carta(13,Carta.Naipe.ESPADAS));
        quadra.add(new Carta(1,Carta.Naipe.COPAS));
        quadra.add(new Carta(1,Carta.Naipe.BASTOS));
        quadra.add(new Carta(1,Carta.Naipe.OURO));
        System.out.println("Four of Kind : " + baralho.combPoker(quadra).toString());

        //TESTE ROYAL FLUSH
        Vector<Carta> royalflush = new Vector<Carta>();
        royalflush.add(new Carta(11,Carta.Naipe.COPAS));
        royalflush.add(new Carta(13,Carta.Naipe.COPAS));
        royalflush.add(new Carta(12,Carta.Naipe.COPAS));
        royalflush.add(new Carta(10,Carta.Naipe.COPAS));
        royalflush.add(new Carta(1,Carta.Naipe.COPAS));
        System.out.println("Royalflush : " + baralho.combPoker(royalflush).toString());

        //TESTE STRAIGTH FLUSH
        Vector<Carta> straightflush = new Vector<Carta>();
        straightflush.add(new Carta(11,Carta.Naipe.COPAS));
        straightflush.add(new Carta(13,Carta.Naipe.COPAS));
        straightflush.add(new Carta(12,Carta.Naipe.COPAS));
        straightflush.add(new Carta(10,Carta.Naipe.COPAS));
        straightflush.add(new Carta(9,Carta.Naipe.COPAS));
        System.out.println("Straightflush : " + baralho.combPoker(straightflush).toString());
        

        //TESTE FLUSH
        Vector<Carta> flush = new Vector<Carta>();
        flush.add(new Carta(2,Carta.Naipe.COPAS));
        flush.add(new Carta(13,Carta.Naipe.COPAS));
        flush.add(new Carta(5,Carta.Naipe.COPAS));
        flush.add(new Carta(3,Carta.Naipe.COPAS));
        flush.add(new Carta(9,Carta.Naipe.COPAS));
        System.out.println("Flush : " + baralho.combPoker(flush).toString());

        //TESTE FULL HOUSE
        Vector<Carta> fullhouse = new Vector<Carta>();
        fullhouse.add(new Carta(2,Carta.Naipe.COPAS));
        fullhouse.add(new Carta(2,Carta.Naipe.OURO));
        fullhouse.add(new Carta(4,Carta.Naipe.BASTOS));
        fullhouse.add(new Carta(2,Carta.Naipe.ESPADAS));
        fullhouse.add(new Carta(4,Carta.Naipe.COPAS));
        System.out.println("Fullhouse : " + baralho.combPoker(fullhouse).toString());

        //partida(baralho,mao);

    }

    public static void partida(Baralho baralho,Vector<Carta> mao){
        System.out.println("Sua mão é: ");
        mao.add(baralho.removeCarta());
        mao.add(baralho.removeCarta());
        mao.add(baralho.removeCarta());
        mao.add(baralho.removeCarta());
        mao.add(baralho.removeCarta());
        for(Carta c:mao){
            System.out.print(c.toString());
        }
        System.out.println("Sua combinação é : " + baralho.combPoker(mao).toString());
            
    }
}
