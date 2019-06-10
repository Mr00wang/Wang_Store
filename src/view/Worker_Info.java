package view;

import java.awt.Color;
import java.awt.Dimension;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import util.DBConnect;
import util.WindowXY;

public class Worker_Info extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel c;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JPanel panel;
    private JLabel label_2;
    private JLabel label_3;
    private JLabel label_1;
    protected Point pressedPoint;
    private JLabel label;
    private JTable jtable;
    private DefaultTableModel tableModel;
    private Vector<Object> columnNames;
    private Vector<Object> rowData;
    private JScrollPane jscrollpane;
    private JButton button7;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Worker_Info frame = new Worker_Info();
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
    public Worker_Info() {
        //background picture
        JLabel picture = new JLabel();
        picture.setIcon(new ImageIcon("picture/WorkerInfo.png"));
        this.getLayeredPane().add(picture,new Integer(Integer.MIN_VALUE));
        picture.setBounds(0,0,841,640);

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
        this.setIconImage(new ImageIcon("picture/员工管理.png").getImage());
        //
        //setBounds(100, 100, 774, 563);
        setBounds(100, 100, 841, 640);
        setLocation(WindowXY.getXY(this.getSize()));//界面居中
        c.setBorder(new LineBorder(Color.GRAY));
        c.setLayout(null);

        //浏览员工
        button1 = new JButton("浏览员工");
        button1.setFont(new Font("宋体", Font.PLAIN, 14));
        button1.setBounds(10, 57, 135, 40);
        button1.setBackground(new Color(0, 191, 255));//颜色
        button1.setForeground(SystemColor.desktop);
        c.add(button1);

        //查询员工
        button2 = new JButton("查询员工");
        button2.setFont(new Font("宋体", Font.PLAIN, 14));
        button2.setBounds(187, 57, 135, 40);
        button2.setBackground(new Color(0, 191, 255));//颜色
        button2.setForeground(SystemColor.desktop);
        c.add(button2);

        //注册员工
        button3 = new JButton("注册员工");
        button3.setFont(new Font("宋体", Font.PLAIN, 14));
        button3.setBounds(356, 57, 135, 40);
        button3.setBackground(new Color(0, 191, 255));//颜色
        button3.setForeground(SystemColor.desktop);
        c.add(button3);

        //新增商品
        button4 = new JButton("修改员工");
        button4.setFont(new Font("宋体", Font.PLAIN, 14));
        button4.setBounds(528, 57, 135, 40);
        button4.setBackground(new Color(0, 191, 255));//颜色
        button4.setForeground(SystemColor.desktop);
        c.add(button4);

        //更新商品
        button5 = new JButton("注销员工");
        button5.setFont(new Font("宋体", Font.PLAIN, 14));
        button5.setBounds(690, 57, 135, 40);
        button5.setBackground(new Color(0, 191, 255));//颜色
        button5.setForeground(SystemColor.desktop);
        c.add(button5);

        //退出
        button6 = new JButton("退出");
        button6.setFont(new Font("宋体", Font.PLAIN, 14));
        button6.setBounds(692, 589, 133, 33);
        button6.setBackground(new Color(0, 191, 255));//颜色
        button6.setForeground(SystemColor.desktop);
        c.add(button6);

        //更新信息
        button7 = new JButton("更新信息");
        button7.setBounds(555, 589, 133, 33);
        button7.setBackground(new Color(0, 191, 255));//颜色
        button7.setForeground(SystemColor.desktop);
        c.add(button7);

        //
        panel = new JPanel();
        panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel.setBackground(new Color(224, 247, 250));
        panel.setBounds(10, 121, 815, 458);
        c.add(panel);
        panel.setLayout(null);

        label_2 = new JLabel("欢迎查看员工信息管理模块");
        label_2.setFont(new Font("华文行楷", Font.PLAIN, 40));
        label_2.setBounds(10, 10, 629, 114);
        panel.add(label_2);

        label_3 = new JLabel("点击按钮进行操作");
        label_3.setFont(new Font("华文行楷", Font.PLAIN, 40));
        label_3.setBounds(136, 83, 552, 124);
        panel.add(label_3);


        //最小化
        label = new JLabel(new ImageIcon("picture/最小化.png"));
        label.setToolTipText("最小化");
        label.setBounds(721, 10, 47, 37);
        c.add(label);

        //关闭
        label_1 = new JLabel(new ImageIcon("picture/关闭.png"));
        label_1.setToolTipText("关闭");
        label_1.setBounds(778, 10, 47, 37);
        c.add(label_1);




        //MyEvent()
        MyEvent();
    }
    public void Look()
    {
//		setVisible(false);
//		setVisible(true);
        panel = new JPanel();
        panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel.setBackground(new Color(224, 247, 250));
        panel.setBounds(10, 121, 815, 458);
        c.add(panel);
        panel.setLayout(null);

        //导入数据设计
        columnNames = new Vector<>();
        columnNames.add("工号");
        columnNames.add("姓名");
        columnNames.add("性别");
        columnNames.add("年龄");
        columnNames.add("部门");
        columnNames.add("职务");
        columnNames.add("电话");
        columnNames.add("月薪");
        columnNames.add("住址");
        columnNames.add("状态");
        columnNames.add("注册时间");
        rowData = new Vector<>();

        //连接数据库
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement statement = null;
        try {
            con = DBConnect.getConnection();
            //创建一个Statement对象
            statement = con.createStatement();
            ps = con.prepareStatement("select * from worker_info");
            rs = ps.executeQuery();
            while(rs.next())
            {
                Vector<Object> hang = new Vector<>();
                hang.add(rs.getString(1));
                hang.add(rs.getString(2));
                hang.add(rs.getString(3));
                hang.add(rs.getString(4));
                hang.add(rs.getString(5));
                hang.add(rs.getString(6));
                hang.add(rs.getString(7));
                hang.add(rs.getString(8));
                hang.add(rs.getString(9));
                hang.add(rs.getString(10));
                hang.add(rs.getString(11));
                rowData.add(hang);
            }

        } catch (SQLException e1) {
            System.out.println("fail to connect the database！");
            e1.printStackTrace();
        }
        finally
        {
            try
            {
                //rs.close();
                //ps.close();
                statement.close();
                if(con!=null)
                    con.close();
            }
            catch(SQLException e1)
            {
                System.out.println("conn close fall");
            }
        }
        //设置表格
        tableModel = new DefaultTableModel(rowData, columnNames);
        //设置表格及不可编辑
        jtable = new JTable(tableModel)
        {
            private static final long serialVersionUID = -4085954475206341833L;

            public boolean isCellEditable(int row,int column)
            {
                return false;
            }
        };
        //设置字体大小
        jtable.setFont(new Font("微软雅黑",5,15));
        //设置表头字体大小
        JTableHeader header = jtable.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(),40));
        header.setFont(new Font("楷体",5,15));

        //设置列宽
        jtable.getColumnModel().getColumn(0).setPreferredWidth(55);
        jtable.getColumnModel().getColumn(1).setPreferredWidth(74);
        jtable.getColumnModel().getColumn(2).setPreferredWidth(55);
        jtable.getColumnModel().getColumn(3).setPreferredWidth(55);
        jtable.getColumnModel().getColumn(4).setPreferredWidth(74);
        jtable.getColumnModel().getColumn(5).setPreferredWidth(74);
        jtable.getColumnModel().getColumn(6).setPreferredWidth(115);
        jtable.getColumnModel().getColumn(7).setPreferredWidth(74);
        jtable.getColumnModel().getColumn(8).setPreferredWidth(74);
        jtable.getColumnModel().getColumn(9).setPreferredWidth(55);
        jtable.getColumnModel().getColumn(10).setPreferredWidth(100);
        //设置行高
        jtable.setRowHeight(32);

        jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//取消自动调整
        //设置滚轮面板
        jscrollpane = new JScrollPane(jtable);
        panel.add(jscrollpane);
        jscrollpane.setBackground(new Color(224, 247, 250));
        jscrollpane.setBounds(0, 0, 815, 458);

        jscrollpane.setOpaque(false);
        //jtable.setOpaque(false);
        //jtable.setDragEnabled(false);

    }
    public void MyEvent()
    {

        //浏览员工
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                panel.setVisible(false);
                panel.removeAll();
                Look();
                panel.setVisible(true);
            }
        });
        //查询员工
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                WorkerSearch frame = new WorkerSearch();
                frame.setVisible(true);
            }
        });
        //注册员工
        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                WorkerAdd frame = new WorkerAdd();
                frame.setVisible(true);
            }
        });
        //修改员工
        button4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                WorkerChange frame = new WorkerChange();
                frame.setVisible(true);
            }
        });
        //注销用户
        button5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                WorkerDelete frame = new WorkerDelete();
                frame.setVisible(true);
            }
        });
        //退出
        button6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                dispose();
            }
        });
        //更新信息
        button7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                dispose();
                Worker_Info frame = new Worker_Info();
                frame.setVisible(true);
            }
        });
        //最小化
        label.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e)
            {
                setExtendedState(JFrame.ICONIFIED);
            }
        });
        //关闭
        label_1.addMouseListener(new MouseAdapter() {
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
