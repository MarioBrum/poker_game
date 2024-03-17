import java.util.Vector;
import java.util.Arrays;
import java.util.Random;
public class Baralho {
    Vector<Carta> baralho;
    private Random random;
    
    public Baralho() {
        Vector<Carta> inicializacaoBaralho = new Vector<Carta>();
        this.random = new Random();
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
            baralho.add(random.nextInt(baralho.size()),c);
            //random.nextInt(baralho.size());
        }
    }

    public void addCarta(Carta c){
        if(!baralho.contains(c)){
            baralho.add(random.nextInt(baralho.size()-1),c);
        }
        else{
            System.out.println("Cartas duplicadas no baralho!!!");
        }
    }

    public Carta removeCarta(){
        if(!(baralho.size() <= 0)){
            Carta c = baralho.remove(random.nextInt(baralho.size()-1));
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
        }
        else if(possuiQuadra(cartas)){
            return ValorPoker.FLUSH;
        }
        else if(possuiTrinca(cartas)){
            return ValorPoker.FLUSH;
        }
        else if(possuiPar(cartas) == 2){
            return ValorPoker.TWO_PAIR;
        }
        else if(possuiPar(cartas) == 1){
            return ValorPoker.ONE_PAIR;
        }
        else if(possuiSeq(cartas)){
            return ValorPoker.STRAIGHT;
        }else{
            return ValorPoker.HIGH_CARD;
        }
        //alterar pra straight flush, royal flush ou flush

    }

    public boolean possuiSeq(Vector<Carta> cartas){
        Vector<Integer> vet = new Vector<Integer>();
        vet = sort(vecCartaToVecInt(cartas));
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
            //breakpoint
            //System.out.println("sort" + menorValor);
            vet.remove(menorValor);    
        }
        return retorno;

    }

    public Vector<Integer> vecCartaToVecInt(Vector<Carta> cartas){
        Vector<Integer> vet = new Vector<Integer>();
        for(Carta c: cartas){
            vet.add(c.getNumeroInt());
        }
        return vet;
    }

    public int possuiPar(Vector<Carta> cartas){
        Vector<Integer> vet = new Vector<Integer>();
        vet = sort(vecCartaToVecInt(cartas));
        int contaPar = 0;
        int i = 0;
        while(i < vet.size()){
            int valor = vet.get(i);
            for(int j = i+1; j < vet.size();j++){
                if(valor == vet.get(j)){
                    contaPar++;
                    i++;
                    break;
                }
            }
            i++;
        }

        return contaPar;
    }
    //ARRUMAR TRINCA
    public boolean possuiTrinca(Vector<Carta> cartas){
        Vector<Integer> vet = new Vector<Integer>();
        vet = sort(vecCartaToVecInt(cartas));
        boolean contaPar = false;
        int i = 0;
        while(i < vet.size()){
            int valor = vet.get(i);
            for(int j = i+1; j < vet.size();j++){
                if(valor == vet.get(j) && valor == vet.get(j+1)){
                    return true;
                }
            }

        }
        return false;
    }

    //ARRUMAR QUADRA
    public boolean possuiQuadra(Vector<Carta> cartas){
        Vector<Integer> vet = new Vector<Integer>();
        vet = sort(vecCartaToVecInt(cartas));
        boolean contaPar = false;
        int i = 0;
        while(i < vet.size()){
            int valor = vet.get(i);
            for(int j = i+1; j < vet.size();j++){
                if(valor == vet.get(j) && valor == vet.get(j+1) && valor == vet.get(j+2)){
                    return true;
                }
            }

        }
        return false;
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
