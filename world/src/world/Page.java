package world;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.eclipse.jface.text.AbstractLineTracker.Request;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;


public class Page extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable dataTable;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page frame = new Page();
					frame.setVisible(true);
					frame.setSize(500, 1500);
					
					  String url = "jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false";
				      String user = "root";
				      String password = "";
				      Connection con = DriverManager.getConnection(url, user, password);				    
				      Statement stm = con.createStatement();
				      
				      String query = "SELECT * FROM user";
				      ResultSet res = stm.executeQuery(query);
				      
				      String columns[] = { "ID", "Nom", "Age" };
				      String data[][] = new String[8][3];
				    
				      //Pour mettre dans une JTable
				      int i = 0;
				      while (res.next()) {
				        int id = res.getInt("ID");
				        String nom = res.getString("nom");
				        String age = res.getString("age");
				        data[i][0] = id + "";
				        data[i][1] = nom;
				        data[i][2] = age;
				        i++;
				      }
				      
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Page() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Faire un appel API
		
		
		//Faire des graphs
				
        JTable dataTable = new JTable(new DefaultTableModel(
        	new Object[][] {
        		{null, "oui je suis la"},
        		{null, null},
        		{null, null},
        	},
        	new String[] {
        		"Test", "New column"
        	}
        ));
		dataTable.setBounds(0, 11, 265, 70);
		contentPane.add(dataTable);
		

		
		//TypeA[] array = a.toArray(new TypeA[a.size()]);  Pour mettre des données  d'une liste a.

		ImageIcon image = new ImageIcon("123.jpg");
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/123.jpg")));
		lblNewLabel.setBounds(10, 189, 112, 50);
		contentPane.add(lblNewLabel);
		
		DefaultPieDataset dataset = new DefaultPieDataset();
			//dataset.addValue(120000.0, "Produit 1", "2000"); 

		    
		    dataset.setValue("la Fraaaance", 10.0);
		    dataset.setValue("les autres", 3.0);
		    
		    
		    JFreeChart barChart = ChartFactory.createPieChart3D("Oui je suis le titre", dataset);
		    ChartPanel cp = new ChartPanel(barChart);
		    cp.setBounds(221, 123, 273, 224);
		    contentPane.add(cp);
		    
		    textField = new JTextField();
		    textField.setBounds(375, 23, 86, 20);
		    contentPane.add(textField);
		    textField.setColumns(10);
		    
		    JButton btnNewButton = new JButton("New button");
		    btnNewButton.setBounds(385, 64, 89, 23);
		    contentPane.add(btnNewButton);
		    
		    btnNewButton.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		 		   System.out.println(textField.getText());

		    	}
		    });
		    


		    
	}
}
