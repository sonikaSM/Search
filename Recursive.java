import java.io.File;

public class Recursive {
    String base,filename;
    Recursive(String st1, String st2){
        base=st1;
        filename=st2;
    }
    public void Search(){
        File f=searchFile(new File(base),filename);

        if(f!=null){
        String path=f.getAbsolutePath();
        System.out.println("Your file is : "+path);
        }else System.out.println("Unfortunately, the search was not successful!");

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
