# Strings #

* A `string` is a sequence of characters
* Although it is treated as array of characters in other languages, in Java it is treated as an object

## The `String` Class ##

* Strings can be created from a String literal (`"like this"`) or from an array of characters (`{'h','e','l','l','o'})
* A `String` object is immutable, meaning its contents cannot be changed once the string is created
  * because of this, JVM uses a unique instance (*interned strings*) for string literals with the same character sequence in order to improve efficiency and save memory
  * Ex: See this excerpt from pg 337, 9.2 "The String Class"![:](/strings/img/interned_strings.PNG)
    * Basically, if Java will share the same instance of a string literal with other entities that reference it, instead of creating a new instance of it every time (unless you explicitly create a new String object with the same "value"...then it will be a separate instance)....just look at the screenshot provided above

### String comparisons ###

* You can not compare the contents of two strings with the `==` operator (or any of the other operators like '<','>', etc.)
  * doing so will only compare the string reference address of both objects
* Use the `equals()` (or `compareTo()` for greater/less than) method to compare contents of two strings
  * Ex: `string1.equals(string2);`
* Here are some of the methods in `String` class for comparing strings![:](/strings/img/string_comparison_methods.PNG)
* for the other String methods....just look it up

## `StringBuilder` and `StringBuffer` classes ##

* These two classes are more flexible than the String class (mainly because not immutable)
   * Can do things like add, insert, or append new contents in "strings"
* `StringBuilder` class is similiar to `StringBuffer` except that the methods for modifiying the buffer in `StringBuffer` are *synchronized*, which means that only one task is allowed to execute the methods
  * Use `StringBuffer` if the class might be accessed by multiple tasks concurrently; `StringBuilder` is more efficient if it is accessed by just a single task
* `StringBuilder` methods: ![img](/strings/img/stringbuilder_methods.PNG)
* more methods: ![img](/strings/img/stringbuilder_methods_2.PNG)

## Command-line arguments ##

* the `main` method can receive string arguments from the command line
  * it has the parameter `args` (note the parameter can be named anything) of `String[]` type...which allows it receive multiple strings as argument
* SKIPPED SECTION, seemed not useful