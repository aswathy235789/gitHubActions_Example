package com.bharath.dating;

import com.bharath.dating.controllers.UserAccountController;
import com.bharath.dating.entities.Interest;
import com.bharath.dating.entities.UserAccount;
import com.bharath.dating.repos.InterestRepository;
import com.bharath.dating.repos.UserAccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class DatingapiApplicationTests {
	@Mock
	UserAccountRepository userAccountRepository;

	@InjectMocks
	UserAccountController controller;
    @Mock
	InterestRepository interestRepository;

//	private UserAccountRepository userAccountRepository = mock(UserAccountRepository.class);
//	private UserAccountController controller = new UserAccountController(userAccountRepository);
	@Test
	public void testRegisterUser()
	{   UserAccount userAccount=new UserAccount();
		UserAccount savedUserAccount=new UserAccount();
		when(userAccountRepository.save(userAccount)).thenReturn(savedUserAccount);
		savedUserAccount.setId(123);
        UserAccount outputUserAccount=controller.registerUser(userAccount);
		Assertions.assertNotNull(outputUserAccount);
		Assertions.assertNotNull(outputUserAccount.getId());
		Assertions.assertEquals(123,outputUserAccount.getId());
		verify(userAccountRepository).save(userAccount);

	}
	@Test
	public void testupdateInterest()
	{
		Interest interest=new Interest();
		interest.setUserAccountId(123);
		when(userAccountRepository.findById(123)).thenReturn(Optional.of(new UserAccount()));
		Interest savedInterest=new Interest();
		when(interestRepository.save(interest)).thenReturn(savedInterest);

		Interest op = controller.updateInterest(interest);
		Assertions.assertNotNull(op);
		Assertions.assertNotNull(op.getId());
		//Assertions.assertEquals(123,op.getId());
		verify(userAccountRepository).findById(123);
		verify(interestRepository).save(interest);


	}
	@Test
	void testDelete()
	{
		doNothing().when(interestRepository).deleteById(123);
		controller.deleteInterest(123);
		verify(interestRepository).deleteById(123);

	}
	@Test
	void testgetAllUsers()
	{

		ArrayList<UserAccount> allusers=new ArrayList<UserAccount>();
		allusers.add(new UserAccount());
		allusers.add(new UserAccount());

		when(userAccountRepository.findAll()).thenReturn(allusers);
		List<UserAccount> outputUsers=controller.getUsers();

		Assertions.assertNotNull(outputUsers);
		Assertions.assertEquals(2,outputUsers.size());
		verify(userAccountRepository).findAll();

	}




}
