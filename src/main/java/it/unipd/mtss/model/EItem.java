////////////////////////////////////////////////////////////////////
// [Mattia] [Brunello] [2009096]
// [Samuel] [Peron] [1225423]
//////////////////////////////////////////////////////////////////// 

package it.unipd.mtss.model;

public class EItem {
    public enum itemType {
        PROCESSOR, MOTHERBOARD, MOUSE, KEYBOARD
    }

    itemType type;
    Double price;
    String name;

    public EItem(itemType tipo, double prezzo, String nome) {
        type = tipo;
        price = prezzo;
        name = nome;
        if(price >= 0.0D) {
            this.price     = prezzo;
        }else {
            throw new IllegalArgumentException("Il prezzo deve essere maggiore 0");
        }
    }

    public itemType getType(){
        return type;
    }

    public double getPrice() {

        return price;
    }

    public String getName()
    {
        return name;
    }
    public void discount(double d){

        this.price *= (1-d);
    }

}