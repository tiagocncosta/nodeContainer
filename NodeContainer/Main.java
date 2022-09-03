package NodeContainer;

import java.io.*;
import java.util.Locale;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/tiagocosta/Documents/pasta/teste5", false));
        ///Users/tiagocosta/Documents/pasta
        String line = "";







        FilenameFilter filterByName = new FilenameFilter() {
            @Override
            public boolean accept(File pathname, String name) {
                String nameLowerCase = name.toLowerCase();
                if (nameLowerCase.endsWith("te5")) {
                    return true;
                }
                return false;
            }
        };



        while (true) {
            System.out.println("What is the filePath");
            line = reader.readLine();
            File f = new File(line);
            if (f.isDirectory()) {
                File[] files = f.listFiles(filterByName);
                System.out.println("This files names were added to the selected file:");
                try {
                    for (File file : files) {

                        writer.write(file + "\n");
                        writer.flush();
                        System.out.println(file.getName());


                    }
                } catch (IOException e) {
                    e.getStackTrace();
                } finally {
                    reader.close();
                    writer.close();
                }
                break;
            }
        }
    }
}




