package tool;

import java.io.*;
import java.nio.channels.FileChannel;

public class UpLoad {
    public static int UpLoad(String FileFrom, String FileTo) {
        int state = 0;
        File from = new File(FileFrom);
        File to = new File(FileTo);
        File parentPath = new File(to.getParent());
        if (!parentPath.exists()) {
            parentPath.mkdir();
        }
        try {
            FileInputStream In = new FileInputStream(from);
            FileOutputStream Out = new FileOutputStream(to);
            FileChannel fileChannelIn = In.getChannel();
            FileChannel fileChannelOut = Out.getChannel();
            fileChannelIn.transferTo(0, fileChannelIn.size(), fileChannelOut);
            fileChannelOut.close();
            fileChannelIn.close();
            Out.close();
            In.close();
            state = 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return state;
    }
}
