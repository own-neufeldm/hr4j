# hr4j

Print horizontal rules. Java port of https://github.com/own-neufeldm/hr.

## Requirements

The following dependencies must already be installed on your system:

| Dependency                                      | Version |
| ----------------------------------------------- | ------- |
| [OpenJDK](https://openjdk.org/projects/jdk/17/) | ^17     |

Please refer to the official vendor documentation for setting up these requirements.

## Setup

Create a portable JAR by using the tools from your JDK:

```bash
# compile source code
javac -d bin src/main/java/*/*.java

# create jar
cd bin
jar --create --file hr4j.jar --main-class hr4j.App */*.class
```

You can now run the app using `java -jar hr4j.jar` in the new `bin` directory.

Additionally, you can create some kind of wrapper to simplify usage, e.g. by adding an alias to your
user profile: `alias hr4j='java -jar <absolute/path/to/jar>'`.

## Usage

Use `hr4j` without arguments to print an untitled horizontal rule:

```
$ hr4j

// -------------------------------------------- //
```

Provide border characters and a title to print a comment, e.g. for Java:

```
$ hr4j -l 40 -b "/*" "ToDo: fix bug"

/* ---------- ToDo: fix bug ---------- */
```

Note that the border characters are reversed on the right side.

See `hr4j --help` for more options.
