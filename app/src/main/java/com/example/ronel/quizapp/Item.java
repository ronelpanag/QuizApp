package com.example.ronel.quizapp;

public class Item {

    String pregunta, respuesta;

    public Item(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }
}
