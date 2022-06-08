# Minimum-sized AVL Trees

**Minimum-sized AVL Trees** is an application for creating AVL trees of a specified height, using the fewest number of nodes possible. It uses the package [**edu.ksu.cis.viewer**](https://github.com/RodHowell-Algorithms/Tree-Viewer).

## Installation

To install the application, simply download the JAR archive [`minAVL.jar`](https://github.com/RodHowell-Algorithms/Min-AVL-Trees/raw/main/minAVL.jar). The [Java<sup>TM</sup> SE Runtime Environment (JRE)](https://java.com) is required to run the heap viewer.

## Usage

The program may be started by either opening `minAVL.jar` or executing the following from a command line in a folder containing this archive:

<pre>
java -jar minAVL.jar
</pre>

From the main window, enter the desired tree height, and a window will be opened displaying an AVL Tree of that height using the fewest nodes possible.

**Warning:** The number of nodes increases exponentially with the height; hence, this app uses exponential time and space. For this reason, heights no greater than 20 are recommended.

## Compiling the Code

If you wish to modify the code, you will need to download a copy, either by cloning it with `git` or by downloading and decompressing a [ZIP archive](https://github.com/RodHowell-Algorithms/Min-AVL-Trees/archive/refs/heads/main.zip). To compile the code, assuming you have the [Java Development Kit (JDK)](https://www.java.com/en/download/manual.jsp) installed, enter the following from a command line within the root folder of the project (i.e., the one containing the subfolder `edu`):

<pre>
javac -classpath one-jar/lib/viewer.jar edu/ksu/cis/minAVL/*.java
</pre>

(Depending on your shell, you may need to replace each `/` with `\`.) To run the program after compiling it:

<pre>
java -cp .;one-jar/lib/viewer.jar edu.ksu.cis.minAVL.Driver
</pre>

(Depending on your shell, you may need to escape the `;` or replace it with `:`, and/or you may need to replace each `/` with `\`.)

## Creating the JAR Archive

To create a JAR archive, you will first need to create an archive containing just the package **edu.ksu.cis.minAVL**. Because the command is rather long, the files `options.txt` and `Manifest.txt` have been provided to shorten it:

<pre>
jar -c -f minAVL-only.jar @options.txt edu/ksu.cis/minAVL/*.class
</pre>

This creates the Jar archive `minAVL-only.jar`. It can be run by opening it, but only if the file `viewer.jar` (found in the folder `one-jar/lib`) is in the same folder. These can be packaged together using [One-Jar<sup>TM</sup>](http://one-jar.sourceforge.net/index.php?page=getting-started&file=quickstart). First, move `minAVL-only.jar` to the folder `one-jar/main`. Then from the `one-jar` folder:

<pre>
jar -c -f ../minAVL.jar -m boot-manifest.mf .
</pre>

This will create the standalone JAR archive `minAVL.jar`.