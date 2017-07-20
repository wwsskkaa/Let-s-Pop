import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class Letspop implements ActionListener
{
    JFrame mainFrame;
    JWindow helperWindow;
    JPanel helperPanel;
    JPanel cPan,sPan,nPan,ePan,wPan,nPanSub;
    JButton firstButton,secondButton,reassembleButton,exitButton,newGameButton,helpButton;//record the 2 jbuttons that get selected for comparison
    JLabel scoremarks=new JLabel("0"); //score
    JLabel space=new JLabel("                  "); //score
    JLabel scoreLabel=new JLabel("Current Score: "); //score string label
    JLabel potionNumber=new JLabel("0"); //score
    JLabel potionLabel=new JLabel("Remaining Potion: "); //score string label
    Container thisCont;
    int textStorage[][] = new int[8][7]; //has the loc of all buttons in this this game
    int x0=0,y0=0,x=0,y=0,text_one=0,text_two=0,validateLV;
    int currentValidLevel,i,n,j;
    CustomizedButton tileButton[][] = new CustomizedButton[6][5];
    static boolean ifAnyPressed=false; //if any button is selected

    public void setBoard() {
        
        mainFrame=new JFrame("Let's Pop");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisCont = mainFrame.getContentPane();
        thisCont.setLayout(new BorderLayout());
        Color background=new Color(163,206,39);
        cPan=new JPanel(); //center panel
        sPan=new JPanel();//south panel
        nPan=new JPanel();//north panel
        nPanSub=new JPanel();//north panel sub
        nPan.setLayout(new BorderLayout());
        wPan=new JPanel();//west panel
        ePan=new JPanel();//east panel
        try{
            Image imageheader = ImageIO.read(new File("food/header.png"));
            JLabel labelheader = new JLabel(new ImageIcon(imageheader));
            nPan.add(labelheader,"North");
        }
        catch (Exception e) {
        e.printStackTrace();
    }
        cPan.setBackground(background);
        sPan.setBackground(background);
        nPan.setBackground(background);
        wPan.setBackground(background);
        ePan.setBackground(background);
        nPanSub.setBackground(background);
        nPan.add(nPanSub,"South");
        //adding all 5 panels.
        thisCont.add(cPan,"Center");
        thisCont.add(nPan,"North");
        thisCont.add(sPan,"South");
        thisCont.add(wPan,"West");
        thisCont.add(ePan,"East");

        cPan.setLayout(new GridLayout(6,5));//6 columns + 5 rows GridLayout
        for(int columns = 0; columns < 6; columns++) {
            for(int rows = 0; rows < 5; rows++) {
                int curcolumn=columns+1;
                int currow=rows+1;
                String buttonString=String.valueOf(textStorage[curcolumn][currow]);
                tileButton[columns][rows]=new CustomizedButton(buttonString);
                tileButton[columns][rows].addActionListener(this);
                cPan.add(tileButton[columns][rows]);
                //create and add all the food's button to cPan
            }
        }
        exitButton=new JButton("Quit");
        exitButton.setFont(new Font("Georgia", Font.PLAIN, 15));
        exitButton.setForeground(background);
        /*exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);*/
        exitButton.addActionListener(this);

        reassembleButton=new JButton("Use Potion");
        reassembleButton.setFont(new Font("Georgia", Font.BOLD, 15));
        reassembleButton.setForeground(background);
        reassembleButton.addActionListener(this);
        if(Integer.parseInt(potionNumber.getText())==0)
        {
            reassembleButton.setEnabled(false);
        }
        else
        {
            reassembleButton.setEnabled(true);
        }

        newGameButton=new JButton("New Game");
        newGameButton.setFont(new Font("Georgia", Font.PLAIN, 15));
        newGameButton.setForeground(background);
        newGameButton.addActionListener(this);

        helpButton=new JButton("?");
        helpButton.setFont(new Font("Georgia", Font.PLAIN, 15));
        helpButton.setForeground(background);
        helpButton.addActionListener(this);
        sPan.add(helpButton);

        sPan.add(reassembleButton);
        sPan.add(exitButton);
        sPan.add(newGameButton);

        String currentscore=String.valueOf(Integer.parseInt(scoremarks.getText()));
        scoreLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
        scoreLabel.setForeground(Color.WHITE);
        scoremarks.setFont(new Font("Georgia", Font.PLAIN, 15));
        scoremarks.setForeground(Color.WHITE);
        scoremarks.setText(currentscore);

        String currentpotion=String.valueOf(Integer.parseInt(potionNumber.getText()));
        potionLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
        potionLabel.setForeground(Color.WHITE);
        potionNumber.setFont(new Font("Georgia", Font.PLAIN, 15));
        potionNumber.setForeground(Color.WHITE);
        potionNumber.setText(currentpotion);

        nPanSub.add(scoreLabel);
        nPanSub.add(scoremarks);
        nPanSub.add(space);
        nPanSub.add(space);
        nPanSub.add(space);
        nPanSub.add(potionLabel);
        nPanSub.add(potionNumber);

        mainFrame.setSize(new Dimension(425,660));//set the height+width
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, dim.height/2-mainFrame.getSize().height/2);
        //set the location of the frame to always the center of the monitor no matter the size.
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
}

