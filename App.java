import java.util.Vector;//para os testes

public class App {
     //jframe?
    public static void main(String[] args) throws Exception{
        Baralho baralho = new Baralho();
        baralho.embaralhamento();
        Vector<Carta> mao = new Vector<Carta>();
		
        /*
        //TESTE TRINCA
        Vector<Carta> trinca = new Vector<Carta>();
        trinca.add(new Carta(1,Carta.Naipe.ESPADAS));
        trinca.add(new Carta(3,Carta.Naipe.ESPADAS));
        trinca.add(new Carta(1,Carta.Naipe.COPAS));
        trinca.add(new Carta(4,Carta.Naipe.OURO));
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
        */
		
        while(true){
            Baralho.ValorPoker valorJogador = partidaJogador(baralho,mao);
            Vector<Carta> maoComputador = new Vector<Carta>();
            Baralho.ValorPoker valorComputador = partidaComputador(baralho,maoComputador);
			System.out.println(baralho.comparaCartas(valorJogador,valorComputador));
            baralho.resetaBaralho();
            mao = new Vector<Carta>();
            maoComputador = new Vector<Carta>();
            Thread.sleep(5000);
        }
    }

    public static Baralho.ValorPoker partidaJogador(Baralho baralho,Vector<Carta> mao){
        //clear cmd
        //System.out.print("\033[H\033[2J");  
        //System.out.flush();
      
        System.out.println("-----------------------------------");
        System.out.println("Sua mão é: ");
        mao.add(baralho.removeCarta());
        mao.add(baralho.removeCarta());
        mao.add(baralho.removeCarta());
        mao.add(baralho.removeCarta());
        mao.add(baralho.removeCarta());
        for(Carta c:mao){
            System.out.print(c.toString());
        }
        Baralho.ValorPoker retorno = baralho.combPoker(mao);
        System.out.println("Sua combinação é : " + retorno.toString());
        return retorno; 
    }

    public static Baralho.ValorPoker partidaComputador(Baralho baralho,Vector<Carta> mao){
        mao.add(baralho.removeCarta());
        mao.add(baralho.removeCarta());
        mao.add(baralho.removeCarta());
        mao.add(baralho.removeCarta());
        mao.add(baralho.removeCarta());
        System.out.println("Mão computador:");
        for(Carta c:mao){
            System.out.print(c.toString());
        }
        Baralho.ValorPoker retorno = baralho.combPoker(mao);
        System.out.println("A combinação do computador é : " + retorno.toString());
        return retorno; 
    }

}