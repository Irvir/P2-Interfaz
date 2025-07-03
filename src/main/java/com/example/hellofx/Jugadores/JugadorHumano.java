package com.example.hellofx.Jugadores;
import com.example.hellofx.Observer.Observador;
import com.example.hellofx.Serializable.Serializacion;
import java.io.Serializable;
import com.example.hellofx.Tablero.GrupoTableros;

public class JugadorHumano implements Jugador{
    private String nombreJugador;
    private char simbolo;
    private int puntuacion;
    private int partidasGanadas;
    private int partidasPerdidas;
    private int partidasEmpatadas;

    public JugadorHumano(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.puntuacion = 0;
        this.partidasGanadas = 0;
        this.partidasPerdidas = 0;
        this.partidasEmpatadas = 0;

    }

    @Override
    public String getNombreJugador() {
        return nombreJugador;
    }

    @Override
    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    @Override
    public int getPuntuacion() {
        return puntuacion;
    }

    @Override
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    @Override
    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    @Override
    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    @Override
    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    @Override
    public int getPartidasEmpatadas() {
        return partidasEmpatadas;
    }


    @Override
    public void setPartidasEmpatadas(int partidasEmpatadas) {
        this.partidasEmpatadas = partidasEmpatadas;
    }


    @Override
    public String toString() {
        return "Tipo: JugadorHumano [ " +
                "Nombre='" + nombreJugador + '\'' +
                ", Ganadas=" + partidasGanadas +
                ", Perdidas=" + partidasPerdidas +
                ", Empatadas=" + partidasEmpatadas +
                ']';
    }
    @Override
    public int hacerJugada(int plano, int posicion, GrupoTableros tableros, char simbolo) {
        int planoId = plano -1;
        int fila = (posicion -1)/3;
        int columna = (posicion -1)%3;
        return tableros.recibirJugada(planoId, fila, columna, simbolo);
    }

    @Override
    public char getSimbolo() {
        return simbolo;
    }

    @Override
    public void setSimbolo(char simbolo) {
     this.simbolo = simbolo       ;
    }

    @Override
    public String getNombre() {
        return nombreJugador;
    }
}
