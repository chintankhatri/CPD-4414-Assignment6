/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author chintan
 */
@MessageDriven(mappedName = "jms/Queue")
public class ProductListener implements MessageListener{
    
    @Inject
    ProductList productlist;

    @Override
    public void onMessage(Message message) {

        try {
         
            if (message instanceof TextMessage) {
            
                String str = ((TextMessage) message).getText();
                //JsonObject json = Json.createReader(new StringReader(str)).readObject();
                //productList.add(new product(json));

            }

        } catch (JMSException ex) {
           
            Logger.getLogger(ProductListener.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (Exception ex) {
          
            Logger.getLogger(ProductListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
