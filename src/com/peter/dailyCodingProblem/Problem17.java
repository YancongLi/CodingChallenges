package com.peter.dailyCodingProblem;

/*
Suppose we represent our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0.

Note:

The name of a file contains at least a period and an extension.

The name of a directory or sub-directory will not contain a period.
*/

import java.util.Stack;

public class Problem17 {
    public static void main(String[] args) {
        String string1 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(theLengthOfTheLongestAbsolutePath(string1));
        //should return 32 ("dir/subdir2/subsubdir2/file2.ext")
    }

    private static int theLengthOfTheLongestAbsolutePath(String str) {
        Stack<File> stack = new Stack<>();
        String[] paths = str.split("\\n");
        //System.out.println(Arrays.toString(paths));
        String result = null;

        for (String path : paths) {
            int level = path.lastIndexOf("\t") + 1;
            path = path.substring(level);

            boolean isFile = path.contains(".");
            while (!stack.isEmpty() && stack.peek().level >= level) {
                stack.pop();
            }

            if (isFile) {
                String fullPath = path;
                if (!stack.isEmpty()) {
                    fullPath = stack.peek().path + "/" + path;
                }
                if (result == null || fullPath.length() > result.length()) {
                    result = fullPath;
                }
            } else {
                if (stack.isEmpty()) {
                    stack.push(new File(path, level));
                } else {
                    stack.push(new File(stack.peek().path + "/" + path, level));
                }
            }
        }
        return result == null ? 0 : result.length();
    }

    private static class File {
        String path;
        int level;

        public File(String path, int level) {
            this.path = path;
            this.level = level;
        }
    }

}
