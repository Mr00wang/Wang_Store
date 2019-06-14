package view;
/**
 * @wang
 */

import javax.swing.*;
import javax.swing.border.LineBorder;

import util.Config;
import util.DBConnect;
import util.WindowXY;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JLabel label1,label2;
    private JLabel label3,label4;
    private JButton button;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private ImageIcon image;
    protected Point pressedPoint;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginWindow frame = new LoginWindow();
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
    public LoginWindow() {
        //background picture
        JLabel picture = new JLabel();
        picture.setIcon(new ImageIcon("picture/login.png"));
        this.getLayeredPane().add(picture,new Integer(Integer.MIN_VALUE));
        picture.setBounds(0,0,470,470);

        JPanel c = new JPanel();
        c = (JPanel)getContentPane();
        c.setOpaque(false);
        //设置图标
        this.setIconImage(new ImageIcon("picture/商场.png").getImage());
        //设置组件风格
        new Style();
        //设置面板大小
        setBounds(200, 200, 470, 460);
        setLocation(WindowXY.getXY(this.getSize()));//界面居中
        c.setLayout(null);
        //设置窗体不可拉伸
        setResizable(false);
        //取消窗体
        setUndecorated(true);
        //setAlwaysOnTop(true);
        //设置边框
        c.setBorder(new LineBorder(Color.GRAY));
        //账号
        label1 = new JLabel("账号：");
        label1.setFont(new Font("楷体", Font.PLAIN, 24));
        label1.setBounds(105, 204, 80, 35);
        c.add(label1);

        textField = new JTextField();
        textField.setFont(new Font("楷体", Font.PLAIN, 20));
        textField.setToolTipText("输入账号");
        textField.setBounds(195, 209, 235, 28);
        c.add(textField);
        textField.setColumns(10);

        //密码
        label2 = new JLabel("密码：");
        label2.setFont(new Font("楷体", Font.PLAIN, 24));
        label2.setBounds(105, 249, 105, 40);
        c.add(label2);

        passwordField = new JPasswordField();
        passwordField.setToolTipText("输入密码");  //提示
        passwordField.setFont(new Font("楷体", Font.PLAIN, 20));
        passwordField.setBounds(195, 257, 235, 28);
        c.add(passwordField);

        //没有账号
        label3 = new JLabel("没有账号？");
        label3.setToolTipText("注册账号");
        //label3.setFont(new Font("楷体", Font.PLAIN, 16));
        label3.setForeground(new Color(65, 105, 225));
        label3.setBounds(195, 280, 81, 40);
        c.add(label3);

        //忘记密码
        label4 = new JLabel("忘记密码？");
        label4.setToolTipText("修改密码");
        //label4.setFont(new Font("楷体", Font.PLAIN, 16));
        label4.setForeground(new Color(65, 105, 225));
        label4.setBounds(372, 288, 88, 25);
        c.add(label4);

        //登陆
        button = new JButton("登    陆");
        button.setBackground(new Color(0, 191, 255));//颜色
        button.setForeground(SystemColor.desktop);
        button.setBounds(131, 350, 196, 48);
        c.add(button);

        //头像
        image = new ImageIcon("picture/商标.png");
        Image img = image.getImage();
        img = img.getScaledInstance(85, 85, Image.SCALE_DEFAULT);
        image.setImage(img);
        label5 = new JLabel();
        label5.setIcon(image);
        label5.setBounds(10, 204, 85, 85);
        c.add(label5);

        //最小化
        label6 = new JLabel(new ImageIcon("picture/最小化.png"));
        label6.setToolTipText("最小化");
        label6.setBounds(372, 10, 54, 50);
        c.add(label6);

        //最大化
        label7 = new JLabel(new ImageIcon("picture/关闭.png"));
        label7.setToolTipText("关闭");
        label7.setBounds(406, 10, 54, 50);
        c.add(label7);



        //MyEvent()事件
        MyEvent();
    }
    public void MyEvent()
    {
        //登陆按钮
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                if(textField.getText().equals("") || new String(passwordField.getPassword()).equals(""))
                {
                    JOptionPane.showMessageDialog(null, "内容不能为空！");
                }
                else
                {

                    Connection conn = null;
                    Statement statement = null;
                    ResultSet rs = null;
                    String sql = "select * from user";
                    int i=0;
                    try {
                        conn = DBConnect.getConnection();
                        statement = conn.createStatement();
                        rs = statement.executeQuery(sql);
                        while(rs.next())
                        {
                            if(textField.getText().equals(rs.getString("id")))
                            {
                                i=1;
                                if(new String(passwordField.getPassword()).trim().equals(rs.getString("password").trim()))
                                {
                                    //
                                    if(rs.getInt("state")==1)
                                    {
                                        System.out.println(textField.getText()+"用户已登录");
                                        Config.id = textField.getText();
                                        JOptionPane.showMessageDialog(null, "登陆成功");
                                        MenuWindow frame = new MenuWindow();
                                        frame.setVisible(true);
                                        dispose();
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(null, "该用户尚未激活，请联系相关人员进行激活！");
                                        textField.setText("");
                                        passwordField.setText("");
                                    }

                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "密码错误");
                                    textField.setText("");
                                    passwordField.setText("");
                                }
                            }

                        }
                        if(i==0)
                        {
                            JOptionPane.showMessageDialog(null, "没有此账号");
                            textField.setText("");
                            passwordField.setText("");
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
        //没有账号
        label3.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e)
            {
                label3.setForeground(new Color(0, 191, 255));
            }
            public void mouseExited(MouseEvent e)
            {
                label3.setForeground(new Color(65, 105, 225));
            }
            public void mousePressed(MouseEvent e)
            {
                RegisterWindow frame = new RegisterWindow();
                frame.setVisible(true);
            }
        });
        //忘记密码
        label4.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e)
            {
                label4.setForeground(new Color(0, 191, 255));
            }
            public void mouseExited(MouseEvent e)
            {
                label4.setForeground(new Color(65, 105, 225));
            }
            public void mousePressed(MouseEvent e)
            {
                JOptionPane.showMessageDialog(null,"请联系管理员进行密码重置！");
            }
        });
        //最小化
        label6.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e)
            {
                setExtendedState(JFrame.ICONIFIED);
            }
        });
        //关闭
        label7.addMouseListener(new MouseAdapter() {
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
