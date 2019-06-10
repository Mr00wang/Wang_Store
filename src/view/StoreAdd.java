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

public class StoreAdd extends JFrame {


    private static final long serialVersionUID = 1L;
    private JPanel c;
    private JTextField textField;
    private JTextField textField_1;
    private JLabel label_2;
    private JButton button_1;
    private JButton button;
    protected Point pressedPoint;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StoreAdd frame = new StoreAdd();
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
    public StoreAdd() {
        //background picture
        JLabel picture = new JLabel();
        picture.setIcon(new ImageIcon("picture/StoreAdd.png"));
        this.getLayeredPane().add(picture,new Integer(Integer.MIN_VALUE));
        picture.setBounds(0,0,442,393);

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
        this.setIconImage(new ImageIcon("picture/商品管理.png").getImage());
        setBounds(100, 100, 442, 393);
        setLocation(WindowXY.getXY(this.getSize()));//界面居中
        c.setBorder(new LineBorder(Color.GRAY));
        c.setLayout(null);

        JLabel label = new JLabel("请输入商品名称：");
        label.setFont(new Font("宋体", Font.PLAIN, 16));
        label.setBounds(26, 130, 128, 36);
        c.add(label);

        textField = new JTextField();
        textField.setBounds(172, 135, 226, 30);
        c.add(textField);
        textField.setColumns(10);

        JLabel label_1 = new JLabel("请输入商品数量：");
        label_1.setFont(new Font("宋体", Font.PLAIN, 16));
        label_1.setBounds(26, 195, 145, 38);
        c.add(label_1);

        textField_1 = new JTextField();
        textField_1.setBounds(176, 201, 222, 30);
        c.add(textField_1);
        textField_1.setColumns(10);

        button = new JButton("返  回");
        button.setFont(new Font("宋体", Font.PLAIN, 16));
        button.setBounds(26, 275, 135, 38);
        button.setBackground(new Color(0, 191, 255));//颜色
        button.setForeground(SystemColor.desktop);
        c.add(button);

        button_1 = new JButton("确  定");
        button_1.setFont(new Font("宋体", Font.PLAIN, 16));
        button_1.setBounds(263, 275, 135, 38);
        button_1.setBackground(new Color(0, 191, 255));//颜色
        button_1.setForeground(SystemColor.desktop);
        c.add(button_1);

        //关闭
        label_2 = new JLabel(new ImageIcon("picture/关闭.png"));
        label_2.setToolTipText("关闭");
        label_2.setBounds(351, 38, 54, 44);
        c.add(label_2);

        //MyEvent
        MyEvent();
    }
    //判断输入是否为正整数
    public static boolean isNumeric(String str){
        for(int i=str.length();--i>=0;){
            int chr=str.charAt(i);
            if(chr<48 || chr>57)
                return false;
        }
        return true;
    }
    public void MyEvent()
    {
        //返回
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                dispose();
            }
        });
        //确定
        button_1.addActionListener(new ActionListener() {

            @Override


            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(textField.getText().equals("") || textField_1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "输入不能为空");
                } else if(isNumeric(textField_1.getText()))
                {
                    Connection conn = null;
                    Statement statement = null;
                    ResultSet rs1 = null;
                    int sum;
                    double price= 0;
                    int q = 0;
                    int q1=0,q2=0;
                    String sql = "select * from store_info";


                    try {
                        conn = DBConnect.getConnection();
                        statement = conn.createStatement();
                        rs1 = statement.executeQuery(sql);
                        while(rs1.next())
                        {
                            if(textField.getText().equals(rs1.getString("store_name")))
                            {
                                q = 1;
                                sum = new Integer(textField_1.getText())+rs1.getInt("store_stock");
                                price = sum * new Integer(rs1.getString("store_jinjia"));
                                System.out.println("新增总数量："+sum+"  总价格："+price);
                                String sql1 = "update store_info set store_stock='"+sum+"'where store_name ='"+textField.getText()+"'";
                                String sql2 = "update store_info set store_price='"+price+"'where store_name ='"+textField.getText()+"'";
                                q1 = statement.executeUpdate(sql1);
                                q2 = statement.executeUpdate(sql2);
                                break;
                            }
                        }
                        if(q==0)
                        {
                            JOptionPane.showMessageDialog(null, "没有该商品名");
                            textField.setText("");
                            textField_1.setText("");
                        }
                        if(q1!=0 && q2!=0)
                            JOptionPane.showMessageDialog(null, "修改成功");
                        else
                            JOptionPane.showMessageDialog(null, "修改失败");

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
                else
                {
                    JOptionPane.showMessageDialog(null, "商品数量请输入正整数");
                    textField_1.setText("");
                }
            }
        });
        //关闭
        label_2.addMouseListener(new MouseAdapter() {
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
