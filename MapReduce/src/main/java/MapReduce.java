/**
 * Created by aargancointepas on 03/01/2017.
 */

import Model.Mappeur;
import Model.Reduce;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class MapReduce {
    public static void main(String[] args) throws Exception {
        //Configuration du projet. Setup of the project.
        JobConf conf = new JobConf(MapReduce.class);
        //Affiche le chemin du fichier d'entrée. Display the path input files.
        System.out.println("args[0]" + args[0]);
        //Affiche le chemin du fichier de sortie. Display the path output files.
        System.out.println("args[1]" + args[1]);

        //Nom du Job. Name Job.
        conf.setJobName("MapReduce");

        //Types des données traiter par les classes. Types of data to process by classes.
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);

        //Conf du Mapper, Combiner et Reducer.
        conf.setMapperClass(Mappeur.class);
        conf.setCombinerClass(Reduce.class);
        conf.setReducerClass(Reduce.class);

        //Types de fichier en entrée et sortie. Types of files in input and output.
        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        //Chemin du fichier d'entrée. Path of the input files.
        FileInputFormat.addInputPath(conf, new Path(args[0]));
        //Chemin du fichier de sortie. Path of the output files.
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));

        //Lancement du Job. Run Job.
        JobClient.runJob(conf);


    }
}