import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // You can create a file that lists all the fields, definitions, and registers and read from it
        // Since this is a demo, I'lve just create definitions based on reg number and field number.

        // In this demo there are
        // 4 Core
        // 1 core has 2 registers -> 1 register with 0 fields, the other with 6 fields
        // The other cores are empty

        // You can use breakpoints to see the layout

        // CPU generator
        // You could store these in a file and import it rather than generating it like below
        List<Field> bte_ctrl_fields = Arrays.asList(
                new Field("F27_START", 0x0, 27, 1),
                // There are no values of the other fields so set them at 0
                new Field("F26_BLOCKING", 0x0, 0, 1),
                new Field("F25_TX_DIR", 0x0, 0, 1),
                new Field("F24_INC_ADDR", 0x0, 0, 1),
                new Field("F16_BXNUM", 0x0, 0, 1),
                new Field("F0_BXADD", 0x0, 0, 1)
        );
        Register bte_ctrl = new Register("BTE_CTRL", 0x5000_0080, 0x0000_0000, bte_ctrl_fields);
        Register bte_sram_addr = new Register("BTE_SRAM_ADDR", 0x0000_0000, 0x0000_0000, new ArrayList<>());
        Core bte = new Core("BTE", Arrays.asList(bte_ctrl, bte_sram_addr));

        Core crga = new Core("CRGA", new ArrayList<>());
        Core pmua = new Core("PMUA", new ArrayList<>());
        Core evthold = new Core("EVTHOLD", new ArrayList<>());

        CPU cpu = new CPU(new ArrayList<>(Arrays.asList(bte, crga, pmua, evthold)));

        Field foundField = cpu.findField("F0_BXADD");
        System.out.println(foundField.getDefinition());
        System.out.println(foundField.getValue());

        foundField.setValue(9999);
        foundField = cpu.findField("F0_BXADD");
        System.out.println(foundField.getDefinition());
        System.out.println(foundField.getValue());

        foundField.reset();
        foundField = cpu.findField("F0_BXADD");
        System.out.println(foundField.getDefinition());
        System.out.println(foundField.getValue());

    }
}
