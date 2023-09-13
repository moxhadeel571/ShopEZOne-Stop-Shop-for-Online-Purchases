package com.example.ecommerce.ecommerce.razorpay;

import io.dropwizard.Configuration;
@org.springframework.context.annotation.Configuration

public class AppConfiguration extends Configuration {

  private String apiKey;

  private String secretKey;

  public String getApiKey() {
    return "rzp_test_BGPTgqrkVagzn6";
  }

  public String getSecretKey() {
    return "l48xX7CnwytQmBn5twVyiavo";
  }

}
