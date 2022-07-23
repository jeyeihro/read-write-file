# read-write-file
Examples for read/write files.

# Usage
You can refer it to execute gradle.

After execution, see stdout.

`gradle run`

# Specifications
- Customize for reading source-file
  - In this program, the contents of the source-file are defined as `Contents`
    - `com.github.jeyeihro.readwritefile.content.Contents`
  - You can change the way files are loaded or contents are created.
  - Implement `ContentsCreator` if necessary
    - `com.github.jeyeihro.readwritefile.content.ContentsCreator`
- Customize for converting from source-file to target-file
  - You can define `Rule` for convert
  - Under the Rule, you can rename target-file, convert line-separator, search and replace for `Contents`, and so on.
  - You can set up a single `Rule` or multiple rules that can ensure sequential
  - Implement `Rule` if necessary
    - `com.github.jeyeihro.readwritefile.rule.Rule`
- Multiple target-files
  - You can output multiple-files, for example, when you want to split it.
  - Refer to `com.github.jeyeihro.readwritefile.example.multipleTarget.ExampleMain`