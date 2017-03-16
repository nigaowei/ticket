package com.biglog.ticket.core.word2Vec.domain;
public class HiddenNeuron extends Neuron{
    
    public double[] syn1 ; //hidden->out
    
    public HiddenNeuron(int layerSize){
        syn1 = new double[layerSize] ;
    }
    
}
