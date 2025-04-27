package streams;

import java.io.*;

public class imagetobytearray {
    public static void main(String[] args) {
        String sourcePath = "";      
        String destinationPath = "output.jpg";

        try {
            FileInputStream fis = new FileInputStream(sourcePath);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            fis.close();

            byte[] imageBytes = baos.toByteArray();
            System.out.println("Image read into byte array. Size: " + imageBytes.length + " bytes");

            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(destinationPath);

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            bais.close();
            fos.close();

            System.out.println("Image written to " + destinationPath);

        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        }
    }
}

