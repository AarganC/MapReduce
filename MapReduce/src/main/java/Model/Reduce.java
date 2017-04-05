/**
 * Created by aargancointepas on 05/12/2016.
 */
package Model;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import java.io.IOException;
import java.util.Iterator;

public class Reduce extends MapReduceBase implements org.apache.hadoop.mapred.Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
        String miles = null;
        int intmiles = 0;
        int counter = 0;
        //Tant qu'il reste des valeurs.
        while (values.hasNext()) {
            miles = values.next().toString();//miles.
            try {
                //Cast du String 'miles' en int 'intmiles'.
                //We cast the String 'miles' to int 'intmiles'.
                intmiles = Integer.parseInt(miles);
            }
            catch(NumberFormatException ex) {
                final int a = 0;
                //On retourne un message d'erreur. We return error message.
                System.err.println("Ilegal input" + a);
            }
            //On ajoute intmiles à counter. We add intmiles to counter.
            counter = counter + intmiles;
        }
        //Ecriture dans le fichier de sortie. Write in the output files.
        output.collect(key,new IntWritable(counter));
    }
}