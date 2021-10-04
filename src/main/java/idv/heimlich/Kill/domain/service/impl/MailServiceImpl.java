package idv.heimlich.Kill.domain.service.impl;

import org.apache.commons.lang.StringUtils;

import idv.heimlich.Kill.domain.dao.MailqueDAO;
import idv.heimlich.Kill.domain.dao.impl.MailqueDAOImpl;
import idv.heimlich.Kill.domain.dto.IMailCreateDTO;
import idv.heimlich.Kill.domain.dto.impl.MailCreateDTO;
import idv.heimlich.Kill.domain.service.GetNumberService;
import idv.heimlich.Kill.domain.service.MailService;

/**
 * 信件服務
 */
public class MailServiceImpl implements MailService {

//	final static CommonLogger logger = MyLoggerFactory.getLogger(Mylogs.clMailService);

	private transient GetNumberService getNumberService = GetNumberServiceImpl.get();

	private transient MailqueDAO mailqueDAO = MailqueDAOImpl.INSTANCE;

	private static MailService INSTANCT = new MailServiceImpl();

	public static MailService get() {
		return INSTANCT;
	}

	@Override
	public String create(final IMailCreateDTO mailCreateDTO) {
//		final DoXdaoSession doXdaoSession = XdaoSessionManager.getDoXdaoSession();
//		final String id = this.getNumberService.getCount(GetNumberType.YYYYMMDD12N);
//		final MailquePo mailquePo = new MailquePo();
//		mailquePo.setMailId(id);
//		mailquePo.setCreateDate(YYYYMMDDHHMMSSUtils.getText());
//		mailquePo.setFilePath(mailCreateDTO.getFilePath());
//		mailquePo.setMailBcc(mailCreateDTO.getMailBcc());
//		mailquePo.setMailCc(mailCreateDTO.getMailCc());
//		mailquePo.setMailFrom(mailCreateDTO.getMailFrom());
//		mailquePo.setMailTo(mailCreateDTO.getMailTo());
//		mailquePo.setMessage(this.getMessage(mailCreateDTO));
//		mailquePo.setPgmId(mailCreateDTO.getPgmId());
//		mailquePo.setRemarks(mailCreateDTO.getRemarks());
//		mailquePo.setSendDate(null);
//		mailquePo.setSubject(mailCreateDTO.getSubject());
//		mailquePo.setStatus(MailqueStatus.W.name());
//		this.mailqueDAO.insert(doXdaoSession, mailquePo);
//		return id;
		return null;
	}

	private String getMessage(final MailCreateDTO mailCreateDTO) {
		return StringUtils.substring(mailCreateDTO.getMessage(), 0, 2500);
	}

	@Override
	public void send() {
//		final DoXdaoSession doXdaoSession = XdaoSessionManager.getDoXdaoSession();
//		final List<MailquePo> mails = this.mailqueDAO.queryMails(doXdaoSession);
//		logger.info("mail size:" + mails.size());
//		for (final MailquePo mailquePo : mails) {
//			logger.info("send mail subject:" + mailquePo.getSubject());
//			final MailFace face = MailqueWarpPo.newMailFace(mailquePo);
//			final MailBean mailBean = new MailBean(face);
//			try {
//				mailBean.sendMail();
//				this.mailqueDAO.update(doXdaoSession, mailquePo.getMailId(), MailqueStatus.C);
//			} catch (MessagingException | UnsupportedEncodingException e) {
//				logger.info("sendamil error mail context:" + ToStringBuilder.reflectionToString(mailquePo));
//				if (mailquePo.getStatus().equals(MailqueStatus.R.name())) {
//					this.mailqueDAO.update(doXdaoSession, mailquePo.getMailId(), MailqueStatus.E);
//				} else {
//					this.mailqueDAO.update(doXdaoSession, mailquePo.getMailId(), MailqueStatus.R);
//				}
//			}
//		}
	}

}
