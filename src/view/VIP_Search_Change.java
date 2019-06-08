package view;

import java.awt.Color;
import java.awt.EventQueue;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import util.DBConnect;
import util.WindowXY;

public class VIP_Search_Change extends JFrame {
    private static final long serialVersionUID = 2914577517638849861L;
    private JPanel c;
    private JTextField textField1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JButton button1;
    private JButton button2;
    protected Point pressedPoint;
    private JLabel label8;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VIP_Search_Change frame = new VIP_Search_Change();
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
    public VIP_Search_Change() {
        //background picture
        JLabel picture = new JLabel();
        picture.setIcon(new ImageIcon("picture/VIPSearchChange.png"));
        this.getLayeredPane().add(picture,new Integer(Integer.MIN_VALUE));
        picture.setBounds(0,0,374,568);

        //
        c = new JPanel();
        c = (JPanel)getContentPane();
        c.setOpaque(false);
        //调用风格
        new Style();
        //设置窗体不可拉伸
        setResizable(false);
        //取消窗体
        setUndecorated(true);
        //设置图标
        this.setIconImage(new ImageIcon("picture/商场.png").getImage());
        //
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 374, 568);
        setLocation(WindowXY.getXY(this.getSize()));//界面居中
        c.setBorder(new LineBorder(Color.GRAY));
        c.setLayout(null);

        //账号
        JLabel label1 = new JLabel("账号：");
        label1.setFont(new Font("宋体", Font.PLAIN, 20));
        label1.setBounds(23, 98, 88, 42);
        c.add(label1);

        textField1 = new JTextField();
        textField1.setFont(new Font("宋体", Font.BOLD, 18));
        textField1.setBounds(112, 104, 204, 35);
        c.add(textField1);
        textField1.setColumns(10);

        //密码：
        label2 = new JLabel("密码：");
        label2.setFont(new Font("宋体", Font.PLAIN, 20));
        label2.setBounds(23, 150, 88, 42);
        c.add(label2);

        //姓名
        label3 = new JLabel("姓名：");
        label3.setFont(new Font("宋体", Font.PLAIN, 20));
        label3.setBounds(23, 202, 88, 42);
        c.add(label3);

        //性别
        label4 = new JLabel("性别：");
        label4.setFont(new Font("宋体", Font.PLAIN, 20));
        label4.setBounds(23, 254, 88, 42);
        c.add(label4);

        //地址
        label5 = new JLabel("地址：");
        label5.setFont(new Font("宋体", Font.PLAIN, 20));
        label5.setBounds(23, 306, 88, 42);
        c.add(label5);

        //电话
        label6 = new JLabel("电话：");
        label6.setFont(new Font("宋体", Font.PLAIN, 20));
        label6.setBounds(23, 358, 88, 42);
        c.add(label6);

        //关闭
        label7 = new JLabel(new ImageIcon("picture/关闭.png"));
        label7.setToolTipText("关闭");
        label7.setBounds(313, 16, 61, 52);
        c.add(label7);

        button1 = new JButton("查  询");
        button1.setFont(new Font("Dialog", Font.PLAIN, 14));
        button1.setBounds(23, 474, 134, 42);
        button1.setBackground(new Color(0, 191, 255));//颜色
        button1.setForeground(SystemColor.desktop);
        c.add(button1);


        button2 = new JButton("修  改");
        button2.setFont(new Font("宋体", Font.PLAIN, 14));
        button2.setBounds(212, 474, 134, 42);
        button2.setBackground(new Color(0, 191, 255));//颜色
        button2.setForeground(SystemColor.desktop);
        c.add(button2);

        //折扣
        label8 = new JLabel("折扣：");
        label8.setFont(new Font("宋体", Font.PLAIN, 20));
        label8.setBounds(23, 410, 88, 42);
        c.add(label8);

        textField2 = new JTextField();
        textField2.setFont(new Font("宋体", Font.BOLD, 18));
        textField2.setColumns(10);
        textField2.setBounds(112, 157, 204, 35);
        getContentPane().add(textField2);

        textField3 = new JTextField();
        textField3.setFont(new Font("宋体", Font.BOLD, 18));
        textField3.setColumns(10);
        textField3.setBounds(112, 209, 204, 35);
        getContentPane().add(textField3);

        textField4 = new JTextField();
        textField4.setFont(new Font("宋体", Font.BOLD, 18));
        textField4.setColumns(10);
        textField4.setBounds(112, 259, 204, 35);
        getContentPane().add(textField4);

        textField5 = new JTextField();
        textField5.setFont(new Font("宋体", Font.BOLD, 18));
        textField5.setColumns(10);
        textField5.setBounds(112, 315, 204, 35);
        getContentPane().add(textField5);

