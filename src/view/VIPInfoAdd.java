package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import util.DBConnect;
import util.SystemTime;
import util.WindowXY;

public class VIPInfoAdd extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel c;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JButton button;
    private JButton button_1;
    private JComponent label_7;
    protected Point pressedPoint;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VIPInfoAdd frame = new VIPInfoAdd();
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
    public VIPInfoAdd() {
        //background picture
        JLabel picture = new JLabel();
        picture.setIcon(new ImageIcon("picture/VIPAdd.png"));
        this.getLayeredPane().add(picture,new Integer(Integer.MIN_VALUE));
        picture.setBounds(0,0,426,577);

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 426, 577);

        setLocation(WindowXY.getXY(this.getSize()));//界面居中
        c.setBorder(new LineBorder(Color.GRAY));
        c.setLayout(null);

        //账号
        JLabel label = new JLabel("账号：");
        label.setFont(new Font("宋体", Font.PLAIN, 20));
        label.setBounds(44, 90, 92, 52);
        c.add(label);

        textField = new JTextField();
        textField.setFont(new Font("宋体", Font.PLAIN, 16));
        textField.setBounds(152, 100, 220, 34);
        c.add(textField);
        textField.setColumns(10);

        //密码
        JLabel label_1 = new JLabel("密码：");
        label_1.setFont(new Font("宋体", Font.PLAIN, 20));
        label_1.setBounds(44, 140, 81, 52);
        c.add(label_1);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("宋体", Font.PLAIN, 16));
        textField_1.setColumns(10);
        textField_1.setBounds(153, 150, 220, 34);
        c.add(textField_1);

        //姓名
        JLabel label_2 = new JLabel("姓名：");
        label_2.setFont(new Font("宋体", Font.PLAIN, 20));
        label_2.setBounds(44, 190, 81, 52);
        c.add(label_2);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("宋体", Font.PLAIN, 16));
        textField_2.setColumns(10);
        textField_2.setBounds(153, 200, 220, 34);
        c.add(textField_2);

        //性别
        JLabel label_3 = new JLabel("性别：");
        label_3.setFont(new Font("宋体", Font.PLAIN, 20));
        label_3.setBounds(44, 240, 81, 52);
        c.add(label_3);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("宋体", Font.PLAIN, 16));
        textField_3.setColumns(10);
        textField_3.setBounds(153, 250, 220, 34);
        c.add(textField_3);

        //住址
        JLabel label_4 = new JLabel("住址");
        label_4.setFont(new Font("宋体", Font.PLAIN, 20));
        label_4.setBounds(44, 290, 81, 52);
        c.add(label_4);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("宋体", Font.PLAIN, 16));
        textField_4.setColumns(10);
        textField_4.setBounds(153, 300, 220, 34);
        c.add(textField_4);

        //电话
        JLabel label_5 = new JLabel("电话：");
        label_5.setFont(new Font("宋体", Font.PLAIN, 20));
        label_5.setBounds(44, 340, 81, 52);
        c.add(label_5);

        textField_5 = new JTextField();
        textField_5.setFont(new Font("宋体", Font.PLAIN, 16));
        textField_5.setColumns(10);
        textField_5.setBounds(153, 350, 220, 34);
        c.add(textField_5);

        //折扣
        JLabel label_6 = new JLabel("折扣：");
        label_6.setFont(new Font("宋体", Font.PLAIN, 20));
        label_6.setBounds(44, 390, 81, 52);
        c.add(label_6);

        textField_6 = new JTextField();
        textField_6.setFont(new Font("宋体", Font.PLAIN, 16));
        textField_6.setColumns(10);
        textField_6.setBounds(153, 400, 220, 34);
        c.add(textField_6);

        //返回按钮
        button = new JButton("退出");
        button.setFont(new Font("宋体", Font.PLAIN, 16));
        button.setBackground(new Color(0, 191, 255));//颜色
        button.setForeground(SystemColor.desktop);
        button.setBounds(44, 468, 127, 37);
        c.add(button);

        //确定新增按钮
        button_1 = new JButton("确定新增");
        button_1.setFont(new Font("宋体", Font.PLAIN, 16));
        button_1.setBackground(new Color(0, 191, 255));//颜色
        button_1.setForeground(SystemColor.desktop);
        button_1.setBounds(248, 468, 127, 37);
        c.add(button_1);

        label_7 = new JLabel(new ImageIcon("picture/关闭.png"));
        label_7.setToolTipText("关闭");
        label_7.setBounds(335, 35, 54, 45);
        c.add(label_7);

        //MyEvent()
        MyEvent();
    }
    public void MyEvent()
    {
        //退出按钮
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                dispose();
            }
        });
        //确定按钮

        button_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String sex1 = "男";
                String sex2 = "女";
                double discount= Double.parseDouble(textField_6.getText());
                System.out.println(discount);
                if(textField.getText().equals("") || textField_1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "账号和密码不能为空！");
                }
                else if( !(textField_3.getText().equals(sex1)) && !(textField_3.getText().equals(sex2)))
                {
                    JOptionPane.showMessageDialog(null, "性别请输入男女");
                    textField_3.setText("");
                }
                else if(discount>1 || discount<0)
                {
                    System.out.println(discount);
                    JOptionPane.showMessageDialog(null, "折扣请输入小于1");
                    textField_6.setText("");
                }
                else
                {
                    Connection conn = null;
                    Statement statement = null;
                    ResultSet rs = null;
                    int q = 0;
                    int q1=0;
                    String sql1 = "select * from vip_info";
                    String sql2 = "insert into vip_info values('"+textField.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"','"
                            +textField_3.getText()+"','"+textField_4.getText()+"','"+textField_5.getText()+"','"+textField_6.getText()+"','"+new SystemTime().getSystemTime()+"')";


                    try {
                        conn = DBConnect.getConnection();
                        statement = conn.createStatement();
                        rs = statement.executeQuery(sql1);
                        while(rs.next())
                        {
                            if(textField.getText().equals(rs.getString("vip_id")))
                            {
                                q1 = 1;
                                break;
                            }
                        }
                        if(q1==1)
                        {
                            JOptionPane.showMessageDialog(null, "已有该账号，请重新输入！");
                            textField.setText("");
                        }
                        else
                        {
                            q = statement.executeUpdate(sql2);
                            if(q!=0)
                            {
                                JOptionPane.showMessageDialog(null, "添加成功");
                                System.out.println("账号："+textField.getText());
                                System.out.println("密码："+textField_1.getText());
                                System.out.println("姓名："+textField_2.getText());
                                System.out.println("性别："+textField_3.getText());
                                System.out.println("地址："+textField_4.getText());
                                System.out.println("电话："+textField_5.getText());
                                System.out.println("折扣："+textField_6.getText());
                                System.out.println("注册时间："+new SystemTime().getSystemTime());

                                textField.setText("");
                                textField_1.setText("");
                                textField_2.setText("");
                                textField_3.setText("");
                                textField_4.setText("");
                                textField_5.setText("");
                                textField_6.setText("");
                            }
                            else
                                JOptionPane.showMessageDialog(null, "添加失败");
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
        label_7.addMouseListener(new MouseAdapter() {
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
