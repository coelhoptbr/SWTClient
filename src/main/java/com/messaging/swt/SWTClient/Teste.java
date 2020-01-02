package com.messaging.swt.SWTClient;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;

public class Teste {

	protected Shell shlCreateAJms;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Composite composite;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Teste window = new Teste();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlCreateAJms.open();
		shlCreateAJms.layout();
		while (!shlCreateAJms.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCreateAJms = new Shell();
		shlCreateAJms.setSize(658, 483);
		shlCreateAJms.setText("Create a JMS Message");
		
		Label lblUser = new Label(shlCreateAJms, SWT.NONE);
		lblUser.setBounds(10, 10, 70, 20);
		lblUser.setText("User");
		
		text = new Text(shlCreateAJms, SWT.BORDER);
		text.setBounds(10, 36, 155, 26);
		
		Label lblSubject = new Label(shlCreateAJms, SWT.NONE);
		lblSubject.setBounds(10, 85, 70, 20);
		lblSubject.setText("Subject");
		
		text_1 = new Text(shlCreateAJms, SWT.BORDER | SWT.V_SCROLL);
		text_1.setBounds(10, 111, 620, 26);
		
		Label lblLocation = new Label(shlCreateAJms, SWT.NONE);
		lblLocation.setBounds(171, 10, 70, 20);
		lblLocation.setText("Location");
		
		text_2 = new Text(shlCreateAJms, SWT.BORDER);
		text_2.setBounds(171, 36, 155, 26);
		
		Label lblMessage = new Label(shlCreateAJms, SWT.NONE);
		lblMessage.setBounds(10, 157, 70, 20);
		lblMessage.setText("Message");
		
		composite = new Composite(shlCreateAJms, SWT.NONE);
		composite.setBounds(10, 186, 620, 198);
		
		text_3 = new Text(composite, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		text_3.setBounds(0, 0, 620, 198);
		
		Button btnSair = new Button(shlCreateAJms, SWT.NONE);
		btnSair.setBounds(540, 400, 90, 30);
		btnSair.setText("Exit");
		
		Button btnEnviar = new Button(shlCreateAJms, SWT.NONE);
		btnEnviar.setBounds(349, 400, 90, 30);
		btnEnviar.setText("Send");
		
		Button btnLimpar = new Button(shlCreateAJms, SWT.NONE);
		btnLimpar.setBounds(445, 400, 90, 30);
		btnLimpar.setText("Clear");

	}
}
