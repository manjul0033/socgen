package com.skillenza.parkinglotjava;

import org.springframework.http.MediaType;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.skillenza.parkinglotjava.ParkingLot;
import com.skillenza.parkinglotjava.ParkingLotController;

@RunWith(SpringRunner.class)
//@WebMvcTest(ParkingLotController.class)
@SpringBootTest
public class ParkinglotjavaApplicationTests {
	
	@MockBean
	private ParkingLotController repo;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getDataTest() throws Exception {
		ParkingLot lot = new ParkingLot("100", "101", "2019-01-01", "30", "mh 03 af 2354", "A101", "2019-08-20");
		
		List<ParkingLot> list = new ArrayList<ParkingLot>();
		list.add(lot);
		
		Mockito.when(repo.getRepoData()).thenReturn(list);
		
		RequestBuilder builder = MockMvcRequestBuilders.get("/api/parkings");
		
		MvcResult result = mockMvc.perform(builder).andReturn();
		
		String expected = "{}";
		System.out.println(result.getResponse().getContentAsString());
		JSONAssert.assertNotEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void posDataTest() throws Exception {
		ParkingLot lot = new ParkingLot("100", "101", "2019-01-01", "30", "mh 03 af 2354", "A101", "2019-08-20");
		
		Mockito.when(repo.saveDate(Mockito.any(ParkingLot.class))).thenReturn(lot);
		
		RequestBuilder builder = MockMvcRequestBuilders.post("/api/parkings").accept(MediaType.APPLICATION_JSON)
									.content(lot.toString()).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(builder).andReturn();
		
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}
}
