import java.io.File;

public class Searcher {


    public static void main(String[] args){
        System.out.println("Hello! I`m Jenny, your searching program");
        System.out.println("My data for the searching is : ");
        String filename;
        String base;

        filename=args[0];
        base=args[1];

        System.out.println("Filename = "+ filename + "\t; Base directory = " + base);

        long start=System.currentTimeMillis();


        File f = searchFile(new File(base),filename);

        if (f!=null){
            String path = f.getAbsolutePath();
            System.out.println("Your file is : "+path);}

        else  System.out.println("Unfortunately, the search was not successful!");

        long time=System.currentTimeMillis()-start;

        System.out.println("Required time : "+time);
    }

    static File searchFile(File file, String search) {
        if (file.isDirectory()) {
            File[] arr = file.listFiles();
            for (File f : arr) {
                File found = searchFile(f, search);
                if (found != null)
                    return found;
            }
        } else {
            if (file.getName().equals(search)) {
                return file;
            }
        }

        return null;
    }
}
