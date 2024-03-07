public class Carta {
    String numero;
    enum Naipe {
        ESPADAS,
        COPAS,  // coracao
        BASTOS, // paus
        OURO
    }
    Naipe naipe;
    
    public Carta(String nro, Naipe n) {
        numero = nro;
        naipe = n;
    }

    public String getNumero() {
        return this.numero;
    }

    public Naipe getNaipe() {
        return this.naipe;
    }

    public String toString() {
        return "Carta: " + this.numero + " de " + this.naipe.name() + " \n ";
    }
}
