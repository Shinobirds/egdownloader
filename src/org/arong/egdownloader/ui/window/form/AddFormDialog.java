package org.arong.egdownloader.ui.window.form;

import java.awt.Color;
import java.awt.Window;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.arong.egdownloader.ui.ComponentConst;
import org.arong.egdownloader.ui.ComponentUtil;
import org.arong.egdownloader.ui.listener.OperaBtnMouseListener;
import org.arong.egdownloader.ui.swing.AJButton;
import org.arong.egdownloader.ui.swing.AJLabel;
import org.arong.egdownloader.ui.swing.AJTextField;
import org.arong.egdownloader.ui.work.interfaces.IListenerTask;
/**
 * 新建下载任务窗口
 * @author 阿荣
 * @since 2013-05-21
 *
 */
public class AddFormDialog extends JDialog {

	private static final long serialVersionUID = 6680144418171641216L;
	
	private JLabel urlLabel;
	private JTextField urlField;
	private JLabel saveDirLabel;
	private JTextField saveDirField;
	private JButton chooserBtn;
	private JButton addTaskBtn;
	private JLabel tipLabel;
	private JFileChooser saveDirChooser;
	
	public AddFormDialog(final JFrame mainWindow){
		this.setTitle("新建任务");
		this.setIconImage(new ImageIcon(getClass().getResource(ComponentConst.ICON_PATH + "add.gif")).getImage());
		this.setSize(480, 210);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(mainWindow);
		
		tipLabel = new AJLabel("提示：保存目录不用填写具体文件夹名，下载器会自动生成", Color.LIGHT_GRAY, 80, 5, this.getWidth() - 80, 30);
		
		urlLabel = new AJLabel("下载地址", Color.BLUE, 5, 40, 60, 30);
		urlField = new AJTextField("urlField", 65, 40, 395, 30);
		saveDirLabel = new AJLabel("保存目录", Color.BLUE, 5, 80, 60, 30);
		saveDirField = new AJTextField("saveDirField", 65, 80, 320, 30);
		chooserBtn = new AJButton("浏览", "chooserBtn", "eye.png", new OperaBtnMouseListener(this, new IListenerTask() {
			public void doWork(Window addFormDialog) {
				AddFormDialog this_ = (AddFormDialog)addFormDialog;
				int result = this_.saveDirChooser.showOpenDialog(this_);
				File file = null;  
                if(result == JFileChooser.APPROVE_OPTION) {  
                    file = this_.saveDirChooser.getSelectedFile();  
                    if(!file.isDirectory()) {  
                        JOptionPane.showMessageDialog(this_, "你选择的目录不存在");
                        return ;
                    }  
                    String path = file.getAbsolutePath();
                    this_.saveDirField.setText(path);
                }
			}
		}) , 400, 80, 60, 30);
		
		addTaskBtn = new AJButton("新建", "", "add.gif", new OperaBtnMouseListener(this, new IListenerTask() {
			public void doWork(Window addFormDialog) {
				AddFormDialog this_ = (AddFormDialog)addFormDialog;
				if("".equals(this_.urlField.getText().trim())){
					JOptionPane.showMessageDialog(this_, "请填写下载地址");
				}else if("".equals(this_.saveDirField.getText().trim())){
					JOptionPane.showMessageDialog(this_, "请选择保存路径");
				}else{
					//具体操作
					
				}
			}
		}), (this.getWidth() - 100) / 2, 120, 100, 30);
		saveDirChooser = new JFileChooser("/");
		saveDirChooser.setDialogTitle("选择保存目录");//选择框标题
		saveDirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//只能选择目录
		ComponentUtil.addComponents(this.getContentPane(), addTaskBtn, urlLabel, urlField, saveDirLabel, saveDirField, chooserBtn, tipLabel);
		
		/*//添加窗口聚焦监听器
		this.addWindowFocusListener(new WindowFocusListener() {
			// 当失去活动状态的时候此窗口被隐藏
			public void windowLostFocus(WindowEvent e) {
				AddFormDialog window = (AddFormDialog) e.getSource();
				window.setVisible(false);
			}
			public void windowGainedFocus(WindowEvent e) {}
		});
		//添加鼠标活动监听器
		this.addMouseListener(new MouseListener() {
			// 当鼠标点击当前窗口时隐藏此窗口
			public void mouseClicked(MouseEvent e) {
				AddFormDialog window = (AddFormDialog) e.getSource();
				window.setVisible(false);
			}
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
		});*/
	}
	public void emptyField(){
		urlField.setText("");
		saveDirField.setText("");
	}
}
