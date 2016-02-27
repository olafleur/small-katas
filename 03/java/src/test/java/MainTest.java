import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {
    private class PrintInterceptor extends PrintStream {
        List<String> printed = new ArrayList<>();

        PrintInterceptor(OutputStream out) {
            super(out, true);
        }

        @Override
        public void println(String s) {
            printed.add(s);
        }
    }

    @Test
    public void integratedTest() {
        // given
        PrintInterceptor out = new PrintInterceptor(System.out);
        System.setOut(out);

        // when
        Main.main(null);

        // then
        assertThat(out.printed.get(0)).isEqualTo("rick : 50");
        assertThat(out.printed.get(1)).isEqualTo("josh : 5");
    }
}
