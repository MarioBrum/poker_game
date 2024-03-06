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
        for(Carta c : baralho){
            baralho.remove(c);
            baralho.add(Math.random(0,50),c);
        }
    }

    public String toString() {
        String saida = "Cartas listadas: \n";
        for(Carta carta : baralho){
            saida += carta.toString() + "\n";
        }
        return saida;
    }
}
