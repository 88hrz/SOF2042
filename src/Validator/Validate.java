/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validator;

import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author X1
 */
public class Validate {
    
    public Boolean isEmpty(JTextField txt, StringBuilder stb, String msq){
        if (txt.getText().trim().isEmpty()) {
            txt.setBackground(Color.yellow);
            stb.append(msq).append("\n");
            return false;
        }else{
            return true;
        }
    }
    
    public boolean isNumber(JTextField txt, StringBuilder stb, String msg, int type) {
        if (!isEmpty(txt, stb, msg)) {
            return false;
        } else {
            try {
                if (type > 0) {
                    double NumberD = Double.parseDouble(txt.getText().trim());
                } else {
                    int NumberI = Integer.parseInt(txt.getText().trim());
                }
            } catch (Exception e) {
                txt.setBackground(Color.YELLOW);
                stb.append(msg).append("\n");
                return false;
            }
        }
        txt.setBackground(Color.WHITE);
        return true;
    }

    //Kiểm tra xem có điền vào số có lớn hơn giới hạn min không
    public boolean NumberLimit(JTextField txt, StringBuilder stb, String msg, int type, int min) {
        if (!isNumber(txt, stb, msg, type)) {
            return false;
        } else {
            int NumberI = Integer.parseInt(txt.getText().trim());
            if (NumberI < min) {
                txt.setBackground(Color.YELLOW);
                stb.append(msg).append("\n");
                return false;
            }
        }
        txt.setBackground(Color.WHITE);
        return true;
    }
}
