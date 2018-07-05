package kr.co.sincweb.user.model.vo;

/***
 *
 * 
 CREATE TABLE SINC_USER_TBL(
 	USERID    VARCHAR2(50) PRIMARY KEY,
 	USERPW    VARCHAR2(50) NOT NULL,
 	USERNAME  VARCHAR2(50) NOT NULL,
 	USERPOINT NUMBER DEFAULT 0
 )
 
 INSERT INTO SINC_USER_TBL (USERID, USERPW ,USERNAME) VALUES ('user00','user00','hulk');
 *
 *
 */

public class UserVO {

	private String userid, userpw, username;
	private int userpoint;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserpoint() {
		return userpoint;
	}
	public void setUserpoint(int userpoint) {
		this.userpoint = userpoint;
	}
	
}
