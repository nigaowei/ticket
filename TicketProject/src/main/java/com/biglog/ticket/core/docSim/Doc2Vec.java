package com.biglog.ticket.core.docSim;
import com.biglog.ticket.core.segmentation.JiebaSegmenter;
import com.biglog.ticket.core.segmentation.SegToken;
import com.biglog.ticket.core.word2Vec.vec.Word2VEC;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by ngw on 2017/2/28.
 */
public class Doc2Vec {

    private static Word2VEC vec = new Word2VEC();

    private static final int LEN = 50;//词向量维度

    public static List<String> stopWords = new ArrayList<String>();//停用词

    public static JiebaSegmenter jiebaSegmenter;

    private static InputStream is= null;

    private static BufferedReader br = null;

    private static Properties pps = new Properties();

    private static final String stopWordsPath = "/stopWords.txt";

    private static final String word2VecPath = "library_javaVector.bin";

    private static final String idfPath = "/idf.properties";

    /**
     * 加载模型初始化
     */

    public Doc2Vec(){

        try {

            String root = this.getClass().getClassLoader().getResource("").toString().replace("file:/","");

            vec.loadJavaModel(root+word2VecPath);

            pps.load(new InputStreamReader(this.getClass().getResourceAsStream(idfPath), "UTF-8"));

            String s = "";

            stopWords = readFile(stopWordsPath);

            jiebaSegmenter = new JiebaSegmenter();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 读取文件
     * @param filePath
     * @return
     */

    public List<String> readFile(String filePath){

        List<String> list = new ArrayList<String>();
        try{
            is = this.getClass().getResourceAsStream(filePath);
            br=new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

            String s = "";

            while((s = br.readLine())!=null){
                list.add(s.trim());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                br.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        return list;


    }

    /**
     * 分词
     * @param line
     * @return
     */

    public ArrayList<String> cutWords(String line){

        ArrayList<String> words = new ArrayList<String>();

        List<SegToken> segTokens = jiebaSegmenter.process(line, JiebaSegmenter.SegMode.INDEX);



        for(SegToken segToken:segTokens){

            if(!stopWords.contains(segToken.toString())){
                words.add(segToken.toString());
            }
        }

        return  words;

    }

    /**
     * 将短文本转化为向量
     * @param line
     * @return
     */

    public  float[] doc2Vec(String line){

        ArrayList<String> words  = this.cutWords(line);

        float[] res = new float[LEN];

        for(String word : words){

            //System.out.println(word);

            float[] wordVec = vec.getWordVector(word);

            //float idf = Float.parseFloat(pps.getProperty(word));

            if(wordVec!=null){

                for(int i=0;i<LEN;i++){

                    res[i] += wordVec[i];
                }
            }

        }
        return res;
    }

    /**
     * 计算两个短文本之间的距离
     * @param line1
     * @param line2
     * @return
     */

    public double getDistance(String line1,String line2){

        float[] vec1 = this.doc2Vec(line1);

        float[] vec2 = this.doc2Vec(line2);

        double sum = 0.0;

        for(int i=0;i<LEN;i++){

            sum += Math.pow(vec1[i]-vec2[i],2);
        }

        return Math.pow(sum,0.5);
    }

    public static void main(String []args){
//
//        Doc2Vec d2c =  new Doc2Vec();
//
//        double dis = d2c.getDistance("更换供电模块","更换板卡后恢复");
//
//        System.out.println(dis);




    }


}
