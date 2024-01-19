import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {
    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar(){
        this.service = new ReajusteService();
        this.funcionario  = new Funcionario("Maria", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
     public void reajusteDeveSerTresPorCentoParaDesempenhoADesejar(){
        service.concederReajuste(funcionario, Desempenho.A_Desejar);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());

    }

    @Test
    public void reajusteDeveSerQuinzePorCentoParaDesempenhoBom() {

        service.concederReajuste(funcionario, Desempenho.Bom);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajustDeveSerVintePorCentoParaDesempenhoOtimo(){

        service.concederReajuste(funcionario, Desempenho.Otimo);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
