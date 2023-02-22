package com.example.crudOperation.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** @createdBy - Ashwini Bhagat **/

@Configuration
public class MyConfigg {

   @Bean
   public ModelMapper modelMapper()
   {
      return new ModelMapper();
   }
}
