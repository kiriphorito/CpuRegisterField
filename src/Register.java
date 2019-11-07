import java.util.List;
import java.util.Optional;

public class Register {

    String defintion;
    int regAddress;
    int regResetValue;
    List<Field> fields;

    public Register(String defintion, int regAddress, int regResetValue, List<Field> fields) {
        this.defintion = defintion;
        this.regAddress = regAddress;
        this.regResetValue = regResetValue;
        this.fields = fields;
    }

    public Optional<Field> findField(String definition) {
        for (Field field : fields) {
            if (field.getDefinition().equals(definition)) {
                return Optional.of(field);
            }
        }
        return Optional.empty();
    }

}
