import com.microsoft.azure.cosmosdb.spark.schema._
import com.microsoft.azure.cosmosdb.spark._
import com.microsoft.azure.cosmosdb.spark.config.Config
import org.codehaus.jackson.map.ObjectMapper
import com.microsoft.azure.cosmosdb.spark.streaming.CosmosDBSourceProvider

import org.apache.spark.sql.SparkSession


object Main {
  val spark = SparkSession
    .builder
    .appName("StructuredNetworkWordCount")
    .getOrCreate()

  val configMap = Map (
    "Endpoint" -> "COSMOSDB ENDPOINT",
    "Masterkey" -> "COSMOSDB MASTER KEY",
    "Database" -> "DATABASE NAME",
    "collection" -> "COLLECTION NAME",
    "ChangeFeedCheckpointLocation" -> "checkpointlocation",
    "changefeedqueryname" -> "Structured Stream interval count")

  def main(args: Array[String]): Unit = {
    print("Start reading data from ocpp as stream")
    var ocpp_streamData = spark.readStream.format(classOf[com.microsoft.azure.cosmosdb.spark.streaming.CosmosDBSourceProvider].getName).options(configMap).load()
  }

}