package com.example.contador;

public class Jugador {
    String nick;
    String monedas;
    int Imagen;

    public Jugador(String nick, String monedas, int imagen) {
        this.nick = nick;
        this.monedas = monedas;
        Imagen = imagen;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMonedas() {
        return monedas;
    }

    public void setMonedas(String monedas) {
        this.monedas = monedas;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }

}
