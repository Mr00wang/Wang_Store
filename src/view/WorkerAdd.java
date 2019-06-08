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
import util.SystemTime;
import util.WindowXY;

public class WorkerAdd extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel c;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JLabel label_6;
    private JTextField textField7;
    private JLabel label_7;
    private JTextField textField8;
    private JLabel label_8;
    private JTextField textField9;
    private JButton button;
    private JButton button_1;
    private JLabel label_9;
    protected Point pressedPoint;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WorkerAdd frame = new WorkerAdd();
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
    public WorkerAdd() {
        //background picture
        JLabel picture = new JLabel();
        picture.setIcon(new ImageIcon("picture/WorkerAdd.png"));
        this.getLayeredPane().add(picture,new Integer(Integer.MIN_VALUE));
        picture.setBounds(0,0,368,573);

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

        setBounds(100, 100, 368, 573);
        setLocation(WindowXY.getXY(this.getSize()));//界面居中
        c.setBorder(new LineBorder(Color.GRAY));
        c.setLayout(null);

        //工号
        JLabel label = new JLabel("工号：");
        label.setFont(new Font("宋体", Font.PLAIN, 18));
        label.setBounds(31, 86, 91, 38);
        c.add(label);

        textField1 = new JTextField();
        textField1.setFont(new Font("宋体", Font.BOLD, 18));
        textField1.setBounds(100, 90, 208, 32);
        c.add(textField1);
        textField1.setColumns(10);

        //姓名
        JLabel label_1 = new JLabel("姓名：");
        label_1.setFont(new Font("宋体", Font.PLAIN, 18));
        label_1.setBounds(31, 134, 91, 38);
        c.add(label_1);

        textField2 = new JTextField();
        textField2.setFont(new Font("宋体", Font.BOLD, 18));
        textField2.setColumns(10);
        textField2.setBounds(100, 138, 208, 32);
        c.add(textField2);

        //性别
        JLabel label_2 = new JLabel("性别：");
        label_2.setFont(new Font("宋体", Font.PLAIN, 18));
        label_2.setBounds(31, 182, 91, 38);
        c.add(label_2);

        textField3 = new JTextField();
        textField3.setFont(new Font("宋体", Font.BOLD, 18));
        textField3.setColumns(10);
        textField3.setBounds(100, 186, 64, 32);
        c.add(textField3);

        //年龄
        JLabel label_3 = new JLabel("年龄：");
        label_3.setFont(new Font("宋体", Font.PLAIN, 18));
        label_3.setBounds(187, 182, 91, 38);
        c.add(label_3);

        textField4 = new JTextField();
        textField4.setFont(new Font("宋体", Font.BOLD, 18));
        textField4.setColumns(10);
        textField4.setBounds(245, 186, 64, 32);
        c.add(textField4);

        //部门
        JLabel label_4 = new JLabel("部门：");
        label_4.setFont(new Font("宋体", Font.PLAIN, 18));
        label_4.setBounds(31, 230, 91, 38);
        c.add(label_4);

        textField5 = new JTextField();
        textField5.setFont(new Font("宋体", Font.BOLD, 18));
        textField5.setColumns(10);
        textField5.setBounds(100, 234, 208, 32);
        c.add(textField5);

        //职位
        JLabel label_5 = new JLabel("职位：");
        label_5.setFont(new Font("宋体", Font.PLAIN, 18));
        label_5.setBounds(31, 278, 91, 38);
        c.add(label_5);

        textField6 = new JTextField();
        textField6.setFont(new Font("宋体", Font.BOLD, 18));
        textField6.setColumns(10);
        textField6.setBounds(100, 282, 208, 32);
        c.add(textField6);

        //电话
        label_6 = new JLabel("电话：");
        label_6.setFont(new Font("宋体", Font.PLAIN, 18));
        label_6.setBounds(31, 326, 91, 38);
        c.add(label_6);

        textField7 = new JTextField();
        textField7.setFont(new Font("宋体", Font.BOLD, 18));
        textField7.setColumns(10);
        textField7.setBounds(100, 330, 208, 32);
        c.add(textField7);

        //工资
        label_7 = new JLabel("工资：");
        label_7.setFont(new Font("宋体", Font.PLAIN, 18));
        label_7.setBounds(31, 374, 91, 38);
        c.add(label_7);

        textField8 = new JTextField();
        textField8.setFont(new Font("宋体", Font.BOLD, 18));
        textField8.setColumns(10);
        textField8.setBounds(100, 378, 208, 32);
        c.add(textField8);

        //住址
        label_8 = new JLabel("住址：");
        label_8.setFont(new Font("宋体", Font.PLAIN, 18));
        label_8.setBounds(31, 422, 91, 38);
        c.add(label_8);

        textField9 = new JTextField();
        textField9.setFont(new Font("宋体", Font.BOLD, 18));
        textField9.setColumns(10);
        textField9.setBounds(100, 426, 208, 32);
        c.add(textField9);

        //查询
        button = new JButton("注册");
        button.setFont(new Font("宋体", Font.PLAIN, 14));
        button.setBounds(31, 484, 121, 38);
        button.setBackground(new Color(0, 191, 255));//颜色
        button.setForeground(SystemColor.desktop);
        c.add(button);

        //返回
        button_1 = new JButton("返  回");
        button_1.setFont(new Font("宋体", Font.PLAIN, 14));
        button_1.setBounds(187, 484, 121, 38);
        button_1.setBackground(new Color(0, 191, 255));//颜色
        button_1.setForeground(SystemColor.desktop);
        c.add(button_1);

        //关闭
        label_9 = new JLabel(new ImageIcon("picture/关闭.png"));
        label_9.setToolTipText("关闭");
        label_9.setBounds(291, 12, 54, 45);
        c.add(label_9);

        //MyEvent()
        MyEvent();
    }
    public void MyEvent()
    {
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String sex1 = "男";
                String sex2 = "女";
                // TODO Auto-generated method stub
                if(textField1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "员工的工号不能为空！");
                }else if( !(textField3.getText().equals(sex1)) && !(textField3.getText().equals(sex2)))
                {
                    JOptionPane.showMessageDialog(null, "性别请输入男女");
                    textField3.setText("");
                }
                else
                {
                    Connection con = null;
                    Statement statement = null;
                    ResultSet rs = null;
                    int q1 = 0;
                    int q = 0;
                    String sql1 = "select * from worker_info";
                    String sql2 = "insert into worker_info values('"+textField1.getText()+"','"+textField2.getText()+"','"+textField3.getText()+"','"
                            +textField4.getText()+"','"+textField5.getText()+"','"+textField6.getText()+"','"+textField7.getText()+"','"+Double.parseDouble(textField8.getText())+"','"
                            +textField9.getText()+"','"+""+"','"+new SystemTime().getSystemTime()+"')";
                    try {
                        con = DBConnect.getConnection();
                        statement = con.createStatement();
                        rs = statement.executeQuery(sql1);
                        while(rs.next())
                        {
                            if(textField1.getText().equals(rs.getString("worker_id")))
                            {
                                q1 = 1;
                                break;
                            }
                        }
                        if(q1==1)
                        {
                            JOptionPane.showMessageDialog(null, "已有该工号，请重新输入！");
                            textField1.setText("");
                        }
                        else
                        {
                            q = statement.executeUpdate(sql2);
                            if(q!=0)
                            {
                                JOptionPane.showMessageDialog(null, "添加成功");
                                System.out.println("工号："+textField1.getText());
                                System.out.println("姓名："+textField2.getText());
                                System.out.println("性别："+textField3.getText());
                                System.out.println("年龄："+textField4.getText());
                                System.out.println("部门："+textField5.getText());
                                System.out.println("职位："+textField6.getText());
                                System.out.println("电话："+textField7.getText());
                                System.out.println("工资："+textField8.getText());
                                System.out.println("地址："+textField9.getText());
                                System.out.println("注册时间："+new SystemTime().getSystemTime());

                                textField1.setText("");
                                textField2.setText("");
                                textField3.setText("");
                                textField4.setText("");
                                textField5.setText("");
                                textField6.setText("");
                                textField7.setText("");
                                textField8.setText("");
                                textField9.setText("");
                            }
                            else
                                JOptionPane.showMessageDialog(null, "添加失败");
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
        button_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                dispose();
            }
        });
        //关闭
        label_9.addMouseListener(new MouseAdapter() {
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
