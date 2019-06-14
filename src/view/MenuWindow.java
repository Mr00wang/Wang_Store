package view;

import java.awt.Color;
import java.awt.EventQueue;
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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import util.Config;
import util.DBConnect;
import util.SystemTime;
import util.WindowXY;

import java.awt.Font;
import java.awt.Point;

public class MenuWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton button1,button2,button3;
    private JButton button4;
    private JLabel label1;
    private JPanel panel;
    private JLabel label2;
    private JLabel label5;
    private JLabel label4;
    private JLabel label3;
    private JButton button5;
    private JLabel label1_1;
    private JLabel label2_1;
    private JLabel label3_1;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    protected Point pressedPoint;
    private JLabel label,label_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuWindow frame = new MenuWindow();
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
    public MenuWindow() {
        //调用组件风格
        new Style();
        //background picture
        JLabel picture = new JLabel();
        picture.setIcon(new ImageIcon("picture/Menu.png"));
        this.getLayeredPane().add(picture,new Integer(Integer.MIN_VALUE));
        picture.setBounds(0,0,841,661);
        //
        JPanel c = new JPanel();
        c = (JPanel)getContentPane();
        c.setOpaque(false);
        //设置图标
        this.setIconImage(new ImageIcon("picture/商场.png").getImage());


        //设置窗体不可拉伸
        setResizable(false);
        //取消窗体
        setUndecorated(true);

        setBounds(100, 100, 841, 661);
        setLocation(WindowXY.getXY(this.getSize()));//界面居中
        c.setLayout(null);
        c.setBorder(new LineBorder(Color.GRAY));


        panel = new JPanel();
        panel.setBackground(new Color(224, 247, 250));
        panel.setBorder(new LineBorder(Color.GRAY));
        panel.setBounds(0, 0, 841, 90);
        c.add(panel);
        panel.setLayout(null);

        //注销用户按钮
        button1 = new JButton("注销用户");
        button1.setFont(new Font("宋体", Font.PLAIN, 14));
        button1.setBounds(10, 10, 145, 45);
        panel.add(button1);
        button1.setBackground(new Color(0, 191, 255));//颜色
        button1.setForeground(SystemColor.desktop);

        //退出系统按钮
        button2 = new JButton("退出系统");
        button2.setFont(new Font("宋体", Font.PLAIN, 14));
        button2.setBounds(170, 11, 145, 45);
        panel.add(button2);
        button2.setBackground(new Color(0, 191, 255));//颜色
        button2.setForeground(SystemColor.desktop);

        //帮助说明按钮
        button3 = new JButton("帮助说明");
        button3.setFont(new Font("宋体", Font.PLAIN, 14));
        button3.setBounds(330, 10, 145, 45);
        panel.add(button3);
        button3.setBackground(new Color(0, 191, 255));//颜色
        button3.setForeground(SystemColor.desktop);

        //关于系统按钮
        button4 = new JButton("关于系统");
        button4.setFont(new Font("宋体", Font.PLAIN, 14));
        button4.setBounds(490, 10, 145, 45);
        panel.add(button4);
        button4.setBackground(new Color(0, 191, 255));//颜色
        button4.setForeground(SystemColor.desktop);

        //账号
        label1 = new JLabel("账号：");
        label1.setFont(new Font("宋体", Font.PLAIN, 16));
        label1.setBounds(10, 104, 78, 30);
        c.add(label1);

        label1_1 = new JLabel();
        label1_1.setFont(new Font("宋体", Font.PLAIN, 14));
        label1_1.setBounds(67, 104, 112, 30);
        c.add(label1_1);

        //姓名
        label2 = new JLabel("姓名：");
        label2.setFont(new Font("宋体", Font.PLAIN, 16));
        label2.setBounds(203, 107, 62, 25);
        c.add(label2);

        label2_1 = new JLabel();
        label2_1.setFont(new Font("宋体", Font.PLAIN, 14));
        label2_1.setBounds(275, 104, 112, 30);
        c.add(label2_1);

        //登陆时间
        label3 = new JLabel("登陆时间：");
        label3.setFont(new Font("宋体", Font.PLAIN, 16));
        label3.setBounds(427, 109, 95, 21);
        c.add(label3);

        label3_1 = new JLabel(new SystemTime().getSystemTime());
        label3_1.setFont(new Font("宋体", Font.PLAIN, 14));
        label3_1.setBounds(513, 100, 157, 41);
        c.add(label3_1);

        //最小化图标
        label4 = new JLabel(new ImageIcon("picture/最小化.png"));
        label4.setToolTipText("最小化");
        label4.setBounds(690, 10, 54, 39);
        panel.add(label4);
        //关闭图标
        label5 = new JLabel(new ImageIcon("picture/关闭.png"));
        label5.setToolTipText("关闭");
        label5.setBounds(742, 10, 54, 39);
        panel.add(label5);

        //个人详情
        button5 = new JButton("个人详情");
        button5.setFont(new Font("宋体", Font.PLAIN, 12));
        button5.setBackground(new Color(0, 191, 255));//颜色
        button5.setForeground(SystemColor.desktop);
        button5.setBounds(680, 105, 125, 30);
        c.add(button5);

        //商品信息管理模块
        button6 = new JButton("商品信息管理模块");
        button6.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        button6.setBounds(42, 214, 233, 49);
        button6.setBackground(new Color(0, 191, 255));//颜色
        button6.setForeground(SystemColor.desktop);;
        c.add(button6);

        //VIP信息管理模块
        button7 = new JButton("VIP信息管理模块");
        button7.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        button7.setBackground(new Color(0, 191, 255));//颜色
        button7.setForeground(SystemColor.desktop);
        button7.setBounds(42, 303, 233, 49);
        c.add(button7);

        //商场人事管理模块
        button8 = new JButton("商场人事管理模块");
        button8.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        button8.setBackground(new Color(0, 191, 255));//颜色
        button8.setForeground(SystemColor.desktop);
        button8.setBounds(42, 398, 233, 49);
        c.add(button8);

        //商品销售管理模块
        button9 = new JButton("商品销售管理模块");
        button9.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        button9.setBackground(new Color(0, 191, 255));//颜色
        button9.setForeground(SystemColor.desktop);
        button9.setBounds(42, 500, 233, 49);
        c.add(button9);

        //版权
        label = new JLabel("设计者:1801汪京龙");
        label.setForeground(new Color(0, 191, 255));
        label.setFont(new Font("宋体", Font.PLAIN, 24));
        label.setBounds(319, 570, 223, 63);
        c.add(label);

        label_1 = new JLabel("该版权归郑州轻工业大学软件学院软件工程1801汪京龙所有");
        label_1.setFont(new Font("宋体", Font.PLAIN, 16));
        label_1.setForeground(new Color(0, 191, 255));
        label_1.setBounds(221, 624, 492, 27);
        getContentPane().add(label_1);

        //信息导入
        InfoLook();
        //MyEvent()
        MyEvent();
    }
    public void MyEvent()
    {
        //注销用户
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int confirm = JOptionPane.showConfirmDialog(null, "您确定要注销该用户吗？","提示",JOptionPane.YES_NO_CANCEL_OPTION);
                if(confirm == JOptionPane.YES_OPTION )
                {
                    dispose();
                    LoginWindow frame = new LoginWindow();
                    frame.setVisible(true);
                   /* String sql2 = "delete from user where id = '"+Config.id+"'";
                    Connection con = null;
                    Statement statement = null;
                    ResultSet rs = null;
                    int q1 = 0;
                    String sql = "select id from user";
                    try {
                        con = DBConnect.getConnection();
                        statement = con.createStatement();
                        rs = statement.executeQuery(sql);
                        while(rs.next())
                        {
                            if(Config.id.equals(rs.getString("id")))
                            {
                                q1 = statement.executeUpdate(sql2);
                                if(q1!=0)
                                {
                                    JOptionPane.showMessageDialog(null,"删除成功,将自动退出系统");
                                    System.exit(0);
                                }

                                else
                                    JOptionPane.showMessageDialog(null,"删除失败！");
                                break;
                            }
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
                    }*/
                }
            }
        });
        //退出系统按钮
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int confirm = JOptionPane.showConfirmDialog(null, "确定退出？", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
                if(confirm == JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                }
            }
        });
        //帮助说明
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"帮助说明请联系客服人员邮箱\n1617289652@qq.com");
            }
        });
        //关于系统
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"版本号：1.0.0");
            }
        });
        //个人详情
        button5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                InfoWindow frame = new InfoWindow();
                frame.setVisible(true);
            }
        });
        //商品信息管理
        button6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Store_Info frame = new Store_Info();
                frame.setVisible(true);
            }
        });
        //VIP信息管理
        button7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                VIP_Info frame = new VIP_Info();
                frame.setVisible(true);
            }
        });
        //商场人事信息管理
        button8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Worker_Info frame = new Worker_Info();
                frame.setVisible(true);
            }
        });
        //商品销售管理
        button9.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JOptionPane.showMessageDialog(null, "正在开发中！");
            }
        });
        //最小化
        label4.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e)
            {
                setExtendedState(JFrame.ICONIFIED);
            }
        });
        //关闭
        label5.addMouseListener(new MouseAdapter() {
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
                    label2_1.setText(rs.getString("name"));
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
