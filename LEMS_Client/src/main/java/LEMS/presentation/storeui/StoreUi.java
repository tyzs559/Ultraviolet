package LEMS.presentation.storeui;

import javax.swing.JPanel;

import java.awt.Rectangle;

import javax.swing.JButton;

import LEMS.presentation.mainUi;
import LEMS.presentation.userui.StoreManagerUi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 章承尧
 * 仓库管理主界面
 */
@SuppressWarnings("serial")
public class StoreUi extends JPanel {

	/**
	 * Create the panel.
	 */
	public StoreUi() {
		setBounds(new Rectangle(0, 0, 1024, 768));
		setLayout(null);
		
		JButton button = new JButton("返回");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StoreManagerUi store=new StoreManagerUi();
				mainUi.frame.setContentPane(store);
			}
		});
		button.setBounds(884, 691, 125, 62);
		add(button);

	}

}
