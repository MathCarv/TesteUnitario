import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.inatel.c209.ProfessorHorarioAtendimento;
import com.inatel.c209.Professor;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class ProfessorHorarioAtendimentoTest {

    private ProfessorHorarioAtendimento professorHorarioAtendimento;

    @Before
    public void setUp() {
        professorHorarioAtendimento = new ProfessorHorarioAtendimento();
    }

    @Test
    public void testGetPredioSala1() {
        assertEquals("1", professorHorarioAtendimento.getPredio(1));
    }

    @Test
    public void testGetPredioSala2() {
        assertEquals("1", professorHorarioAtendimento.getPredio(2));
    }

    @Test
    public void testGetPredioSala5() {
        assertEquals("1", professorHorarioAtendimento.getPredio(5));
    }

    @Test
    public void testGetPredioSala6() {
        assertEquals("2", professorHorarioAtendimento.getPredio(6));
    }

    @Test
    public void testGetPredioSala7() {
        assertEquals("2", professorHorarioAtendimento.getPredio(7));
    }

    @Test
    public void testGetPredioSala10() {
        assertEquals("2", professorHorarioAtendimento.getPredio(10));
    }

    @Test
    public void testGetPredioSala11() {
        assertEquals("3", professorHorarioAtendimento.getPredio(11));
    }

    @Test
    public void testGetHorarioAtendimentoComSalaValidaEPredio1() throws Exception {
        JSONObject jsonEsperado = new JSONObject("{"
                + "\"nomeDoProfessor\":\"Guilherme\","
                + "\"horarioDeAtendimento\":\"Segunda-feira, das 14h às 16h\","
                + "\"periodo\":\"noturno\","
                + "\"sala\":\"101\","
                + "\"predio\":[\"1\", \"2\", \"3\", \"4\", \"6\"]"
                + "}");
        JSONObject jsonRetornado = professorHorarioAtendimento.getHorarioAtendimento("Renzo", "101", 1);
        assertEquals(jsonEsperado.toString(), jsonRetornado.toString());
    }

    @Test
    public void testGetHorarioAtendimentoComSalaValidaEPredio2() throws Exception {
        JSONObject jsonEsperado = new JSONObject("{"
                + "\"nomeDoProfessor\":\"Chris\","
                + "\"horarioDeAtendimento\":\"Segunda-feira, das 14h às 16h\","
                + "\"periodo\":\"noturno\","
                + "\"sala\":\"101\","
                + "\"predio\":[\"1\", \"2\", \"3\", \"4\", \"6\"]"
                + "}");
        JSONObject jsonRetornado = professorHorarioAtendimento.getHorarioAtendimento("Samuel", "101", 6);
        assertEquals(jsonEsperado.toString(), jsonRetornado.toString());
    }

    @Test
    public void testGetHorarioAtendimentoComSalaValidaEPredio3() throws Exception {
        assertNull(professorHorarioAtendimento.getHorarioAtendimento("Carlos", "101", 3));
    }

    @Test
    public void testGetHorarioAtendimentoComSalaValidaEPredio4() throws Exception {
        assertNull(professorHorarioAtendimento.getHorarioAtendimento("Luiz Felipe", "101", 4));
    }

    @Test
    public void testGetHorarioAtendimentoComSalaValidaEPredio6() throws Exception {
        JSONObject jsonEsperado = new JSONObject("{"
                + "\"nomeDoProfessor\":\"Karina\","
                + "\"horarioDeAtendimento\":\"Segunda-feira, das 14h às 16h\","
                + "\"periodo\":\"noturno\","
                + "\"sala\":\"101\","
                + "\"predio\":[\"1\", \"2\", \"3\", \"4\", \"6\"]"
                + "}");
        JSONObject jsonRetornado = professorHorarioAtendimento.getHorarioAtendimento("Luis", "101", 10);
        assertEquals(jsonEsperado.toString(), jsonRetornado.toString());
    }


    @Test(expected = Exception.class)
    public void testGetHorarioAtendimentoComErroDeConexao() throws Exception {
        // mock do objeto que realiza a requisição para simular um erro de conexão
        ProfessorHorarioAtendimento professorHorarioAtendimentoMock = mock(ProfessorHorarioAtendimento.class);
        when(professorHorarioAtendimentoMock.getHorarioAtendimento("Fábio", "101", 1))
                .thenThrow(new Exception("Erro de conexão"));

        professorHorarioAtendimentoMock.getHorarioAtendimento("Ricardo", "101", 1);
    }

    @Test(expected = Exception.class)
    public void testGetHorarioAtendimentoComJsonInvalido() throws Exception {
        String jsonInvalido = "{";
        // mock do objeto que realiza a requisição para retornar um JSON inválido
        ProfessorHorarioAtendimento professorHorarioAtendimentoMock = mock(ProfessorHorarioAtendimento.class);
        when(professorHorarioAtendimentoMock.getHorarioAtendimento("Rodrigo", "101", 1))
                .thenReturn(new JSONObject(jsonInvalido));

        professorHorarioAtendimentoMock.getHorarioAtendimento("Fred", "101", 1);
    }

    @Test(expected = Exception.class)
    public void testGetHorarioAtendimentoComNomeProfessorInvalido() throws Exception {
        professorHorarioAtendimento.getHorarioAtendimento("", "101", 1);
    }

    @Test(expected = Exception.class)
    public void testGetHorarioAtendimentoComPredioInvalido() throws Exception {
        professorHorarioAtendimento.getHorarioAtendimento("Rogerio", "101", 5);
    }

    @Test(expected = Exception.class)
    public void testGetHorarioAtendimentoComNomeProfessorNulo() throws Exception {
        professorHorarioAtendimento.getHorarioAtendimento(null, "101", 1);
    }

    @Test(expected = Exception.class)
    public void testGetHorarioAtendimentoComSalaNula() throws Exception {
        professorHorarioAtendimento.getHorarioAtendimento("Vinicius", null, 1);
    }
    @Test
    public void testGetPredioSala12() {
        assertEquals("3", professorHorarioAtendimento.getPredio(12));
    }
    @Test
    public void testGetPredioSala8() {
        assertEquals("2", professorHorarioAtendimento.getPredio(8));
    }

}



