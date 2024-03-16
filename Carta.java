public class Carta {
    int numero;
    enum Naipe {
        ESPADAS,
        COPAS,  // coracao
        BASTOS, // paus
        OURO
    }
    Naipe naipe;
    
    public Carta(int nro, Naipe n) {
        numero = nro;
        naipe = n;
    }

    public String getNumero() {
        if(this.numero == 1){
            return "A";
        }
        else if(this.numero == 11){
            return "J";
        }
        else if(this.numero == 12){
            return "Q";
        }
        else if(this.numero == 13){
            return "K";
        }
        else{
            return String.valueOf(this.numero);
        }
    }

    public int getNumeroInt() {
        return this.numero;
    }

    public Naipe getNaipe() {
        return this.naipe;
    }

    public String toString() {
        return "Carta: " + this.getNumero() + " de " + this.naipe.name() + " \n ";
    }
}
