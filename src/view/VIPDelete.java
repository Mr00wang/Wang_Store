package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

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

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VIPDelete extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -2887813122795960149L;
    private JPanel c;
    private JTextField textField;
    private JLabel label2;
    private JLabel label2_1;
    private JLabel label3;
    private JLabel label3_1;
    private JLabel label4;
    private JLabel label4_1;
    private JLabel label5;
    private JLabel label5_1;
    private JLabel label6;
    private JLabel label6_1;
    private JLabel label7;
    private JButton button1;
    private JButton button2;
    protected Point pressedPoint;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VIPDelete frame = new VIPDelete();
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
    public VIPDelete() {
        //background picture
        JLabel picture = new JLabel();
        picture.setIcon(new ImageIcon("picture/VIPDelete.png"));
        this.getLayeredPane().add(picture,new Integer(Integer.MIN_VALUE));
        picture.setBounds(0,0,374,535);

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
        this.setIconImage(new ImageIcon("picture/viptubiao.png").getImage());
        //
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 374, 535);
        setLocation(WindowXY.getXY(this.getSize()));//界面居中
        c.setBorder(new LineBorder(Color.GRAY));
        c.setLayout(null);

        //账号
        JLabel label1 = new JLabel("账号：");
        label1.setFont(new Font("宋体", Font.PLAIN, 20));
        label1.setBounds(23, 98, 88, 42);
        c.add(label1);

        textField = new JTextField();
        textField.setFont(new Font("宋体", Font.BOLD, 18));
        textField.setBounds(112, 104, 204, 35);
        c.add(textField);
        textField.setColumns(10);

        //姓名：
        label2 = new JLabel("姓名：");
        label2.setFont(new Font("宋体", Font.PLAIN, 20));
        label2.setBounds(23, 150, 88, 42);
        c.add(label2);

        label2_1 = new JLabel("");
        label2_1.setFont(new Font("宋体", Font.BOLD, 18));
        label2_1.setBounds(115, 157, 204, 35);
        c.add(label2_1);

        //性别
        label3 = new JLabel("性别：");
        label3.setFont(new Font("宋体", Font.PLAIN, 20));
        label3.setBounds(23, 202, 88, 42);
        c.add(label3);

        label3_1 = new JLabel("");
        label3_1.setFont(new Font("宋体", Font.BOLD, 18));
        label3_1.setBounds(115, 209, 204, 35);
        c.add(label3_1);

        //地址
        label4 = new JLabel("地址：");
        label4.setFont(new Font("宋体", Font.PLAIN, 20));
        label4.setBounds(23, 254, 88, 42);
        c.add(label4);

        label4_1 = new JLabel("");
        label4_1.setFont(new Font("宋体", Font.BOLD, 18));
        label4_1.setBounds(115, 261, 204, 35);
        c.add(label4_1);

        //电话
        label5 = new JLabel("电话：");
        label5.setFont(new Font("宋体", Font.PLAIN, 20));
        label5.setBounds(23, 306, 88, 42);
        c.add(label5);

        label5_1 = new JLabel("");
        label5_1.setFont(new Font("宋体", Font.BOLD, 18));
        label5_1.setBounds(115, 313, 204, 35);
        c.add(label5_1);

        //折扣
        label6 = new JLabel("折扣：");
        label6.setFont(new Font("宋体", Font.PLAIN, 20));
        label6.setBounds(23, 358, 88, 42);
        c.add(label6);

        label6_1 = new JLabel("");
        label6_1.setFont(new Font("宋体", Font.BOLD, 18));
        label6_1.setBounds(115, 365, 204, 35);
        c.add(label6_1);

        //关闭
        label7 = new JLabel(new ImageIcon("picture/关闭.png"));
        label7.setToolTipText("关闭");
        label7.setBounds(286, 21, 61, 52);
        c.add(label7);

        button1 = new JButton("显示信息");
        button1.setFont(new Font("Dialog", Font.PLAIN, 14));
        button1.setBounds(23, 439, 134, 42);
        button1.setBackground(new Color(0, 191, 255));//颜色
        button1.setForeground(SystemColor.desktop);
        c.add(button1);


        button2 = new JButton("确定注销");
        button2.setFont(new Font("宋体", Font.PLAIN, 14));
        button2.setBounds(200, 439, 134, 42);
        button2.setBackground(new Color(0, 191, 255));//颜色
        button2.setForeground(SystemColor.desktop);
        c.add(button2);

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
                if(textField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "请输入要注销的VIP账号！");
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
                            if(textField.getText().trim().equals(rs.getString("vip_id")))
                            {
                                q=1;
                                label2_1.setText(rs.getString("vip_name"));
                                label3_1.setText(rs.getString("vip_sex"));
                                label4_1.setText(rs.getString("vip_address"));
                                label5_1.setText(rs.getString("vip_telephone"));
                                label6_1.setText(rs.getString("vip_discount"));
                            }
                        }
                        if(q==0)
                        {
                            JOptionPane.showMessageDialog(null, "没有该账号用户，请重新输入！");
                            textField.setText("");
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
        //确定注销
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(textField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "请输入要注销的VIP账号！");
                }else
                {
                    Connection con = null;
                    Statement statement = null;
                    ResultSet rs = null;
                    int q = 0;
                    int q1 = 0;
                    String sql1 = "select * from vip_info";
                    String sql2 = "delete from vip_info where vip_id = '"+textField.getText().trim()+"'";
                    try {
                        con = DBConnect.getConnection();
                        statement = con.createStatement();
                        rs = statement.executeQuery(sql1);
                        while(rs.next())
                        {
                            if(textField.getText().trim().equals(rs.getString("vip_id")))
                            {
                                q=1;
                                q1 = statement.executeUpdate(sql2);
                                if(q1!=0)
                                    JOptionPane.showMessageDialog(null,"删除成功！");
                                else
                                    JOptionPane.showMessageDialog(null,"删除失败！");
                                break;
                            }
                        }
                        if(q==0)
                        {
                            JOptionPane.showMessageDialog(null, "没有改账号用户，请重新输入！");
                            textField.setText("");
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
