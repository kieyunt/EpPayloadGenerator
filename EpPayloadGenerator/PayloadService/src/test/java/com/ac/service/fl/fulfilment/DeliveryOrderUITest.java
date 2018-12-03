package com.ac.service.fl.fulfilment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DeliveryOrderUITest {

	public static void main(String[] args) {
		
		JLabel deliveryOrderLabel = new JLabel("Delivery Order ID / Number");
		deliveryOrderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextField deliveryOrderTxt = new JTextField();
		deliveryOrderTxt.setColumns(20);
		
        JTextArea payloadTextArea = new JTextArea();
        payloadTextArea.setText("");
        payloadTextArea.setLineWrap(true);
        payloadTextArea.setWrapStyleWord(true);
        payloadTextArea.setLineWrap(true);
        payloadTextArea.setMargin(new Insets(5, 5, 5, 5));
        payloadTextArea.setFont(new Font("", 0, 20));
        payloadTextArea.setColumns(69);
        payloadTextArea.setRows(37);
        payloadTextArea.setFont(new Font("Arial", Font.PLAIN, 12));
        
        DeliveryOrderService deliveryOrderService = new DeliveryOrderService();        
		JButton generateBtn = new JButton("Generate");
		generateBtn.addActionListener((e) -> {
			String deliveryOrderDoc = deliveryOrderTxt.getText().trim();
			try {
				payloadTextArea.setText(deliveryOrderService.generateDeliveryOrderPayload(deliveryOrderDoc));
			} catch (Exception e1) {
				payloadTextArea.setText("unable to get payload.");
			}
		});
		
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputPanel.add(deliveryOrderLabel);
        inputPanel.add(deliveryOrderTxt);
        inputPanel.add(generateBtn);
		
		JPanel payloadPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		payloadPanel.add(new JScrollPane(payloadTextArea));
        
		JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(payloadPanel, BorderLayout.CENTER);
		
		JFrame f = new JFrame();
		f.setTitle("Delivery Order Payload Generator");
		f.setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		f.setSize(800, 650);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		f.add(mainPanel);
	}

}
