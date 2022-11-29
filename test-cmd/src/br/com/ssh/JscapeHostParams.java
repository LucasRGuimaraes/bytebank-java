package br.com.ssh;

/**
 * 
 * @author Thiago Guimarães
 * @email thiagobrg98@gmail.com
 * @date 05/04/2022
 */
public class JscapeHostParams {
	
	private String ip;
	private String username;
	private String password;
	
	public JscapeHostParams(String ip, String username, String password) {
		this.ip = ip;
		this.username = username;
		this.password = password;
	}
	
	public String getIp() {
		return ip;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
}
