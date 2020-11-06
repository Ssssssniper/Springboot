package com.example.demo.analysisfile;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPUtils {
    public static final String GZIP_ENCODE_UTF_8 = "UTF-8"; 
    public static final String GZIP_ENCODE_ISO_8859_1 = "ISO-8859-1";

    private GZIPUtils(){}
    
    public static byte[] compress1(byte[] data) {
        if (data == null || data.length== 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(data);
            gzip.close();
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    public static byte[] compress(byte[] data){
        if (data == null || data.length== 0) {
            return null;
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (GZIPOutputStream gzip = new GZIPOutputStream(outputStream)){
            gzip.write(data);
        }catch (IOException e){
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
    public static byte[] uncompress(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (ByteArrayInputStream in = new ByteArrayInputStream(bytes);
             GZIPInputStream ungzip = new GZIPInputStream(in)){

            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    public static void main(String[] args) throws IOException {




        String s = "12345flsfd是空间打开sajflalfkj";

        byte[] compress = compress(s.getBytes());
      //  System.out.println(ByteConvert.bytesToHexString(compress));

        byte[] compress1 = compress1(s.getBytes());
      //  System.out.println(ByteConvert.bytesToHexString(compress1));
//        byte[]  d = FileRead.getbytes("F:\\test\\123.txt");
//        FileRead.getFile(compress(d),"F:\\test","12.zz");
//        byte[]  d1 = FileRead.getbytes("F:\\test\\12.zz");
//        byte[] uncompress = uncompress(d1);
//        System.out.println(new String(uncompress));


     }
}