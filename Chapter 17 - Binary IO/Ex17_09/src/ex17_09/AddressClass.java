/*
 */
package ex17_09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AddressClass {

    private RandomAccessFile raf;

    // create object with given file
    public AddressClass(File file) throws FileNotFoundException {
        raf = new RandomAccessFile(file, "rw");
    }

    // writes the addres to the file
    public void addAddress(String[] address) throws IOException {
        raf.seek(raf.length());
        raf.writeUTF(String.format("%-32s", address[0]));
        raf.writeUTF(String.format("%-32s", address[1]));
        raf.writeUTF(String.format("%-20s", address[2]));
        raf.writeUTF(String.format("%-2s", address[3]));
        raf.writeUTF(String.format("%-5s", address[4]));
    }

    // returns first address details as an array of strings
    public String[] getFirstAddress() throws IOException {
        raf.seek(0);

        String[] address = new String[5];

        for (int i = 0; i < address.length; i++) {
            address[i] = raf.readUTF();
        }
        return address;
    }

    // returns first address details as an array of strings
    public String[] getNextAddress() throws IOException {
        if (raf.length() == raf.getFilePointer()) {
            return getLastAddress();
        }

        String[] address = new String[5];

        for (int i = 0; i < address.length; i++) {
            address[i] = raf.readUTF();
        }
        System.out.println(raf.getFilePointer());
        return address;
    }

    // returns previous address details as an array of strings
    public String[] getPreviousAddress() throws IOException {
        raf.seek(raf.getFilePointer() - 202);

        String[] address = new String[5];

        for (int i = 0; i < address.length; i++) {
            address[i] = raf.readUTF();
        }
        return address;
    }

    // returns the last address details as an array of strings
    public String[] getLastAddress() throws IOException {
        raf.seek(raf.length() - 101);

        String[] address = new String[5];

        for (int i = 0; i < address.length; i++) {
            address[i] = raf.readUTF();
        }
        return address;
    }
    // Updates the address details of the current address 
    public void updateAddress(String[] address) throws IOException {
        raf.seek(raf.getFilePointer() - 101);
        raf.writeUTF(String.format("%-32s", address[0]));
        raf.writeUTF(String.format("%-32s", address[1]));
        raf.writeUTF(String.format("%-20s", address[2]));
        raf.writeUTF(String.format("%-2s", address[3]));
        raf.writeUTF(String.format("%-5s", address[4]));
    }
}
