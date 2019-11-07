import java.util.List;
import java.util.Optional;

public class Core {

    String definition;
    List<Register> registers;

    public Core(String definition, List<Register> registers) {
        this.definition = definition;
        this.registers = registers;
    }

    public Optional<Field> findField(String definition) {
        for (Register register : registers) {
            Optional<Field> optionalField = register.findField(definition);
            if (optionalField.isPresent()) {
                return optionalField;
            }
        }
        return Optional.empty();
    }

}