public void remove(){
    ifAnyPressed=false;
    currentValidLevel=0;
    firstButton.setVisible(false);
    secondButton.setVisible(false);
    calculateScore();
    textStorage[x][y]=0;
    textStorage[x0][y0]=0;
}

public void generatingBoard() {
    int randoms,cols,rows;
    for(int twins=1; twins<=15; twins++) {
        randoms=(int)(Math.random()*25+1);
        for(int alike=1; alike<=2; alike++) {
            cols=(int)(Math.random()*6+1);
            rows=(int)(Math.random()*5+1);
            while(textStorage[cols][rows]!=0) {
                cols=(int)(Math.random()*6+1);
                rows=(int)(Math.random()*5+1);
            }
            this.textStorage[cols][rows]=randoms;
        }
    }
}

public void calculateScore() {
    int currentscore=Integer.parseInt(scoremarks.getText())+100;
    scoremarks.setText(String.valueOf(currentscore));
    int currentpotion=currentscore/5000;
    potionNumber.setText(String.valueOf(currentpotion));
    if(currentpotion>0)
    {
        reassembleButton.setEnabled(true);
    }
    else
    {
        reassembleButton.setEnabled(false);
    }
    
}

public void reload() {
    int save[] = new int[30];
    int n=0;
    int cols,rows;
    int textStorage[][]= new int[8][7];
    for(int i=0; i<=6; i++) {
        for(int j=0; j<=5; j++) {
            if(this.textStorage[i][j]!=0) { //when content != 0
                save[n]=this.textStorage[i][j]; //send textStorage content to save[n] to store
                n++;
            }
        }
    }
    n=n-1;
    this.textStorage=textStorage;

    while(n>=0) {
        cols=(int)(Math.random()*6+1);
        rows=(int)(Math.random()*5+1);
        while(textStorage[cols][rows]!=0) {
            cols=(int)(Math.random()*6+1);
            rows=(int)(Math.random()*5+1);
        }
        this.textStorage[cols][rows]=save[n]; //send textStorage content to save[n] to store
        n--;
    }
    mainFrame.setVisible(false);
    ifAnyPressed=false;
    //reset the boolean because no button is selected yet.
    setBoard();
    for(int i = 0; i < 6; i++) {
        for(int j = 0; j < 5; j++ ) {
            if(textStorage[i+1][j+1]==0) //when one of the textStorage content =0
            {
              tileButton[i][j].setVisible(false);
            }
        }
    }
}

public void checkIfEqualValue(int xCoord,int yCoord,JButton sb) {
    if(ifAnyPressed==false) { //no other button is selected
        x=xCoord;
        y=yCoord;
        text_two=textStorage[x][y];
        secondButton=sb;
        ifAnyPressed=true; //set this true because now it is selected
    }
    else {//when there is already one button selected
        x0=x;
        y0=y;
        x=xCoord;
        y=yCoord;
        text_one=text_two;
        text_two=textStorage[x][y]; //second msg store in textStorage[x][y]
        firstButton=secondButton; //2 buttons chosen are the same
        secondButton=sb;
        if(text_one==text_two) {
            if(secondButton!=firstButton)
            {
                canItPop();//check if they can be popped even when they r the same
            }
        }
    }
}

