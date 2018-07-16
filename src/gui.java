import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class gui extends JFrame implements ActionListener { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JList<?> treffer;
	
	JLabel lareiseziel;
	JLabel laort;
	JLabel lafname;
	JLabel laplz;
	JLabel laland;
	JLabel labewertung;
	JLabel lazimmer;
	JLabel lagroesse;
	JLabel lapreis;
	JLabel lamin;
	JLabel lamax;
	JLabel lavon;
	JLabel lavtag;
	JLabel lavmonat;
	JLabel lavjahr;
	JLabel labis;
	JLabel labtag;
	JLabel labmonat;
	JLabel labjahr;
	JLabel laausstattung;
	
	static JComboBox<String> hcb = new JComboBox<String>();		
	static JComboBox<String> lcb = new JComboBox<String>();
	static JComboBox<String> landcb = new JComboBox<String>();
	
	static JTextField ort;
	static JTextField fname;
	static JTextField plz;
	static JTextField bewertung;
	static JTextField zimmer;
	static JTextField groesse;
	static JTextField min;
	static JTextField max;
	static JTextField vtag;
	static JTextField vmonat;
	static JTextField vjahr;
	static JTextField btag;
	static JTextField bmonat;
	static JTextField bjahr;
	static JTextArea ash;
	static JTextArea asl;
	
	JButton suchen;
	JButton hinzufuegen;
	JButton loeschen;
	JButton buchen;
	
	public gui() {
		this.setPreferredSize(new Dimension(1000,1000));
		this.setTitle("Ferienwohnung");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lareiseziel = new JLabel("Reiseziel:");
		laort = new JLabel("Ort:");
		lafname = new JLabel("Ferienwohnung:");
		laplz = new JLabel("PLZ:");
		laland = new JLabel("Land:");
		
		labewertung = new JLabel("Bewertung:");
		lazimmer = new JLabel("Zimmer:");
		lagroesse = new JLabel("Groesse:");
		
		lapreis = new JLabel("Preis:");
		lamin = new JLabel("Min");
		lamax = new JLabel("Max");
		
		lavon = new JLabel("Von:");
		lavtag = new JLabel("Tag:");
		lavmonat = new JLabel("Monat");
		lavjahr = new JLabel("Jahr:");
		
		labis = new JLabel("Bis:");
		labtag = new JLabel("Tag");
		labmonat = new JLabel("Monat");
		labjahr = new JLabel("Jahr:");
		
		laausstattung = new JLabel("Ausstattung:");
		
		ort = new JTextField("", 10);
		fname = new JTextField("", 10);
		plz = new JTextField("", 10);
		bewertung = new JTextField("", 10);
		zimmer = new JTextField("", 10);
		groesse = new JTextField("", 10);
		min = new JTextField("", 10);
		max = new JTextField("", 10);
		vtag = new JTextField("", 10);
		vmonat = new JTextField("", 10);
		vjahr = new JTextField("", 10);
		btag = new JTextField("", 10);
		bmonat = new JTextField("", 10);
		bjahr = new JTextField("", 10);
				
		suchen = new JButton("Suchen");
		suchen.addActionListener(this);
		hinzufuegen = new JButton("Hinzufuegen");
		hinzufuegen.addActionListener(this);
		loeschen = new JButton("Loeschen");
		loeschen.addActionListener(this);
		buchen = new JButton("Buchen");
		buchen.addActionListener(this);
		
        suchen.setPreferredSize(new Dimension(100, 100));
        hinzufuegen.setPreferredSize(new Dimension(100, 100));
        loeschen.setPreferredSize(new Dimension(100, 100));

		
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3,1));
		panel1.add(laort);
		panel1.add(lafname);
		panel1.add(laland);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3,1));
		panel2.add(ort);
		panel2.add(fname);
		panel2.add(landcb);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(3,1));
		panel3.add(labewertung);
		panel3.add(lazimmer);
		panel3.add(lagroesse);
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(3,1));
		panel4.add(bewertung);
		panel4.add(zimmer);
		panel4.add(groesse);
		
		JPanel panel8 = new JPanel();
		panel8.setLayout(new GridLayout(3,1));
		panel8.add(bewertung);
		panel8.add(zimmer);
		panel8.add(groesse);
		
		JPanel pvt = new JPanel();
		pvt.setLayout(new GridLayout(2, 1));
		pvt.add(lavtag);
		pvt.add(vtag);
		
		JPanel pvm = new JPanel();
		pvm.setLayout(new GridLayout(2, 1));
		pvm.add(lavmonat);
		pvm.add(vmonat);
		
		JPanel pvj = new JPanel();
		pvj.setLayout(new GridLayout(2, 1));
		pvj.add(lavjahr);
		pvj.add(vjahr);
		
		JPanel pvon = new JPanel();
		pvon.setLayout(new GridLayout(4, 1));
		pvon.add(lavon);
		pvon.add(pvt);
		pvon.add(pvm);
		pvon.add(pvj);
		
		JPanel pbt = new JPanel();
		pbt.setLayout(new GridLayout(2, 1));
		pbt.add(labtag);
		pbt.add(btag);
		
		JPanel pbm = new JPanel();
		pbm.setLayout(new GridLayout(2, 1));
		pbm.add(labmonat);
		pbm.add(bmonat);
		
		JPanel pbj = new JPanel();
		pbj.setLayout(new GridLayout(2, 1));
		pbj.add(labjahr);
		pbj.add(bjahr);
		
		JPanel pbis = new JPanel();
		pbis.setLayout(new GridLayout(4, 1));
		pbis.add(labis);
		pbis.add(pbt);
		pbis.add(pbm);
		pbis.add(pbj);
		
		JPanel pvonbis = new JPanel();
		pvonbis.setLayout(new GridLayout(1,3));
		pvonbis.add(pvon);
		pvonbis.add(pbis);
		
		JPanel pmin = new JPanel();
		pmin.setLayout(new GridLayout(1,2));
		pmin.add(lamin);
		pmin.add(min);
		
		JPanel pmax = new JPanel();
		pmax.setLayout(new GridLayout(1,2));
		pmax.add(lamax);
		pmax.add(max);
		
		JPanel preis = new JPanel();
		preis.setLayout(new GridLayout(3,1));
		preis.add(lapreis);
		preis.add(pmin);
		preis.add(pmax);
		
		lcb.setSelectedItem(null);
		lcb.setBounds(90, 85, 245, 31);
		this.getContentPane().add(lcb);
		
		loeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = (String)hcb.getSelectedItem();
				if (value != null) {
					System.out.println(value + " wurde geloescht!");
					lcb.addItem(value);
					hcb.removeItem(value);
				}
			}
		});
		hinzufuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = (String)lcb.getSelectedItem();
				if (value != null) {
					System.out.println(value + " wurde hinzugefuegt!");
					hcb.addItem(value);
					lcb.removeItem(value);
				}
			}
		});
		
		JPanel panel6 = new JPanel();
		panel6.setLayout(new GridLayout(1,2));
		panel6.add(hinzufuegen);
		panel6.add(loeschen);
		
		JPanel panel5 = new JPanel();
		panel5.setLayout(new GridLayout(1,4));
		panel5.add(lcb);
		panel5.add(panel6);
		panel5.add(hcb);
		
		suchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sort ="", sfname="",sland="",sbewertung ="", szimmer="", von="", bis = "", sv="", sb="";
					if (vtag.getText().equals("") || vmonat.getText().equals("") || vjahr.getText().equals("") || btag.getText().equals("") || bmonat.getText().equals("") || bjahr.getText().equals("")) {
					} else {
						von = vtag.getText() + "/" + vmonat.getText() + "/" + vjahr.getText(); // 13/10/2016
						bis = btag.getText() + "/" + bmonat.getText() + "/" + bjahr.getText();
						sv = " AND Ferienwohnung.name NOT IN (SELECT fname FROM Buchung WHERE Buchung.von >= '" + von + "' AND Buchung.von < '" + bis + "' OR (Buchung.bis >= '" + bis + "' AND Buchung.von <= '" + von + "'))";
					}
					System.out.println(sv);
					if (ort.getText().equals("")) {
					} else {
						sort = " AND Adresse.ort = '" + ort.getText() + "' AND Ferienwohnung.adressId = Adresse.adressId";
					}
					if (fname.getText().equals("")) {
					} else {
						sfname = " AND Ferienwohnung.name = '" + fname.getText() + "'";
					}
					if (landcb.getSelectedItem().equals("")) {
					} else {
						sland = " AND Land.name = '" + landcb.getSelectedItem() + "' AND Land.name = Adresse.landName AND Ferienwohnung.adressId = Adresse.adressId";
					}
					if (zimmer.getText().equals("")) {
					} else {
						int y = Integer.parseInt(zimmer.getText());
						szimmer = " AND Ferienwohnung.zimmer >= " + y ;
					}
					System.out.println(sland);
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					String url= "jdbc:oracle:thin:@oracle12c.in.htwg-konstanz.de:1521:ora12c";
					Connection conn = DriverManager.getConnection(url, "dbsys30", "dbsys30");
					Statement stmt = conn.createStatement();
					String sql = "SELECT DISTINCT Ferienwohnung.name From Ferienwohnung, Adresse, Land, Buchung WHERE 1 = 1 " + sort + sfname + sland + szimmer + sv;
					System.out.println(sql);
					ResultSet rs = stmt.executeQuery(sql);
					while (rs.next()) {
						String name = rs.getString("name");
						System.out.println(name);
					}

					conn.close();
				} catch (Exception f) {
					System.out.println(f);
				}
			}
		});
		buchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					String url= "jdbc:oracle:thin:@oracle12c.in.htwg-konstanz.de:1521:ora12c";
					Connection conn = DriverManager.getConnection(url, "dbsys30", "dbsys30");
					Statement stmt = conn.createStatement();
					/*String sql = "SELECT Ferienwohnung.name From Ferienwohnung WHERE 1 = 1 " + sort + sfname;
					ResultSet rs = stmt.executeQuery(sql);
					while (rs.next()) {
						String name = rs.getString("name");
						System.out.println(name);
					}*/
					ComboBoxModel<String> model = hcb.getModel();
	                int size = model.getSize();
	                String as ="";
	                for(int i=0;i<size;i++) {
	                    Object element = model.getElementAt(i);
	                    as += " AND Ausstattung.name = " + element;
	                }
	                System.out.println(as);
	                
					
					conn.close();
				} catch (Exception f) {
					System.out.println(f);
				}
			}
		});
		JPanel psuchen = new JPanel();
		psuchen.setLayout(new GridLayout(1,2));
		psuchen.add(suchen);
		psuchen.add(buchen);
		
		JPanel ausstattung = new JPanel();
		ausstattung.setLayout(new GridLayout(2,1));
		ausstattung.add(laausstattung);
		ausstattung.add(panel5);
		
		JPanel mainpanel = new JPanel();
		mainpanel.add(panel1);
		mainpanel.add(panel2);
		mainpanel.add(panel3);
		mainpanel.add(panel4);
		mainpanel.add(panel8);
		mainpanel.add(pvonbis);
		mainpanel.add(preis);
		mainpanel.add(ausstattung);
		mainpanel.add(psuchen);
		this.add(mainpanel);
		
		pack();
		setVisible(true);
		
	}
	public static void main(String[] args) {
		connect();
		new gui();
	}
	
	private static void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url= "jdbc:oracle:thin:@oracle12c.in.htwg-konstanz.de:1521:ora12c";
			Connection conn = DriverManager.getConnection(url, "dbsys30", "dbsys30");
			Statement stmt = conn.createStatement();
			String sql = "SELECT name FROM Ausstattung";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) { // Ausstattungen
				String name = rs.getString("name");
				lcb.addItem(name);
			}
			//Laender
			sql = "SELECT name FROM Land";
			rs = stmt.executeQuery(sql);
			landcb.addItem("");
			while (rs.next()) {
				String name = rs.getString("name");
				
				landcb.addItem(name);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
