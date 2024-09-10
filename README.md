# CS-2003-Lab-1

## Overview
This first lab has two goals. First, you'll be implementing four essential array algorithms. These algorithms are the _array sum_, _array product_, _array minimum_, and _array maximum_ algorithms. This lab will also serve as your introduction to the process that you'll be following each week to accept, complete, and submit assignments. Secondly, this lab will introduce you to programming with non-primitive data types called **objects**.

Assignment instructions can be found in the `README.md` included with each assignment. The assignment instructions will include an **Overview** of the assignment, the **Assignment** description, a description of the **Input**, the expected **Output**, and a few **Samples** of tests. Your goal for each week will be to parse the provided inputs and implement the assigned algorithm(s) in order to print the desired output.

Instructions will also include other sections, such as **Hints** and **Submission**, which are intended to provide helpful information towards completing or submitting assignments. If you run into any problems submitting your code, please see the **Help** section. For all other issues, please contact your TA or your instructor for assistance.

When you're ready, you can use the sample test cases to manually evaluate your assignment submission. See the **Grading Rubric** section for more information on how points are awarded for the assignment. The same test cases (and more) are used by the TU Grader (TUG) to compute your score for each submission. To run the autograder, please execute the provided `src/test/java/TUGrader.java` file, run `./build.sh test` from a UNIX terminal, or use the Test (beaker) extension provided by VS Code. See **Compiling and Testing Code** section for more information.

## Assignment
Please complete the implementation of `src/main/java/Main.java`. For this assignment, you'll need to parse the provided inputs, and print the sum, product, minimum, and maximum of the provided array.

Once complete, please create a class called `BankAccount`, which can be created in its own file or as an inner class within `src/main/java/Main.java`. If you choose to create your own file, it must be located within `src/main/java/`. The `BankAccount` class must implement the `Accountable` interface located at `src/main/java/Accountable.java`.

Lastly, revise your implementation of all four algorithms to use an array of `BankAccount`s rather than an array of `int`s.

## Input
You'll be provided with a line of input containing a single integer `n (1 <= n <= 10^3)`, the number of elements in the array. The next line will contain `n` space-separated integers `a_i (-10^5 <= a_i <= 10^5)`. All inputs will be provided on STDIN (System.in).

## Output
You are to print a single line of output containing four space-separated integers, which are the sum, product, minimum, and maximum, respectively. All outputs need to be printed on STDOUT (System.out).

## Samples
| Sample Input | Sample Output |
| ------------ | ------------- |
| `10` | |
| `1 2 3 4 5 6 7 8 9 10` | `55 3628800 1 10` |
| | |
| `10` | |
| `-1 2 3 4 5 6 7 8 9 10` | `53 -3628800 -1 10` |

## Grading Rubric
- [ ] (70pts) Computes the sum, product, minimum, and maximum
- [ ] (15pts) Has an implementation (BankAccount) of Accountable
- [ ] (15pts) Revises the algorithms to use BankAccounts (manually graded)

## Submission
The assignment is due by the end-of-day Friday of the following week.

To submit your work, you must _stage_, _commit_, and _sync_ your changes. After submitting, you can check the **Actions** tab on your GitHub repo online to ensure that your work was submitted and to see the results of the autograder. If the autograder shows a green check for your latest commit, you've completed the autograded portion of the lab. Note that labs also include a manually graded portion.

### Commits
Commits should be made incrementally. Many commits are always better than few, and commits can always be squashed together later if there are too many. You should try to make a commit every time you've made tangible progress in the development of your code.

Every commit should have a commit message. The standard format for commit messages is to start with a verb in present-tense followed by a concise message (typically less than 50 characters) that summarizes the change that the commit is introducing to the repo. For example, "updates README", "implements Array", "passes testGet".

Popular IDEs, such as VS Code, provide integrated Git tools. If you're on Windows, you can install Git Bash or Windows Subsystem for Linux (WSL). If you're on Mac or Linux, you already have git installed. Mac users will need to ensure that XCode stays up to date.

You can use the Source Control (branch) extension provided by VS Code to stage, commit, and sync your assignment. These three steps are the submission process. To stage changes, use the plus sign next to each file. To commit changes, add a commit message in the text field at the top and then click commit. To sync changes, click the sync button.

