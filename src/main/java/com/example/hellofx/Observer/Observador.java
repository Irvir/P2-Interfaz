package com.example.hellofx.Observer;

import com.example.hellofx.Jugadores.Jugador;

public interface Observador {
    void actualizar(Jugador jugador, String tipo);
}
