package org.sample.controller.service;


import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.pojos.TeamForm;
import org.sample.model.User;

public interface SampleService {

    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException;
    public TeamForm saveFrom(TeamForm teamForm);
    public SignupForm getTeams();
	public User getUser(long userId) throws InvalidUserException;

}
