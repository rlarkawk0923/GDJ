package service;

import domain.ContactDTO;

public interface ContactService { // 인터페이스 특 : 본문없음
	
	public void addContact(ContactDTO contact);//ContactDTO contact추가할 정보 가진것
	public void modifyContact(ContactDTO contact);
	public void deleteContact(int contact_no); // int contact_no 삭제할 정보 가짐
	public void findContactByNo(int contact_no);
	public void findAllContacts();// 매개변수 전달 필요없음

}
