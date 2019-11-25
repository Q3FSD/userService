package com.mentorondemand.userservice.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.userservice.entities.Users;
import com.mentorondemand.userservice.services.MentorCalendarRepository;
import com.mentorondemand.userservice.services.UserRepository;

@RestController
@RequestMapping(path = "/v1/mc")
public class MentorCalendarController {
	@Autowired // This means to get the bean called mentorCalendarRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private MentorCalendarRepository mentorCalendarRepository;
	@Autowired
	private UserRepository userRepository;

	@PostMapping(path = "/add")
	public @ResponseBody String addMentorCalendar(@RequestParam String userName, @RequestParam String startDate,
			@RequestParam String endDate) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		try {
			mentorCalendarRepository.add(userName, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(startDate),
					new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(endDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Added";
	}

	@DeleteMapping(path = "/remove/{userName}/{startDate}/{endDate}")
	public @ResponseBody Object removeMentorCalendar(@PathVariable(value = "userName") String userName,
			@PathVariable(value = "startDate") String startDate, @PathVariable(value = "endDate") String endDate) {
		try {
			mentorCalendarRepository.delete(userName, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(startDate),
					new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(endDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Removed";
	}

	@GetMapping(path = "/all/{userName}")
	public @ResponseBody Object getMentorCalendar(@PathVariable(value = "userName") String userName) {
		Optional<Users> optional = userRepository.findByUserName(userName);
		HashMap<String, Boolean> map = new HashMap<>();

		if (optional.isPresent()) {
			Users user = optional.get();
			// This returns a JSON or XML with the users
			return mentorCalendarRepository.findAllByUser(user);
		} else {
			// user not exist
			map.put("userExist", false);
			return map;
		}
	}
}
