package dynamodb.com.example.Dyname.db.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "dynamodb.com.example.Dyname.db.repository")
public class DynamoDBConfig {

  @Value("dynamodb.eu-north-1.amazonaws.com")
  private String endpoint;
  @Value("${amazon.aws.accesskey}")
  private String accessKey;

  @Value("${amazon.aws.secretkey}")
  private String secretKey;

  @Value("${amazon.aws.region}")
  private String region;

  @Bean
  public AmazonDynamoDB amazonDynamoDB() {
    return AmazonDynamoDBAsyncClientBuilder
        .standard()
        .withEndpointConfiguration(
            new EndpointConfiguration(endpoint,region)
        )
        .withCredentials( new AWSStaticCredentialsProvider(
            new BasicAWSCredentials(accessKey,secretKey)))
        .build();

  }
}
