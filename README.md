# kafka-application 
# Project implemented to Kafka studies
# Kafka runing with local instance

Iniciando servidor zookeeper:
Zookeeper-server-start c:\kafka\config\zookeeper.properties

Iniciando Servidor Kafka:
kafka-server-start c:\kafka\config\server.properties

Comandos:
kafka-topics.bat --bootstrap-server localhost:9092 --list
Kafka-topics --bootstrap-server lokalhost:9092 --topic teste --describe

Alterar partições em um tópico:
Kafka-topics --bootstrap-server lokalhost:9092 --alter --topic teste --partitions 10

Deletar Topico:
Kafka-topics --bootstrap-server lokalhost:9092 --delete --topic teste 

Criação de topicos com partições:
kafka-topics.bat --bootstrap-server localhost:9092 --create --topic name --partitions

Criação de topicos:
kafka-topics.bat --bootstrap-server localhost:9092 --create --topic name 

Run Producer:
kafka-console-producer.bat --broker-list localhost:9092 --topic teste

Com chave e valor:
kafka-console-producer --broker-list localhost:9092 --topic teste --property "parse.key=true" --property "key.separator=,"

Run Consumer:
kafka-console-consumer --bootstrap-server localhost:9092 --topic teste --from-beginning

Com chave e valor:
kafka-console-consumer --bootstrap-server localhost:9092 --topic teste --property "print.key=true" --property "key.separator=,"
