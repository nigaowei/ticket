package com.biglog.ticket.core.idf;

import com.biglog.ticket.core.segmentation.JiebaSegmenter;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by ngw on 2017/3/6.
 */
public class Idf {

    private static ArrayList<String> fileList=new ArrayList<String>();

    private static final String  CODE="UTF-8";

    private static final JiebaSegmenter segmenter = new JiebaSegmenter();
    /**
     * 读取文件
     * @param filePath
     * @return
     */

    public static ArrayList<String> readFile(String filePath){
        InputStream is = null;
        BufferedReader bw = null;
        try{
            is = Idf.class.getClass().getResourceAsStream(filePath);
            bw = new BufferedReader(new InputStreamReader(is, Charset.forName(CODE)));
            String s = "";
            while((s = bw.readLine())!=null){
                if(!fileList.contains(s))
                    fileList.add(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{

                if(bw!=null)
                    bw.close();
                if(is!=null)
                    is.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return fileList;
    }

    /**
     * 获取所有的词语
     * @param file
     */

    public static Set<String> getWords(String file) {

        Set<String> res = new HashSet<String>();

        String[] words = file.split(" ");

        for(String word:words){

            res.add(word);
        }

        return res;

    }

    /**
     * 计算词语的idf并保存为idf.properties
     * @param inPath
     * @param outPath
     * @return
     */

    public static void idf (String inPath,String outPath) throws Exception{

        Properties pps = new Properties();

        String url  = Idf.class.getClass().getResource(outPath).getFile().replaceFirst("/","");

        FileOutputStream fos = new FileOutputStream(new File(url));

        OutputStreamWriter osw = new OutputStreamWriter(fos,CODE);


        ArrayList<String> fileList = readFile(inPath);

        int docLen = fileList.size();

        HashMap<String,Double> idf = new HashMap<String,Double>();

        HashMap<String,Integer> dict =  new HashMap<String,Integer>();

        for(String file:fileList){

            Set<String>words = getWords(file);

            for(String word:words){

                if(dict.containsKey(word)){
                    dict.put(word,dict.get(word)+1);
                }else{
                    dict.put(word,1);
                }
            }
        }

        Iterator iter = dict.entrySet().iterator();

        while(iter.hasNext()){

            Map.Entry entry = (Map.Entry)iter.next();

            String word = (String)entry.getKey();

            //System.out.println(word);

            int num = (Integer)entry.getValue();

            pps.setProperty(word, Math.log(docLen / num * 1.0) + "");

            idf.put(word, Math.log(docLen / num * 1.0));
        }

        pps.store(osw,"word idf");

        fos.close();

    }



    public static void main(String []args) throws Exception{

        idf("/w2c","/idf.properties");
    }

}
