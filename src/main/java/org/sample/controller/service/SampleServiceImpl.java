package org.sample.controller.service;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.pojos.TeamForm;
import org.sample.model.Address;
import org.sample.model.Team;
import org.sample.model.User;
import org.sample.model.dao.AddressDao;
import org.sample.model.dao.TeamDao;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;





import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;


@Service
public class SampleServiceImpl implements SampleService {

    @Autowired    UserDao userDao;
    @Autowired    AddressDao addDao;
    @Autowired	  TeamDao teamDao;
    
    @Transactional
    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException{

        String firstName = signupForm.getFirstName();

        if(!StringUtils.isEmpty(firstName) && "ESE".equalsIgnoreCase(firstName)) {
            throw new InvalidUserException("Sorry, ESE is not a valid name");   // throw exception
        }


        Address address = new Address();
        address.setStreet("TestStreet-foo");
        
        User user = new User();
        user.setFirstName(signupForm.getFirstName());
        user.setEmail(signupForm.getEmail());
        user.setLastName(signupForm.getLastName());
        user.setAddress(address);
        
        user.setTeam(teamDao.findOne(signupForm.getTeamId()));
        
        user = userDao.save(user);   // save object to DB
        
        
       
        
        // Iterable<Address> addresses = addDao.findAll();  // find all 
        // Address anAddress = addDao.findOne((long)3); // find by ID
        
        
        signupForm.setId(user.getId());
        

        return signupForm;

    }
    
    @Transactional
    public TeamForm saveFrom(TeamForm teamForm){
    	String teamName = teamForm.getTeamName();
    	
    	Team team = new Team();
    	team.setTeamName(teamName);
    	team.setTimestamp(getTimestamp());
    	
    	team = teamDao.save(team);
    	
    	teamForm.setId(team.getId());
    	teamForm.setTimestamp(team.getTimestamp());
    	
    	return teamForm;
    }
    
    private java.sql.Timestamp getTimestamp(){
    	java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    	return currentTimestamp;
    	
    }

    @Transactional
	public SignupForm getTeams() {
		SignupForm signupForm = new SignupForm();
		List<Team> teams = constructList(teamDao.findAll());
		signupForm.setPossibleTeams(teams);
		return signupForm;
	}
	
	private List<Team> constructList(Iterable<Team> teams) {
		List< Team> list = new ArrayList<Team>();
        for (Team team: teams) {
            list.add(team);
        }
        return list;
    }

	@Transactional
	public User getUser(long userId) throws InvalidUserException {
		if(!userDao.exists(userId)){
			throw new InvalidUserException("Sorry, this userId is does not exist.");   // throw exception
        }
		
		User user = userDao.findOne(userId);
		
		
		return user;
	}
}
