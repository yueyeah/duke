import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    @Test
    public void decideCmd_genericInvalidInput_invalidDukeInputException(){
        Assertions.assertThrows(InvalidDukeInputException.class, () -> {
            Parser.decideCmd("kkj");
        });
    }
}