At some point, you'll want to get familiar with using the git terminal commands instead.

To sync changes made from another device, use the following command.
- `git fetch origin main`
- `git pull origin main`

To push commits from command line, use the following commands.
- `git add -A`
- `git commit -m "<your message goes here>"`
- `git push origin main`

You can also sync all changes and submit with the following commands depending on your terminal.
- `./build.sh submit`

## Help

### Can't submit due to Git log
If you've just installed git or this is your first time submitting an assignment with git on this machine, it will need to be configured. The easiest way to configure git is from a terminal. Use the following commands. Note that the quotes need to stay but the angular brackets (<>) should be replaced alongside your username and email.
- `git config --global user.name "<github-username-goes-here>"`
- `git config --global user.email "<github-email-goes-here>"`
- `git config --global pull.rebase false`
- `git config --global fetch.prune true` (optional)
- `git config --global diff.colorMoved zebra` (optional)

### Can't sync due to Git error
In some cases, when you attempt to sync, you'll see a down-arrow rather than just an up-arrow. The up-arrow indicates that you have changes that need to be pushed to the cloud whereas the down-arrow indicates that there are changes in the cloud that need to be pulled to your machine. You can use the ellipsis at the top next to the commit text field to navigate to the pull option which will download and apply those changes to your local machine. If you're unable to use the sync button, please pull first. This may create conflicts on your machine which will have to be resolved manually. If you need help, please ask your TA or your instructor. Once all changes have been pulled and the down-arrow is gone, you can sync your changes.
- You may find it easier to use `git pull origin main` in your terminal

## Hints

### Hint 1 - parsing STDIN using Scanner
All inputs are provided on STDIN. One of the most common ways to parse inputs from STDIN is to use the `Scanner` class, which can be imported with `import java.util.Scanner;`

```java
Scanner scanner = new Scanner(System.in);
int n = scanner.nextInt();
```

### Hint 2 - assigned algorithms
There are four algorithms that need to be implemented as a part of this lab. These algorithms can be implemented together, but a snippet of each individual algorithm is provided below in pseudo code. Note that pseudo code is not Java code and cannot be compiled by the Java compiler. This is my own shorthand for writing pseudo code. It is intended to balance clarity with brevity. If you have any questions about it, please don't hesitate to ask.

```pseudo
Sum(int[] arr) begin
    let sum := 0;
    for all elt in arr, do
        sum := sum + elt;
    end
    return sum;
end
```

```pseudo
Prod(int[] arr) begin
    let prod := 1;
    for all elt in arr, do
        prod := prod * elt;
    end
    return prod;
end
```

```pseudo
Min(int[] arr) begin
    let min := arr[0];
    for all elt in arr, do
        if elt < min, then
            min := elt;
        end
    end
    return min;
end
```

```pseudo
Max(int[] arr) begin
    let max := arr[0];
    for all elt in arr, do
        if max < elt, then
            max := elt;
        end
    end
    return max;
end
```

### Hint 3 - int vs long
When computing the sum, minimum, or maximum of an array of integers, it is often okay to use the 32-bit primitive `int` type defined by Java, which can store numbers approximately as large as `2 * 10^9`. However, it is very easy to exceed this maximum value when computing the product of integers. In such cases, it may be necessary to instead use the 64-bit primitive `long` type defined by Java, which can store numbers approximately as large as `9 * 10^18`.

### Hint 4 - formatted printing
To output a single line of space separated integers, it is easiest to use formatted printing provided by `System.out.printf`. An example of printing four space-separated integers is provided below. The formatting characters `%d` are use to format a single integer variable, which can be the `short`, `int`, or `long` type. Just remember to include the newline character `\n` (i.e., line break) since a line break is not automatically included when using `printf`.

```java
int x1, x2, x3, x4;
System.out.printf("%d %d %d %d\n", x1, x2, x3, x4);
```

### Hint 5 - implementing an Interface
To have a class implement an interface, you need to follow the name of the class with the keyword `implements` followed by the name of the interface. A class that implements an interface must implement each of the interface's methods.

