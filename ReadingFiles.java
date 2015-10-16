/*
 * Michael Wong
 * 10/16/15
 * "AP"Java
 * 
 * fooling around with reading files
 */

public class ReadingFiles
{
    public static void main(String args[])
    {
        TextIO.putf("which file do you want to read\n");
        String fileName = TextIO.getln();
        String buffer;
        TextIO.readFile(fileName);
        
        while(TextIO.peek() != TextIO.EOF)
        {
            buffer = TextIO.getln();
            TextIO.putf("%s\n", buffer);
        }
        TextIO.readStandardInput();
    }
}