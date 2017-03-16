package com.biglog.ticket;

import com.biglog.ticket.core.word2Vec.vec.Learn;
import com.biglog.ticket.core.word2Vec.vec.Word2VEC;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;


/**
 * Created by ngw on 2017/3/6.
 */
public class Word2VecTest extends TestCase{

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }


    @Test
    public void testTrain() throws Exception{

        Learn learn = new Learn();
        long start = System.currentTimeMillis();
        String root = this.getClass().getClassLoader().getResource("").toString().replace("file:/","");
        File file = new File(this.getClass().getResource("/w2c").toString().replace("file:/",""));

        learn.learnFile(file);
        System.out.println("use time " + (System.currentTimeMillis() - start));
        learn.saveModel(new File(root+"library_javaVector.bin"));


    }
    @Test
    public void testWord2Vec() throws Exception{

        Word2VEC word2VEC = new Word2VEC();

        String root = this.getClass().getClassLoader().getResource("").toString().replace("file:/","");

        word2VEC.loadJavaModel(root+"library_javaVector.bin");

        System.out.println(word2VEC.getWordVector("重启"));

    }


}
