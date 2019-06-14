package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import util.DBConnect;
import util.SystemTime;
import util.WindowXY;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RegisterWindow extends JFrame {


    private static final long serialVersionUID = -4047249914771262169L;
    private JPanel c;
    private JTextField textField;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;
    private JLabel label_3;
    private JLabel label_4;
    protected Point pressedPoint;
    private JButton button;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegisterWindow frame = new RegisterWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public RegisterWindow() {
        //background picture
        JLabel picture = new JLabel();
        picture.setIcon(new ImageIcon("picture/Register.png"));
        this.getLayeredPane().add(picture,new Integer(Integer.MIN_VALUE));
        picture.setBounds(0,0,424,424);

        c = new JPanel();
        c = (JPanel)getContentPane();
        c.setOpaque(false);
        //设置图标
        this.setIconImage(new ImageIcon("picture/商场.png").getImage());
        //设置组件风格
        new Style();
        //设置面板大小
        setBounds(100, 100, 424, 424);
        setLocation(WindowXY.getXY(this.getSize()));//界面居中
        //设置边框
        c.setBorder(new LineBorder(Color.GRAY));
        //设置窗体不可拉伸
        setResizable(false);
        //取消窗体
        setUndecorated(true);

        c.setBorder(new EmptyBorder(5, 5, 5, 5));
        c.setLayout(null);

        JLabel label = new JLabel("账    号：");
        label.setFont(new Font("宋体", Font.PLAIN, 16));
        label.setBounds(24, 90, 80, 45);
        c.add(label);

        textField = new JTextField();
        textField.setBounds(131, 95, 236, 38);
        c.add(textField);
        textField.setColumns(10);

        JLabel label_1 = new JLabel("密    码：");
        label_1.setFont(new Font("宋体", Font.PLAIN, 16));
        label_1.setBounds(24, 158, 80, 45);
        c.add(label_1);

        passwordField = new JPasswordField();
        passwordField.setBounds(131, 163, 236, 38);
        c.add(passwordField);

        JLabel label_2 = new JLabel("确认密码：");
        label_2.setFont(new Font("宋体", Font.PLAIN, 16));
        label_2.setBounds(24, 231, 92, 45);
        c.add(label_2);

        passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(131, 238, 236, 38);
        c.add(passwordField_1);

        button = new JButton("注    册");
        button.setBounds(110, 322, 196, 48);
        button.setBackground(new Color(0, 191, 255));//颜色
        button.setForeground(SystemColor.desktop);
        c.add(button);

        label_3 = new JLabel(new ImageIcon("picture/最小化.png"));
        label_3.setToolTipText("最小化");
        label_3.setBounds(292, 20, 54, 45);
        c.add(label_3);

        label_4 = new JLabel(new ImageIcon("picture/关闭.png"));
        label_4.setToolTipText("关闭");
        label_4.setBounds(344, 20, 54, 45);
        c.add(label_4);

        //
        MyEvent();
    }
    public void MyEvent()
    {
        //
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(textField.getText().equals("") || passwordField.getText().equals("") || passwordField_1.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "所有信息输入不能为空！");
                }
                else if(!passwordField.getText().equals(passwordField_1.getText()))
                {
                    JOptionPane.showMessageDialog(null, "两次密码输入不一致");
                    passwordField.setText("");
                    passwordField_1.setText("");
                }
                else
                {
                    Connection conn = null;
                    Statement statement = null;
                    ResultSet rs = null;
                    int q = 0;
                    int q1 = 0;
                    String sql1 = "select * from user";
                    String sql = "insert into user(id,password,time) values('"+textField.getText()+"','"+passwordField.getText()+"','"+new SystemTime().getSystemTime()+"')";
                    try {
                        conn = DBConnect.getConnection();
                        statement = conn.createStatement();
                        rs = statement.executeQuery(sql1);
                        while(rs.next())
                        {
                            if(textField.getText().equals(rs.getString("id")))
                            {

                                q=1;
                                JOptionPane.showMessageDialog(null, "已有该账号，请重新输入！");
                                break;
                            }
                        }
                        if(q==0)
                        {
                            q1 = statement.executeUpdate(sql);
                            if(q1!=0)
                            {
                                JOptionPane.showMessageDialog(null, "注册成功！\n请联系管理员进行激活");
                            }else
                            {
                                JOptionPane.showMessageDialog(null, "注册失败！");
                            }

                        }

                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        System.out.println("数据库连接失败");
                        e1.printStackTrace();
                    }
                    finally {
                        try {
                            statement.close();
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            System.out.println("关闭失败");
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
        //最小化
        label_3.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e)
            {
                setExtendedState(JFrame.ICONIFIED);
            }
        });
        //关闭
        label_4.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e)
            {
                dispose();
            }

        });
        //面板拖拉
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) { //鼠标按下事件
                pressedPoint = e.getPoint(); //记录鼠标坐标
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) { // 鼠标拖拽事件
                Point point = e.getPoint();// 获取当前坐标
                Point locationPoint = getLocation();// 获取窗体坐标
                int x = locationPoint.x + point.x - pressedPoint.x;// 计算移动后的新坐标
                int y = locationPoint.y + point.y - pressedPoint.y;
                setLocation(x, y);// 改变窗体位置
            }
        });
    }
}
