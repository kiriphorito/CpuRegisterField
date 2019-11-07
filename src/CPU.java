import java.util.List;
import java.util.Optional;

public class CPU {

    private List<Core> cores;

    public CPU(List<Core> cores) {
        this.cores = cores;
    }

    public void addCore(Core core) {
        cores.add(core);
    }

    public Field findField(String definition) {
        for (Core core : cores) {
            Optional<Field> optionalField = core.findField(definition);
            if (optionalField.isPresent()) {
                return optionalField.get();
            }
        }
        throw new IllegalArgumentException("Cannot find field in any register with given definition of: " + definition);
    }


}
