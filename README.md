# hr4j

Print horizontal rules. Java port of https://github.com/own-neufeldm/hr.

## Requirements

tbc

## Setup

tbc

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
