package com.messaging.swt.SWTClient;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MessageSender extends Composite {

	public MessageSender(Composite parent, int style) {
		super(parent, style);
	}

	static Display display;
	static Shell shell;
	static Text local;
	static Text subject;
	static Text message;
	static Composite composite;

	public static void main(String[] args) {
		display = new Display();

		shell = new Shell(display);
		shell.setText("Enviar mensagem");

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		shell.setLayout(gridLayout);

		GridData gridDataLbl = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gridDataLbl.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;

		Label lbl = new Label(shell, SWT.NULL);
		lbl.setText("Localização: ");
		lbl.setLayoutData(gridDataLbl);
		local = new Text(shell, SWT.SINGLE | SWT.BORDER);
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalSpan = 2;
		local.setLayoutData(gridData);

		lbl = new Label(shell, SWT.NULL);
		lbl.setText("Assunto: ");
		lbl.setLayoutData(gridDataLbl);
		subject = new Text(shell, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalSpan = 2;
		subject.setLayoutData(gridData);

		lbl = new Label(shell, SWT.NULL);
		lbl.setText("Mensagem: ");
		lbl.setLayoutData(gridDataLbl);
		message = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		gridData = new GridData(GridData.FILL_BOTH);
		gridData.horizontalSpan = 2;
		message.setLayoutData(gridData);

		
		


		Button enviar = new Button(shell, SWT.PUSH);
		enviar.setText("Enviar");
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_END);
		enviar.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				MessageDTO mes = new MessageDTO(message.getText(), 1, local.getText(), subject.getText(), null);
				shell.setCursor(new Cursor(display, SWT.CURSOR_WAIT));
				Response res = Util.getInvocationBuilder().post(Entity.entity(mes, MediaType.APPLICATION_JSON));
				shell.setCursor(new Cursor(display, SWT.CURSOR_ARROW));
				
				if (res.getStatus() == 201) {

					int style = SWT.ICON_INFORMATION | SWT.OK;
					MessageBox dia = new MessageBox(shell, style);
					dia.setText("Sucesso");
					dia.setMessage("Mensagem enviada.");
					dia.open();

					local.setText("");
					subject.setText("");
					message.setText("");
				} else {
					int style = SWT.ICON_INFORMATION | SWT.ERROR;
					MessageBox dia = new MessageBox(shell, style);
					dia.setText("Erro");
					dia.setMessage("Não foi possível enviar a mensagem.");
					dia.open();
				}
			}
		});
		
		Button limpar = new Button(shell, SWT.PUSH);
		limpar.setText("Limpar");
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_END);
		limpar.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				local.setText("");
				subject.setText("");
				message.setText("");
			}
		});
		
		Button fechar = new Button(shell, SWT.PUSH);
		fechar.setText("Fechar");
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_END);
		fechar.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				shell.close();
			}
		});

		/*
		 * Button enviar = new Button(shell, SWT.PUSH); enviar.setText("Enviar");
		 * gridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		 * enviar.setLayoutData(gridData); enviar.addSelectionListener(new
		 * SelectionAdapter() { public void widgetSelected(SelectionEvent event) {
		 * 
		 * MessageDTO mes = new MessageDTO(message.getText(), 1, local.getText(),
		 * subject.getText(), null); Response res =
		 * Util.getInvocationBuilder().post(Entity.entity(mes,
		 * MediaType.APPLICATION_JSON));
		 * 
		 * if (res.getStatus() == 201) {
		 * 
		 * int style = SWT.ICON_INFORMATION | SWT.OK; MessageBox dia = new
		 * MessageBox(shell, style); dia.setText("Sucesso");
		 * dia.setMessage("Mensagem enviada."); dia.open();
		 * 
		 * local.setText(""); subject.setText(""); message.setText(""); } else { int
		 * style = SWT.ICON_INFORMATION | SWT.ERROR; MessageBox dia = new
		 * MessageBox(shell, style); dia.setText("Erro");
		 * dia.setMessage("Não foi possível enviar a mensagem."); dia.open(); } } });
		 * 
		 * Button limpar = new Button(shell, SWT.PUSH); limpar.setText("Limpar");
		 * gridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		 * limpar.setLayoutData(gridData); limpar.addSelectionListener(new
		 * SelectionAdapter() { public void widgetSelected(SelectionEvent event) {
		 * local.setText(""); subject.setText(""); message.setText(""); } });
		 * 
		 * Button fechar = new Button(shell, SWT.PUSH); fechar.setText("Fechar");
		 * gridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		 * fechar.setLayoutData(gridData); fechar.addSelectionListener(new
		 * SelectionAdapter() { public void widgetSelected(SelectionEvent event) {
		 * shell.close(); } });
		 */

		shell.pack();
		shell.setSize(500, 500);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
}
