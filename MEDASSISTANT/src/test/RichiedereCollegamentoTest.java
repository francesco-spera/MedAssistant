package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import bean.Account;
import control.gestioneCollegamento.RichiedereCollegamento;

class RichiedereCollegamentoTest {
 
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private RichiedereCollegamento servlet;
	@BeforeEach
 public void setUp() {
	 servlet = new RichiedereCollegamento();
	 request = new MockHttpServletRequest();
	 response = new MockHttpServletResponse();
 }
	@Test
	void test() throws ServletException, IOException {
		Account account = new Account();
		account.setPatient("ciaicjdsn@gmail.com");
		String email = "vincenzofabiano@gmail.com";
		String oggetto = "richiesta collegamento";
		String text = "dhazsxdcfvgbhjkssxdcfvgbhnjmkzsxdcfgvhbnjmkjf";
		request.setParameter("email", email);
		request.setParameter("oggetto", oggetto);
		request.setParameter("text", text);
		request.getSession().setAttribute("pazLog", account);
		assertThrows(IllegalArgumentException.class, () ->{
			servlet.doPost(request, response);
		});
		
	}

}
