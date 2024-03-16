import java.util.Vector;
import java.util.Arrays;
//import java.util.random;
public class Baralho {
    Vector<Carta> baralho;
    
    public Baralho() {
        Vector<Carta> inicializacaoBaralho = new Vector<Carta>();
        Vector<Integer> simbolos = new Vector<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13));
        for(Integer s : simbolos){
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
        //straigh, royal ou flush
        if(false){
            return ValorPoker.ROYAL_FLUSH;
        }
        else if(possuiFlush(cartas) && possuiSeq(cartas)){
            return ValorPoker.STRAIGHT_FLUSH;
        }
        else if(possuiFlush(cartas)){
            return ValorPoker.FLUSH;
        else if(possuiSeq(cartas)){
            return ValorPoker.STRAIGHT;
        }
        return ValorPoker.HIGH_CARD;
        //alterar pra straight flush, royal flush ou flush

    }

    //ARRUMAR SEQUENCIA
    public boolean possuiSeq(Vector<Carta> cartas){
        Vector<Integer> vet = new Vector<Integer>();
        for(Carta c: cartas){
            vet.add(c.getNumeroInt());
            System.out.println(c.getNumeroInt());
        }
        //vet.sort(null); // FAZER SORT
        vet = sort(vet);
        int cont = 0;
        int inicio = vet.get(0);
        boolean seq = true;
        for(int i = 0; i < vet.size()-1; i++){
            if (!(vet.get(i) + 1== vet.get(i+1))){
                seq = false;
                break;
            }
        }
        
        return seq;
    }

    //sort funcionando
    public Vector<Integer> sort(Vector<Integer> vet){
        Vector<Integer> retorno = new Vector<Integer>();
        int tam = vet.size();
        for(int i = 0; i < tam; i++){
            Integer menorValor = vet.get(0);
            for(int j = 0; j < vet.size(); j++){
                if(vet.get(j) < menorValor){
                    menorValor = vet.get(j);
                }
            }
            retorno.add(menorValor);
            System.out.println("sort" + menorValor);
            vet.remove(menorValor);    
        }
        return retorno;

    }

    public boolean possuiFlush(Vector<Carta> cartas){
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
        return flush;
    }

    public String toString() {
        String saida = "Cartas listadas: \n";
        for(Carta carta : baralho){
            saida += carta.toString() + "\n";
        }
        return saida;
    }
}
