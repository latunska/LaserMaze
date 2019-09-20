import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/*
 * This file should not be modified.  Implement in src/main/java/Lasermaze.java
 */
@RunWith(Parameterized.class)
public class LasermazeTest {

    private static final String paddingFormat = "%03d";
    private static final String inputFileFormat = "input/input" + paddingFormat + ".txt";
    private static final String outputFileFormat = "output/output" + paddingFormat + ".txt";
    private static final Charset encoding = Charset.forName("UTF-8");


    private int iteration;
    private String inputFile;
    private String outputFile;
    public LasermazeTest(int iteration, String inputFile, String outputFile) {
        this.iteration = iteration;
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @Parameters(name = "{1}")
    public static Collection<Object[]> data() {
        List<Object[]> testIterators = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            testIterators.add(new Object[] { i, String.format(inputFileFormat, i), String.format(outputFileFormat, i) });
        }
        return testIterators;
    }

    public String resourceAsString(String resourceName) throws IOException {
        StringWriter sw = new StringWriter();
        try (InputStream stream =
                LasermazeTest.class.getResourceAsStream(resourceName)) {
            IOUtils.copy(stream, sw, encoding);
        }
        return sw.toString();
    }

    @Test
    public void testEvalatuate() throws IOException {
        Testable testableLasermaze = new Lasermaze();
        String input = resourceAsString(inputFile);
        int expectedOutput = Integer.valueOf(resourceAsString(outputFile));

        int result = testableLasermaze.evaluate(input);

        Assert.assertEquals("Given input:\n" + input + "\n",
            expectedOutput, result);
    }
}