public boolean checkIfNext()
{
    if(((x0==x+1||x0==x-1)&&(y0==y))||((x0==x)&&(y0==y+1||y0==y-1))) {
        return true;
    } 
    return false;
}

public void canItPop() {
//check if they can be popped even when they r the same
    if(checkIfNext()) {
        remove(); //if they are next to each other, pop it
    }
    else{
        for (j=0; j<7; j++) {
            if (textStorage[x0][j]==0) { //see which button are already popped on the same line as first button
                if (y==j ) {
                  //if 2nd button's y coord = empty button's y coord->1st & 2nd are same button
                    columnValidation1();//passed first validation
                }
                else if (y>j) {
                  //if 2nd button's y coord > empty button's y coord->1st button is left to 2nd button
                    for (i=y-1;i>=j;i--) {//see if there is any button in to the right of 1st button but left of second
                        if (textStorage[x][i]!=0) {
                            currentValidLevel=0; //should not pop
                            break;
                        }
                        else{currentValidLevel=1;} //passed first validation
                    }
                    if (currentValidLevel==1) {
                        columnValidation1();
                    }
                }
                else {
                  //if 2nd button's y coord < empty button's y coord->1st button is right to 2nd button
                    for (i=y+1; i<=j; i++ ) {
                      //see if there is any button in to the left of 1st button but right of second
                        if (textStorage[x][i]!=0) {
                            currentValidLevel=0;//should not pop
                            break;
                        }
                        else { currentValidLevel=1; }//passed first validation
                    }
                    if (currentValidLevel==1) {
                        columnValidation1();
                    }
                }
            }
            if (currentValidLevel==2) { //2nd validation
                if (x0==x) { //if 1st button x0 coord =2nd button x coord
                    remove(); //pop them both
                }
                else if (x0<x) {
                    for (n=x0; n<=x-1; n++ ) {
                        if (textStorage[n][j]!=0) {
                            currentValidLevel=0;
                            break;
                        }
                        if(textStorage[n][j]==0 && n==x-1) {
                            remove();
                        }
                    }
                }
                else {
                  //if 1st button's x0 coord > second button's x coord->1st button is right to 2nd button
                    for (n=x0; n>=x+1; n-- ) {
                        if (textStorage[n][j]!=0) {
                            currentValidLevel=0;
                            break;
                        }
                        if(textStorage[n][j]==0 && n==x+1) {
                            remove();
                        }
                    }
                }
            }
        }
        for (i=0; i<8; i++ ) { //column traverse
            if (textStorage[i][y0]==0) { //see which buttons are the same on the same column as 1st button (empty?)
                if (x==i) { //if 1st button x0=2nd button x coord
                    rowValidation1();
                }
                else if (x>i) {
                  //if 1st button's x0 coord < second button's x coord->1st button is left to 2nd button
                    for (j=x-1; j>=i; j-- ) {
                        if (textStorage[j][y]!=0) {
                            currentValidLevel=0;
                            break;
                        }
                        else { currentValidLevel=1; } //currentValidLevel=1，pass first validation
                    }
                    if (currentValidLevel==1) {
                        rowValidation1();
                    }
                }

                else {
                  //if 1st button's x0 coord < second button's x coord->1st button is right to 2nd button
                    for (j=x+1; j<=i; j++ ) {
                      if (textStorage[j][y]!=0) {
                          currentValidLevel=0;
                          break;
                      }
                      else {currentValidLevel=1; }
                    }
                    if (currentValidLevel==1) {
                       rowValidation1();
                    }
                }
            }
                if (currentValidLevel==2) {
                    if (y0==y) {//if 1st button y0=2nd button y coord
                        remove();
                    }
                    else if (y0<y) {
                      //if 1st button's y0 coord < second button's y coord->1st button is below 2nd button
                        for (n=y0; n<=y-1; n++ ) {
                            if (textStorage[i][n]!=0) {
                                currentValidLevel=0;
                                break;
                            }
                            if(textStorage[i][n]==0 && n==y-1) {
                                remove();
                            }
                        }
                    }
                    else {
                      //if 1st button's y0 coord > second button's y coord->1st button is above 2nd button
                        for (n=y0; n>=y+1; n--) {
                            if (textStorage[i][n]!=0) {
                                currentValidLevel=0;
                                break;
                            }
                            if(textStorage[i][n]==0 && n==y+1) {
                                remove();
                            }
                        }
                    }
                }
            }
        }
    }

