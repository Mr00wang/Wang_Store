package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import util.Config;
import util.DBConnect;
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

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class InfoWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel label1;
    private JLabel label1_1;
    private JLabel label2;
    private JLabel label2_2;
    private JLabel label3;
    private JLabel label3_3;
    private JLabel label4;
    private JLabel label4_4;
    private JLabel label5;
    private JLabel label5_5;
    private Container label6;
    private JLabel label6_6;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton button1;
    private JButton button2;
    private JLabel label9;
    protected Point pressedPoint;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InfoWindow frame = new InfoWindow();
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
    public InfoWindow() {
        //background picture
        JLabel picture = new JLabel();
        picture.setIcon(new ImageIcon("picture/info.png"));
        this.getLayeredPane().add(picture,new Integer(Integer.MIN_VALUE));
        picture.setBounds(0,0,373,476);
        //
        JPanel c = new JPanel();
        c = (JPanel)getContentPane();
        c.setOpaque(false);
        //组建风格
        new Style();
        //设置图标
        this.setIconImage(new ImageIcon("picture/商场.png").getImage());
        //设置窗体不可拉伸
        setResizable(false);
        //取消窗体
        setUndecorated(true);
        setBounds(100, 100, 373, 476);
        setLocation(WindowXY.getXY(this.getSize()));//界面居中

        c.setBorder(new LineBorder(Color.GRAY));
        c.setLayout(null);

        //账号
        label1 = new JLabel("账号：");
        label1.setFont(new Font("宋体", Font.PLAIN, 16));
        label1.setBounds(8, 84, 63, 33);
        c.add(label1);

        label1_1 = new JLabel("New label");
        label1_1.setFont(new Font("宋体", Font.PLAIN, 16));
        label1_1.setBounds(61, 84, 105, 33);
        c.add(label1_1);

        //姓名
        label2 = new JLabel("姓名：");
        label2.setFont(new Font("宋体", Font.PLAIN, 16));
        label2.setBounds(8, 125, 55, 33);
        c.add(label2);

        label2_2 = new JLabel("New label");
        label2_2.setFont(new Font("宋体", Font.PLAIN, 16));
        label2_2.setBounds(61, 127, 87, 33);
        c.add(label2_2);

        //性别
        label3 = new JLabel("性别：");
        label3.setFont(new Font("宋体", Font.PLAIN, 16));
        label3.setBounds(158, 128, 60, 27);
        c.add(label3);

        label3_3 = new JLabel("New label");
        label3_3.setFont(new Font("宋体", Font.PLAIN, 16));
        label3_3.setBounds(215, 126, 87, 32);
        c.add(label3_3);

        //部门
        label4 = new JLabel("部门：");
        label4.setFont(new Font("宋体", Font.PLAIN, 16));
        label4.setBounds(8, 170, 61, 33);
        c.add(label4);

        label4_4 = new JLabel("New label");
        label4_4.setFont(new Font("宋体", Font.PLAIN, 16));
        label4_4.setBounds(61, 173, 87, 27);
        c.add(label4_4);

        //职务
        label5 = new JLabel("职务：");
        label5.setFont(new Font("宋体", Font.PLAIN, 16));
        label5.setBounds(158, 170, 70, 33);
        c.add(label5);

        label5_5 = new JLabel("New label");
        label5_5.setFont(new Font("宋体", Font.PLAIN, 16));
        label5_5.setBounds(215, 174, 73, 25);
        c.add(label5_5);

        //注册时间
        label6 = new JLabel("注册时间：");
        label6.setFont(new Font("宋体", Font.PLAIN, 16));
        label6.setBounds(8, 213, 91, 35);
        c.add(label6);

        label6_6 = new JLabel("New label");
        label6_6.setFont(new Font("宋体", Font.PLAIN, 16));
        label6_6.setBounds(93, 214, 158, 32);
        c.add(label6_6);

        //新密码
        JLabel label7 = new JLabel("新密码：");
        label7.setFont(new Font("宋体", Font.PLAIN, 16));
        label7.setBounds(8, 268, 83, 27);
        c.add(label7);

        passwordField1 = new JPasswordField();
        passwordField1.setFont(new Font("宋体", Font.PLAIN, 14));
        passwordField1.setBounds(93, 265, 173, 36);
        c.add(passwordField1);

        //确认密码
        JLabel label8 = new JLabel("确认密码：");
        label8.setFont(new Font("宋体", Font.PLAIN, 16));
        label8.setBounds(8, 321, 83, 23);
        c.add(label8);

        passwordField2 = new JPasswordField();
        passwordField2.setFont(new Font("宋体", Font.PLAIN, 14));
        passwordField2.setBounds(93, 317, 173, 36);
        c.add(passwordField2);

        //退出按钮
        button1 = new JButton("退出");
        button1.setBounds(10, 395, 120, 33);
        button1.setBackground(new Color(0, 191, 255));//颜色
        button1.setForeground(SystemColor.desktop);
        c.add(button1);

        //修改密码按钮
        button2 = new JButton("修改密码");
        button2.setBounds(180, 395, 122, 33);
        button2.setBackground(new Color(0, 191, 255));//颜色
        button2.setForeground(SystemColor.desktop);
        c.add(button2);

        label9 = new JLabel(new ImageIcon("picture/关闭.png"));
        label9.setToolTipText("关闭");
        label9.setBounds(292, 22, 54, 41);
        c.add(label9);

        //导入信息
        InfoLook();
        //MyEvent()事件
        MyEvent();

    }
    public void MyEvent()
    {
        //退出按钮
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                dispose();
            }
        });
        //修改密码按钮
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(new String(passwordField1.getPassword()).equals("") || new String(passwordField2.getPassword()).equals(""))
                {
                    JOptionPane.showMessageDialog(null, "输入不能为空");
                    passwordField1.setText("");
                    passwordField2.setText("");
                }
                else if(!new String(passwordField1.getPassword()).equals(new String(passwordField2.getPassword())))
                {
                    JOptionPane.showMessageDialog(null, "密码两次输入不一致");
                    passwordField1.setText("");
                    passwordField2.setText("");
                }
                else
                {
                    Connection conn = null;
                    Statement statement = null;
                    String sql = "update user set password ='"+new String(passwordField1.getPassword()).trim()+"'where id='"+Config.id+"'";
                    try {
                        conn = DBConnect.getConnection();
                        statement = conn.createStatement();
                        int q = statement.executeUpdate(sql);
                        if(q!=0)
                        {
                            JOptionPane.showMessageDialog(null, "修改成功，请重新进行登陆");
                            LoginWindow frame = new LoginWindow();
                            frame.setVisible(true);
                            System.exit(0);

                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "修改失败!");
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
        //关闭
        label9.addMouseListener(new MouseAdapter() {
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
    public void InfoLook()
    {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        String sql = "select * from user";
        try {
            conn = DBConnect.getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            while(rs.next())
            {
                if(Config.id.equals(rs.getString("id")))
                {
                    label1_1.setText(rs.getString("id"));
                    label2_2.setText(rs.getString("name"));
                    label3_3.setText(rs.getString("sex"));
                    label4_4.setText(rs.getString("position"));
                    label5_5.setText(rs.getString("section"));
                    label6_6.setText(rs.getString("time"));
                    break;
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
