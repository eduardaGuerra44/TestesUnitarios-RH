import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {
    @Test
    public void reajusteDeveSerTresPorCentoParaDesempenhoADesejar(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Maria", LocalDate.now(), new BigDecimal("1000"));

        service.concederReajuste(funcionario, Desempenho.A_Desejar);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());

    }

    @Test
    public void reajusteDeveSerQuinzePorCentoParaDesempenhoBom() {
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Clara", LocalDate.now(), new BigDecimal("1000"));

        service.concederReajuste(funcionario, Desempenho.Bom);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }
}
