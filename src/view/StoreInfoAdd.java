package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StoreInfoAdd extends JFrame {
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
    private JLabel label_7;
    protected Point pressedPoint;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StoreInfoAdd frame = new StoreInfoAdd();
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
    public StoreInfoAdd() {
        //background picture
        JLabel picture = new JLabel();
        picture.setIcon(new ImageIcon("picture/StoreInfoAdd.png"));
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

        //编号
        JLabel label = new JLabel("编号：");
        label.setFont(new Font("宋体", Font.PLAIN, 20));
        label.setBounds(44, 90, 92, 52);
        c.add(label);

        textField = new JTextField();
        textField.setFont(new Font("宋体", Font.PLAIN, 16));
        textField.setBounds(152, 100, 220, 34);
        c.add(textField);
        textField.setColumns(10);

        //商品
        JLabel label_1 = new JLabel("商品：");
        label_1.setFont(new Font("宋体", Font.PLAIN, 20));
        label_1.setBounds(44, 140, 81, 52);
        c.add(label_1);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("宋体", Font.PLAIN, 16));
        textField_1.setColumns(10);
        textField_1.setBounds(153, 150, 220, 34);
        c.add(textField_1);

        //厂商
        JLabel label_2 = new JLabel("厂商：");
        label_2.setFont(new Font("宋体", Font.PLAIN, 20));
        label_2.setBounds(44, 190, 81, 52);
        c.add(label_2);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("宋体", Font.PLAIN, 16));
        textField_2.setColumns(10);
        textField_2.setBounds(153, 200, 220, 34);
        c.add(textField_2);

        //类别
        JLabel label_3 = new JLabel("类别：");
        label_3.setFont(new Font("宋体", Font.PLAIN, 20));
        label_3.setBounds(44, 240, 81, 52);
        c.add(label_3);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("宋体", Font.PLAIN, 16));
        textField_3.setColumns(10);
        textField_3.setBounds(153, 250, 220, 34);
        c.add(textField_3);

        //进价
        JLabel label_4 = new JLabel("进价：");
        label_4.setFont(new Font("宋体", Font.PLAIN, 20));
        label_4.setBounds(44, 290, 81, 52);
        c.add(label_4);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("宋体", Font.PLAIN, 16));
        textField_4.setColumns(10);
        textField_4.setBounds(153, 300, 220, 34);
        c.add(textField_4);

        //数量
        JLabel label_5 = new JLabel("数量：");
        label_5.setFont(new Font("宋体", Font.PLAIN, 20));
        label_5.setBounds(44, 340, 81, 52);
        c.add(label_5);

        textField_5 = new JTextField();
        textField_5.setFont(new Font("宋体", Font.PLAIN, 16));
        textField_5.setColumns(10);
        textField_5.setBounds(153, 350, 220, 34);
        c.add(textField_5);

        //售价
        JLabel label_6 = new JLabel("售价：");
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
        label_7.setBounds(333, 31, 54, 45);
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
                if(textField.getText().equals("") || textField_1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "商品编号和商品名不能为空！");
                }
                else
                {
                    Connection conn = null;
                    Statement statement = null;
                    ResultSet rs = null;
                    int q = 0;
                    int q1=0;
                    double price = new Integer(textField_5.getText()) * new Integer(textField_4.getText());
                    String sql1 = "select * from store_info";
                    String sql2 = "insert into store_info values('"+textField.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"','"
                            +textField_3.getText()+"','"+textField_4.getText()+"','"+new Integer(textField_5.getText())+"','"+textField_6.getText()+"','"+new SystemTime().getSystemTime()+"','"+price+"')";


                    try {
                        conn = DBConnect.getConnection();
                        statement = conn.createStatement();
                        rs = statement.executeQuery(sql1);
                        while(rs.next())
                        {
                            if(textField.getText().equals(rs.getString("store_id")))
                            {
                                q1 = 1;
                                break;
                            }
                        }
                        if(q1==1)
                        {
                            JOptionPane.showMessageDialog(null, "已有该编号，请重新输入！");
                            textField.setText("");
                        }
                        else
                        {
                            q = statement.executeUpdate(sql2);
                            if(q!=0)
                            {
                                JOptionPane.showMessageDialog(null, "添加成功");
                                System.out.println("编号："+textField.getText());
                                System.out.println("商品："+textField_1.getText());
                                System.out.println("厂商："+textField_2.getText());
                                System.out.println("类型："+textField_3.getText());
                                System.out.println("进价："+textField_4.getText());
                                System.out.println("数量："+textField_5.getText());
                                System.out.println("售价："+textField_6.getText());
                                System.out.println("添加时间："+new SystemTime().getSystemTime());
                                System.out.println("总价格："+price);

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