```java
class BankAccount implements Accountable {}
```

### Hint 6 - implementing compareTo
A class that implements compareTo must followed a given standard specified in the official Java documentation. The method must return a negative integer if A is less than B, return zero if A is equal to B, and return a positive integer is A is greater than B. In the case of `Accountable`, objects are compared by their account balance.

```java
public int compareTo(Accountable B) {
    if (balance < B.getBalance()) return -1;
    else if (balance == B.getBalance()) return 0;
    else return 1;
}

Accountable A, B;
if (A < B) {
    System.out.println("This is wrong. You cannot use < with objects.");
}
if (A.compareTo(B) < 0) {
    System.out.println("This is correct!");
    // use A.compareTo(B) < 0 instead of A < B
    // use A.compareTo(B) == 0 instead of A == B
    // use A.compareTo(B) > 0 instead of A > B
}
```

### Hint 7 - array of BankAccounts
You can also create arrays of non-primitive objects, but they may appear strange at first. Unlike arrays of primitives, such as `int`s, when you create an array of non-primitive objects, you have to initialize each object.

```java
int n;
BankAccount[] accounts = new BankAccount[n];
for (int i = 0; i < accounts.length; i++) {
    accounts[i] = new BankAccount(0);
}
```

## Compiling and Testing Code
Your IDE should provide tools to compile your code. If you're unfamiliar with that process, instructions are provided on Harvey. While we'll be using Visual Studio Code in this course, most developers compile and run their code from command line using a shell script, such as a **Makefile** or build script (**build.sh**).

I've provided build scripts for you in _Bash_. Refer to the following directions on how to use these scripts based on the terminal that you're using. If you're on Windows, please use Windows Subsystem for Linux (WSL) or Git Bash.

Only failing tests are shown by default. `TUGrader.java` can be run in `--verbose`  mode to show the output of passing tests. Tests are run in parallel, so please do not use static variables unless they are provided to you. Console output is always silenced during testing to grade your output, so don't use console output to debug your code. You should instead rely on debugging tools provided by your development environment or switch to manual testing.

### Windows Users (WSL, Git Bash), Mac and Linux Users
- To compile your code: `./build.sh`
- To compile and run your code: `./build.sh run` (forwards clargs to program)
- To compile and test your code: `./build.sh test` (forwards clargs to TUGrader)
- To format your code: `./build.sh fmt`
- To generate docs of your code: `./build.sh docs`
- To sync your code: `./build.sh sync`
- To submit your code: `./build.sh submit`
- To remove class files: `./build.sh clean`

These scripts use the following commands. Note that Windows users need to replace the colon with a semicolon in the Java classpath.
- To compile a Java file: `javac -d target -cp lib/*:src <filepath>.java`
- To execute a Java file: `java -cp lib/*:target <package-path>.<filename>`
- To format a Java file: `java -jar lib/google-java-format.jar --replace --skip-javadoc-formatting <filepath>.java`
- To remove class files: `rm -r target/*`

## Docs
A docs folder is provided with every assignment. You can open the `docs/index.html` file in the browser of your choice to navigate and search the Java docs of the assignment. This may provide a more helpful means of exploring the assignment and whatever code is provided to you as a part of the lab.

## Code Style
All code should follow the [Google Java style guidelines](https://google.github.io/styleguide/javaguide.html). If you find anything in the code that does not follow the style guidelines, feel free to fix it, but you are not required to do so. Only your handwritten code will be evaluated for its style. You do not need to follow the style guidelines to the letter but egregious deviations from the style guidelines will be penalized. A submission that passes all test cases but does not use an appropriate style will not receive an A for the assignment.

For those using an IDE, such as Eclipse or VS Code, the IDE should provide a formatting tool. I've included the XML specification of the Google Java Style Guidelines at `.vscode/java-google-style.xml`. You can configure your IDE to use the provided XML as its formatting rules to format your code to the Google Java Style Guidelines, which are the industry standard.

If you're working from command-line, [google-java-format](https://github.com/google/google-java-format) is an open-source formatting tool that you can use to format your files. You can use the following commands to format your code depending on your terminal.
- `./build.sh fmt`
