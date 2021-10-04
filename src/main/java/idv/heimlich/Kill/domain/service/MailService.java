package idv.heimlich.Kill.domain.service;

import idv.heimlich.Kill.domain.dto.IMailCreateDTO;

public interface MailService {

	String create(IMailCreateDTO mailCreateDTO);

	void send();

}
