package hr4j;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;


// Usage: hr [OPTIONS] [TITLE] COMMAND [ARGS]...

// Print horizontal rules.

// Arguments:
// [TITLE] An optional title.

// Options:
// -l, --length INTEGER Minimum character length. [default: 50]
// -b, --border TEXT Character(s) to use for outer borders. [default: #]
// -f, --filler TEXT Character to use for inner fillers. [default: -]
// -p, --paragraph Prepend 'BEGIN' and 'END' before title.
// -u, --upper Convert title to uppercase.
// -n, --no-newline Do not print a new-line character at the end.
// --version Show version and exit.
// --help Show this message and exit.

@Command(name = "hr4j", version = "v1.0.0")
public class App implements Runnable {
    @Option(names = {"-v", "--version"}, versionHelp = true, description = "Show version and exit.")
    private boolean showVersion = false;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this message and exit.")
    private boolean showHelp = false;

    public void run() {
        throw new RuntimeException("Not implemented.");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
