import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {
    @Test
    void bonusZeroParaSalarioMuitoAlto(){
        BonusService service = new BonusService();
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Mariana", LocalDate.now(),new BigDecimal("25000"))));


    }

    @Test
    void bonusDeveSer10PorCentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus =  service.calcularBonus(new Funcionario("Carolina", LocalDate.now(),new BigDecimal("2500")));

        Assertions.assertEquals(new BigDecimal("250.0"), bonus);
    }


}
