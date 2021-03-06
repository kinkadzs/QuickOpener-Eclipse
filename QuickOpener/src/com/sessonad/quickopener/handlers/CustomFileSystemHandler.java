package com.sessonad.quickopener.handlers;

import java.awt.Dimension;
import java.awt.Toolkit;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import com.sessonad.quickopener.dialogues.DialogueFileSystem;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class CustomFileSystemHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public CustomFileSystemHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
			DialogueFileSystem dialogue = new DialogueFileSystem(null,true,window);			
			final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            final int x = (screenSize.width - dialogue.getWidth()) / 2;
            final int y = (screenSize.height - dialogue.getHeight()) / 2;
            dialogue.setLocation(x, y);
            dialogue.setVisible(true); 
	    } catch (Exception ex) {
	       // MessageDialog.openInformation(null,"error", ex.getMessage());
	    }
		return null;
	}
}
