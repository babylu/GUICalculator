/**
 * Created by babylu on 9/19/16.
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class CalculatorFrame extends JFrame{
    private JButton btn0=new JButton("0");
    private JButton btn1=new JButton("1");
    private JButton btn2=new JButton("2");
    private JButton btn3=new JButton("3");
    private JButton btn4=new JButton("4");
    private JButton btn5=new JButton("5");
    private JButton btn6=new JButton("6");
    private JButton btn7=new JButton("7");
    private JButton btn8=new JButton("8");
    private JButton btn9=new JButton("9");
    private JButton btnpoint=new JButton(".");
    private JButton btnsqrt=new JButton("√");
    private JButton btnadd=new JButton("+");
    private JButton btnsub=new JButton("-");
    private JButton btnmul=new JButton("*");
    private JButton btndiv=new JButton("/");
    private JButton btnequ=new JButton("=");
    private JButton btnperc=new JButton("%");
    private JButton btnback=new JButton("back");
    private JButton btnclear=new JButton("CE");
    private JTextArea input=new JTextArea(2,26);
    private JTextArea show=new JTextArea("Result:",2,26);

    private String result="";
    private ArrayList<Integer> signpos=new ArrayList<Integer>();

    private DecimalFormat df = new DecimalFormat("#.##########");
    private boolean eqlFlag = false;

    public void MyFrame(){
        setTitle("My Caculator");
        setLayout(new FlowLayout(FlowLayout.LEADING));
        setSize(320, 280);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        show.setEditable(false);
        input.setEditable(false);
        add(input);
        add(show);
        add(btnclear);
        add(btnback);
        add(btnperc);
        add(btndiv);
        add(btn7);
        add(btn8);
        add(btn9);
        add(btnmul);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btnsub);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btnadd);
        add(btnpoint);
        add(btn0);
        add(btnsqrt);
        add(btnequ);

        //clear function
        btnback.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String in=input.getText();
                if(in.isEmpty())    return;
                input.setText(in.substring(0, in.length()-1));
                if(in.endsWith("+")||in.endsWith("-")||in.endsWith("*")||in.endsWith("/"))
                    signpos.remove(signpos.size()-1);
            }
        });
        btnclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText("");
                signpos.clear();
            }
        });
        //number function
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(eqlFlag){
                    input.setText("0");
                    signpos.clear();
                    eqlFlag = false;
                }
                else input.setText(input.getText()+"0");
            }
        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(eqlFlag){
                    input.setText("1");
                    signpos.clear();
                    eqlFlag = false;
                }
                else input.setText(input.getText()+"1");
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(eqlFlag){
                    input.setText("2");
                    signpos.clear();
                    eqlFlag = false;
                }
                else input.setText(input.getText()+"2");
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(eqlFlag){
                    input.setText("3");
                    signpos.clear();
                    eqlFlag = false;
                }
                else input.setText(input.getText()+"3");
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(eqlFlag){
                    input.setText("4");
                    signpos.clear();
                    eqlFlag = false;
                }
                else input.setText(input.getText()+"4");
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(eqlFlag){
                    input.setText("5");
                    signpos.clear();
                    eqlFlag = false;
                }
                else input.setText(input.getText()+"5");
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(eqlFlag){
                    input.setText("6");
                    signpos.clear();
                    eqlFlag = false;
                }
                else input.setText(input.getText()+"6");
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(eqlFlag){
                    input.setText("7");
                    signpos.clear();
                    eqlFlag = false;
                }
                else input.setText(input.getText()+"7");
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(eqlFlag){
                    input.setText("8");
                    signpos.clear();
                    eqlFlag = false;
                }
                else input.setText(input.getText()+"8");
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(eqlFlag){
                    input.setText("9");
                    signpos.clear();
                    eqlFlag = false;
                }
                else input.setText(input.getText()+"9");
            }
        });
        //point
        btnpoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String in = input.getText();
                if(eqlFlag){
                    input.setText("");
                    signpos.clear();
                    eqlFlag = false;
                    return;
                }
                if(in.contains(".")&&
                        (!in.contains("*"))&&
                        (!in.contains("/"))&&
                        (!in.contains("+"))&&
                        (!in.contains("-"))) return;
                if(disableOperatorFunctions(in)) return;
                if(in.contains("*")||in.contains("/")||in.contains("+")||in.contains("-")){
                    int position1 = in.lastIndexOf("*");
                    int position2 = in.lastIndexOf("/");
                    int position3 = in.lastIndexOf("+");
                    int position4 = in.lastIndexOf("-");
                    int position = Math.max(position1,position2);
                    position = Math.max(position,position3);
                    position = Math.max(position,position4);
                    if(position == -1) position = 0;
                    if (in.substring(position, in.length() - 1).contains(".")) return;
                }
                input.setText(input.getText()+".");
            }
        });
        //symbol function
        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String in = input.getText();
                if(disableOperatorFunctions(in)) return;
                if(eqlFlag) eqlFlag = false;
                signpos.add(in.length());
                input.setText(in+"+");

            }
        });
        btnsub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String in = input.getText();
                if(disableOperatorFunctions(in)) return;
                if(eqlFlag) eqlFlag = false;
                signpos.add(in.length());
                input.setText(in+"-");
            }
        });
        btnmul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String in = input.getText();
                if(disableOperatorFunctions(in)) return;
                if(eqlFlag) eqlFlag = false;
                signpos.add(in.length());
                input.setText(in+"*");
            }
        });
        btndiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String in = input.getText();
                if(disableOperatorFunctions(in)) return;
                if(eqlFlag) eqlFlag = false;
                signpos.add(in.length());
                input.setText(in+"/");
            }
        });

        //result
        btnequ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String in=input.getText();
                if(disableOperatorFunctions(in)) return;
                if(signpos.size()==0){
                    result = in;
                }else{
                    result=String.valueOf(df.format(calculate(in)));
                }
                if(isInfinity(result)){
                    show.setText("Result:\n  Error!");
                    return;
                }
                show.setText("Result:\n  "+in+" = "+result);
                input.setText(result);
                signpos.clear();
                eqlFlag = true;
            }
        });
        btnperc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String in=input.getText();
                if(in.isEmpty()) return;
                if(disableOperatorFunctions(in)) return;
                in = getResult(in);
                if(isInfinity(result)){
                    show.setText("Result:\n  Error!");
                    return;
                }
                double doubleRes = Double.parseDouble(result);
                show.setText("Result: " + in + "% = " + doubleRes/100);
                input.setText(""+doubleRes/100);
                signpos.clear();
                eqlFlag = true;
            }
        });
        btnsqrt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String in=input.getText();
                if(in.isEmpty()) return;
                if(disableOperatorFunctions(in)) return;
                in = getResult(in);
                if(isInfinity(result)){
                    show.setText("Result:\n  Error!");
                    return;
                }
                double doubleRes = Double.parseDouble(result);

                if(doubleRes < 0){
                    show.setText("Result:\n  Error!");
                }else{
                    show.setText("Result:\n  √" + in + " = " + Math.sqrt(doubleRes));
                    input.setText("" + Math.sqrt(doubleRes));
                    signpos.clear();
                }
                eqlFlag = true;
            }
        });

    }

    private double calculate(String str){
        //Stack<String> parameterStack = new Stack<String>();
        ArrayList<String> parameterList = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char tmp = str.charAt(i);
            if(tmp == '.' ||(tmp - '0' >= 0 && tmp - '0' < 10)){
                if(i == str.length() - 1){
                    sb.append(tmp);
                    parameterList.add(sb.toString());
                }else{
                    sb.append(tmp);
                }
            }
            if(tmp == '+' || tmp == '-'){
                parameterList.add(sb.toString());
                sb = new StringBuilder();
                parameterList.add(String.valueOf(tmp));
            }
            if(tmp == '*' || tmp == '/'){
                double pre = Double.parseDouble(sb.toString());
                StringBuilder tmpsb = new StringBuilder();
                boolean isTail = false;
                for(int j = i + 1; j < str.length(); j++){
                    char tmpForMul = str.charAt(j);
                    if(tmpForMul == '.' || (tmpForMul - '0' >= 0 && tmpForMul - '0' < 10)){
                        if(j == str.length() - 1){
                            isTail = true;
                            tmpsb.append(tmpForMul);
                            i = j;
                        }else{
                            tmpsb.append(tmpForMul);
                        }
                    }else{
                        i = j - 1;
                        break;
                    }
                }
                double pos = Double.parseDouble(tmpsb.toString());
                double res = 0.0;
                if(tmp == '*'){
                    res = pre * pos;
                }else{
                    res = pre / pos;
                }
                String calculated = String.valueOf(res);
                if(isTail) parameterList.add(calculated);
                sb = new StringBuilder().append(calculated);
            }
        }
        double d = 0.0;
        double sign = 1.0;
        for(int index = 0; index < parameterList.size(); index++){
            if(parameterList.get(index).equals("+")){
                sign = 1.0;
            }else if(parameterList.get(index).equals("-")){
                sign = -1.0;
            }else{
                if(parameterList.get(index).isEmpty()) continue;
                double tmp = Double.parseDouble(parameterList.get(index));
                d += sign * tmp;
            }
        }
        return d;
    }
    private String getResult(String in){

        if(signpos.size()==0){
            result = in;
        }else{
            result=String.valueOf(df.format(calculate(in)));
            in = "("  + in + ")";
        }
        return in;

    }
    /**
     * disable operator functions
     */
    private boolean disableOperatorFunctions(String in){
        if(in.isEmpty()) return true;
        char lastDigit = in.charAt(in.length()-1);
        if(lastDigit == '*' || lastDigit == '/' || lastDigit == '+' || lastDigit == '-' || lastDigit == '.') return true;
        return false;
    }
    /**
     * deal with infinity
     */
    private boolean isInfinity(String result){
        if(result.equals("Infinity")||result.equals("∞")) {
            eqlFlag = true;
            input.setText("");
            return true;
        }
        return false;
    }
}
