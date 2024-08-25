package hr4j;

import java.util.ArrayList;
import java.util.List;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Help.Ansi;
import picocli.CommandLine.Help.ColorScheme;

@Command(name = "hr4j", version = "v1.0.0", abbreviateSynopsis = true,
        description = "%n  Print horizontal rules.", parameterListHeading = "%nArguments:%n",
        optionListHeading = "%nOptions:%n", separator = " ", sortOptions = false)
public class App implements Runnable {
    @Parameters(arity = "0..1", description = "An optional title.", paramLabel = "TITLE")
    private String title = "";

    @Option(names = {"-l", "--length"},
            description = "Minimum character length. [default: ${DEFAULT-VALUE}]",
            paramLabel = "INT")
    private int length = 50;

    @Option(names = {"-b", "--border"},
            description = "Character(s) to use for outer borders. [default: ${DEFAULT-VALUE}]",
            paramLabel = "STR")
    private String border = "//";

    @Option(names = {"-f", "--filler"},
            description = "Character to use for inner fillers. [default: ${DEFAULT-VALUE}]",
            paramLabel = "STR")
    private String filler = "-";

    @Option(names = {"-p", "--paragraph"}, description = "Prepend 'BEGIN' and 'END' before title.")
    private boolean asParagraph = false;

    @Option(names = {"-u", "--upper"}, description = "Convert title to uppercase.")
    private boolean toUpper = false;

    @Option(names = {"-n", "--no-newline"},
            description = "Do not print a new-line character at the end.")
    private boolean noNewline = false;

    @Option(names = {"-v", "--version"}, versionHelp = true, description = "Show version and exit.")
    private boolean showVersion = false;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this message and exit.")
    private boolean showHelp = false;

    public void run() {
        List<String> titles = new ArrayList<String>();

        if (title.isEmpty()) {
            if (asParagraph) {
                titles.add("BEGIN");
                titles.add("END");
            } else {
                titles.add("");
            }
        } else {
            if (toUpper) {
                title = title.toUpperCase();
            }

            if (asParagraph) {
                titles.add(String.format("BEGIN %s", title));
                titles.add(String.format("END %s", title));
            } else {
                titles.add(title);
            }
        }

        for (String title : titles) {
            String horizontalRule =
                    hr4j.Lib.getHorizontalRule(title, length, border, filler.substring(0, 1));

            if (noNewline) {
                System.out.print(horizontalRule);
            } else {
                System.out.println(horizontalRule);
            }
        }
    }

    public static void main(String[] args) {
        ColorScheme colorScheme = CommandLine.Help.defaultColorScheme(Ansi.OFF);
        int exitCode = new CommandLine(new App()).setColorScheme(colorScheme).execute(args);
        System.exit(exitCode);
    }
}
