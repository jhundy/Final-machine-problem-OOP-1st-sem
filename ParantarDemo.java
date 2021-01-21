import java.time.LocalDate;
import java.io.*; 
import java.text.DecimalFormat;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*; 


class ATMGUI extends JFrame implements ActionListener
{
   JLabel labelAcc, titleW, labelPass, outPut, openLabel, Label, Confirm,Jpasswordfi; 
   JTextField firstIn, secondIn, openDepo, input;
   JPanel p1, p2, p3, p4, p5, p6, p7, CP, menuP;
   JButton log_in, openAcc, openCONFIRM, BBI, BD, BW;
   JButton BCA;
   JButton BC;
   JButton BM;
   JButton BO;
   JButton depositCONFIRM, withdrawCONFIRM, NO;
   String accountNumber, password;
   File accounts;
   boolean isOpen = false;
   Container c = getContentPane();
   public ATMGUI(){
      super("ATM");
      labelAcc = new JLabel("Account #: ");
      labelAcc.setHorizontalAlignment(JLabel.LEFT);
      labelPass = new JLabel("Password: ");
      labelPass.setHorizontalAlignment(JLabel.LEFT);
      titleW = new JLabel("ATM Machine");
      titleW.setHorizontalAlignment(JLabel.CENTER);
      firstIn = new JTextField(5);
      
      secondIn = new JTextField(5);
      
      log_in = new JButton("Login");
      log_in.addActionListener(this);
      openAcc = new JButton("Open new Account");
      openAcc.addActionListener(this);
      //--------------------------header
      p1 = new JPanel();
      p1.setLayout(new GridLayout(10, 20));
      p1.add(titleW);
      p1.setVisible(true);
      //--------------------------start display
      p2 = new JPanel(); 
      p2.setLayout(new GridLayout(5, 1));
      p2.add(titleW);
      p2.add(labelAcc);
      p2.add(firstIn);
      p2.add(labelPass);
      p2.add(secondIn);
      p2.setVisible(true);
           //---------------------------start navigational
      p3 = new JPanel();
      p3.setLayout(new GridLayout(10, 20));
      p3.add(log_in);
      p3.add(openAcc);
      p3.setVisible(true);
      //------------------------------new Account Input
      p4 = new JPanel();
      p4.setLayout(new GridLayout(10,20));
      openLabel = new JLabel("INPUT DEPOSIT: ");
      openDepo = new JTextField(5);
      p4.add(openLabel);
      p4.add(openDepo);
      p4.setVisible(false);
      //------------------------------
      p5 = new JPanel();
      p5.setLayout(new GridLayout(2,1));
      openCONFIRM = new JButton("CONFIRM");
      titleW.setHorizontalAlignment(JButton.CENTER);

      
      
      openCONFIRM.addActionListener(this);
      p5.add(openCONFIRM);
      p5.setVisible(false);
      //------------------------------
      p6 = new JPanel();
      p6.setLayout(new GridLayout(5,5));
      BW = new JButton("WITHDRAW");
      
      BW.addActionListener(this);
      BCA = new JButton("CLOSE ACCOUNT");
      
      BCA.addActionListener(this);
      BBI = new JButton("BALANCE INQUIRY");
      
      BBI.addActionListener(this);
      BD = new JButton("DEPOSIT");
      
      BD.addActionListener(this);
      
      p6.add(BBI);
      p6.add(BD);
      p6.add(BW);
      p6.add(BCA);
      p6.setVisible(false);
      //------------------------------
      p7 = new JPanel();
      p7.setLayout(new GridLayout(2,2));
      p7.setVisible(false);
      depositCONFIRM = new JButton("CONFIRM");
      
      depositCONFIRM.addActionListener(this);
      withdrawCONFIRM = new JButton("CONFIRM");
      
      withdrawCONFIRM.addActionListener(this);
      Label = new JLabel("ENTER DEPOSIT");
      Confirm = new JLabel("CLICK CONFIRM TO DEPOSIT");
      input = new JTextField(10);
      p7.add(Label);
      p7.add(input);
      p7.add(Confirm);
      p7.add(depositCONFIRM);
      NO = new JButton("NO");
     //---------------------------
      NO.addActionListener(this);
      JLabel sel = new JLabel("SELECT OPTION:");
      JLabel sol = new JLabel("");
      CP = new JPanel();
      CP.setLayout(new GridLayout(2,2));
      BC = new JButton("CLOSE");
      BC.addActionListener(this);
      BM = new JButton("BACK");
      
      BM.addActionListener(this);
      BO = new JButton("EXIT");
      
      BO.addActionListener(this);
      CP.add(sel);CP.add(sol);
      CP.add(BM);
      CP.add(BO);
      CP.setVisible(false);
      c.add(p1, BorderLayout.WEST);
      c.add(p2, BorderLayout.CENTER);
      c.add(p3, BorderLayout.WEST);
           
      setSize(500,500);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false); setVisible(true);
    }
    //------------------------------------------
      public void	actionPerformed(ActionEvent e)   {
      ATM atm = new ATM();
      

      
      //------------------------------------
      if(e.getSource()==BM)
      {
         c.removeAll();
         repaint();
         c.add(p1,BorderLayout.NORTH);
         c.add(p6,BorderLayout.CENTER);
         p1.setVisible(true);
         p6.setVisible(true); 
         repaint(); 
      }
      if(e.getSource()==BO)
      {
        c.removeAll();
        repaint();
  
        c.add(p1, BorderLayout.NORTH); 
        c.add(p2, BorderLayout.CENTER);
        c.add(p3, BorderLayout.SOUTH); 
        p1.setVisible(true);
        p2.setVisible(true);
        p3.setVisible(true);
        repaint(); 
      }
      if(e.getSource()==BCA){
        c.removeAll();
        p7.remove(depositCONFIRM); p7.remove(Confirm);
        c.add(p7,BorderLayout.CENTER);
        p7.setVisible(true);
        repaint();
        input.setEditable(false);
        repaint();
        if(atm.closeAccount(accountNumber,input,accounts)){
        c.removeAll();
        p7.remove(Confirm);
        CP.remove(BM);
        input.setText("Account closed!");
        c.add(p7, BorderLayout.CENTER);
        c.add(CP, BorderLayout.SOUTH);
        p7.setVisible(true);
        CP.setVisible(true);
        repaint();
         }
         else{
              c.removeAll();
            p7.remove(Confirm);
            c.add(p7, BorderLayout.CENTER);
            c.add(CP, BorderLayout.SOUTH);
            p7.setVisible(true);
            CP.setVisible(true);
            repaint();
         }
      }
      if(e.getSource()==BBI)
      {
         c.removeAll();
         c.add(p7,BorderLayout.CENTER);
         p7.remove(depositCONFIRM); p7.remove(Confirm);
         Label.setText("Remaining Balance");
         input.setEditable(false);
         p7.setVisible(true);
         atm.balanceInquiry(input, firstIn);
         c.add(CP, BorderLayout.SOUTH);
         CP.setVisible(true);
         repaint();
      }
      if(e.getSource() == depositCONFIRM){
         double temp = 0;
      try{
         
         temp = Double.parseDouble(input.getText());
      }
      catch (Exception ea) { 
           input.setText("INCORRECT INPUT!");
        } 
      if(atm.deposit(accountNumber, input, accounts) == true){
        p7.remove(depositCONFIRM);
        input.setText("Deposit successful!");
         c.add(p7, BorderLayout.CENTER); p7.setVisible(true);
         c.add(CP, BorderLayout.SOUTH);CP.setVisible(true);
         repaint();
         
         }
      }
      if(e.getSource() == BD){
         c.removeAll();
         p7.removeAll();
         p7.add(Label);
         p7.add(input);
         input.setText("");
         input.setEditable(true);
         p7.add(Confirm);
         p7.add(depositCONFIRM);
         c.add(p7,BorderLayout.CENTER);
         Label.setText("INPUT DEPOSIT");
        Confirm.setText("CLICK CONFIRM TO DEPOSIT");
         p7.setVisible(true);
         c.add(CP,BorderLayout.SOUTH);
         CP.setVisible(true);
         repaint();
         
      }
      if(e.getSource()==BW){
         c.removeAll();
          p7.removeAll();
          p7.add(Label);
          p7.add(input);
          input.setText("");
          input.setEditable(true);
          p7.add(Confirm);
          p7.add(withdrawCONFIRM);
          c.add(p7,BorderLayout.CENTER);
            p7.setVisible(true);
           Label.setText("Enter withdrawal amount");
          Confirm.setText("Click CONFIRM to confirm withdrawal");
           c.add(CP,BorderLayout.SOUTH);
         CP.setVisible(true);

         repaint();
      }
      if(e.getSource()==withdrawCONFIRM){
         double temp = 0;
      try{
         
         temp = Double.parseDouble(input.getText());
      }
      catch (Exception ea) { 
           input.setText("INCORRECT INPUT!");
        } 
      if(atm.withdraw(accountNumber, input, accounts) == true){
        p7.remove(withdrawCONFIRM);
        input.setText("Withdrawal Successful!");
         c.add(p7, BorderLayout.CENTER);  p7.setVisible(true);
         c.add(CP, BorderLayout.SOUTH); CP.setVisible(true);
         repaint();
         }
      }
      if(e.getSource() == log_in){
        accountNumber = firstIn.getText();
        password = secondIn.getText();
         String fName = "SA" + accountNumber + ".txt";
      File accounts = new File(fName);
      if (atm.LOGIN(firstIn,secondIn,accounts)) {
         c.removeAll();
         c.add(p1,BorderLayout.NORTH);
         p1.setVisible(true);
         c.add(p6,BorderLayout.NORTH);
         p6.setVisible(true);
         repaint();
        }  
      }
      if(e.getSource() == openCONFIRM){
      double temp = 0;
      try{
         
         temp = Double.parseDouble(openDepo.getText());
      }
      catch (Exception ea) { 
           openDepo.setText("INCORRECT INPUT!");
        } 
    
        
        
        if(atm.openAccount(accountNumber,temp,accounts) == true){
         c.remove(p4);
         c.remove(p5);
         c.add(p1,BorderLayout.NORTH);
         p1.setVisible(true);
         c.add(p6,BorderLayout.CENTER);
         p6.setVisible(true);
         repaint();
        }
      }
      
      if(e.getSource() == openAcc){
         accountNumber = firstIn.getText();
         password = secondIn.getText();
         String fName = "SA" + accountNumber + ".txt";
        try {
        File accounts = new File(fName);
        if (accounts.createNewFile() && password.equals("1234")) {
         c.removeAll();
         c.add(p4, BorderLayout.CENTER); p4.setVisible(true);
         c.add(p5, BorderLayout.SOUTH); p5.setVisible(true);
         if(!(password.equals("1234"))){
         secondIn.setText("PASSWORD INCORRECT");
        }
        
      } else {
        firstIn.setText("ACCOUNT ALREADY EXISTS");
        if(!(password.equals("1234"))){
         secondIn.setText("PASSWORD INCORRECT");
        }
      }
    } catch (IOException ae) {
      System.out.println("An error occurred.");
      ae.printStackTrace();
    }
         
      } 
   }
      
   }
 
