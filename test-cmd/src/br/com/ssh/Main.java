package br.com.ssh;

import java.io.IOException;

import com.jscape.inet.ssh.SshException;

public class Main {

	public static void main(String[] args) throws IOException {

		String hostname = "192.168.1.20";
		String username = "vagrant";
		String password = "vagrant";
		
		String[] commands = {"CHKDSK"};
		
		
		JscapeService jscapeService = new JscapeService();
		JscapeHostParams host = new JscapeHostParams(hostname, username, password);
		
		try {
			String[] executeCommands = jscapeService.executeCommands(host , commands);
			System.out.println(executeCommands[0]);
		} catch (SshException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

//		Connection conn = new Connection(hostname);
//		conn.connect();
//		conn.authenticateWithPassword(username, password);
//
//		conn.openSession();
//
//		Session sess = conn.openSession();
//		
//		sess.execCommand("sysctl hw | grep mem");
//
//		InputStream stdout = new StreamGobbler(sess.getStdout());
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
//
//		while (true) {
//			String line = br.readLine();
//			if (line == null)
//				break;
//			System.out.println(line);
//		}
//
//		/* Show exit status, if available (otherwise "null") */
//
//		System.out.println("Saída: " + sess.getExitStatus());

	}

}
