package com.ice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ice.domain.Stock;
import com.ice.repository.StockRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.*;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by Chaitanya on 12/9/16.
 */
//@RunWith(SpringRunner.class)
@Ignore
//@SpringBootTest
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class StockControllerTests {

    @Autowired
    private StockRepository stockRepository;

    //Test RestTemplate to invoke the APIs.
    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Value("${local.server.port}")
    int port;

    @Ignore
    public void testAllApis() throws JsonProcessingException {
        //Building the Request body data
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("GOOGL", "Alphabet, Inc.", null, null, null));
        stocks.add(new Stock("GS", "Goldman Sachs Group Inc", null, new Long(10), null));
        stocks.add(new Stock("JPM", "JPMORGAN CHASE &CO", null, null, null));
        stocks.add(new Stock("INTC", "Intel Corporation", null, new Long(4), null));
        stocks.add(new Stock("AAPL", "Apple Inc.", null, new Long(22), null));
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        //Creating http entity object with request body and headers
        HttpEntity<String> httpEntity =
                new HttpEntity<>(gson.toJson(stocks), requestHeaders);

        //Invoking the API
        Map<String, Object> apiResponse =
                restTemplate.postForObject("http://localhost:"+port+"/user/save", httpEntity, Map.class, Collections.EMPTY_MAP);

        assertNotNull(apiResponse);

    }
}
