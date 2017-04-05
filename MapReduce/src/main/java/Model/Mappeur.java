/**
 * Created by aargancointepas on 05/12/2016.
 */
package Model;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

import java.io.*;
import java.util.StringTokenizer;

public class Mappeur extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {


    @Override
    public void map(LongWritable longWritable, Text value, OutputCollector<Text, IntWritable> outputCollector, Reporter reporter) throws IOException  {

        String word = value.toString();
        //itr. est un jeton avec une valeur qui nous permet de naviguer sur la ligne.
        //itr. is a token with a value why allow to navigate on the row.
        StringTokenizer itr = new StringTokenizer(word, ", ");
        //Enregistrement de la 1er valeur dans id_driver.
        //Record the first value in id_driver.
        final String id_driver = itr.nextToken();
        //On passe la 2ème valeur sans l'enregistrer.
        //We skip the 2nd value without saving it.
        itr.nextToken(); // hour
        //On passe sur la 3ème valeur sans l'enregistrer.
        //We skip the 3rd value without saving it.
        itr.nextToken(); // week
        //On passe à la 4ème valeur en l'enregistrent dans miles.
        //We move to the 4th value and save it in miles.
        final String miles = itr.nextToken();
        //On cast le String 'miles' en int 'intmiles'
        //We cast the String 'miles' to int 'intmiles'.
        try {
            final int intmiles = Integer.parseInt(miles);
            //Valeur retourner. Value return.
            outputCollector.collect(new Text(id_driver), new IntWritable(intmiles));
        }
        catch(NumberFormatException ex) {
            final int intmiles = 0;
            //On retourne un message d'erreur. We return error message.
            System.err.println("Ilegal input" + intmiles);
        }
        //En sortie du map on a id_driver et intmiles.
        //remplacement de intmiles par new IntWritable(intmiles)

    }
}

