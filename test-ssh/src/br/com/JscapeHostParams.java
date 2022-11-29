package br.com;

/**
 * 
 * @author Thiago Guimarães
 * @email thiagobrg98@gmail.com
 * @date 05/04/2022
 */
public class JscapeHostParams {

	private String ip;
	private Integer port;
	private String username;
	private String password;

	public JscapeHostParams(String ip, Integer port, String username, String password) {
		this.ip = ip;
		this.port = port;
		this.username = username;
		this.password = password;
	}

	public String getIp() {
		return ip;
	}

	public Integer getPort() {
		return port;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
