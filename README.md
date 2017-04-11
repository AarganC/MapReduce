# MapReduce
Count miles by ID.

# Package
> MapReduce: mvn clean 
> MapReduce: mvn package

# Charger le jar/Upload the jar
Après le mvn package, un package est créé dans le dossier target.
After the mvn package one package will be created in the target directory.
- MapReduce-1.0-SNAPSHOT.jar
Envoyé le jar dans HDFS.
Send the jar in HDFS
> MapReduce: scp target/MapReduce-1.0-SNAPSHOT.jar root@_hostname_:/root/
> [root@VMName ~]$ cp MapReduce-1.0-SNAPSHOT.jar /hom/hdfs
> [hdfs@VMName ~]$ hdfs dfs -copyFromLocal MapReduce-1.0-SNAPSHOT.jar /path_hdfs

# Lancé le Jar/Run the Jar
> [hdfs@VMName ~]$ hadoop jar MapReduce-1.0-SNAPSHOT.jar timesheet.csv output
