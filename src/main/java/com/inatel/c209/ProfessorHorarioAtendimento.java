package com.inatel.c209;

import java.util.List;
import org.json.JSONObject;

public class ProfessorHorarioAtendimento {

    public JSONObject getHorarioAtendimento(String professor, String sala, int predio) throws Exception {
        // método que realiza a requisição e retorna um JSON com as informações de horário de atendimento
        // implementação omitida para fins de teste
        return new JSONObject("{"
                + "\"nomeDoProfessor\":\"" + professor + "\","
                + "\"horarioDeAtendimento\":\"Segunda-feira, das 14h às 16h\","
                + "\"periodo\":\"noturno\","
                + "\"sala\":\"" + sala + "\","
                + "\"predio\":[\"1\", \"2\", \"3\", \"4\", \"6\"]"
                + "}");
    }

    public String getPredio(int sala) {
        if (sala >= 1 && sala <= 5) {
            return "1";
        } else if (sala >= 6 && sala <= 10) {
            return "2";
        } else {
            return "3";
        }
    }

}
