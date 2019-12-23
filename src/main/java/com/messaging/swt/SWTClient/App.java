package com.messaging.swt.SWTClient;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Hello world!
 *
 */
public class App {
	static Display display;
	static Shell shell;
	static Text dogName;
	static Combo dogBreed;
	static Canvas dogPhoto;
	static Image dogImage;
	static List categories;
	static Text ownerName;
	static Text ownerPhone;

	public static void main(String[] args) {
		display = new Display();

		shell = new Shell(display);
		shell.setText("Dog Show Entry");

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 6;
		shell.setLayout(gridLayout);
		
		new Label(shell, SWT.NULL).setText("11111111111");
		new Label(shell, SWT.NULL).setText("22222222222");
		new Label(shell, SWT.NULL).setText("33333333333");
		new Label(shell, SWT.NULL).setText("44444444444");
		new Label(shell, SWT.NULL).setText("55555555555");
		new Label(shell, SWT.NULL).setText("66666666666");
		

		// linha 1
		new Label(shell, SWT.NULL).setText("Dog's Name:");

		dogName = new Text(shell, SWT.SINGLE | SWT.BORDER);
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalSpan = 5;
		dogName.setLayoutData(gridData);

		// linha 2
		new Label(shell, SWT.NULL).setText("Breed:");

		dogBreed = new Combo(shell, SWT.NULL);
		dogBreed.setItems(new String[] { "Collie", "Pitbull", "Poodle", "Scottie" });
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalSpan = 3;
		dogBreed.setLayoutData(gridData);

		Label label = new Label(shell, SWT.NULL);
		label.setText("Categories");
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gridData.horizontalSpan = 2;
		label.setLayoutData(gridData);

		// linha 3
		new Label(shell, SWT.NULL).setText("Photo:");

		dogPhoto = new Canvas(shell, SWT.BORDER);
		gridData = new GridData(GridData.FILL_BOTH);
		gridData.widthHint = 80;
		gridData.heightHint = 80;
		gridData.verticalSpan = 3;
		gridData.horizontalSpan = 3;
		dogPhoto.setLayoutData(gridData);
		dogPhoto.addPaintListener(new PaintListener() {

			public void paintControl(final PaintEvent event) {
				if (dogImage != null) {
					event.gc.drawImage(dogImage, 0, 0);
				}
			}

		});

		categories = new List(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);

		categories.setItems(new String[] {

				"Best of Breed", "Prettiest Female", "Handsomest Male", "Best Dressed", "Fluffiest Ears", "Most Colors",
				"Best Performer", "Loudest Bark", "Best Behaved", "Prettiest Eyes", "Most Hair", "Longest Tail",
				"Cutest Trick" });

		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.verticalSpan = 4;
		gridData.horizontalSpan = 2;

		int listHeight = categories.getItemHeight() * 12;
		Rectangle trim = categories.computeTrim(0, 0, 0, listHeight);

		gridData.heightHint = trim.height;

		categories.setLayoutData(gridData);

		// linha 4
		Button browse = new Button(shell, SWT.PUSH);
		browse.setText("Browse...");

		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalIndent = 5;

		browse.setLayoutData(gridData);

		browse.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				String fileName = new FileDialog(shell).open();
				if (fileName != null) {
					dogImage = new Image(display, fileName);
				}
			}

		});

		// linha 5
		Button delete = new Button(shell, SWT.PUSH);
		delete.setText("Delete");

		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_BEGINNING);
		gridData.horizontalIndent = 5;

		delete.setLayoutData(gridData);
		delete.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {

				if (dogImage != null) {

					dogImage.dispose();
					dogImage = null;

					dogPhoto.redraw();

				}
			}

		});

		// linha 6
		Group ownerInfo = new Group(shell, SWT.NULL);

		ownerInfo.setText("Owner Info");

		gridLayout = new GridLayout();
		gridLayout.numColumns = 4;

		ownerInfo.setLayout(gridLayout);

		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalSpan = 4;

		ownerInfo.setLayoutData(gridData);

		new Label(ownerInfo, SWT.NULL).setText("Name:");

		ownerName = new Text(ownerInfo, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 3;
		ownerName.setLayoutData(gridData);
	
		
		new Label(ownerInfo, SWT.NULL).setText("Phone:");

		ownerPhone = new Text(ownerInfo, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 3;
		ownerPhone.setLayoutData(gridData);

		// linha 7
		label = new Label(shell, SWT.NULL);
		label.setText("");
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 4;
		label.setLayoutData(gridData);

		Button enter = new Button(shell, SWT.PUSH);
		enter.setText("Enter");

		gridData = new GridData(GridData.FILL_HORIZONTAL);

		enter.setLayoutData(gridData);
		enter.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {

				System.out.println("\nDog Name: " + dogName.getText());
				System.out.println("Dog Breed: " + dogBreed.getText());
				System.out.println("Owner Name: " + ownerName.getText());
				System.out.println("Owner Phone: " + ownerPhone.getText());
				System.out.println("Categories:");

				String cats[] = categories.getSelection();

				for (int i = 0; i < cats.length; i++) {

					System.out.println("\t" + cats[i]);

				}

			}

		});

		Button btnClose = new Button(shell, SWT.PUSH);
		btnClose.setText("Close");

		gridData = new GridData(GridData.FILL_HORIZONTAL);

		btnClose.setLayoutData(gridData);
		btnClose.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {

				shell.close();

			}

		});

		shell.pack();

		shell.open();

		while (!shell.isDisposed()) {

			if (!display.readAndDispatch())
				display.sleep();

		}

		if (dogImage != null) {

			dogImage.dispose();

		}
	}
}
