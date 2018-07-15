package com.moneytap.bitcoinwatcher.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.moneytap.bitcoinwatcher.dto.BitCoinResponseMatcher;
import com.moneytap.bitcoinwatcher.util.BitCoinWatcherConstants;

@Service
public class BitCoinDetailServiceImpl implements BitCoinDetailService {

	@Autowired
	Environment env;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public ResponseEntity<?> saveRecord(){
		log.info("save Record()");
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
		RestTemplate restTemplate=new RestTemplate(requestFactory);
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
        //Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        // Note: here we are making this converter to process any kind of response, 
       // not only application/*json, which is the default behaviour
       converter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));         
       messageConverters.add(converter);  
       restTemplate.setMessageConverters(messageConverters);  
		return restTemplate.getForEntity(env.getProperty(BitCoinWatcherConstants.BITCOIN_DATA_RECOURCE_URL), BitCoinResponseMatcher.class);
		
	}
}
