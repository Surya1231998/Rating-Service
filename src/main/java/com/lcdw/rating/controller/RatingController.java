package com.lcdw.rating.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcdw.rating.entities.Rating;
import com.lcdw.rating.service.RatingService;


@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
	{
	     String ratingId = UUID.randomUUID().toString();
	     rating.setRatingId(ratingId);
	     return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
		     
	}
	
	//getAllRating
	
	@GetMapping
	public ResponseEntity<List<Rating>>getAllRating()
	{
		return ResponseEntity.ok(ratingService.getAllRating());
		
	}
	
	//getAllRating by UserId
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<Rating> >getByUserId(@PathVariable String userId)
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(userId));
	}
	
	//getAllRating by HotelId
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<List<Rating> >getByHotelId(@PathVariable String hotelId)
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(hotelId));
	}
	
	
	 
	
	

}
