import java.util.Vector;//para os testes

public class App {
     //jframe?
    public static void main(String[] args) {
        Baralho baralho = new Baralho();
        System.out.println("--------------------------------------");
        Vector<Carta> flush = new Vector<Carta>();
        flush.add(new Carta("A",Carta.Naipe.ESPADAS));
        flush.add(new Carta("2",Carta.Naipe.ESPADAS));
        flush.add(new Carta("4",Carta.Naipe.ESPADAS));
        flush.add(new Carta("5",Carta.Naipe.ESPADAS));
        flush.add(new Carta("7",Carta.Naipe.ESPADAS));

        Vector<Carta> notFlush = new Vector<Carta>();
        notFlush.add(new Carta("A",Carta.Naipe.COPAS));
        notFlush.add(new Carta("2",Carta.Naipe.ESPADAS));
        notFlush.add(new Carta("4",Carta.Naipe.ESPADAS));
        notFlush.add(new Carta("5",Carta.Naipe.ESPADAS));
        notFlush.add(new Carta("7",Carta.Naipe.ESPADAS));

        Vector<Carta> notFlush2 = new Vector<Carta>();
        notFlush2.add(new Carta("A",Carta.Naipe.COPAS));
        notFlush2.add(new Carta("2",Carta.Naipe.ESPADAS));
        notFlush2.add(new Carta("4",Carta.Naipe.ESPADAS));
        notFlush2.add(new Carta("5",Carta.Naipe.ESPADAS));
        notFlush2.add(new Carta("7",Carta.Naipe.BASTOS));

        Vector<Carta> flush2 = new Vector<Carta>();
        flush2.add(new Carta("A",Carta.Naipe.BASTOS));
        flush2.add(new Carta("2",Carta.Naipe.BASTOS));
        flush2.add(new Carta("4",Carta.Naipe.BASTOS));
        flush2.add(new Carta("5",Carta.Naipe.BASTOS));
        flush2.add(new Carta("7",Carta.Naipe.BASTOS));


        System.out.println(baralho.combPoker(flush));
        System.out.println(baralho.combPoker(notFlush));
        System.out.println(baralho.combPoker(flush2));
        System.out.println(baralho.combPoker(notFlush2));
    }
}
