package br.com.ssh;

import java.io.IOException;
import java.io.InputStream;

import com.jscape.inet.scp.Scp;
import com.jscape.inet.ssh.SshException;
import com.jscape.inet.ssh.SshSession;
import com.jscape.inet.ssh.util.SshParameters;

/**
 * 
 * @author Thiago Guimarães
 * @email thiagobrg98@gmail.com
 * @date 05/04/2022
 */
public class JscapeService {
	
	/**
	 * 
	 * Faz o envio de um arquivo para o Host e Destino escolhido.
	 * 
	 * @param host
	 * @param file
	 * @param destination
	 * @throws IOException
	 */
	public void uploadFile(JscapeHostParams host, InputStream file, String destination, String fileName) throws IOException {
		
		SshParameters params = new SshParameters(host.getIp(), host.getUsername(), host.getPassword());
		
		// create new Scp instance
		Scp scp = new Scp(params);
		
		// establish connection (and disconnect, below)
		scp.connect();
		
		// UPLOAD. The first argument is a File, the second is a Destination folder third fileName.
		scp.upload(file, destination, fileName);
		
		// Disconnect (exit)
		scp.disconnect();
		
		// Close SCP
		scp.close();
	}
	
	/**
	 * Executa os comandos passados.
	 * 
	 * O retorna é um array que contem as respostas de cada comando na mesma posição que o comando foi passado no parametro.
	 * 
	 * @param host
	 * @param comands
	 * @return
	 * @throws SshException
	 */
	public String[] executeCommands(JscapeHostParams host, String[] comands) throws SshException {
		
		SshParameters sshParameters = new SshParameters(host.getIp(), host.getUsername(), host.getPassword());
		
		//criação da sessão SSH
		SshSession session = new SshSession(sshParameters);
		
		// timeout em 5 minutos, caso não haja nenhum output do host alvo
		session.getSsh().setReadTimeout(5L * 60L * 100000L);
		
		//define o caracter que determina o fim de um comando
		session.setCommandTerminator("\r");

		//configuracoes de prompt do terminal
		session.setShellPrompt("\\$|#|>", true);
	
		// TIMEOUT de 10 segundos para a tentativa de conexão
		session.connect(10 * 100000);
		
		String[] resultCommands = new String[comands.length];
		
		for (int i = 0; i < comands.length; i++) {
			resultCommands[i] = session.send(comands[i]);
		}
		
		// Desconecta o SSH (exit)
		session.disconnect();
		
		return resultCommands;
		
	}
}
