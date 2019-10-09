package projeto.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class SystemController  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String tmpMessage = "";
	
	public static void limparCacheMensagem() { tmpMessage = ""; }

	public static String getTmpMessage() {
		return tmpMessage;
	}

	public static void setTmpMessage(String tmpMessage) {
		SystemController.tmpMessage = tmpMessage;
	}
	
}
