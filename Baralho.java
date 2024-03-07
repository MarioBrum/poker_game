import java.util.Vector;
import java.util.Arrays;
//import java.util.random;
public class Baralho {
    Vector<Carta> baralho;
    
    public Baralho() {
        Vector<Carta> inicializacaoBaralho = new Vector<Carta>();
        Vector<String> simbolos = new Vector<String>(Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K"));
        for(String s : simbolos){
            inicializacaoBaralho.add(new Carta(s,Carta.Naipe.ESPADAS));
            inicializacaoBaralho.add(new Carta(s,Carta.Naipe.COPAS));
            inicializacaoBaralho.add(new Carta(s,Carta.Naipe.BASTOS));
            inicializacaoBaralho.add(new Carta(s,Carta.Naipe.OURO));
        }
        this.baralho = inicializacaoBaralho;
    }
    //shuffle
    public void embaralhamento(){
        for(int i = 0; i < 51; i++){
            Carta c = baralho.remove(i);
            baralho.add((int)(Math.random()*52),c);
            //random.nextInt(baralho.size());
        }
    }

    public void addCarta(Carta c){
        if(!baralho.contains(c)){
            baralho.add((int)(Math.random()*52),c);
        }
        else{
            System.out.println("Cartas duplicadas no baralho!!!");
        }
    }

    public Carta removeCarta(){
        if(!(baralho.size() <= 0)){
            Carta c = baralho.remove((int)(Math.random()*52));
            return c;
        }
        else{
            System.out.println("Não há cartas no baralho!!!");
            return null;
        }
    }

    enum ValorPoker {
        ROYAL_FLUSH,
        STRAIGHT_FLUSH, 
        FOUR_OF_KIND, 
        FULL_HOUSE,
        FLUSH,
        STRAIGHT,
        THREE_OF_A_KIND,
        TWO_PAIR,
        ONE_PAIR,
        HIGH_CARD
    }

    public ValorPoker combPoker(Vector<Carta> cartas){
        //flush config
        boolean flush = true;
        Carta.Naipe naipe = null;
        for(Carta c:cartas){
            if(naipe == null){
                naipe = c.naipe;
            }
            else if(c.naipe != naipe)
            {
                flush = false;
            }
        }
        if(flush){
            return ValorPoker.FLUSH;
        }
        else{
            return ValorPoker.HIGH_CARD;
        }
        //alterar pra straight flush, royal flush ou flush

    }

    public String toString() {
        String saida = "Cartas listadas: \n";
        for(Carta carta : baralho){
            saida += carta.toString() + "\n";
        }
        return saida;
    }
}