public void columnValidation1() {
   if (y0<j) { //the empty button within same row of 1st button is in between 1st button and 2nd button
        for (i=y0+1; i<=j; i++) {
            if (textStorage[x0][i]!=0) {
                currentValidLevel=0;
                break;
            }
            else{ 
                currentValidLevel=2; 
            }
        }
    }
    else if (y0>j) { //the empty button within same row of 1st button is on the left of 1st button
        for (i=y0-1; i>=j; i-- ) { //see if there is any button in between the 1dt button and the empty button on its left
            if (textStorage[x0][i]!=0) {
                currentValidLevel=0;
                break;
            }
            else { 
                currentValidLevel=2; 
            } //passed the second validation
        }
    }
}

public void rowValidation1(){
     if (x0<i) { //the empty button within same column of 1st button is below 1st button
        for (j=x0+1; j<=i; j++ ) {
            if (textStorage[j][y0]!=0) {
                currentValidLevel=0;
                break;
            }
            else { 
                currentValidLevel=2; 
            }
        }
    }
    else if (x0>i) { //the empty button within same column of 1st button is above 1st button
        for (j=x0-1; j>=i; j-- ) {
            if (textStorage[j][y0]!=0) {
                currentValidLevel=0;
                break;
            }
            else { 
                currentValidLevel=2; 
            }
        }
    }
}

public void actionPerformed(ActionEvent e) {
    if(e.getSource()==newGameButton) {
        int textStorage[][] = new int[8][7];
        this.textStorage = textStorage;
        generatingBoard();
        mainFrame.setVisible(false);
        ifAnyPressed=false;
        setBoard();
    }
    if(e.getSource()==reassembleButton) {
        int currentpotion=Integer.parseInt(potionNumber.getText())-1;
        int currentscore=Integer.parseInt(scoremarks.getText())-5000;
        if(currentpotion<0){currentpotion=0;}
        if(currentpotion==0){
            reassembleButton.setEnabled(false);
        }
        else
        {
            reassembleButton.setEnabled(true);
        }
        potionNumber.setText(String.valueOf(currentpotion));
        scoremarks.setText(String.valueOf(currentscore));
        reload();
    }
    if(e.getSource()==helpButton){
        HelperScreen hel=new HelperScreen();
        try{
            hel.setHelperScreen();
            hel.setVisible(true);
        }
        catch (Exception h) {
        h.printStackTrace();
        }
    }
    if(e.getSource()==exitButton) {
        ImageIcon logo = new ImageIcon("cry.png");
        if (JOptionPane.showConfirmDialog(null, "Nothing will be saved, still exit?", "", 
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,logo)== JOptionPane.YES_OPTION)
        {
           System.exit(0);
        }
    }
    for(int cols=0; cols < 6; cols++) {
        for(int rows=0; rows < 5; rows++ ) {
            if(e.getSource()==tileButton[cols][rows]) {
                checkIfEqualValue(cols+1,rows+1,tileButton[cols][rows]);
            }
        }
    }
}

private static class CustomizedButton extends JButton implements ActionListener {
     String text = "";
     String imagesource="";
     /*ImageIcon water = new ImageIcon("water.bmp");
     JButton button = new JButton(water);*/

     public CustomizedButton(String t) {
        text=t;
        //setText(text);	//adds text to JButton
        imagesource="food/"+text+".png";
        ImageIcon water = new ImageIcon(imagesource);
        setIcon(water);
        addActionListener(this); //registers JButton with ActionListener
     }
     public void actionPerformed(ActionEvent e) { }
}

}
