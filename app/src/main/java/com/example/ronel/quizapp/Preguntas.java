package com.example.ronel.quizapp;

public class Preguntas {
    String[] pregunta = {
            "Existen animales autótrofos.",
            "Los líquenes son la unión simbiótica de un hongo y un alga.",
            "Las arañas son insectos.",
            "CO2 es dióxido de carbono.",
            "O3 es oxígeno.",
            "NaCl es cloruro de sodio.",
            "La capital de Corea del Norte es Seúl.",
            "Egipto se encuentra al Noreste de África.",
            "Las palabras graves están acentuadas en la última sílaba.",
            "El núcleo del sujeto puede no aparecer en la frase."
    };
    private String[] respuesta = {
            "false",
            "true",
            "false",
            "true",
            "false",
            "true",
            "false",
            "true",
            "false",
            "true"
    };

    public String getPregunta(int n) {
        return pregunta[n];
    }

    public String getRespuesta(int n) {
        return respuesta[n];
    }
}