        textField6 = new JTextField();
        textField6.setFont(new Font("宋体", Font.BOLD, 18));
        textField6.setColumns(10);
        textField6.setBounds(112, 366, 204, 35);
        getContentPane().add(textField6);

        textField7 = new JTextField();
        textField7.setFont(new Font("宋体", Font.BOLD, 18));
        textField7.setColumns(10);
        textField7.setBounds(112, 416, 204, 35);
        getContentPane().add(textField7);

        //MyEvent()
        MyEvent();
    }
    public void MyEvent()
    {
        //显示信息
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(textField1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "请输入要查询的VIP账号！");
                }else
                {
                    Connection con = null;
                    Statement statement = null;
                    ResultSet rs = null;
                    int q = 0;
                    String sql1 = "select * from vip_info";
                    //String sql2 = "delete from vip_info where vip_id = '"+textField.getText().trim()+"'";
                    try {
                        con = DBConnect.getConnection();
                        statement = con.createStatement();
                        rs = statement.executeQuery(sql1);
                        while(rs.next())
                        {
                            if(textField1.getText().trim().equals(rs.getString("vip_id")))
                            {
                                q=1;
                                textField1.setText(rs.getString("vip_id"));
                                textField1.setEnabled(false);
                                textField2.setText(rs.getString("vip_password"));
                                textField3.setText(rs.getString("vip_name"));
                                textField4.setText(rs.getString("vip_sex"));
                                textField5.setText(rs.getString("vip_address"));
                                textField6.setText(rs.getString("vip_telephone"));
                                textField7.setText(rs.getString("vip_discount"));
                            }
                        }
                        if(q==0)
                        {
                            JOptionPane.showMessageDialog(null, "没有该账号用户，请重新输入！");
                            textField1.setText("");
                        }
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }finally
                    {
                        try {
                            statement.close();
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
        //确定修改
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String sex1 = "男";
                String sex2 = "女";
                double discount= Double.parseDouble(textField7.getText());
                if(textField1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "请输入要查询的VIP账号！");
                }
                else if( !(textField4.getText().equals(sex1)) && !(textField4.getText().equals(sex2)))
                {
                    JOptionPane.showMessageDialog(null, "性别请输入男女");
                    textField4.setText("");
                }
                else if(discount>1 || discount<0)
                {
                    System.out.println(discount);
                    JOptionPane.showMessageDialog(null, "折扣请输入小于1");
                    textField7.setText("");
                }
                else
                {
                    Connection con = null;
                    Statement statement = null;
                    ResultSet rs = null;
                    int q = 0;
                    int q1 = 0;
                    String sql = "select * from vip_info";
                    //String sql1 = "update vip_info set vip_id='"+textField1.getText()+"' where vip_id = '"+textField1.getText().trim()+"'";
                    String sql2 = "update vip_info set vip_password='"+textField2.getText()+"' where vip_id = '"+textField1.getText().trim()+"'";
                    String sql3 = "update vip_info set vip_name='"+textField3.getText()+"' where vip_id = '"+textField1.getText().trim()+"'";
                    String sql4 = "update vip_info set vip_sex='"+textField4.getText()+"' where vip_id = '"+textField1.getText().trim()+"'";
                    String sql5 = "update vip_info set vip_address='"+textField5.getText()+"' where vip_id = '"+textField1.getText().trim()+"'";
                    String sql6 = "update vip_info set vip_telephone='"+textField6.getText()+"' where vip_id = '"+textField1.getText().trim()+"'";
                    String sql7 = "update vip_info set vip_discount='"+textField7.getText()+"' where vip_id = '"+textField1.getText().trim()+"'";
                    try {
                        con = DBConnect.getConnection();
                        statement = con.createStatement();
                        rs = statement.executeQuery(sql);
                        while(rs.next())
                        {
                            if(textField1.getText().trim().equals(rs.getString("vip_id")))
                            {
                                q=1;
                                //q1 = statement.executeUpdate(sql1);
                                q1 = statement.executeUpdate(sql2);
                                q1 = statement.executeUpdate(sql3);
                                q1 = statement.executeUpdate(sql4);
                                q1 = statement.executeUpdate(sql5);
                                q1 = statement.executeUpdate(sql6);
                                q1 = statement.executeUpdate(sql7);
                                if(q1!=0)
                                    JOptionPane.showMessageDialog(null,"修改成功！");
                                else
                                    JOptionPane.showMessageDialog(null,"修改失败！");
                                break;
                            }
                        }
                        if(q==0)
                        {
                            JOptionPane.showMessageDialog(null, "没有该账号用户，请重新输入！");
                            textField1.setText("");
                        }
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }finally
                    {
                        try {
                            statement.close();
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                }
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