class ATM{
//-------------------------
   public boolean openAccount(String accountNumber, double temp, File accounts){
   String fName = "SA" + accountNumber + ".txt";
   
   accounts = new File(fName);
      FileWriter f2;
      LocalDate date = LocalDate.now();
      DecimalFormat f = new DecimalFormat("#.00"); 
   try {
      f2 = new FileWriter(accounts,true);
      f2.write(date + "\t" + "OPEN ACCOUNT" + " = " + f.format(temp) + "\t");
      
      f2.close(); f2 = null;
} catch (IOException e) {
        e.printStackTrace();
}
   return true;
   
   }
   public boolean LOGIN(JTextField firstIn, JTextField secondIn, File accounts){
      
         boolean isLOGIN = false;
         String outPut = "";
         String temp = "";
          String f = "SA"+firstIn.getText() +".txt";
         try   {
         BufferedReader b = new BufferedReader(new FileReader(f));
         String line = null;   
         while((line = b.readLine()) != null) {
            String tmp[] = line.split("\t");
            temp = tmp[tmp.length-1];
         }
         b.close(); b = null;
      } catch(IOException ae)  {
         ae.printStackTrace();
      }
       outPut = temp;
       if(outPut.equals("Closed Account"))
       {
         firstIn.setText("Your Account is closed");
       }
      else{
         String password = secondIn.getText();
      if (accounts.exists()==true && password.equals("1234")) {
         
         if(!(password.equals("1234"))){
         secondIn.setText("PASSWORD INCORRECT");
        }
        isLOGIN = true;
        
      } else {
        if(!(accounts.exists())){
        firstIn.setText("DBCOUNT DOESN'T EXIST");
        }
        if(!(password.equals("1234"))){
         secondIn.setText("PASSWORD INCORRECT");
        }
      }
      }
    return isLOGIN;
   }
   //----------------------
   public void balanceInquiry(JTextField input, JTextField firstIn ){
      String temp="";
      String f = "SA"+firstIn.getText() +".txt";
      String outPut="";
      String last = "";
      int num = 0;   
      try   {
         BufferedReader b = new BufferedReader(new FileReader(f));
         String line = null;   
         while((line = b.readLine()) != null) {
            String tmp[] = line.split("\t");
            temp = tmp[tmp.length-1];
         }
         b.close(); b = null;
      } catch(IOException ae)  {
         ae.printStackTrace();
      }
       outPut = temp;
      num = outPut.lastIndexOf("=");
      last = outPut.substring(num+1, outPut.length());
      if(last.length()==0)
      {
         last = "0.00";
      }
      if(last.length()!=0)
      {
         if(Double.parseDouble(last)==0)
         {
            last = "0.00";
         } 
      }
      input.setText("P "+last);
   }
   public boolean deposit(String accountNumber, JTextField input, File accounts){
      boolean isDeposit = false;
      String fName = "SA" + accountNumber + ".txt";
      String file = "";
      String tempa = "";
      double Prevb =0;
      accounts = new File(fName);
      FileWriter f2;
    
   try {
       LocalDate date = LocalDate.now();
       DecimalFormat f = new DecimalFormat("#.00"); 
       FileReader f1 = new FileReader(fName); 
      int x; 
      while ((x=f1.read()) != -1) 
      file+=(char) x;   
      f1.close();  f1=null;
      if(file.length()!=0)
       {
        Prevb = 0 ;
        tempa = "";
        int y = file.lastIndexOf('='); 
        tempa = file.substring(y+1,file.length());
        Prevb = Double.parseDouble(tempa);
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
    try {
       LocalDate date = LocalDate.now();
       DecimalFormat f = new DecimalFormat("#.00"); 
      double dep = Double.parseDouble(input.getText());
       if(dep<0)
      {
        input.setText("Do not Input negative digits");
      }
      else{
      f2 = new FileWriter(accounts,true);
      if(Prevb==0){
      f2.write(date + "\t" + "DEPOSIT" + " = " + f.format(dep) + "\t");
      }
      else{
      f2.write(date + "\t" + "DEPOSIT" + " = " + f.format(dep+Prevb) + "\t"); 
      }
      f2.close(); f2 = null;
      isDeposit = true;
      }
} catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
}
    catch(NumberFormatException nfe){
            input.setText("Digits only");
      } 
   
   return isDeposit;
   }
   public boolean withdraw(String accountNumber, JTextField input, File accounts){
    boolean isWithdraw = false;
      String fName = "SA" + accountNumber + ".txt";
      String file = "";
      String tempa = "";
      double Prevb =0;
      double with = 0;
      accounts = new File(fName);
      FileWriter f2;
   try {
       LocalDate date = LocalDate.now();
       DecimalFormat f = new DecimalFormat("#.00"); 
       FileReader f1 = new FileReader(fName); 
      int x; 
      while ((x=f1.read()) != -1) 
      file+=(char) x;   
      f1.close();  f1=null;
      if(file.length()!=0)
       {
        Prevb = 0 ;
        tempa = "";
        int y = file.lastIndexOf('='); 
        tempa = file.substring(y+1,file.length());
        Prevb = Double.parseDouble(tempa);
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
    try {
       LocalDate date = LocalDate.now();
       DecimalFormat f = new DecimalFormat("#.00"); 
       with = Double.parseDouble(input.getText());
      if(with<0)
      {
        input.setText("Do not Input negative digits");
      }
      else{
      f2 = new FileWriter(accounts,true);
      if(Prevb< with){
        input.setText("Not enough funds");
      }
      else{
      f2.write(date + "\t" + "WITHDRAW" + " = " + f.format(Prevb - with) + "\t"); 
      f2.close(); f2 = null;
      isWithdraw = true;
      }
      }
} catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
}
    catch(NumberFormatException nfe){
            input.setText("Digits only");
      } 
   return isWithdraw;
   }
   public boolean closeAccount(String accountNumber, JTextField input, File accounts){
      boolean isClose = false;
      String fName = "SA" + accountNumber + ".txt";
      String file = "";
      String tempa = "";
      double Prevb =0;
      accounts = new File(fName);
      FileWriter f2;
    
   try {
       LocalDate date = LocalDate.now();
       DecimalFormat f = new DecimalFormat("#.00"); 
       FileReader f1 = new FileReader(fName); 
      int x; 
      while ((x=f1.read()) != -1) 
      file+=(char) x;   
      f1.close();  f1=null;
      if(file.length()!=0)
       {
        Prevb = 0 ;
        tempa = "";
        int y = file.lastIndexOf('='); 
        tempa = file.substring(y+1,file.length());
        Prevb = Double.parseDouble(tempa);
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
    try {
       LocalDate date = LocalDate.now();
       DecimalFormat f = new DecimalFormat("#.00"); 
       if(Prevb==0)
      {
        f2 = new FileWriter(accounts,true);
      f2.write(date + "\t" + "Closed Account");
      f2.close(); f2 = null;
      isClose = true;
       
      }
      else{
      input.setText("Please select back if you wish to continue transaction...");
      }
} catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
}

   return isClose;
   }
   }
   

public class ParantarDemo{

   public static void main(String args[])
   {
      ATMGUI log = new ATMGUI();
   }
}